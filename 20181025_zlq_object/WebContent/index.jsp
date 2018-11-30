<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<title>图书借阅首页</title>
	<link rel="stylesheet" type="text/css" href="./style/index.css">
	<script type="text/javascript" src="./js/index.js"></script>
</head>
<body>
	<div class="title">
		<div class="title_zh"><font>中北大学图书馆借阅</font></div>
		<div class="title_en"><font>LIBRARY OF MORTH UNIVERSITY OF CHINA</font></div>
	</div>

	<div class="paly">
		<div class="paly_images" >
			<ul class="paly_images_ul" id="pic">
				<div class="prev" id="point_prev"></div>
				<div class="next" id="point_next"></div>
				<li style="z-index: 1"><img src="images/1.jpg" /></li>
		        <li><img src="images/2.jpg" /></li>
		        <li><img src="images/3.jpg" /></li>
		        <li><img src="images/4.jpg" /></li>
			</ul>
		</div>		
	</div>

	<a href="login.jsp" class="click_btn" id="click_btn">
		<span>图书馆</span>
	</a>

	<div class="bottom">
		<span>
			Copyright ©2015-2016 中北大学图书馆.  All Rights Reserved.    Tel: 0351—3922071. 建议请使用屏幕分辨率为1440*900、IE10及以上版本的浏览器
		</span>
	</div>

	<script type="text/javascript">
		var oPic = document.getElementById('pic');
		var oPre = document.getElementById('point_prev');    //下一张
		var oNext = document.getElementById('point_next');    //上一张

		var oLi = oPic.getElementsByTagName('li');
		// console.log(oLi);
		
		var now = 0;
		var nowZindex = 1;   //图片的堆叠顺序

		
		function tab(){
			oLi[now].style.zIndex = nowZindex++;
			oLi[now].style.height = 0;
			move(oLi[now],{height:360});

			// for(var j=0;j<oLi.length;j++){

			// }

		}

		//点击播放
		oNext.onclick = function(){
			now++;
			if(now == oLi.length){
				now = 0;
			}
			tab();
		}

		oPre.onclick = function(){
			now--;
			if(now == -1){
				now = oLi.length - 1;
			}
			tab();
		}

		//自动播放及鼠标移入移出时的效果
		var timer = setInterval(oNext.onclick,3500);

		oPic.onmouseover = function(){
			clearInterval(timer);
			changeOpacity(oPre,60);
			changeOpacity(oNext,60);
		}

		oPic.onmouseout = function(){
			timer = setInterval(oNext.onclick,3500);
			changeOpacity(oPre,0);
			changeOpacity(oNext,0);
		}


// 

	</script>
	
</body>
</html>