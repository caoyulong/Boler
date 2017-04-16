<div class="container">
  <div class="row">
    <div class="col-md-6 col-md-offset-3">
      <header class="header">
        <div class="banner-area" style="padding-top:50px;padding-bottom:50px;">
          <h1>加入Boler 寻找千里马</h1>
        </div>
      </header>
      <form id="regForm" role="form">
        <div class="form-group">
          <span>
            <input type="email" id="email" name="email" class="form-control" placeholder="邮 箱" />
          </span>
          <span>
            <label id="emailWarn" style="color:red;display:none" class="form-control">该邮箱已被注册</label>
          </span>
        </div>
        <div class="form-group">
          <input type="password" id="password" name="password" class="form-control" placeholder="输入密码" />
        </div>
        <div class="form-group">
          <span>
            <input type="password" id="pwdConfirm" class="form-control" placeholder="确认密码" />
          </span>
          <span>
            <label id="pwdWarn" style="color:red;display:none">密码不一致</label>
          </span>
        </div>
        <div class="form-group">
          <span><label>您 是：</label></span>
          <span>
            <select id="role" name="role" class="form-control">
              <option value="1">求贤者</option>
              <option value="2">求职者</option>
            </select>
          </span>
        </div>
      </form>
      <div>
        <button id="regBtn" class="btn btn-default">注 册</button>
      </div>
    </div>
  </div>
</div>
