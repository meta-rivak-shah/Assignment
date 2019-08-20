package Mysql.JDBC;

import java.sql.*;

/**
 * this class is used to connect all 
 * database and also 
 * exexute the query 
 * @database 
 * @author Rivak
 *
 */
public class SqlConnector {
	private String dataBaseType;
	private String dataBaseName;

	public String getDataBaseType() {
		return dataBaseType;
	}

	public void setDataBaseType(String dataBaseType) {
		this.dataBaseType = dataBaseType;
	}

	public String getDataBaseName() {
		return dataBaseName;
	}

	public void setDataBaseName(String dataBaseName) {
		this.dataBaseName = dataBaseName;
	}

	SqlConnector(String dataBaseType, String dataBaseName) {
		this.setDataBaseType(dataBaseType);
		this.setDataBaseName(dataBaseName);
	}

	Connection connectMysql() {
		try {
			Class.forName(this.getDataBaseType());
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/" + this.dataBaseName, "root",
					"rivak");
			return con;
		} catch (Exception e) {
			// Handle errors for Class.forName
			System.out.println(e);
			return null;
		}

	}

	ResultSet executeQuery(String query) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		try {
			con = this.connectMysql();
			con.setAutoCommit(false);
			stmt = con.createStatement();
			ResultSet queryResult = stmt.executeQuery(query);
			con.commit();
			return queryResult;
		} catch (SQLException e) {
			// SQL Exception will occur If connection not Create
			System.out.println(e);
			con.rollback();
		} catch (Exception e) {
			// Null Pointer Exception will occur If connection not Create
			System.out.println(e);
		}
		return null;
	}

	int executeUpdate(String query) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		try {
			con = this.connectMysql();
			con.setAutoCommit(false);
			stmt = con.createStatement();
			stmt.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
			int queryResult = stmt.executeUpdate(query);
			con.commit();
			stmt.executeUpdate("SET FOREIGN_KEY_CHECKS = 1");
			return queryResult;
		} catch (Exception e) {
			// Null Pointer Exception will occur If connection not Create
			System.out.println(e);
			con.rollback();
		}
		return 0;
	}

	int insertDataThroughtBatch(String Query[]) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		try {
			con = this.connectMysql();
			con.setAutoCommit(false);
			stmt = con.createStatement();
			for (int i = 0; i < Query.length; i++) {
				stmt.addBatch(Query[i]);
			}
			stmt.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
			int[] result = stmt.executeBatch();
			con.commit();
			stmt.executeUpdate("SET FOREIGN_KEY_CHECKS = 1");
			int j = 0;
			for (int i = 0; i < result.length; i++) {
				if (result[i] == 1) {
					j++;
				}
			}
			if (j != result.length) {
				return 0;
			} else {
				return 1;
			}
		} catch (Exception e) {
			// Null Pointer Exception will occur If connection not Create
			System.out.println(e);
			;
			con.rollback();
			return 0;
		}
	}

}
