<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<link rel="stylesheet" href="/sizaikanri/css/common.css" type="text/css" />
<script type="text/javascript" src="/sizaikanri/js/jquery.min.js"></script>
<div>
	<font color="blue">ユーザ:<s:property value="session.loginInfo.name" /></font>
	<font color="blue">部署:<s:property value="session.loginInfo.depname" /></font>
	<font color="blue">権限:
	<s:if test="session.loginInfo.role_class == 1" >一般ユーザ</s:if>
	<s:if test="session.loginInfo.role_class == 2" >部門長</s:if>
	<s:if test="session.loginInfo.role_class == 3" >発注担当者</s:if>
	<s:if test="session.loginInfo.role_class == 4" >倉庫管理者</s:if>
	<s:if test="session.loginInfo.role_class == 5" >システム管理者</s:if>
	</font>
</div>
<div class="cp_navi">
<ul>
    <s:if test="session.loginInfo.role_class == 1" >
	<li><a href="/sizaikanri/requestList/init" >購入依頼</a></li>
	</s:if>
	<s:if test="session.loginInfo.role_class == 2" >
	<li><a href="/sizaikanri/approvalList/init" >購入承認</a></li>
	</s:if>
	<s:if test="session.loginInfo.role_class == 3 || session.loginInfo.role_class == 5" >
	<li>
		<a href="#">発注・納品 <span class="caret"></span></a>
		<div>
			<ul>
				<li><a href="/sizaikanri/order/init" >発注</a></li>
				<li><a href="/sizaikanri/delever/init" >納品</a></li>
			</ul>
		</div>
	</li>
	</s:if>
	<s:if test="session.loginInfo.role_class == 4 || session.loginInfo.role_class == 5" >
	<li>
		<a href="#">入庫・出庫 <span class="caret"></span></a>
		<div>
			<ul>
				<li><a href="/sizaikanri/inStore/init" >入庫</a></li>
				<li><a href="/sizaikanri/outStore/init" >出庫</a></li>
			</ul>
		</div>
	</li>
	</s:if>
	<li><a href="/sizaikanri/logout" >ログアウト</a></li>
</ul>
</div>
<br/>

<div>
	<s:if test="messageflag == true">
		<font color="green"><s:property value="message" /></font>
	</s:if>
	<s:if test="messageflag == false">
		<font color="red"><s:property value="message" /></font>
	</s:if>
</div>
