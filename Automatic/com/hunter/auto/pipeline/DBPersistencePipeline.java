package com.hunter.auto.pipeline;

import java.sql.Date;
import java.text.SimpleDateFormat;

import com.hunter.auto.bean.EducationNews;
import com.hunter.dao.HunterDao;
import com.hunter.dao.HunterDaoImpl;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * 数据库持久化pipeline
 * @author snowalker
 * 16.7.26
 */
public class DBPersistencePipeline implements Pipeline {

	private EducationNews educationNews;
	
	private HunterDao hunterDao;
	
	@Override
	public void process(ResultItems resultItems, Task task) {
		//获取实例
		educationNews = (EducationNews) resultItems.get("educationNews");
		//拆分实例并持久化
		String title = educationNews.getTitle();
		String content = educationNews.getContent();
		//获取持久层
		hunterDao = new HunterDaoImpl();
		boolean flag = hunterDao.saveData(title, 
				new Date(System.currentTimeMillis()), 
				content);
		if (flag) {
			System.out.println("持久化成功");
		} else {
			System.out.println("持久化失败");
		}
	}

}
