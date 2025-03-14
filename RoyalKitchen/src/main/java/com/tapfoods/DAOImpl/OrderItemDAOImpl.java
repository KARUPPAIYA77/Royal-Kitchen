
package com.tapfoods.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tapfoods.DAO.OrderItemDAO;
import com.tapfoods.DBUtils.DBUtils;
import com.tapfoods.model.Orderitem;

/**
 * The OrderItemDAOImpl class implements the {@link OrderItemDAO} interface.
 * <p>This class provides the actual implementation of data access operations for {@link Orderitem} entities using JDBC.</p>
 */
public class OrderItemDAOImpl implements OrderItemDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;

	private static final String ADD_ORDER_ITEM = "INSERT INTO `orderitem` (`orderid`, `menuid`, `menuname`, `quantity`, `subtotal`) VALUES (?, ?, ?, ?, ?)";
	private static final String GET_ALL_ORDER_ITEM = "SELECT * FROM `orderitem`";
	private static final String GET_ON_ID = "SELECT * FROM `orderitem` WHERE `orderid`=?";
	private static final String GET_BY_ORDER_ID = "SELECT * FROM `orderitem` WHERE `orderid`=?";

	/**
	 * Constructs a new {@code OrderItemDAOImpl} instance and establishes a database connection.
	 * <p>This constructor initializes the database connection using {@link DBUtils#myConnect()}.</p>
	 */
	public OrderItemDAOImpl() throws SQLException {
		try {
			con = DBUtils.myConnect();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to connect to the database", e);
		}
	}

	/**
	 * Adds a new order item to the database.
	 * <p>This method prepares an SQL {@code INSERT} statement and executes it to add an {@link Orderitem} object to the database.</p>
	 * 
	 * @param oi the {@link Orderitem} object to be added
	 * @return an integer indicating the result of the operation (e.g., the number of rows affected)
	 * @throws SQLException if a database access error occurs
	 */
	@Override
	public int addOrderItem(Orderitem oi) throws SQLException {
		try {
			con = DBUtils.myConnect();
			pstmt = con.prepareStatement(ADD_ORDER_ITEM);
			pstmt.setInt(1, oi.getOrderid());
			pstmt.setInt(2, oi.getMenuid());
			pstmt.setString(3, oi.getMenuname());
			pstmt.setInt(4, oi.getQuantity());
			pstmt.setFloat(5, oi.getSubtotal());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Failed to add order item", e);
		} finally {
			DBUtils.closeResources(con, null, pstmt, null);
		}
	}

	/**
	 * Retrieves all order items for a specific order ID.
	 * <p>This method prepares an SQL {@code SELECT} statement with a specified order ID and retrieves all {@link Orderitem} records associated with that order ID.</p>
	 * 
	 * @param orderId the ID of the order whose items are to be retrieved
	 * @return an {@link ArrayList} of {@link Orderitem} objects corresponding to the specified order ID
	 * @throws SQLException if a database access error occurs
	 */
	public ArrayList<Orderitem> getOrderItemsByOrderId(int orderId) throws SQLException {
		ArrayList<Orderitem> orderitemList = new ArrayList<>();
		try {
			con = DBUtils.myConnect();
			pstmt = con.prepareStatement(GET_BY_ORDER_ID);
			pstmt.setInt(1, orderId);
			resultSet = pstmt.executeQuery();
			orderitemList = extractOrderitemListFromResultSet(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Failed to retrieve order items by order ID", e);
		} finally {
			DBUtils.closeResources(con, pstmt, null, resultSet);
		}
		return orderitemList;
	}

	/**
	 * Retrieves all order items from the database.
	 * <p>This method executes an SQL {@code SELECT} statement to retrieve all {@link Orderitem} records and returns them as an {@link ArrayList}.</p>
	 * 
	 * @return an {@link ArrayList} of {@link Orderitem} objects representing all order items
	 * @throws SQLException if a database access error occurs
	 */
	@Override
	public ArrayList<Orderitem> getAllOrderItem() throws SQLException {
		ArrayList<Orderitem> orderitemList = new ArrayList<>();
		try {
			con = DBUtils.myConnect();
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(GET_ALL_ORDER_ITEM);
			orderitemList = extractOrderitemListFromResultSet(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Failed to retrieve all order items", e);
		} finally {
			DBUtils.closeResources(con, stmt, null, resultSet);
		}
		return orderitemList;
	}

	/**
	 * Retrieves an order item from the database by its ID.
	 * <p>This method prepares an SQL {@code SELECT} statement with a specified order item ID and retrieves the corresponding {@link Orderitem} record.</p>
	 * 
	 * @param orderitemid the ID of the order item to be retrieved
	 * @return the {@link Orderitem} object corresponding to the specified ID, or {@code null} if no order item is found
	 * @throws SQLException if a database access error occurs
	 */
	@Override
	public Orderitem getOrderItem(int orderid) throws SQLException {
		try {
			con = DBUtils.myConnect();
			pstmt = con.prepareStatement(GET_ON_ID);
			pstmt.setInt(1, orderid);
			resultSet = pstmt.executeQuery();
			ArrayList<Orderitem> orderitemList = extractOrderitemListFromResultSet(resultSet);
			if (!orderitemList.isEmpty()) {
				return orderitemList.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Failed to retrieve order item by ID", e);
		} finally {
			DBUtils.closeResources(con, null, pstmt, resultSet);
		}
		return null;
	}

	/**
	 * Extracts a list of {@link Orderitem} objects from the provided {@link ResultSet}.
	 * <p>This method iterates over the {@link ResultSet} and creates a list of {@link Orderitem} objects from the data.</p>
	 * 
	 * @param resultSet the {@link ResultSet} object containing order item data
	 * @return an {@link ArrayList} of {@link Orderitem} objects
	 * @throws SQLException if a database access error occurs
	 */
	private ArrayList<Orderitem> extractOrderitemListFromResultSet(ResultSet resultSet) throws SQLException {
		ArrayList<Orderitem> orderitems = new ArrayList<>();
		try {
			while (resultSet.next()) {
				orderitems.add(new Orderitem(
						resultSet.getInt("orderitemid"),
						resultSet.getInt("orderid"),
						resultSet.getInt("menuid"),
						resultSet.getString("menuname"),
						resultSet.getInt("quantity"),
						resultSet.getFloat("subtotal")
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Failed to extract order items from ResultSet", e);
		}
		return orderitems;
	}
}
