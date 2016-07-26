package com.hunter.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Jsoup工具类
 * 接收一个URL
 * 返回对应的网页标题和正文
 * @author snowalker
 * 16.7.26
 */
public class JsoupUtils {
	
	private static String title;
	private static Document docs;
	private static String articleContent;

	/**
	 * 返回文章标题
	 * @param url
	 * @return title
	 */
	public static String getArticleTitle(String url) {
		try {
			docs = Jsoup.connect(url).timeout(3000)           // 设置连接超时时间
					.get();

			//文章标题
			Elements articleTitle = docs.select("#C-Main-Article-QQ > div.hd > h1");
			for (Element element : articleTitle) {
				title = element.html();
			}
		} catch (Exception e) {
			System.out.println("没有发现内容");
		}
		return title;
	}
	
	public static String getArticleContent(String url) {
		try {
			docs = Jsoup.connect(url).timeout(3000)           // 设置连接超时时间
					.get();

			//正文html
			Element contentHtml = docs.getElementById("Cnt-Main-Article-QQ");
			articleContent = contentHtml.html();
		} catch (Exception e) {
			System.out.println("没有发现内容");
		}
		return articleContent;
	}
	

}
