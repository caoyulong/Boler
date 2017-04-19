<div class="col-md-6 col-md-offset-3">
  <div>
    <form role="form" id="mdfPwdForm">
      <div class="form-group">
        <label for="oldPassword">旧密码</label>
        <input id="oldPassword" type="password" class="form-control" name="oldPassword" placeholder="请输入旧密码" required/>
      </div>
      <div class="form-group">
        <label for="newPassword">新密码</label>
        <input id="newPassword" type="password" class="form-control" name="newPassword" placeholder="请输入新密码" required/>
      </div>
      <div class="form-group">
        <label for="repeat">确认密码</label>
        <input id="repeat" type="password" class="form-control" name="repeat" placeholder="请再次输入" required/>
        <span id="notEqual" class="alert alert-warning blankData">
          密码不一致
        </span>
      </div>
    </form>
  </div>
  <div id="noData" class="alert alert-warning blankData">
    请输入密码信息
  </div>
  <div class="form-group col-md-6 col-md-offset-3">
    <button id="modifyPasswordSub" class="btn btn-default">确认修改</button>
  </div>
</div>