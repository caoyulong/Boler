<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <title>招聘者主页</title>
  <%@ include file="/WEB-INF/views/head.jsp"%>
  <link href="resources/css/boler.css" rel="stylesheet" />
  <script src="resources/js/employ/employ.js"></script>
  <script src="resources/js/user/user.js"></script>
</head>
<body>
  <header></header>
  <div class="container">
    <div class="row">
      <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
          <div class="navbar-header">
            <a class="navbar-brand" href="#">Boler</a>
          </div>
          <div>
            <ul class="nav navbar-nav">
              <li id="allApp"><a href="javascript:void(0)">求职申请</a></li>
              <li id="pageAllRecruits"><a href="javascript:void(0)">招聘启事</a></li>
              <li id="pageEmailTemp"><a href="javascript:void(0)">邮件模板</a></li>
              <li class="divider"></li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">用 户<b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li><a id="modifyPassword" href="javascript:void(0)">修改密码</a></li>
                  <li><a id="logout" href="javascript:void(0)">注 销</a></li>
                </ul>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </div>
    <div class="row" id="content" style="padding-top:50px;padding-bottom:50px;"></div>
  </div>
  <footer class="footer">
    <%@ include file="/WEB-INF/views/foot.jsp"%>
  </footer>
</body>
</html>