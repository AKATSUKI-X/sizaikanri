<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>購入依頼詳細</title>
<link rel="stylesheet" type="text/css" href="/css/common.css">
<style>
    textarea {
        width: 400px;  /* 指定宽度 */
        height: 100px; /* 指定高度 */
    }
</style>
<script>
    window.onload = function() {
        var flag = document.body.getAttribute("data-flag"); 

        var inputs = document.querySelectorAll(".seigyo");

        if (flag === "false") {  
            inputs.forEach(function(input) {
                input.disabled = true; // 非活性にする
            });
        }
    };
</script>
</head>
<body data-flag="<s:property value="requestDF.flag" />">
	<div>
		<h2>購入依頼詳細</h2>
	</div>
	<br/>
	<div><font color="blue">購入理由、補足事項を備考欄に記載してください。</font></div>
	<div>
		<form name="requestDetailForm" action="/sizaikanri/requestDetail/modify" method="post">
			<table class="inputtable">
				<tr>
					<td><label>資材ID</label></td>
					<td>
						<font name="requestDF.sizaiDto.id"><s:property value="requestDF.sizaiDto.id"/></font>
						<input type="hidden" name="requestDF.sizaiDto.id" value="<s:property value='requestDF.sizaiDto.id'/>"/>
					</td>
				</tr>
				<tr>
					<td><label>資材名</label></td>
					<td><input 
							class="seigyo" 
							type="text" 
							name="requestDF.sizaiDto.name" 
							value="<s:property value="requestDF.sizaiDto.name"/>"/>
					</td>
				</tr>
				<tr>
					<td><label>数量</label></td>
					<td><input 
							class="seigyo"
							type="number" 
							min="1" 
							max="999" 
							step="1" 
							oninput="this.value = Math.min(Math.max(this.value, 1), 999)"
							name="requestDF.sizaiDto.num" 
							value="<s:property value="requestDF.sizaiDto.num"/>"/>
					</td>
				</tr>
				<tr>
					<s:select 
							class="seigyo"
							name="requestDF.sizaiDto.category_id" 
							label="カテゴリ" 
							list="requestDF.categoryList" 
							listKey="id" 
							listValue="name"/>
				</tr>
				<tr>
					<td><label>購入依頼者</label></td>
					<td><font><s:property value="requestDF.sizaiDto.request_user_name"/></font></td>
				</tr>
				<tr>
					<td><label>購入依頼部門</label></td>
					<td><font><s:property value="requestDF.sizaiDto.request_dept_name"/></font></td>
				</tr>
				<tr>
					<td><label>状態</label></td>
					<td><font><s:property value="requestDF.sizaiDto.status_name"/></font></td>
				</tr>
				<tr>
					<td><label>依頼日</label></td>
					<td><font><s:property value="requestDF.sizaiDto.request_date"/></font></td>
				</tr>
				<tr>
					<td><label>備考</label></td>
					<td><textarea 
							class="seigyo"
							name="requestDF.sizaiDto.note"><s:property value="requestDF.sizaiDto.note"/></textarea>
					</td>
				</tr>
			</table>
			<input class="seigyo" type="submit" value="更新"/>
		</form>
	</div>
	<div><a href="/sizaikanri/requestList/init">一覧へ戻る</a></div>
</body>
</html>