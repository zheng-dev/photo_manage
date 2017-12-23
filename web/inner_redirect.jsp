<%--
  Created by IntelliJ IDEA.
  User: zzc
  Date: 2017/12/13
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String err = request.getAttribute("state").toString();
    response.getWriter().print("request.getAttribute" + err);
%>
<html>
<head>
    <title>tow${requestScope.state}</title>
</head>
<body>
<div>
    <h1>tow</h1>
    <span>requestScope.state=${requestScope.state}</span>
</div>
</body>
</html>
