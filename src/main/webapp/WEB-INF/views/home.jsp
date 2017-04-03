<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
  <base href="${basePath}"/>
  <title>欢迎来到Boler</title>                                                                              154
  <link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" />
  <script src="http://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
  <script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="resources/js/user/user.js"></script>
  <script src="resources/js/sha3.js"></script>
  <script src="resources/js/sha3_util.js"></script>
</head>
<body>
  <div class="container">
    <div class="row_fluid">
      <div id="view" class="col-md-6">
        <h1>Boler 互联网招聘新伯乐</h1>
        <form id="loginForm">
          <div class="form-group">
            <input type="email" name="email" style="width: 200px" class="form-control" id="email" placeholder="用户名">
          </div>
          <div>
            <input type="password" name="password" id="password" placeholder="密 码" />
          </div>
        </form>
        <div>
          <span>
            <button id="loginBtn" class="btn btn-default">登 录</button>
          </span>
          <span>
            <button id="regBtn" class="btn btn-default">注 册</button>
          </span>
        </div>
      </div>
    </div>
  </div>
</html>
