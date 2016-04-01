<%@ page contentType="text/html;charset=utf-8" %>
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>用户登录</title> 
    <meta http-equiv="expires" content="0">
    <style type="text/css">.style1 {  color: #1c1d1c;font-size: 24px;font-weight: bold;}
    </style>
  </head>  
  <body>
  <center>
  	<form name="loginForm" method="post" action="loginAction.jsp" >
    <table width="50%" hight="" border="2"  align="center" cellpadding="5" cellspacing="1" bordercolor="#CCCCCC">
      <caption>
      <span class="style1">      登 录      </span><br>
      </caption>
      <tr align="left" >
        <th width="43%" height="45" align="right" scope="row">用 户 名:</th>
        <td width="60%"><input name="uid" type="text" id="uid" maxlength="20" style=height:30px></td>
      </tr>
      <tr align="left">
        <th width="43%" height="45" align="right" scope="row">密&nbsp;&nbsp;码:</th>
        <td><input name="password" type="password" id="password" maxlength="30" style=height:30px></td>
      </tr>
      <tr align="center">
        <th height="45" colspan="2" scope="row" >
            <input type="submit" value="登    录" style=font-size:16px;font-weight:bold;width:100px;height:30px;background-color:#C6BDBB >
            <input type="button" value="注    册" style=font-size:16px;font-weight:bold;width:100px;height:30px;background-color:#C6BDBB onclick="javascript:window.location='userRegister.jsp'">
        </th>
      </tr>
    </table>
    </form>
  </center>
  </body>
</html>
