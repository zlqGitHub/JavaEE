window.onload = function(){
	var click_btn = document.getElementById('click_btn');
	// console.log(click_btn);
	click_btn.onmouseover = function(){
		this.className = 'click_btn2';
		//this.style.background_position = '0 -190px';     //此处为下划线
	}
	click_btn.onmouseout = function(){
		this.className = 'click_btn';
	}	
}

