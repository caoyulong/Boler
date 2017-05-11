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
});

function loadAllRecruitsPage() {
    $("#content").load("page/employee_recruit", function() {
        getJobType(function(array) {
            array.forEach(function(e) {
                var link = "<a href='javascript:void(0)' onclick='queryByType(" + e.id + ")'>" + e.type + "</a>";
                var li = "<li>" + link + "</li>";
                $("#jobTypes").append(li);
            });
        });
    }); 
}

function queryByType(typeId) {
    $.ajax({
        url : "api/employee/query_recruit_type",
        data : {"jobType.id" : typeId, "pageNum" : 0, "pageSize" : 0},
        type : "post",
        dataType : "json",
        timeout : TIMEOUT,
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
        error : function(data) {
            
        }
    });
}

function recruitDetail() {
    $("#content").load("page/employee_recruit_detail", function() {
        console.info("Load page of all recruitment.");
        $("#corporation").html(recruitItem.corporation);
        $("#jobName").html(recruitItem.jobName);
        $("#lowSalary").html(recruitItem.lowSalary);
        $("#highSalary").html(recruitItem.highSalary);
        $("#address").html(recruitItem.address);
        $("#industry").html(recruitItem.industry);
        $("#jobDetail").html(recruitItem.jobDetail);
        $("#requirement").html(recruitItem.requirement);
        $("#state").html(recruitItem.state);
        $("#expireDate").html(recruitItem.expireDate);
        $("#id").val(recruitItem.id);
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
