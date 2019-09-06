package Action;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Bean.User;
import DAO.IUser;
import DAO.MySQLPrepareDb;
import DAO.UserImp;
import exception.LoginException;

public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	User userBean;
	String account;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	/**
	 * 登陆验证
	 * @return
	 */
	public String loginValidate(){
		String loginResult=ERROR;
		if (account.indexOf("@")==-1) {
			userBean.setUid(Integer.valueOf(account.trim()));
			userBean.setEmail(null);
		} else {
			userBean.setEmail(account);
			userBean.setUid(0);
		}
		IUser userDao=new UserImp();
		try {
			int uid=userDao.validateLogin(userBean);
			if (uid!=0) {
				loginResult=SUCCESS;
				Map<String,Object> sessionMap=ActionContext.getContext().getSession();
				sessionMap.put("loginedUser", uid);
			} else{
				loginResult=ERROR;
				throw new LoginException("登陆失败");
			}
		} catch (SQLException | LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loginResult;
	}
	public User getUserBean() {
		return userBean;
	}
	public void setUserBean(User userBean) {
		this.userBean = userBean;
	}
   
}
