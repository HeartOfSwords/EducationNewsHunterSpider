package com.hunter.auto.bean;

import java.util.Date;

/**
 * 教育新闻实体
 * @author snowalker
 * 16.7.25
 */
public class EducationNews {
	
	private Integer id;			//新闻id
	
	private String title;		//新闻题目
	
	private Date upload_date;	//上传时间
	
	private String content;		//新闻内容
	
	private String source;		//新闻来源
	
	public EducationNews() {
	}
	
	public EducationNews(Integer id, String title, Date upload_date, String content, String source) {
		super();
		this.id = id;
		this.title = title;
		this.upload_date = upload_date;
		this.content = content;
		this.source = source;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public Date getUpload_date() {
		return upload_date;
	}

	public void setUpload_date(Date upload_date) {
		this.upload_date = upload_date;
	}


	public void setContent(String content) {
		this.content = content;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}


	
}
