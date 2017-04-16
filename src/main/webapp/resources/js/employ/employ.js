/**
 *
 */

var TIMEOUT = 2000;
var recruitItem = null;

$("#content").ready(function() {
    allApp();
});

$(function() {
    $("#pageRecruitment").on("click", function() {
        $("#content").load("page/recruit", function() {
            getJobType();
            addRecruit();
        });
    });
    
    $("#pageAllRecruits").on("click", function() {
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
                                   "<button onclick='recruitDetail()' class='btn btn-default'>详 情</button>",
                                   "span"
                           );
                           var closeBtn = jointTag(
                                   "<button onclick='recruitClose()' class='btn btn-default'>结束招聘</button>",
                                   "span"
                           );
                           var div = jointTag(jobNameSpan + expireDateSpan + detailSpan + closeBtn, "div");
                           var li = "<li class='list-group-item'>" + div + "</li>";
                           $("#recruitList").append(li);
                       });
                   } 
               },
               error : function() {
                   console.error("Request for all recruitments failed.");
               }
           });
       });
       });

    $("#allApp").on("click", function() {
        allApp();
    });
});

function recruitClose() {
    
}

function recruitDetail() {
    $("#content").load("page/recruitDetail", function() {
        console.info("Load page of all recruitment.");
        $("#corporation").html(recruitItem.corporation);
        $("#jobName").html(recruitItem.jobName);
        
        var baseInfo = new Array();
        baseInfo[0] = recruitItem.lowSalary + " - " + recruitItem.highSalary;
        baseInfo[1] = recruitItem.address;
        baseInfo[2] = recruitItem.jobType.type;
        baseInfo[3] = recruitItem.industry;
        
        $("#baseInfo").html(baseInfo.join(" / "));
        $("#jobDetail").html(recruitItem.jobDetail);
        $("#requirement").html(recruitItem.requirement);
    });
}


function getJobType() {
    $.ajax({
        url : "api/employ/all_job_types",
        timeout : TIMEOUT,
        dataType : "json",
        success : function(data) {
            console.info("Get all job types.");
            data.value.forEach(function(e) {
                var option = "<option value='" + e.id + "'>" + e.type + "</option>";
                $("#jobType").append(option);
            });
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
                        console.info("Publish succeed.")
                    } else {
                        console.error("Publish recruitment failed.");
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

function jointTag(content, clazz, tag) {
    return "<" + tag + " class='" + clazz + "'>" + content + "</" + tag + ">";
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
                    var tds = "";
                    data.value.forEach(function(e) {
                        tds += jointTag(e, "td");
                    });
                    jointTag(tds, "tr");
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
