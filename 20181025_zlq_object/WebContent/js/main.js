window.onload = function(){
	var oMyInfo = document.getElementById('myInfo');
	var oInfo = document.getElementById("info");
	
	var oMain = document.getElementById("main");
	var oLeft = document.getElementById("left");
	var oRight = document.getElementById("right");
	
//	console.log(oRight);
	
//	oMain.style.height = 1000+'px';    设置div的高度
	
//	console.log(oMain.offsetHeight);
//	console.log(oLeft.offsetHeight);
//	console.log(oRight.offsetHeight);
	
	
//	使得main的高度自适应
	if(oLeft.offsetHeight > oRight.offsetHeight){
		oMain.style.height = oLeft.offsetHeight+'px';
	}
	else{
		oMain.style.height = oRight.offsetHeight+'px';
	}
	
//	console.log(oMain.offsetHeight);
	
	
//	 console.log(oMyInfo);
	oMyInfo.onmouseover = function(){
		// console.log("aa");
		oInfo.style.display = 'block';
	}
	oMyInfo.onmouseout = function(){
		oInfo.style.display = 'none';
	}
}