/**
 *
 */

var TIMEOUT = 2000;
var recruitItem = null;
var stateDict = ["新创建", "已关闭"]

$("#content").ready(function() {
    allApp();
});

$(function() {
    $("#pageAllRecruits").on("click", function() {
       loadAllRecruit();
    });

    $("#allApp").on("click", function() {
        allApp();
    });
    
    $("#pageEmailTemp").on("click", function() {
        loadAllEmailTemp();
    });
});

function loadAllEmailTemp() {
    $("#content").load("page/all_email_temp", function() {
        console.info("Request to query all email template.");
        $.ajax({
            url : "api/employ/all_emailtemp",
            dataType : "json",
            timeout : TIMEOUT,
            success : function(data) {
                if (data.code == 200) {
                    if (data.value.length == 0) {
                        console.info("No data.");
                        $("#emailTempBlank").show();
                        return;
                    }
                    console.info("Query all email template.");
                    data.value.forEach(function(e) {
                        var emailTemp = jointTag(e.subject, "span");
                        var detailBtn = jointTag(
                            "<button onclick='emailTempDetail()' style='float:right' class='btn btn-default'>详 情</button>",
                            "span"
                        );
                        var delBtn = jointTag(
                            "<button onclick='delEmailTemp(" + e.id + ")' style='float:right' class='btn btn-default'>删 除</button>",
                            "span"
                        );
                        var textDiv = "<div id='text' class='blankData'>" + e.text + "</div>"
                        var div = jointTag(
                            emailTemp + detailBtn + delBtn + textDiv, "div"
                        );
                        var li = "<li id='emailTemp" + e.id +"' class='list-group-item'>" + div + "</li>";
                        $("#emailTempList").append(li);
                    });
                } else {
                    console.info("Qeury all email templates failed.");
                }
            },
            error : function() {
                console.error("Request failed.");
            }
        });
        pageAddEmailTemp();
    });
}

function emailTempDetail() {
    $("#text").toggle();
}

function delEmailTemp(id) {
    $.ajax({
        url : "api/employ/del_emailtemp",
        data : {"id" : id},
        dataType : "json",
        timeout : TIMEOUT,
        success : function(data) {
            if (data.code == 200) {
                alert("删除成功");
                loadAllEmailTemp();
            } else {
                alert("删除失败");
            }
        },
        error : function() {
            console.error("Request to delete email tempate failed.");
        }
    });
}

function pageAddEmailTemp() {
    console.info("pageAddEmailTemp");
    $("#addEmailTemp").on("click", function() {
        $("#content").load("page/add_email_temp", function() {
            $("#saveEmailTemp").on("click", function() {
               $.ajax({
                   url : "api/employ/add_emailtemp",
                   data : $("#emailTempForm").serialize(),
                   type : "post",
                   timeout : TIMEOUT,
                   dataType : "json",
                   success : function(data) {
                       if (data.code == 200) {
                           alert("保存成功");
                           loadAllEmailTemp();
                       } else {
                           alert("保存失败");
                       }
                   },
                   error : function() {
                       console.error("Request to save email template failed.");
                   }
               }); 
            });
        });
    })
}

function loadAllRecruit() {
    $("#content").load("page/all_recruits", function() {
        $.ajax({
            url : "api/employ/all_recruits",
            dataType : "json",
            timeout : TIMEOUT,
            data : {"pageNum" : 0, "pageSize" : 0},
            success : function(data) {
                if(data.code = 200 && data.value.length > 0) {
                    data.value.forEach(function(e) {
                        recruitItem = e;
                        
                        var jobNameSpan = jointTag(e.jobName, "span");
                        var expireDateSpan = jointTag(e.expireDate, "span");
                        var detailSpan = jointTag(
                            "<button onclick='recruitDetail()' style='float:right' class='btn btn-default'>详 情</button>",
                            "span"
                        );
                        var div = jointTag(jobNameSpan + expireDateSpan + detailSpan, "div");
                        var li = "<li class='list-group-item'>" + div + "</li>";
                        $("#recruitList").append(li);
                    });
                } 
            },
            error : function() {
                console.error("Request for all recruitments failed.");
            }
        });
        
        pageAddRecruit();
    });
}

function pageAddRecruit() {
    $("#pageAddRecruit").on("click", function() {
        $("#content").load("page/add_recruit", function() {
            getJobType(function(array) {
                array.forEach(function(e) {
                    var option = "<option value='" + e.id + "'>" + e.type + "</option>";
                    $("#jobType").append(option);
                });
            });
            addRecruit();
        });
    });
}

function recruitDetail() {
    $("#content").load("page/recruit_detail", function() {
        console.info("Load page of all recruitment.");
        $("#corporation").val(recruitItem.corporation);
        $("#jobName").val(recruitItem.jobName);
        $("#lowSalary").val(recruitItem.lowSalary);
        $("#highSalary").val(recruitItem.highSalary);
        $("#address").val(recruitItem.address);
        $("#industry").val(recruitItem.industry);
        $("#jobDetail").val(recruitItem.jobDetail);
        $("#requirement").val(recruitItem.requirement);
        var option = "<option value='" + recruitItem.state + "' selected>" + stateDict[recruitItem.state] + "</option>"
        $("#state").prepend(option);
        $("#expireDate").val(recruitItem.expireDate);
        $("#id").val(recruitItem.id);
        getJobType(function(array) {
            array.forEach(function(e) {
                var option = null;
                if (recruitItem.jobType.id == e.id)
                    option = "<option value='" + e.id + "' selected>" + e.type + "</option>";
                option = "<option value='" + e.id + "'>" + e.type + "</option>";
                $("#jobType").append(option);
            });
        });
        update();
    });
}

function update() {
    $("#updateRecruit").on("click", function() {
        console.info("Request to update recruitment.");
        $.ajax({
            url : "api/employ/update_recruit",
            type : "post",
            data : $("#recruitForm").serialize(),
            dataType : "json",
            timeout : TIMEOUT,
            success : function(data) {
                if (data.code == 200){
                    alert("更新招聘信息成功");
                    loadAllRecruit();
                } else {
                    alert("更新招聘信息失败")
                }
            },
            error : function() {
                console.error("Request to update recruitment failed.");
            }
        });
    })
}

function appDetail(employee) {
    $.load("page/employee_resume", function() {
        $.ajax({
            url : "api/employ/query_resume",
            type : "post",
            dataType : "json",
            timeout : TIMEOUT,
            data : {"employee" : employee},
            success : function(data) {
                
            },
            error : function() {
                console.error("Request to query resume failed.");
            }
        });
    });
}

function getJobType(callback) {
    $.ajax({
        url : "api/employ/all_job_types",
        timeout : TIMEOUT,
        dataType : "json",
        success : function(data) {
            console.info("Get all job types.");
            callback(data.value);
        },
        error : function() {
            console.error("Request for job types failed.");
        }
    });
}

function addRecruit(){
    $("#addRecruit").ready(function() {
        $("#addRecruit").on("click", function() {
            $.ajax({
                url : "api/employ/publish_recruit",
                data : $("#recruitForm").serialize(),
                dataType : "json",
                timeout : TIMEOUT,
                type : "post",
                success : function(data) {
                    if (data.code == 200) {
                        alert("发布成功");
                        loadAllRecruit
                    } else {
                        alert("发布失败");
                    }
                },
                error : function() {
                    console.error("Request failed.");
                }
            });
        });
    });
}

function jointTag(content, tag) {
    return "<" + tag + ">" + content + "</" + tag + ">";
}

function allApp() {
    $("#content").load("page/all_apps", function() {
        $.ajax({
            type : "post",
            url : "api/employ/all_apps",
            dataType : "json",
            timeout : TIMEOUT,
            data : {
                "pageNum" : 0,
                "pageSize" : 0
            },
            success : function(data) {
                if (data.code == 200 && data.value.length > 0) {
                    data.value.forEach(function(e) {
                        var tds = "";
                        tds += jointTag(e.employee.email, "td");
                        tds += jointTag(e.state, "td");
                        tds += jointTag(e.createTime, "td");
                        tds += jointTag(e.modifyTime, "td");
                        var option = "<button class='btn btn-default' onclick='appDetail(" + e.employee.id + ")'>详 情</button>";
                        tds += jointTag(option, "td");
                        var tr = jointTag(tds, "tr");
                        $("#allApps").append(tr);
                    });
                } else {
                    console.info("No application data.");
                    $("#blankData").show();
                }
            },
            error : function() {
                console.error("Request failed.");
            }
        });
    });
}
