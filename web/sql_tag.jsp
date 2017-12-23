<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="me.dao.VersionDao" %>
<%@ page import="me.bean.Version" %>
<%@ page import="java.io.*,java.util.*,java.sql.*" %>
<%--
  Created by IntelliJ IDEA.
  User: zzc
  Date: 2017/12/13
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <title>sql_tag</title>
</head>
<body>
<div><h1>sql_tag</h1></div>
<%
    VersionDao vd = new VersionDao();
    Version vs = vd.getVersion();
    out.println("ok");
    if (vs != null) {
        out.println(vs.getVersion());
        out.println(vs.getDate_time());
    } else out.println("empty");
    out.println("end");

    ResourceBundle resource = ResourceBundle.getBundle("jdbc");
    pageContext.setAttribute("passwd", resource.getString("dataSource.password"));
    pageContext.setAttribute("username", resource.getString("dataSource.username"));
    pageContext.setAttribute("url", resource.getString("dataSource.url"));
    pageContext.setAttribute("driver", resource.getString("dataSource.driverClassName"));

%>
<sql:setDataSource var="snapshot" scope="application"
                   driver="${driver}" url="${url}" user="${username}" password="${pageScope.passwd}"/>
<sql:query var="result" dataSource="${snapshot}">
    select * from version;
</sql:query>
<table>
    <tr>
        <c:forEach var="row" items="${result.rows}">
    <tr>
        <td><c:out value="${row.version}"/></td>
        <td><c:out value="${row.date_time}"/></td>
    </tr>
    </c:forEach>
    </tr>
</table>

<form action="/tow" method="POST" enctype="multipart/form-data">
    <table align="center" border="1" width="50%">
        <tr>
            <td>选择要上传的文件:</td>
            <td><input type="text" name="file"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="上传"></td>
        </tr>
    </table>
</form>
</body>
</html>
