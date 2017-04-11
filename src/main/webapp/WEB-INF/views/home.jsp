<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <title>欢迎来到Boler</title>
  <%@ include file="/WEB-INF/views/head.jsp"%>
  <script src="resources/js/user/user.js"></script>
</head>
<body>
  <div class="container">
    <div class="row">
      <div id="view" class="col-md-6 col-md-offset-3">
        <header class="header">
          <div class="banner-area" style="padding-top:50px;padding-bottom:50px;">
            <h1>Boler 互联网招聘新伯乐</h1>
          </div>
        </header>
        <div>
          <form role="form" id="loginForm">
            <div class="form-group">
              <span>
                <input type="email" name="email" style="width: 200px" class="form-control" id="email" placeholder="用户名">
              </span>
              <span id="loginFailed" class="alert alert-danger" style="display: none">
                用户名或密码不正确
              </span>
            </div>
            <div class="form-group">
              <span>
                <input type="password" name="password" id="password" placeholder="密 码" style="width: 200px" class="form-control" />
              </span>
              <span id="notComplete" class="alert alert-danger" style="display: none">
                请输入完整登录信息
              </span>
            </div>
          </form>
        </div>
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
  <footer class="footer" style="padding-top:50px;padding-bottom:50px;">
    <%@ include file="/WEB-INF/views/foot.jsp"%>
  </footer>
</body>
</html>
