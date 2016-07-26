package com.hunter.auto.processor;

import com.hunter.auto.bean.EducationNews;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * 腾讯新闻解析器
 * @author snowalker
 *
 */
public class TencentNewsProcessor implements PageProcessor {

	/**
	 * 格式化输出整数
	 * @param i
	 * @return XXXXXi
	 * 输入一个整数0-9999
	 * 返回格式为000i-9999
	 */
	public static String IntegerFomatterUtil(int i) {
		String string = String.format("%04d", i);
		return string;
	}
	/**
	 * 抓取网站的相关配置，编码，抓取间隔，重试次数等
	 */
	private Site site = Site.me()
			.setRetryTimes(3)
			.setSleepTime(100)
			.setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64; rv:47.0) Gecko/20100101 Firefox/47.0")
			.setTimeOut(400);

	@Override
	public Site getSite() {
		return site;
	}
	/**
	 * 核心逻辑，在此处编写抽取的核心业务
	 */
	@Override
	public void process(Page page) {
		// 部分二：定义如何抽取页面信息，并保存下来
		//题目
		String title = page.getHtml().xpath("//*[@id='C-Main-Article-QQ']/div[1]/h1").toString();
		//正文
		String content = page.getHtml().xpath("//*[@id='Cnt-Main-Article-QQ']").toString();
		page.putField("title", title);
        page.putField("content", content);
        /**
         * 保存数据到对象中
         */
        EducationNews educationNews = new EducationNews();
        educationNews.setTitle(page.getHtml().xpath("//*[@id='C-Main-Article-QQ']/div[1]/h1").toString());
        educationNews.setContent(page.getHtml().xpath("//*[@id='Cnt-Main-Article-QQ']").toString());
        //空内容则跳过
        if (educationNews.getContent() == null) {
        	 page.setSkip(true);
		} else {
			//不为空则设值
			page.putField("educationNews", educationNews);
		}
        
        // 部分三：从页面发现后续的url地址来抓取
        //获取所有满足正则表达式的连接并添加到队列中去		http://edu\\.qq\\.com/a
        page.addTargetRequests(page.getHtml().links().regex("(http://edu\\.qq\\.com/\\a/\\w+/\\w+/\\.htm)").all());
	}

}
