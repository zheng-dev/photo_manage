<%--
  Created by IntelliJ IDEA.
  User: zzc
  Date: 2017/12/18
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add_photo</title>
</head>
<body>
<div>
    <%= request.getParameter("state")%>
</div>
<form action="/add_photo" method="POST" enctype="multipart/form-data">
    <table align="center" border="1" width="50%">
        <tr>
            <td>选择要上传的文件:</td>
            <td><input type="file" name="file"></td>
        </tr>
        <tr>
            <td>图片名:</td>
            <td><input type="text" name="photo_name"></td>
        </tr>
        <tr>
            <td>描述:</td>
            <td><input type="text" name="description"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="上传"></td>
        </tr>
    </table>
</form>
</body>
</html>
