var wait = 60;
var result;//验证码调度对象
var opCode = null;//操作码
var loginType = null;//登录类型
var regDevice = null;//设备信息
var regSource = null;//来源
var isSubmiting = false;

$(function(){
	
 	$("#veriCode_Btu").click(function(){
 		
 		if(!phone_vali()) return;
		
		var postData = {};
		postData.account = $("#phone_input").val();
		postData.regDevice = regDevice;
		postData.moduleName = "cLogin";
		$.post("cmbs/user/veriCode.htm", {postData:JSON.stringify(postData)}, function (data) {
			
			var jsonReturn = eval("(" + data + ")");
			if(jsonReturn.resultFlag==1){
				toastShow("短信已发送请注意查收！");
			}else{
				toastShow(jsonReturn.resultMsg);
			}
        });
		
 		$("#veriCode_Btu").attr("disabled",true);
		 result = self.setInterval("sendVeriCode()",1000);
 	});
 	
 	$("#validation_Btu").click(function(){
 		validation();
 	});
 	
 	//弹出框
 	$("#modal_container").modal({
		  keyboard: false,
		  show:false
	});
 	
 	opCode = $("#opCode").val();
 	loginType = $("#loginType").val();
 	regDevice = $("#regDevice").val();
 	regSource = $("#regSource").val();
 	if(opCode==undefined || opCode==null || opCode=="" ) opCode = "back";
 	if(loginType==undefined || loginType==null || loginType=="" || !(/^\d{1,2}$/.test(loginType))) loginType = "5";
 	if(regDevice==undefined || regDevice==null || regDevice=="" || !(/^\d{1,2}$/.test(regDevice))) regDevice = "5";
 	if(regSource==undefined || regSource==null || regSource=="" || !(/^\d{1,2}$/.test(regSource))) regSource = "5";
});


function validation(){
	
	if(!phone_vali()) return;
	if(!veriCode_vali()) return;
	
	var postData = {};
	postData.account = $("#phone_input").val();
	postData.veriCode = $("#veriCode_input").val();
	postData.loginType = loginType;
	postData.uuid = $("#data2").val();
	postData.regSource = regSource;
	postData.div = $("#data1").val();
	
	if (isSubmiting) {
         tanchu("表单正在提交，请稍后操作！");
         return;
    }
	
	isSubmiting = true;
	$("#validation_Btu").attr("disabled",true);
	$.post("cmbs/user/loginByVericode.htm", {postData:JSON.stringify(postData)}, function (data) {
		//alert(data);
		var jsonReturn = eval("(" + data + ")");
        if (jsonReturn.resultFlag == "1") {
        	if(opCode=="posterSender"){//海报发放
        		toastShow(opCode);
        	}
        } else{
        	toastShow(jsonReturn.resultMsg);
        }
        $("#validation_Btu").attr("disabled",false);
        isSubmiting = false;
    });
}

function phone_vali(){
	var account = $("#phone_input").val();
	if(account==""){
		tanchu("手机号不能为空！");
		return false;
	}
	
	if(!(/^1[3|4|5|8][0-9]\d{8}$/.test(account))){ 
        tanchu("手机号格式不合法！");
        return false;
    } 
	return true;
}


function veriCode_vali(){
	
	var veriCode = $("#veriCode_input").val();
	
	if(!(/^\d{6}$/.test(veriCode))){ 
        tanchu("验证码格式不合法！");
        return false;
    } 
	return true;
}


function sendVeriCode(){
	
	if(wait<=0){
		
		wait = 60;
		window.clearInterval(result);
		$("#veriCode_Btu").attr("disabled",false);
		$("#veriCode_Btu").html("获取验证码");
	}else{
		
		$("#veriCode_Btu").html("重新发送（"+wait+"s）");
		wait--;
	}
}


function tanchu(msg){
	$("#modal_msg").html(msg);
	$("#modal_container").modal("show");
}


function toastShow(msg){
	
	$(".resultMessage").text(msg);
	$(".resultMessage").fadeIn(500);
	setTimeout(function(){$(".resultMessage").fadeOut(500)},2000);
}