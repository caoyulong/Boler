/**
 * 
 */
var TIMEOUT = 2000
$("#content").ready(function() {
    allApp();
});

$(function() {
    $("#pubRecruitment").on("click", function() {
        $("#content").load("api/employ/page_recruit");
    });
    
    $("#allApp").on("click", function() {
        allApp();
    });
    
});

$("#jobType").ready(function() {
    $.ajax({
        url : "api/employ/all_job_types",
        timeout : TIMEOUT,
        dataType : "json",
        success : function(data) {
            data.value.forEach(function(e) {
                var option = "<option value='" + e.id + "'>" + e.name + "</option>";
                $(this).append(option);
            });
        },
        error : function() {
            
        }
    });
});


function jointTag(content, tag) {
    return "<" + tag + ">" + content + "</" + tag + ">"
}

function allApp(){
    $("#content").load("api/employ/page_all_apps");
    
    $(function() {
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
                if (value.code = 200 && data.value.length > 0) {
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
                console.error("Failed to query all applications.");
            }
        });
    });
}