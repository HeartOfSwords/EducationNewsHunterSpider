package com.hunter.dao;

import java.sql.Date;

/**
 * 数据访问层接口
 * @author snowalker
 * 16.7.26
 */
public interface HunterDao {
	
	//数据持久化
	public boolean saveData(String title, Date date, String content);
}
