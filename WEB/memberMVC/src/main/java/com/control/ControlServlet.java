package com.control;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.net.URLPermission;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = {"*.do"},
		initParams = {
				@WebInitParam(name = "propertyConfig", value = "command.properties")
			}
		)
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> map = new HashMap<String, Object>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {

		String propertyConfig = config.getInitParameter("propertyConfig");
		System.out.println("propertyConfig = " + propertyConfig);

		//@WebServlet로 서블릿을 등록했을 때
		String realFolder = config.getServletContext().getRealPath("/WEB-INF");
		String realPath = realFolder + "/" + propertyConfig;

		System.out.println("realPath : " + realPath);
		
		//command.properties의 파일의 내용을 읽어서 map에 보관
		FileInputStream fin = null;
        Properties properties = new Properties();
        

        try {

        	//WebServlet을 사용했을 때
        	fin = new FileInputStream(realPath); 
        	//Web.xml을 사용했을 때
//        	 fin = new FileInputStream(propertyConfig);
             properties.load(fin);
             System.out.println("properties = "+properties);
             

          } catch (IOException e) {
             e.printStackTrace();
          }finally{
             try {
                fin.close();
             } catch (IOException e) {
                e.printStackTrace();
             }
          }
          System.out.println();

          Iterator<Object> it = properties.keySet().iterator();
          while(it.hasNext()) {
             String key = (String)it.next();
             System.out.println("key = "+key);

             String className = properties.getProperty(key);
             System.out.println("className= "+className);

             try {
                Class<?> classType = Class.forName(className);
                Object ob = classType.getConstructor().newInstance();

                System.out.println("ob = "+ob);

                map.put(key, ob);

             } catch (ClassNotFoundException e) {
                e.printStackTrace();
             } catch (InstantiationException e) {
                e.printStackTrace();
             } catch (IllegalAccessException e) {
                e.printStackTrace();
             } catch (IllegalArgumentException e) {
                e.printStackTrace();
             } catch (InvocationTargetException e) {
                e.printStackTrace();
             } catch (NoSuchMethodException e) {
                e.printStackTrace();
             } catch (SecurityException e) {
                e.printStackTrace();
             }

             System.out.println();
          }//while
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request,response);
	}
	
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println();
		
		if(request.getMethod().equals("POST")) request.setCharacterEncoding("UTF-8");
		
		String category = request.getServletPath();
		System.out.println("category" + category);
		CommandProcess com = (CommandProcess) map.get(category);// Map 을 이용하여 key에 해당하는 값을 꺼내온다.
		
		String view= null;
	
		try {
			view = com.requestPro(request, response);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
		if(view.equals("")) {
			return;
		}
			
		//forward;
		RequestDispatcher dispatcher =  request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		
	}

}
