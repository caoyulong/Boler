<div class="col-md-6 col-md-offset-3">
  <h1>发布新的招聘信息</h1>
  <form role="form">
    <div class="form-group">
      <label for="corporation">公司</label>
      <input type="text" class="form-control" name="corporation" id="corporation" placeholder="请输入公司名称">
    </div>
    <div class="form-group">
      <label for="jobName">岗位名称</label>
      <input type="text" class="form-control" id="jobName" placeholder="请输入岗位名称">
    </div>
    <div class="form-group">
      <label for="jobType">岗位类型</label>
      <select class="form-control" id="jobType"></select>
    </div>
    <div class="form-group">
      <label for="lowSalary">最低薪资</label>
      <input type="text" class="form-control" id="lowSalary" placeholder="请输入最低薪资">
    </div>
    <div class="form-group">
      <label for="highSalary">最高薪资</label>
      <input type="text" class="form-control" id="highSalary" placeholder="请输入最高薪资">
    </div>
    <div class="form-group">
      <label for="address">工作地点</label>
      <input type="text" class="form-control" id="address" placeholder="请输入工作地点">
    </div>
    <div class="form-group">
      <label for="industry">行 业</label>
      <input type="text" class="form-control" id="industry" placeholder="请输入所属行业">
    </div>
    <div class="form-group">
      <label for="jobDetail">工作内容</label>
      <textarea class="form-control" id="jobDetail" rows="10" placeholder="请输入工作内容"></textarea>
    </div>
    <div class="form-group">
      <label for="requirement">任职需求</label>
      <textarea class="form-control" id="requirement" rows="10" placeholder="请输入任职需求"></textarea>
    </div>
    <div class="form-group form-inline">
      <label for="expireDate">过期时间</label>
      <input type="date" class="form-control" id="expireDate">
    </div>
  </form>
  <div class="form-group col-xs-1 col-xs-offset-6">
    <button type="submit" class="btn btn-default">确认发布</button>
  </div>
</div>
