package com.hunter.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.hunter.global.GlobalVariable;

/**
 * @author 武文良
 *         <p>
 *         date 2016.5.9
 *         </p>
 *         数据库工具类，获取/关闭数据库连接
 */
public class DBUtils {

	private Connection connection = null;

	/**
	 * 获取数据库连接
	 * 
	 * @return connection
	 */
	public Connection getCon() {

		try {
			// 加载驱动
			Class.forName(GlobalVariable.DB_DRIVER);
			// 建立连接
			connection = DriverManager.getConnection(GlobalVariable.DB_URL, GlobalVariable.DB_USERNAME, GlobalVariable.DB_PASSWORD);
			System.out.println(new SimpleDateFormat("yyyy-MM-dd,hh:mm:ss ").format(new Date()) + "connected==>" + connection.getMetaData().getURL());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * 关闭数据库连接
	 * 
	 * @param connection
	 * @param statement
	 * @param preparedStatement
	 * @param resultSet
	 * @throws SQLException
	 */
	public void closeCon(Connection connection, Statement statement, PreparedStatement preparedStatement,
			ResultSet resultSet) throws SQLException {
		if (resultSet != null) {
			resultSet.close();
			System.out.println("关闭resultset");
		}
		if (preparedStatement != null) {
			preparedStatement.close();
			System.out.println("关闭preparedStatement");
		}
		if (statement != null) {
			statement.close();
			System.out.println("关闭statement");
		}
		if (connection != null) {
			connection.close();
			System.out.println("关闭connection");
		}
	}
}
