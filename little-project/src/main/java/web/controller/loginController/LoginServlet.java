package web.controller.loginController;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import web.domain.LoginInfo;
import web.domain.LoginResult;
import web.service.LoginService;
import web.service.impl.LoginServiceImpl;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet{
	
	private LoginService loginService=new LoginServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("登录接口被调用");
		
		Map<String, String[]> map = req.getParameterMap();
		LoginInfo loginInfo=new LoginInfo();
		
		try {
			//封装登录信息
			BeanUtils.populate(loginInfo, map);
		} catch (IllegalAccessException e) {
			// 没有访问权限，操作对象具有一定的保护级别
			System.out.println("数据封装失败");
			e.printStackTrace();
			return;
		} catch (InvocationTargetException e) {
			// 当被调用的方法的内部抛出了异常而没有被捕获时，将由此异常接收
			System.out.println("数据封装失败");
			e.printStackTrace();
			return;
		}
		
		System.out.println("用户登录信息："+loginInfo.toString());
		
		//调用service层方法
		boolean flag = loginService.login(loginInfo);
		LoginResult result=new LoginResult();
		if(flag) {
			result.setMsg("登陆成功");
			result.setStatusCode("0");
		}else {
			result.setMsg("登陆失败");
			result.setStatusCode("1");
		}
		
		//将result对象序列化为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(result);
        //将json数据写回前端
        //设置content-type
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(json);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}	
}
