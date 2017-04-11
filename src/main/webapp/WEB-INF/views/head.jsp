<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<base href="<%=basePath%>" />
<script src="http://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
  <link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" />
<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="resources/js/sha3.js"></script>
<script src="resources/js/sha3_util.js"></script>