<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>入庫画面</title>
<link rel="stylesheet" type="text/css" href="/css/common.css">
</head>
<body>
	<div>
		<h2>入庫</h2>
	</div>
	<hr />
	<div id="disdiv" style="display: none">
		<video id="preview" width="300" height="300"></video>
	</div>
	<button id="scanbutton" onclick="scan()">QRコード読取</button>
	<div>
		<form name="storeForm" action="/sizaikanri/inStore/search"
			method="post">
			<input 
				id="target" 
				type="number" 
				min="1" 
				max="999" 
				step="1"
				value="1"
				oninput="this.value = Math.min(Math.max(this.value, 1), 999)"
				name="storeF.request_id" /> 
			<input type="submit" value="検索" />
		</form>
	</div>
	<hr/>
	<s:if test="storeF.falg">
	<div>
		<form action="/sizaikanri/inStore/act" method="post">
			<table class="inputtable">
				<tr>
					<td><label>資材ID</label></td>
					<td>
						<font><s:property value="storeF.sizaiDto.id"/></font>
						<input type="hidden" name="storeF.sizaiDto.id" value="<s:property value='storeF.sizaiDto.id'/>"/>
					</td>
				</tr>
				<tr>
					<td><label>資材名</label></td>
					<td>
						<font><s:property value="storeF.sizaiDto.name"/></font>
					</td>
				</tr>
				<tr>
					<td><label>数量</label></td>
					<td>
						<font><s:property value="storeF.sizaiDto.num"/></font>
					</td>
				</tr>
				<tr>
					<td><label>カテゴリ</label></td>
					<td>
						<font><s:property value="storeF.sizaiDto.category_name"/></font>
					</td>
				</tr>
				<tr>
					<td><label>状態</label></td>
					<td>
						<font><s:property value="storeF.sizaiDto.status_name"/></font>
					</td>
				</tr>
				<s:if test="storeF.sizaiDto.status == 5">
					<tr>
					<s:select 
							name="storeF.sizaiDto.souko_id" 
							label="倉庫" 
							list="storeF.soukoDtoList" 
							listKey="id" 
							listValue="name"/>
					</tr>
				</s:if>
				<s:if test="storeF.sizaiDto.status != 5">
					<tr>
						<td><label>倉庫</label></td>
						<td>
							<font><s:property value="storeF.sizaiDto.souko_name"/></font>
						</td>
					</tr>
				</s:if>
				<tr>
					<td><label>購入依頼者</label></td>
					<td>
						<font><s:property value="storeF.sizaiDto.request_user_name"/></font>
					</td>
				</tr>
				<tr>
					<td><label>購入依頼部門</label></td>
					<td>
						<font><s:property value="storeF.sizaiDto.request_dept_name"/></font>
					</td>
				</tr>
				<tr>
					<td><label>依頼日</label></td>
					<td>
						<font><s:property value="storeF.sizaiDto.request_date"/></font>
					</td>
				</tr>
				<tr>
					<td><label>発注日</label></td>
					<td>
						<font><s:property value="storeF.sizaiDto.order_date"/></font>
					</td>
				</tr>
				<tr>
					<td><label>入庫日</label></td>
					<td>
						<font><s:property value="storeF.sizaiDto.instore_date"/></font>
					</td>
				</tr>
				<tr>
					<td><label>出庫日</label></td>
					<td>
						<font><s:property value="storeF.sizaiDto.outstore_date"/></font>
					</td>
				</tr>
				<tr>
					<td><label>備考</label></td>
					<td>
						<font><s:property value="storeF.sizaiDto.note"/></font>
					</td>
				</tr>
			</table>
			<s:if test="storeF.sizaiDto.status == 5">
				<input type="submit" value="入庫"/>
			</s:if>
		</form>
	</div>
	</s:if>
	
</body>
</html>