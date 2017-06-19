/**
 * 
 */
var TIMEOUT = 2000;

$("#content").ready(function() {
    loadAllRecruitsPage();
});

$(function() {
    $("#recruit").on("click", function() {
        loadAllRecruitsPage();
    });
    
    $("#myAPP").on("click", function() {
        loadAppPage();
    });
    
    $("#myResume").on("click", function() {
        loadResumePage();
    });
});

function loadAppPage() {
    $("#content").load("page/employee_app", function() {
        
    });
}

function loadResumePage() {
    $("#content").load("page/employ_resume", function() {
        $("#resumeSubmit").on("click", function() {
            $.ajax({
               url : "api/employee/all_resumes",
               dataType : "json",
               timeout : TIMEOUT,
               success : function(data) {
                   if (data.code == 200 && data.value.length > 0)
                       initResume(data[0]);
               },
               error : function() {
                   console.error("Request to get online resume failed.");
               }
            });
        });
        $("#resumeSubmit").on("click", function() {
            $.ajax({
               url : "api/employee/all_resumes",
               dataType : "json",
               timeout : TIMEOUT,
               success : function(data) {
                   if (data.code == 200 && data.value.length > 0)
                       initResume(data[0]);
               },
               error : function() {
                   console.error("Request to get online resume failed.");
               }
            });
        });
        $("#resumeSubmit").on("click", function() {
            $.ajax({
               url : "api/employee/all_resumes",
               dataType : "json",
               timeout : TIMEOUT,
               success : function(data) {
                   if (data.code == 200 && data.value.length > 0)
                       initResume(data[0]);
               },
               error : function() {
                   console.error("Request to get online resume failed.");
               }
            });
        });
    });
}

function initResume(data) {
    $("#name").val(data.name);
    $("#edu_startTime").val(data.edu_exp.startTime);
    $("#edu_endTime").val(data.edu_exp.endTime);
    $("#school").val(data.edu_exp.school);
    $("#degree").val(data.edu_exp.degree);
    $("#major").val(data.edu_exp.major);
    $("#course").val(data.edu_exp.course);
    $("#work_startTime").val(data.work_exp.startTime);
    $("#work_endTime").val(data.work_exp.endTime);
    $("#corporation").val(data.work_exp.corporation);
    $("#scale").val(data.work_exp.scale);
    $("#department").val(data.work_exp.department);
    $("#job").val(data.work_exp.job);
    $("#detail").val(data.work_exp.detail);
    $("#proj_startTime").val(data.proj_exp.startTime);
    $("#proj_endTime").val(data.proj_exp.endTime);
    $("#proj_name").val(data.proj_exp.name);
    $("#team_scale").val(data);
    $("#").val(data);
    $("#").val(data);
    $("#").val(data);
}

function apply() {
    $.ajax({
        url : "api/employee/save_app",
        type : "post",
        dataType : "json",
        timeout : TIMEOUT,
        data : {"recruitment.id" : $("#recruitment").val()},
        success : function(data) {
            if (data.code == 200) {
                alert("申请成功！");
            }
        },
        error : function() {
            console.error("Request to save application failed.");
        }
    });
}

function loadAllRecruitsPage() {
    $("#content").load("page/employee_recruit", function() {
        getJobType(function(array) {
            array.forEach(function(e) {
                var link = "<a href='javascript:void(0)' onclick='queryByType(" + e.id + ")'>" + e.type + "</a>";
                var li = "<li>" + link + "</li>";
                $("#jobTypes").append(li);
            });
        });
        loadRecruit();
    }); 
}

function loadRecruit() {
    $.ajax({
        url : "api/employee/all_recruitments",
        type : "post",
        dataType : "json",
        timeout : TIMEOUT,
        data : {"pageNum" : 0, "pageSize" : 0},
        success : function(data) {
            recruitList(data); 
        },
        error : function() {
            
        }
    });
}

function queryByType(typeId) {
    $.ajax({
        url : "api/employee/recruit_condition",
        data : {"jobType.id" : typeId, "pageNum" : 0, "pageSize" : 0},
        type : "post",
        dataType : "json",
        timeout : TIMEOUT,
        success : function(data) {
            console.info(data);
            recruitList(data);
        },
        error : function(data) {
            console.error("Request to load all recruits");
        }
    });
}

function recruitList(data) {
    if(data.code = 200 && data.value.length > 0) {
        data.value.forEach(function(e) {
            recruitItem = e;
            var corName = jointTag(e.corporation, "span");
            var jobNameSpan = jointTag(e.jobName, "span");
            var expireDateSpan = jointTag(e.expireDate, "span");
            var detailSpan = jointTag(
                "<button onclick='recruitDetail()' style='float:right' class='btn btn-default'>详 情</button>",
                "span"
            );
            var div = jointTag(corName + jobNameSpan + expireDateSpan + detailSpan, "div");
            var li = "<li class='list-group-item'>" + div + "</li>";
            $("#recruitList").append(li);
        });
    } 
}

function recruitDetail() {
    $("#content").load("page/employee_recruit_detail", function() {
        console.info("Load page of all recruitment.");
        $("#corporation").html(recruitItem.corporation);
        $("#jobName").html(recruitItem.jobName);
        $("#jobType").html(recruitItem.jobType.type);
        $("#lowSalary").html(recruitItem.lowSalary);
        $("#highSalary").html(recruitItem.highSalary);
        $("#address").html(recruitItem.address);
        $("#industry").html(recruitItem.industry);
        $("#jobDetail").html(recruitItem.jobDetail);
        $("#requirement").html(recruitItem.requirement);
        $("#expireDate").html(recruitItem.expireDate);
        $("#recruitment").val(recruitItem.id);
    });
}

function loadAppsPage() {
    $("#myApp").on("click", function() {
        $("#content").load("page/my_apps", function() {
            getAllApps();
        });
    });
}

function getAllApps() {
    $.ajax({
        url : "all_apps",
        dataType : "json",
        timeout : TIMEOUT,
        success : function(data) {
            console.error("Request to get all applications succeed..");
        },
        error : function() {
            console.error("Request to get all applications failed.");
        }
    });
}

function getJobType(callback) {
    $.ajax({
        url : "api/employee/all_job_types",
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

function jointTag(content, tag) {
    return "<" + tag + ">" + content + "</" + tag + ">";
}
