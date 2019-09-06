package interceptor;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import Bean.UserInfo;
import DAO.IUser;
import DAO.IUserInfo;
import DAO.UserInfoImp;

public class AdminAccessControlInterceptor extends AbstractInterceptor {

	public AdminAccessControlInterceptor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		 //取得请求的URL  
        String url = ServletActionContext.getRequest().getRequestURL().toString();  
        HttpServletResponse response=ServletActionContext.getResponse();  
        response.setHeader("Pragma","No-cache");            
        response.setHeader("Cache-Control","no-cache");     
        response.setHeader("Cache-Control", "no-store");     
        response.setDateHeader("Expires",0);  
        int loginedUser;
        //验证Session是否过期  
        if(!ServletActionContext.getRequest().isRequestedSessionIdValid()){  
            //session过期,转向session过期提示页,最终跳转至登录页面  
            return "tologin";  
        }  
        else{  
        	loginedUser = (int)ServletActionContext.getRequest().getSession().getAttribute("loginedUser");
        	IUserInfo userInfo=new UserInfoImp();
        	UserInfo userBean=userInfo.read(loginedUser);
        	if (userBean!=null) {
				if (userBean.getType()!="管理员"||userBean.getType()!="超级管理员") {
					return "tologin";
				}else{
					return ai.invoke();
				}
			}else {
				return "tologin";
			}
        }              
		        
	}

}
