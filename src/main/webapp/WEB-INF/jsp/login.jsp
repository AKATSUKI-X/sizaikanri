<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<div>
	<s:if test="messageflag == true">
		<font color="green"><s:property value="message" /></font>
	</s:if>
	<s:if test="messageflag == false">
		<font color="red"><s:property value="message" /></font>
	</s:if>
</div>
	<form name="loginform" action="./loginact" method="post">
		<table>
			<tr>
				<td><label>ユーザID</label></td>
				<td><input type="text" name="loginForm.id" /></td>
			</tr>
			<tr>
				<td><label>パスワード</label></td>
				<td><input type="password" name="loginForm.password" /></td>
			</tr>
			<tr>
			<td colspan="2">
			<input type="submit" value="ログイン"/>
			</td>
			</tr>
		</table>
	</form>
</body>
