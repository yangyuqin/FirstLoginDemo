<%@ page contentType="text/html; charset=utf-8" language="java"  errorPage="" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ut-8">
<title>用户注册</title>
</head>
<body>
<form name="userRegisterForm" method="post" action="Register" onsubmit="return checkForm(this)">

<table width="60%"  border="0" align="center" cellpadding="2" cellspacing="0" >
<caption>
<font color="blue" style="font-size: 20px">用户注册</font><br></caption>
  <tr bgcolor="#EFEFEF">
    <td height="40" width="25%" align="right">用户名:</td>
    <td width="30%" valign="middle">
      <input name="uid"type="text" id="uid" size="20" maxlength="50"></td>
    <td width="45%">*
        <input name="checkUser" type="button" value="查看是否被占用" onclick="checkUid();">
    </td>
  </tr>

  <tr><td height="40" align="right">密　码:</td>
    <td><input name="password" type="password" id="password" size="20" maxlength="50"></td>
    <td>*(长度为6～14位,支持数字、大小写字母和标点符号，不允许空格)</td>
  </tr>

  <tr bgcolor="#EFEFEF">
    <td height="40" align="right" valign="middle">密码确认:</td>
    <td><input name="confirmPassword" type="password" id="confirmPassword" size="20" maxlength="50"></td>
    <td>*(请再输一遍，以便确认) </td>
  </tr>
  <tr><td height="40" align="right" valign="middle">电子邮件:</td>
    <td><input name="email" type="text" size="20" maxlength="50"></td>
    <td>*(请输入正确的E-mail地址)</td>
  </tr>
  <tr>
    <td colspan="3" align="center">
        <input type="submit" value="提    交" style=font-size:16px;font-weight:bold;width:100px;height:30px;background-color:#C6BDBB >
    </td>
  </tr>
</table>
</form>
</body>
</html>

<script language="javascript">
	function checkForm(form){
		if(isEmpty(form.uid.value) || isEmpty(form.password.value) || isEmpty(form.confirmPassword.value) || isEmpty(form.email.value)){
			alert("请将必填项填写完整");
			return false;
		}
        if(form.password.value.length<6 || form.password.value.length>16){
            alert("密码长度不得少于6个字符，不得多于16个字符");
            return false;
        }
		if(form.password.value != form.confirmPassword.value){
            alert("两次密码不匹配");
            return false;
        }
        return true;
	}

	function isEmpty(str){
		if(str==null || str.length==0)
			return true;
		else 
			return false;
	}

	function checkUid(){
		var name=document.userRegisterForm.uid.value;
		if(name.length>0){
			window.open("checkUid.jsp?uid=" +name ,"检查用户名","toolbar=no, location=no,status=no,menubar=no, scrollbars=no,resizable=no,width=300,height=200");

        }
	}
</script>

