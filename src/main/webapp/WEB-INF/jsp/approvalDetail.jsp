<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>購入承認詳細</title>
</head>
<body>
	<div>
		<h2>購入承認詳細</h2>
	</div>
	<div>
		<table style="border: none;">
			<tr>
				<td><font>資材ID</font></td>
				<td><font><s:property value="approvalDF.sizaiDto.id"/></font></td>
			</tr>
			<tr>
				<td><font>資材名</font></td>
				<td><font><s:property value="approvalDF.sizaiDto.name"/></font></td>
			</tr>
			<tr>
				<td><font>数量</font></td>
				<td><font><s:property value="approvalDF.sizaiDto.num"/></font></td>
			</tr>
			<tr>
				<td><font>購入依頼者</font></td>
				<td><font><s:property value="approvalDF.sizaiDto.request_user_name"/></font></td>
			</tr>
			<tr>
				<td><font>購入依頼部門</font></td>
				<td><font><s:property value="approvalDF.sizaiDto.request_dept_name"/></font></td>
			</tr>
			<tr>
				<td><font>状態</font></td>
				<td><font><s:property value="approvalDF.sizaiDto.status_name"/></font></td>
			</tr>
			<tr>
				<td><font>依頼日</font></td>
				<td><font><s:property value="approvalDF.sizaiDto.request_date"/></font></td>
			</tr>
			<tr>
				<td><font>備考</font></td>
				<td><font><s:property value="approvalDF.sizaiDto.note"/></font></td>
			</tr>
		</table>
	</div>
</body>
</html>