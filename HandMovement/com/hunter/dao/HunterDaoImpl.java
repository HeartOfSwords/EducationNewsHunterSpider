package com.hunter.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.Calendar;

import com.hunter.util.DBUtils;

/**
 * 数据访问层实现类
 * @author snowalker
 * 16.7.26
 */
public class HunterDaoImpl implements HunterDao {

	private static Connection connection = null;
	private PreparedStatement pstmt;
	private int flag;
	
	public static Connection getConnectionInstance() {
		if (connection == null) {
			connection = new DBUtils().getCon();
		}
		return connection;
	}
	//数据持久化
	@Override
	public boolean saveData(String title, Date date, String content) {
		String sql = "INSERT into edu_news(title, upload_date, content) VALUES(?,?,?)";
		connection = getConnectionInstance();
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setDate(2, date);
			pstmt.setString(3, content);
			flag = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (flag > 0) {
			return true;
		}
		return false;
	}
	
}
