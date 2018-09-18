package com.test.filter;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CharactorFilter
 */
@WebFilter("/CharactorFilter")
public class CharactorFilter implements Filter {
	String encoding = null;
    /**
     * Default constructor. 
     */
    public CharactorFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		encoding = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
//		HttpServletRequest req = (HttpServletRequest)request;   ��ServletRequestת��ΪHttpServletRequest
//		HttpServletResponse res = (HttpServletResponse)response;
		if(encoding !=null){
			request.setCharacterEncoding(encoding);
			
			response.setContentType("text/html;charset="+encoding);	
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		encoding = fConfig.getInitParameter("encoding");
	}

}
