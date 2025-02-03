<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>発注画面</title>
<link rel="stylesheet" type="text/css" href="/css/common.css">
</head>
<body>
	<div>
		<h2>発注</h2>
	</div>
	<hr/>
	<div>
		<form name="orderform" action="/sizaikanri/order/search" method="post">
			<s:select 
				name="orderDeliverF.request_dept_id"
				list="orderDeliverF.departmentDtoList"
				listKey="id" 
				listValue="name"/>
			<br/>
			<input type="submit" value="検査"/>
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
				<th><font>発注</font></th>
			</tr>
			<s:iterator value="orderDeliverF.sizaiDtoList">
				<tr>
					<td><font><s:property value="id"/></font></td>
					<td><a target="under" href="http://localhost:8080/sizaikanri/approvalDetail/init?approvalDF.request_id=<s:property value="id"/>"><s:property value="name"/></a></td>
					<td><font><s:property value="num"/></font></td>
					<td><font><s:property value="category_name"/></font></td>
					<td><font><s:property value="request_user_name"/></font></td>
					<td><font><s:property value="request_dept_name"/></font></td>
					<td><font><s:property value="status_name"/></font></td>
					<td><font><s:property value="request_date"/></font></td>
					<s:if test="status == 2">
						<td><a href="http://localhost:8080/sizaikanri/order/act?orderDeliverF.request_id=<s:property value="id"/>">発注</a></td>
					</s:if>
					<s:if test="status != 2">
						<td><font color="red">発注済</font></td>
					</s:if>
				</tr>
			</s:iterator>
		</table>
	</div>
	<hr/>
	<div>
		<iframe name="under" width="100%" height="400" style="border: none;"></iframe>
	</div>
</body>
</html>