/**
 * 
 */
var TIMEOUT = 2000;

$(function() {
	$("#loginBtn").on("click", function() {
		$.ajax({
			url : "api/user/login",
			type : "post",
			dataType : "json",
			timeout: TIMEOUT,
			data : {"email" : $("#email").val(), "password" : sha3($("#password").val())},
			success : function(data) {
				if (data.code == 102) {
					$("body").load("api/user/index");
				}
			},
			error : function() {
				console.info("Login failed.");
			}
		});
	});
	
	$("#regBtn").on("click", function() {
		$("body").load("api/user/register");
		
		$(function() {
			$.ajax({
				url : "api/user/all_roles",
				type : "get",
				dataType : "json",
				timeout : TIMEOUT,
				success : function(data) {
					console.info("Get all roles.");
					data.value.forEach(function(e) {
						var option = "<option value='" + e.id + "'>" + e.name + "</option>";
						$("#role").append(option);
					});
				},
				error : function() {
					console.error("Get all roles failed.");
				}
			});
		});
		
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
					data : {"email" : email, "password" : sha3(password), "role.id" : role},
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
					data : {"id" : id},
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
						
					}
				});0
			});
		});
	});
})


