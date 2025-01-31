<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>購入依頼一覧</title>
<link rel="stylesheet" type="text/css" href="/css/common.css">
</head>
<body>
	<div>
		<h2>購入依頼一覧</h2>
	</div>
	<div>
		<form name="dateform" action="/sizaikanri/requestList/search" method="post">
			<label>From:</label>
			<input type="date" name="requestF.fromTime" value="<s:property value="requestF.fromTime"/>"/> 
			<label>To:</label> 
			<input type="date" name="requestF.toTime" value="<s:property value="requestF.toTime"/>"/>
			<input type="submit" value="検索" />
		</form>
	</div>
	<div>
		<table class="outputtable">
			<tr>
				<th><font>資材ID</font></th>
				<th><font>資材名</font></th>
				<th><font>数量</font></th>
				<th><font>カテゴリ</font></th>
				<th><font>購入依頼者</font></th>
				<th><font>購入依頼部門</font></th>
				<th><font>状態</font></th>
				<th><font>依頼日</font></th>
				<th><font>撤回</font></th>
			</tr>
			<s:iterator value="requestF.sizaiDtoList">
				<tr>
					<td><font><s:property value="id"/></font></td>
					<td><a href="http://localhost:8080/sizaikanri/requestDetail/init?requestDF.request_id=<s:property value="id"/>"><s:property value="name"/></a></td>
					<td><font><s:property value="num"/></font></td>
					<td><font><s:property value="category_name"/></font></td>
					<td><font><s:property value="request_user_name"/></font></td>
					<td><font><s:property value="request_dept_name"/></font></td>
					<td><font><s:property value="status_name"/></font></td>
					<td><font><s:property value="request_date"/></font></td>
					<s:if test="status == 1 or status == 3">
						<td><a href="http://localhost:8080/sizaikanri/requestList/delete?requestF.request_id=<s:property value="id"/>">撤回</a></td>
					</s:if>
					<s:if test="status != 1 and status != 3">
						<td><font color="red">撤回不可</font></td>
					</s:if>
				</tr>
			</s:iterator>
		</table>
	</div>
	<br/>
	<div><a href="http://localhost:8080/sizaikanri/requestRegist/init">購入依頼登録</a></div>
</body>
</html>