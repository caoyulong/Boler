/**
 * 
 */
var TIMEOUT = 2000;

$(function() {
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

    $("#regBtn").on("click", function() {
        $("body").load("page/register");

        $(function() {
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
        });
    });
})
