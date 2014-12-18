package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.gson.Gson;

@SuppressWarnings("serial")
public class AjaxreqtestServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
	 //If request type is GET 
		System.out.println("doget...");
		dosomethingwithreq(req ,resp);
	}
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
     //If request type is POST
		System.out.println("dopost..");
		dosomethingwithreq(req ,resp);
		
	}
	
	private void dosomethingwithreq(HttpServletRequest req,
			HttpServletResponse resp) {
		try {
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			resp.setHeader("Access-Control-Allow-Origin","*");
		 
			 Enumeration<String> parameterNames = req.getParameterNames();
			 HashMap map1 = new HashMap();
			 
			 while(parameterNames.hasMoreElements()){
				 //Getting parameterNames 
				 String paramName = parameterNames.nextElement();
				
		         
		         String[] paramValues = req.getParameterValues(paramName);
		         for(int i=0; i<paramValues.length; i++){
		        	 		        	 String paramvalue = paramValues[i];
		        	 map1.put(paramName, paramvalue);
		        	 
                 
		         }
				 
			 }
			 System.out.println("Printing parameters::"+map1);
//				System.out.println("-----------Gson ends------------");
			Gson gson = new Gson();
			String testgson = gson.toJson(map1);
			System.out.println("Json is ::"+testgson);
//				System.out.println("-----------Gson ends------------");
			  out.write(testgson);
			 out.close();

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
