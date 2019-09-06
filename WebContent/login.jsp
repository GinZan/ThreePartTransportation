<%@ page pageEncoding="UTF-8"%>
<%-- <jsp:include page="commonjsp/var.jsp"></jsp:include> --%>
<!DOCTYPE html>
<html  class="no-js">
    <head>
        <meta charset="utf-8">
        <title>欢迎登入</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel="stylesheet" href="css/login/reset.css">
        <link rel="stylesheet" href="css/login/supersized.css">
        <link rel="stylesheet" href="css/login/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>
    <body>
        <div class="page-container">
            <h1>GinZan包车订票系统</h1>
            <form action="./validate/loginValidate" method="post">
                <input type="text"  name="account"  class="username" placeholder="邮箱或用户id">
                <input type="password" name="userBean.pass" class="password" placeholder="密码">
                <button type="submit">立即登入</button>
                <button>注册</button>
                <div class="error"><span>+</span></div>
            </form>
        </div>
        <!-- Javascript -->
        <script src="js/jquery-1.9.1.min.js"></script>
        <script src="js/login/supersized.3.2.7.min.js"></script>
        <script src="js/login/supersized-init.js"></script>
        <script src="js/login/scripts.js"></script>
    </body>
</html>

