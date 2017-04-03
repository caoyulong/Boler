<div>
  <div>
    <form id="regForm">
      <div>
        <span>
          <input type="email" id="email" name="email" placeholder="邮 箱" />
        </span>
        <span>
          <label id="emailWarn" style="color:red;display:none">该邮箱已被注册</label>
        </span>
      </div>
      <div>
        <input type="password" id="password" name="password" placeholder="输入密码" />
      </div>
      <div>
        <span>
          <input type="password" id="pwdConfirm" placeholder="确认密码" />
        </span>
        <span>
          <label id="pwdWarn" style="color:red;display:none">密码不一致</label>
        </span>
      </div>
      
      <div>
        <span><label>您 是：</label></span>
        <span>
          <select id="role" name="role"></select>
        </span>
      </div>
    </form>
    <div>
      <button id="regBtn">注 册</button>
    </div>
  </div>
</div>
