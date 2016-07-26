package com.hunter.service;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hunter.dao.HunterDao;
import com.hunter.dao.HunterDaoImpl;
import com.hunter.util.JsoupUtils;
/**
 * URL解析器
 * 根据前台输入的URL对其所对应的页面进行解析
 * @author snowalker
 * 16.7.26
 */
public class URLPaser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HunterDao hunterDao;
       
    public URLPaser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//获取参数
		String url = request.getParameter("url");
		System.out.println(url);
		//传入参数进行处理,解析对应的内容
		String articleTitle = JsoupUtils.getArticleTitle(url);
		String articleContent = JsoupUtils.getArticleContent(url);
		//持久化数据
		hunterDao = new HunterDaoImpl();
		Boolean flag = hunterDao.saveData(articleTitle, new Date(System.currentTimeMillis()), articleContent);
		//判断返回结果进行请求转发
		if (flag == true) {
			request.setAttribute("message", "数据添加成功，请继续添加");
			request.getRequestDispatcher("HunterIndex").forward(request, response);
		} else {
			request.setAttribute("message", "数据添加失败，请核对url是否正确");
			request.getRequestDispatcher("HunterIndex").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
