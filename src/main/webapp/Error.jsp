<%@ page language="java" contentType="text/html; charset=SJIS" pageEncoding="SJIS"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=SJIS">
    <title>エラーページ</title>
  </head>
 
  <body>
    <h2>エラーページ</h2>
    <h4>The application has malfunctioned.</h4>
    <p><a href="<s:url action='index' />" >戻る</a></p>
    <p>システム管理員にご連絡ください。</p> 
    <h4>異常メッセージ：<s:property value="exception" /> </h4>

    <!-- <h4>Exception Details: <s:property value="exceptionStack" /></h4>  -->
  </body>
</html>