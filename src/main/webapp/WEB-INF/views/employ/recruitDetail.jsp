<div class="col-md-6 col-md-offset-3">
  <form role="form" id="recruitForm">
    <div class="form-group">
      <label for="corporation">公司</label>
      <input id="corporation" type="text" class="form-control" name="corporation" placeholder="请输入公司名称">
    </div>
    <div class="form-group">
      <label for="jobName">岗位名称</label>
      <input id="jobName" type="text" class="form-control" name="jobName" placeholder="请输入岗位名称">
    </div>
    <div class="form-group">
      <label for="jobType">岗位类型</label>
      <select id="jobType" class="form-control" name="jobType.id" id="jobType"></select>
    </div>
    <div class="form-group">
      <label for="lowSalary">最低薪资</label>
      <input id="lowSalary" type="text" class="form-control" name="lowSalary" placeholder="请输入最低薪资">
    </div>
    <div class="form-group">
      <label for="highSalary">最高薪资</label>
      <input id="highSalary" type="text" class="form-control" name="highSalary" placeholder="请输入最高薪资">
    </div>
    <div class="form-group">
      <label for="address">工作地点</label>
      <input id="address" type="text" class="form-control" name="address" placeholder="请输入工作地点">
    </div>
    <div class="form-group">
      <label for="industry">行 业</label>
      <input id="industry" type="text" class="form-control" name="industry" placeholder="请输入所属行业">
    </div>
    <div class="form-group">
      <label for="jobDetail">工作内容</label>
      <textarea id="jobDetail" class="form-control" name="jobDetail" rows="10" placeholder="请输入工作内容"></textarea>
    </div>
    <div class="form-group">
      <label for="requirement">任职需求</label>
      <textarea id="requirement" class="form-control" name="requirement" rows="10" placeholder="请输入任职需求"></textarea>
    </div>
    <div class="form-group form-inline">
      <label for="expireDate">过期时间</label>
      <input id="expireDate" type="date" class="form-control" name="expireDate">
    </div>
    <div class="form-group form-inline">
      <label for="state">当前状态</label>
      <select id="state" class="form-control">
        <option value="1">关 闭</option>
      </select>
    </div>
    <input type="hidden" id="id" name="id" />
  </form>
  <div class="form-group col-xs-1 col-xs-offset-6">
    <button id="updateRecruit" class="btn btn-default">确 认</button>
  </div>
</div>