<%--
  Created by IntelliJ IDEA.
  User: 18323
  Date: 2020/2/1
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
    <style type="text/css">
*{
    margin: 0px;
    padding: 0px;
        }
#data{
        width: 850px;
        border: 1px solid #000000;
         margin: 20px auto;
        }
#data > p{
         display: flex;
        }
#data > h5{
         text-align: center;
        }
#data > p > span{
          padding: 0 10px;
    }
#prev,#next{
    cursor: pointer;
    }
#nian{
        flex: 1;
        text-align: center;
    }
#title{
    overflow: hidden;
    list-style: none;
    background: #ccc;
    }
#title > li{
        float: left;
        width: 120px;
        height: 70px;
        line-height: 70px;
        text-align: center;
        }
#date{
        overflow: hidden;
        list-style: none;
    }
#date > li{
    float: left;
    width: 114px;
    height: 60px;
    margin: 1px 1px;
    border: 2px solid rgba(0,0,0,0);
    line-height: 60px;
    text-align: center;
    cursor: pointer;
}
#date >.hover:hover{
    border: 2px solid red;
}
.active{
       color: red;
        }
</style>
</head>
<body>
    <div id="data">
              <p>
                 <span id="prev">上一月</span>
                 <span id="nian">2018</span>
                 <span id="next">下一月</span>
               </p>
              <h5 id="yue">一月</h5> 
               <ul id="title"> 
                <li>日</li>
                <li>一</li>
                <li>二</li>
                <li>三</li> 
                <li>四</li>
                <li>五</li>
                <li>六</li>
               </ul> 
               <ul id="date"> 
               </ul> 
        </div>
    <script type="text/javascript">
    var dat = new Date(); //当前时间 
    var nianD = dat.getFullYear();//当前年份 
    var yueD = dat.getMonth(); //当前月 
    var tianD = dat.getDate(); //当前天 这保存的年月日 是为了 当到达当前日期 有对比 

    add(); //进入页面第一次渲染 

    function add(){
        document.getElementById('date').innerHTML = "";
        var nian = dat.getFullYear();//当前年份 
        var yue = dat.getMonth(); //当前月 
        var tian = dat.getDate(); //当前天 
        var arr=["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"];
        document.getElementById('nian').innerText = nian;
        document.getElementById('yue').innerText = arr[yue];

        var setDat = new Date(nian,yue + 1,1 - 1); //把时间设为下个月的1号 然后天数减去1 就可以得到 当前月的最后一天; 
        var setTian = setDat.getDate(); //获取 当前月最后一天 
        var setZhou = new Date(nian,yue,1).getDay(); //获取当前月第一天 是 周几 

        for(var i=0;i<setZhou ;i++){//渲染空白 与 星期 对应上 
            var li=document.createElement('li');
            document.getElementById('date').appendChild(li);
        }

        for(var i=1;i<=setTian;i++){//利用获取到的当月最后一天 把 前边的 天数 都循环 出来 
            var li=document.createElement('li');
            li.innerText = i;
            if(nian == nianD && yue == yueD && i == tianD){
                li.className = "active";
            }else{
                li.className = "hover";
            }

            document.getElementById('date').appendChild(li);
        }

    }

    document.getElementById("next").onclick = function(){
        dat.setMonth(dat.getMonth() + 1); //当点击下一个月时 对当前月进行加1; 
        add(); //重新执行渲染 获取去 改变后的 年月日 进行渲染; 
    };
    document.getElementById("prev").onclick = function(){
        dat.setMonth(dat.getMonth() - 1); //与下一月 同理 
        add();
    };
</script> 
</body>
</html>