package com.hunter.auto.serviceEngine;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 自动模式关闭
 * @author snowalker
 * 16.7.26
 */
public class Shutdown extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Shutdown() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
