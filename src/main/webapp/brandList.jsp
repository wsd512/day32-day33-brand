<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有品牌</title>
    <style>
        table{
            border-collapse: collapse;
        }
        tr:hover{
            background-color: yellow;
        }
    </style>
</head>
<body>

<input type="button" value="新增" onclick="location.href='addBrand.jsp';">
<input type="button" value="退出" onclick="location.href='LogoutServlet';">
<span>欢迎您,${user.username}</span>
<a href="login.jsp">登录页面</a>
<hr>
<center>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${brands}" var="brand" varStatus="row">
    <tr align="center">
        <td>${row.count}</td>
        <td>${brand.brandName}</td>
        <td>${brand.companyName}</td>
        <td>${brand.ordered}</td>
        <td>${brand.description}</td>
        <td>${brand.status==0?"禁用":"启用"}</td>
        <td><a href="selectByIdServlet?id=${brand.id}">修改</a> <a href="javascript:deleteBrand('${brand.id}','${brand.brandName}');">删除</a></td>
    </tr>
    </c:forEach>
</table>

</center>
</body>
<script type="text/javascript">
    function deleteBrand(id,brandName) {
        if(confirm("真的要删除"+brandName+"这一行吗?")){
            location.href=`deleteServlet?id=\${id}`;
        }
    }
</script>
</html>
