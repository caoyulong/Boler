/**
 * 
 */
var TIMEOUT = 2000;

$(function() {
    login();
    register();
    logout();
    pagemmodifyPassword();
});

function pagemmodifyPassword() {
    $("#modifyPassword").on("click", function() {
        $("#content").load("page/modify_passwd", function() {
            modifyPassword();
        });
    });
}

function modifyPassword() {
    $("#modifyPasswordSub").on("click",function() {
        var oldPassword = $("#oldPassword").val();
        var newPassword = $("#newPassword").val();
        var repeat = $("#repeat").val();
        
        if (newPassword == "" || oldPassword == "" || repeat == "") {
            $("#notEqual").show();
            return;
        } 
        if (newPassword != repeat) {
            $("#noData").show();
            return;
        }
        $.ajax({
            url : "api/user/modify_password",
            type : "post",
            dataType : "json",
            timeout : TIMEOUT,
            data : {
                oldPasswd : sha3(oldPassword),
                newPasswd : sha3(newPassword)
            },
            success : function(data) {
                console.info("Request to modify password succeed.");
                if (data.code == 106) {
                    alert("密码修改成功");
                    logout();
                } else {
                    alert("密码修改失败");
                }
            },
            error :  function() {
                console.error("Request to modify password failed.");
            }
        });
    });
}

function logout() {
    $("#logout").on("click", function() {
        $.ajax({
            url : "api/user/logout",
            dataType : "json",
            timeout : TIMEOUT,
            success : function(data) {
                console.info("Request to logout succeed.");
                if (data.code == 104) {
                    window.location.href = "/boler";
                } else {
                    alert("注销失败");
                }
            },
            error : function() {
                console.error("Request to logout failed.");
            }
        });
    });
}

function register() {
    $("#regBtn").on("click", function() {
        $("body").load("page/register", function() {
            pwdConfirm();
            register();
            hasRegistered();
        });
    });
}

function login() {
    $("#loginBtn").on("click", function() {
        $("#notComplete").hide();
        $("#loginFailed").hide();
        var email = $("#email").val();
        var password = $("#password").val();
        console.info(email);
        if (email == "" || password == "") {
            $("#notComplete").show();
            return;
        }
        $.ajax({
            url : "api/user/login",
            type : "post",
            dataType : "json",
            timeout : TIMEOUT,
            data : {
                "email" : email,
                "password" : sha3(password)
            },
            success : function(data) {
                if (data.code == 102) {
                    window.location = "api/user/index";
                } else {
                    $("#password").val("");
                    $("#loginFailed").show();
                }
            },
            error : function() {
                console.info("Login failed.");
            }
        });
    });
}

function pwdConfirm() {
    $("#pwdConfirm").on("blur", function() {
        $("#regBtn").attr("disabled", false);
        var password = $("#password").val();
        var pwdConfirm = $("#pwdConfirm").val();
        if (password != pwdConfirm) {
            $("#pwdWarn").show();
            $("#pwdConfirm").val("");
            $("#regBtn").attr("disabled", true);
        } else {
            $("#pwdWarn").hide();
            $("#regBtn").attr("disabled", false);
        }
    });
}

function hasRegistered() {
    $("#email").on("blur", function() {
        var id = $("#email").val();
        if (id == "")
            return;

        $.ajax({
            url : "api/user/has_registered",
            type : "get",
            dataType : "json",
            timeout : TIMEOUT,
            data : {
                "id" : id
            },
            success : function(data) {
                console.info(data);
                if (data.value == true) {
                    $("#emailWarn").show();
                    $("#regBtn").attr("disabled", true);
                } else {
                    $("#emailWarn").hide();
                    $("#regBtn").attr("disabled", false);
                }
            },
            error : function() {
                console.error("Register failed.");
            }
        });
    });
}

function register() {
    $("#regBtn").on("click", function() {
        console.info("Register.");
        var email = $("#email").val();
        var password = $("#password").val();
        var pwsConfirm = $("#pwsConfirm").val();
        var role = $("#role").val();

        if (email == "" || password == "" || pwsConfirm == "") {
            alert("请输入完整信息");
            return;
        }

        $.ajax({
            url : "api/user/register",
            type : "post",
            dataType : "json",
            timeout : TIMEOUT,
            data : {
                "email" : email,
                "password" : sha3(password),
                "role.id" : role
            },
            success : function(data) {
                console.info(data);
                if (data.code == 100) {
                    $("body").load("/boler");
                }
            },
            error : function() {
                console.info("Request to register failed.");
            }
        });
    });
}
