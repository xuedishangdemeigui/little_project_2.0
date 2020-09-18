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
		System.out.println("��¼�ӿڱ�����");
		
		Map<String, String[]> map = req.getParameterMap();
		LoginInfo loginInfo=new LoginInfo();
		
		try {
			//��װ��¼��Ϣ
			BeanUtils.populate(loginInfo, map);
		} catch (IllegalAccessException e) {
			// û�з���Ȩ�ޣ������������һ���ı�������
			System.out.println("���ݷ�װʧ��");
			e.printStackTrace();
			return;
		} catch (InvocationTargetException e) {
			// �������õķ������ڲ��׳����쳣��û�б�����ʱ�����ɴ��쳣����
			System.out.println("���ݷ�װʧ��");
			e.printStackTrace();
			return;
		}
		
		System.out.println("�û���¼��Ϣ��"+loginInfo.toString());
		
		//����service�㷽��
		boolean flag = loginService.login(loginInfo);
		LoginResult result=new LoginResult();
		if(flag) {
			result.setMsg("��½�ɹ�");
			result.setStatusCode("0");
		}else {
			result.setMsg("��½ʧ��");
			result.setStatusCode("1");
		}
		
		//��result�������л�Ϊjson
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(result);
        //��json����д��ǰ��
        //����content-type
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(json);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}	
}
