//forgetBtn --> 页面跳转
// function forgetpwd(){
// 	window.location.href="http://localhost:8080/router/updatePwd";
//
// }


//loginBtn  --> 成功实现页面跳转，失败页面提示
function loginsuccess(){
	
	var username_input = input_username_pwd.username.value;//获取用户名输入框信息
	console.log("输入的用户名为："+username_input)
	var pwd_input = input_username_pwd.pwd.value;//获取密码输入框信息
    console.log("输入的密码为："+pwd_input)
	
	if((username_input=="")||(username_input == null)){
		alert("请输入用户名");
		return;
	}else if((pwd_input == "")||(pwd_input == null)){
		alert("请输入密码");
		return;
	}
	else{

		$.ajax({
    	type:"post",
    	url:"/user/index",
    	async:true,
    	data:{
    		"username":"username_input",
    		"password":"pwd_input"
    	},
    	success: function (data) {
            if (data.resultInfo == "invalid username") {
                $("#loginBtn").removeAttr("disabled"),
                alert("用户不存在")
            }
            else if (data.resultInfo == "invalid password") {
                $("#loginBtn").removeAttr("disabled"),
                alert("密码错误")
            } else{
            	input_username_pwd.submit();
                //window.location.href = "/student/dashboard";
                window.open("loginSuc.html")

            }
       },

    });

	}
    
    
   
}
