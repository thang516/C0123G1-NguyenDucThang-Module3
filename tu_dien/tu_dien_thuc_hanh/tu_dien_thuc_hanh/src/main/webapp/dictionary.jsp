<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 4/26/2023
  Time: 10:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Dictionary</title>
</head>
<body>
<%!
 Map<String,String> dic = new HashMap<>();
%>
<%
dic.put("hello","Xin chào");
  dic.put("how", "Thế nào");
  dic.put("book", "Quyển vở");
  dic.put("computer", "Máy tính");
  String search = request.getParameter("search");
String result = dic.get(search);
if( result != null){

  System.out.println("Word:"+search);
  System.out.println("Result:"+ result);
}else {
  System.out.println("Not found");
}
%>

</body>
</html>
