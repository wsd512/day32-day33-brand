<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改品牌</title>
</head>
<body>

<h3>修改品牌</h3>
<form action="updateServlet" method="post">
    <input type="hidden" name="id" value="${brand.id}">
    品牌名称：<input name="brandName" value="${brand.brandName}"><br>
    企业名称：<input name="companyName" value="${brand.companyName}"><br>
    排序：<input name="ordered" value="${brand.ordered}"><br>
    描述信息：<textarea rows="5" cols="20" name="description">${brand.description}</textarea><br>
    状态：

    <input type="radio" name="status" value="0" ${brand.status==0?"checked=checked":""}>禁用
    <input type="radio" name="status" value="1" ${brand.status==1?"checked=checked":""}>启用<br>

    <input type="submit" value="提交">
</form>

</body>
</html>
