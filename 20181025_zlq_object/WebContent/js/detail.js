window.onload = function() {
	var oImg = document.getElementById('img');
	var oImg2 = document.getElementById('img2');
	console.log(oImg2);
	var timer = null;
	oImg.onmouseover = function(){
		// console.log("aa");
		oImg2.style.display = 'block';
	}
	oImg.onmouseout = function(){
		// console.log("aa");
		timer = setTimeout(function(){
			oImg2.style.display = 'none';
		},500);		
	}
	oImg2.onmouseover = function(){
		clearTimeout(timer);

		oImg2.style.display = 'block';
	}
	oImg2.onmouseout = function(){
		timer = setTimeout(function(){
			oImg2.style.display = 'none'
		},500);

	}
}