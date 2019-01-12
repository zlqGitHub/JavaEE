window.onload = function () {
    var navBarUlId = document.getElementById('navBarUlId');
    var aLi = navBarUlId.getElementsByTagName('li');

    var mainContent = document.getElementById('mainContent');  //获取首页内容的div
    var mainH = mainContent.offsetHeight;


    //为选项卡li元素绑定响应函数
    for(var i=0;i<aLi.length;i++) {
        aLi[i].tip = i;
        aLi[i].index = i;
        aLi[i].onmouseover = function(){
            // alert(this.innerHTML);
            this.firstChild.style.color = "#EF6762";
        }
        aLi[i].onmouseout = function(){
            // alert(this.innerHTML);
            if(this.tip != 0){
                this.firstChild.style.color = "black";
            }
        }
        bind(aLi[i],"click",function () {
            for(var j=0;j<aLi.length;j++) {
                //将所有的标题li元素全部不激活
                aLi[j].firstChild.style.color = "black";
                aLi[j].tip = 1;
            }
            //设置当前的标题li元素激活
            if(this.index == 0){
                mainContent.style.display = "block";
               
            }
            else{
                mainContent.style.display = "none";
            }
            this.firstChild.style.color = "#EF6762";
            this.tip = 0;

        });
    }

    //为新闻资讯绑定事件
    var shadowbox = document.getElementsByName("shadowbox");
    // alert(shadowbox.length);
    for(var i=0; i<shadowbox.length; i++){
        shadowbox[i].onmouseover = function () {
            // move2(this ,"-5",1);
            move(this,{top:-5});
        }
        shadowbox[i].onmouseout = function () {
            move(this,{top:0});
        }
    }

    //为课程体系绑定事件
    var shadowbox2 = document.getElementsByName("shadowbox2");
    // alert(shadowbox.length);
    for(var i=0; i<shadowbox2.length; i++){
        shadowbox2[i].onmouseover = function () {
            // move2(this ,"-3",1);
            this.getElementsByTagName("p")[0].getElementsByTagName("a")[0].style.color = "#DB4D49";
            move(this,{top:-5});
        }
        shadowbox2[i].onmouseout = function () {
            this.getElementsByTagName("p")[0].getElementsByTagName("a")[0].style.color = "";
            move(this,{top:0});
        }
    }

    //为wx头像绑定事件
    var wx = document.getElementById("wx");
    var weixin = document.getElementById("weixin");
    var timer;
    // console.log(weixin);
    wx.onmouseover = weixin.onmouseover = function () {
        clearTimeout(timer);
        timer = setTimeout(function () {
            move.style.display = "block";
        },200)
    }
    wx.onmouseout = weixin.onmouseout = function () {
        timer = setTimeout(function () {
            move.style.display = "none";
        },400)
    }
}