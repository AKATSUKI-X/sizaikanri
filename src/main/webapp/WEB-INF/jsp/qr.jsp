<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>


<html>
<head>
<script type="text/javascript" src="/sizaikanri/js/jquery.min.js"></script>
<script type="text/javascript" src="/sizaikanri/js/jquery.qrcode.min.js"></script>
<script>
$(function() {
  $('#qrcode').qrcode({width: 150, height: 150, text: '<s:property value="form.sizaiId"/>'});
});
</script>
</head>
<body>
<font>資材ID:<s:property value="form.sizaiId"/></font>
<br/>
<div id = "qrcode"></div>
<input type="button" value="QRコード印刷" onclick="window.print();" />
</body>