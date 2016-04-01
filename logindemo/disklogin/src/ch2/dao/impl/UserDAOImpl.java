/**
 * 
 */
package ch2.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ch2.dao.UserDAO;
import ch2.util.db.Database;
import ch2.vo.User;

/**
 * @author Administrator
 */
public class UserDAOImpl implements UserDAO {
	private Connection connection;

	public UserDAOImpl() {
		try {
			connection = Database.getConnection();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	/**
	 * @return Returns the connection.
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * @param connection
	 *            The connection to set.
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch2.dao.UserDAO#addUser(ch2.vo.User)
	 */
	public void addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;

		try {
			ps = connection
					.prepareStatement("Insert into user(uid,password,realName,gender,email,tel,question,answer,validateCode) values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, user.getUid());
			ps.setString(2, user.getPassword());
//			ps.setString(3, user.getRealName());
//			ps.setInt(4, user.getGender());
//			ps.setString(5, user.getEmail());
//			ps.setString(6, user.getTel());
//			ps.setString(7, user.getQuestion());
//			ps.setString(8, user.getAnswer());
			ps.setString(9, user.getValidateCode());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			closeStatement(ps);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch2.dao.UserDAO#updateUser(ch2.vo.User)
	 */
	public void updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;

		try {
			ps = connection
					.prepareStatement("update user set password=?,realName=?,gender=?,email=?,tel=?,question=?,answer=?,validateCode=?,loginNum=? where uid=? ");
			ps.setString(1, user.getPassword());
//			ps.setString(2, user.getRealName());
//			ps.setInt(3, user.getGender());
//			ps.setString(4, user.getEmail());
//			ps.setString(5, user.getTel());
//			ps.setString(6, user.getQuestion());
//			ps.setString(7, user.getAnswer());
			ps.setString(8, user.getValidateCode());
			ps.setInt(9, user.getLoginNum());
			ps.setString(10, user.getUid());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			closeStatement(ps);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch2.dao.UserDAO#deleteUser(java.lang.String)
	 */
	public void deleteUser(String uid) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement("delete from user where uid=?");
			ps.setString(1, uid);
			ps.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			closeStatement(ps);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch2.dao.UserDAO#listAllUser()
	 */
	public List listAllUser() throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		List result = null;

		try {
			ps = connection
					.prepareStatement("select * from user order by uid asc");
			rs = ps.executeQuery();
			User user = null;
			result = new ArrayList();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUid(rs.getString("uid"));
				user.setPassword(rs.getString("password"));
//				user.setRealName(rs.getString("realName"));
//				user.setGender(rs.getInt("gender"));
//				user.setEmail(rs.getString("email"));
//				user.setTel(rs.getString("tel"));
//				user.setQuestion(rs.getString("question"));
//				user.setAnswer(rs.getString("answer"));
				user.setValidateCode(rs.getString("validateCode"));
				user.setLoginNum(rs.getInt("loginNum"));
				result.add(user);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch2.dao.UserDAO#getUser(java.lang.String)
	 */
	public User getUser(String uid) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;

		try {
			ps = connection.prepareStatement("select * from user where uid=?");
			ps.setString(1, uid);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUid(rs.getString("uid"));
				user.setPassword(rs.getString("password"));
//				user.setRealName(rs.getString("realName"));
//				user.setGender(rs.getInt("gender"));
//				user.setEmail(rs.getString("email"));
//				user.setTel(rs.getString("tel"));
//				user.setQuestion(rs.getString("question"));
//				user.setAnswer(rs.getString("answer"));
				user.setValidateCode(rs.getString("validateCode"));
				user.setLoginNum(rs.getInt("loginNum"));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
		}
		return user;
	}

	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
				st = null;
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
	}
}
