<%@ page language="java" contentType="text/html; charset=SJIS" pageEncoding="SJIS"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=SJIS">
    <title>�G���[�y�[�W</title>
  </head>
 
  <body>
    <h2>�G���[�y�[�W</h2>
    <h4>The application has malfunctioned.</h4>
    <p><a href="<s:url action='index' />" >�߂�</a></p>
    <p>�V�X�e���Ǘ����ɂ��A�����������B</p> 
    <h4>�ُ탁�b�Z�[�W�F<s:property value="exception" /> </h4>

    <!-- <h4>Exception Details: <s:property value="exceptionStack" /></h4>  -->
  </body>
</html>