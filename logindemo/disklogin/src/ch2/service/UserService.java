/**
 * 
 */
package ch2.service;

import java.sql.Connection;
import java.util.List;

import ch2.dao.UserDAO;
import ch2.dao.impl.UserDAOImpl;
import ch2.util.db.Database;
import ch2.util.mail.MailUtil;
import ch2.vo.User;

/**
 * @author Administrator
 *
 */
public class UserService {
	private UserDAO userDAO=new UserDAOImpl();

    public UserService() {
    }

    public void addUser(User user,String basePath)throws Exception{
		Connection connection = null;
		
		StringBuffer body=new StringBuffer();
		StringBuffer link=new StringBuffer();
		body.append("您在XXX网站新注册的用户名是：");
		body.append(user.getUid());
		body.append(",请点击以下链接激活帐号！\n");
		link.append(basePath);
		link.append("activeUser.jsp?uid=");
		link.append(user.getUid());
		link.append("&validateCode=");
		link.append(user.getValidateCode());
		body.append(link.toString());
		try{
			connection=Database.getConnection();
			userDAO.setConnection(connection);
			userDAO.addUser(user);
			MailUtil.sendEmail(user.getEmail(),"XXX网站用户注册激活码",body.toString());
			Database.commit();
		}catch(Exception e){
			e.printStackTrace();
			Database.rollback();
			throw e;
		}finally{
			Database.releaseConnection(connection);
		}
	}
   public void deleteUser(String uid)throws Exception{
		Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   userDAO.setConnection(connection);
		   userDAO.deleteUser(uid);
		   Database.commit();
	   }catch(Exception e){
		   e.printStackTrace();
		   Database.rollback();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);
	   }
   }
   public void updateUser(User user)throws Exception{
		Connection connection = null;
		try{
		   connection=Database.getConnection();
		   userDAO.setConnection(connection);
		   userDAO.updateUser(user);
		   Database.commit();
	   }catch(Exception  e){
		   e.printStackTrace();
		   Database.rollback();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);
	   }
   }
   public List listAllUser()throws Exception{
	   List userList=null;
	   Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   userDAO.setConnection(connection);
		   userList=userDAO.listAllUser();
	   }catch(Exception e){
		   e.printStackTrace();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);		   
	   }	   
	   return userList;
   }
   public User getUser(String uid)throws Exception{
	   User user=null;
	   Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   userDAO.setConnection(connection);
		   user=userDAO.getUser(uid);
	   }catch(Exception e){
		   e.printStackTrace();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);
	   }
	   return user;
   }
   public boolean login(String uid,String password)throws Exception{
//	   User user=null;
//	   boolean result=false;
//	   Connection connection = null;
//	   try{
//		   connection=Database.getConnection();
//		   userDAO.setConnection(connection);
//		   user=userDAO.getUser(uid);
//		   if(user!=null){
//			   if(user.getPassword().equals(password)){
//				   user.setLoginNum(user.getLoginNum()+1);
//				   userDAO.updateUser(user);
//				   Database.commit();
//				   result=true;
//			   }
//			   else{ result=false; }
//		   }else{ result=false;}
//	   }catch(Exception e){
//		   e.printStackTrace();
//		   Database.rollback();
//		   throw e;
//	   }finally{
//		   Database.releaseConnection(connection);
//	   }
//	   return result;
       return true;
   }
   public boolean checkUid(String uid)throws Exception{	   
	   try{
		   User user=getUser(uid);
		   if(user==null)
			   return false;
		   else
			   return true;
	   }catch(Exception e){
		   throw e;
	   }
   }
   public boolean validateUser(String uid,String validateCode)throws Exception{
	   UserDAO userDAO=new UserDAOImpl();
	   Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   userDAO.setConnection(connection);
		   User user=userDAO.getUser(uid);
		   if(user!=null){
			   if(user.getValidateCode().equals(validateCode)){
				   user.setValidateCode("activated");
				   userDAO.updateUser(user);
				   Database.commit();
				   return true;
			   }
		   }
	   }catch(Exception e){
		   e.printStackTrace();
		   Database.rollback();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);
	   }
	   return false;
   }
/**
 * @return Returns the userDAO.
 */
public UserDAO getUserDAO() {
	return userDAO;
}
/**
 * @param userDAO The userDAO to set.
 */
public void setUserDAO(UserDAO userDAO) {
	this.userDAO = userDAO;
}
   
}
