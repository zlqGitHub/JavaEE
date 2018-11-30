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

// 改变切换按钮透明度
function changeOpacity(obj,x){
	obj.style.opacity = x/100;
	obj.style.filter = "alpha(opacity:"+x+")";
}

// 完美运动框架
function move(obj,json,fnEnd){
	clearInterval(obj.timer);
	
	obj.timer = setInterval(function(){
		var bStop = true; //假设所有值的目标都已经达到

		for(var attr in json){
			
			var current = 0;
			if(attr == "opacity")
			{
				current = Math.round(parseFloat(getStyle(obj,attr))*100); 
			}
			else
			{
				current = parseInt(getStyle(obj,attr));
			}

			var speed = (json[attr] - current)/6;
			speed = speed > 0 ? Math.ceil(speed) : Math.floor(speed);

			if(current != json[attr])
			{
				bStop = false; //判断每个目标是否到达，只要没到达，就将bStop=false
			}
			
			if(attr == "opacity")
			{
				obj.style.opacity = ( current + speed )/100;
				obj.style.filter = "alpha(opacity:"+ (current + speed) +")";
			}
			else
			{
				obj.style[attr] = current + speed + "px";
			}

		}

		//运动停止条件
		if(bStop)
		{
			clearInterval(obj.timer);
			if(fnEnd)fnEnd();
		}

	},30);
	
}	

//取非行间样式
function getStyle(obj,name)
{

	if(obj.currentStyle)
	{
		return obj.currentStyle[name]; //兼容IE
	}
	else
	{
		return getComputedStyle(obj,false)[name];  //兼容FF等
	}
}
		
