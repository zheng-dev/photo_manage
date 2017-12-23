<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="me.dao.PhotoInfoDao" %>
<%@ page import="java.util.List" %>
<%@ page import="me.bean.PhotoInfo" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="me.lib.Util" %>
<%--
  Created by IntelliJ IDEA.
  User: zzc
  Date: 2017/12/13
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>main</title>
    <style type="text/css">
        .center_dis {
            margin: 0 auto;
            display: block;
        }

        .page{
            display: block;
            height: 100px;
            width: 92px;
            background: url(/photo/slider_btn_icon_1fac543.png) no-repeat
        }
        .page:hover{background-color: #f3f3f3;}
        .pre{
            background-position: 0px -75px;
        }
        .next{
            background-position: -40px 15px;
        }

        .banner_op{
            display: block;
            position: absolute;
            margin-left: 46%;
            margin-top: 76px;
        }
        .banner_op img{width: 50px;height: 50px;}
        .banner_op_ext{margin-top: 0px;}
    </style>
</head>
<body>

<%
    PhotoInfoDao pd = new PhotoInfoDao();

    int start = 0;
    try {
        start = Integer.parseInt(request.getParameter("page"));
    } catch (Exception e) {
    }

    int number = 10;
    Map args = new HashMap();
    args.put("start", start * number);
    args.put("number", number);

    List<PhotoInfo> rows = pd.getRows(args);
%>


<div style="align-content: center;">
    <a onclick="banner_op(this)" href="#" class="banner_op"><img src="/photo/up.png" id="banner_op_img"/></a>
    <div id="banner" style="overflow: hidden">
        <a class="page pre" href="?page=<%=Math.max(0,start-1)%>" style="float: left;"> </a>
        <% for (PhotoInfo row : rows) { %>
        <img src="/photo/<%=row.getScale_photo()%>"
             onclick="javascript:document.getElementById('screen').src=
                     '/photo/<%=row.getFull_photo()%>'"/>
        <%}%>
        <a class="page next" href="?page=<%=start+1%>" style="float: right;"> </a>
    </div>
</div>
<img id="screen" class="center_dis"/>
<script type="text/javascript">
    var stat = 0
    function banner_op(doObj) {
        var obj = document.getElementById('banner');
        var bannerImg=document.getElementById('banner_op_img');
        if (stat == 0) {
            obj.style.height = "0px";
            doObj.className = "banner_op banner_op_ext";
            bannerImg.src="/photo/down.png";
            stat = 1;
        }
        else {
            obj.style.height = "";
            doObj.className = "banner_op";
            bannerImg.src="/photo/up.png";
            stat = 0;
        }

    }
</script>
</body>
</html>
