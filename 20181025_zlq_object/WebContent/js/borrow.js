window.onload = function() {
	var input = document.getElementById("input");
	var tip = document.getElementById("tip");
	var jump = document.getElementById("jump");
//	console.log(input.value);
	console.log(jump);
	if(input.value == ""){
		tip.style.display = "block";
		setTimeout(function(){    //设置定时器
			window.location.href="main.jsp";   //页面跳转
		},1800); 
	}
	else{
		tip.style.display = "none";
	}
}