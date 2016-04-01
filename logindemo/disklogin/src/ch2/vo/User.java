/**
 * 
 */
package ch2.vo;

/**
 * @author Administrator
 */
public class User {
	private int id;

	private String uid;

	private String password;

	private String email;

	private String validateCode;
	
	private int loginNum;


	/**
	 * @return Returns the email.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            The email to set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            The id to set.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return Returns the password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            The password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}



	/**
	 * @return Returns the uid.
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * @param uid
	 *            The uid to set.
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * @return Returns the validateCode.
	 */
	public String getValidateCode() {
		return validateCode;
	}

	/**
	 * @param validateCode
	 *            The validateCode to set.
	 */
	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	/**
	 * @return Returns the loginNum.
	 */
	public int getLoginNum() {
		return loginNum;
	}

	/**
	 * @param loginNum The loginNum to set.
	 */
	public void setLoginNum(int loginNum) {
		this.loginNum = loginNum;
	}

}
