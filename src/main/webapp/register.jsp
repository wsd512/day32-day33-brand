<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎注册</title>
    <link href="css/register.css" rel="stylesheet">
    <script src="js/axios-0.18.0.js"></script>
</head>
<body>

<div class="form-div">
    <div class="reg-content">
        <h1>欢迎注册</h1>
        <span>已有帐号？</span> <a href="login.jsp">登录</a>
    </div>
    <form id="reg-form" action="registerServlet" method="post">
        <table>
            <tr>
                <td>用户名</td>
                <td class="inputs">
                    <input name="username" type="text" id="username">
                    <br>
                    <span id="username_err" class="err_msg">${msg}</span>

                </td>
            </tr>

            <tr>
                <td>密码</td>
                <td class="inputs">
                    <input name="password" type="password" id="password">
                    <br>
                    <span id="password_err" class="err_msg" style="display: none">密码格式有误</span>
                </td>
            </tr>

            <tr>
                <td>验证码</td>
                <td class="inputs">
                    <input name="checkCode" type="text" id="checkCode">
                    <img id="checkCodeImg" src="checkCodeServlet">
                    <a href="javascript:changeImg();" id="changeImg">看不清？</a>
                    <script type="text/javascript">
                        function changeImg() {
                            document.getElementById("checkCodeImg").src = "checkCodeServlet?a=" + Math.random();
                        }
                    </script>
                </td>
            </tr>
        </table>

        <div class="buttons">
            <input value="注 册" type="submit" id="reg_btn">
        </div>
        <br class="clear">
    </form>
</div>
<script type="text/javascript">
    //用户名文本框失去焦点就判断
    document.getElementById("username").onblur = function () {
        //使用axios判断用户名是否存在
        axios.get("SelectUserServlet?username=" + this.value).then(resp => {
            document.getElementById("username_err").innerText = resp.data;
        });
    }
</script>
</body>
</html>