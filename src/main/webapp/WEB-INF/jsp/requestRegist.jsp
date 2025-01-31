<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>購入依頼登録</title>
<link rel="stylesheet" type="text/css" href="/css/common.css">
<style>
    textarea {
        width: 400px;  /* 指定宽度 */
        height: 100px; /* 指定高度 */
    }
</style>
</head>
<body>
	<div>
		<h2>購入依頼登録</h2>
	</div>
	<br/>
	<div><font color="blue">購入理由、補足事項を備考欄に記載してください。</font></div>
	<div>
		<form name="requestRegistForm" action="/sizaikanri/requestRegist/regist" method="post">
			<table class="inputtable">
				<tr>
					<td><label>資材名</label></td>
					<td><input type="text" name="requestRF.sizaiDto.name"/></td>
				</tr>
				<tr>
					<td><label>数量</label></td>
					<td><input 
							type="number" 
							min="1" 
							max="999" 
							step="1" 
							oninput="this.value = Math.min(Math.max(this.value, 1), 999)"
							name="requestRF.sizaiDto.num"/>
					</td>
				</tr>
				<tr>
					<s:select 
							name="requestRF.sizaiDto.category_id" 
							label="カテゴリ" 
							list="requestRF.categoryList" 
							listKey="id" 
							listValue="name"/>
				</tr>
				<tr>
					<td><label>備考</label></td>
					<td><textarea name="requestRF.sizaiDto.note"></textarea></td>
				</tr>
			</table>
			<input type="submit" value="登録"/>
			<input type="reset" value="クリア"/>
		</form>
	</div>
	<div><a href="/sizaikanri/requestList/init">一覧へ戻る</a></div>
</body>
</html>