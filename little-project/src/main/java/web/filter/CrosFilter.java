//参考：https://www.cnblogs.com/paradise1352/p/12794108.html

package web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;


@WebFilter(urlPatterns = "/*",filterName = "CrosFilter")
public class CrosFilter implements Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("进入过滤器CrosFilter");
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		httpServletResponse.setHeader("Access-Control-Allow-Origin", "*"); //前端不会报错
		
//		httpServletResponse.setHeader("Access-Control-Allow-Credentials","true");
//		httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
//		httpServletResponse.setHeader("Access-Control-Max-Age", "3600"); //设置过期时间
//		httpServletResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, client_id, uuid, Authorization");
//		httpServletResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // 支持HTTP 1.1.
//		httpServletResponse.setHeader("Pragma", "no-cache"); // 支持HTTP 1.0. response.setHeader("Expires", "0");
        
		chain.doFilter(request, response);
		System.out.println("过滤器CrosFilter放行");
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
