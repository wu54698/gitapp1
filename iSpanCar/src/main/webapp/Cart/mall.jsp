<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css/help-center.css" />
    <title>購物車</title>

    <style>
        * {
            margin: 0;
            padding: 0;
            font-family: "微軟雅黑";
            list-style: none;
            color: #666;
            text-decoration: none;
            font-size: 14px;
        }

        body {
            background: #f5f5f5;
            height: 100%;
        }

        .header {
            font-size: 12px;
            border-bottom: 2px solid #ff6700;
            background: #fff;
            color: #b0b0b0;
            position: relative;
            z-index: 20;
            height: 100px;
        }

        .header .container {
            position: relative;
            width: 1226px;
            margin-right: auto;
            margin-left: auto;
        }

        .header .container .header-logo {
            width: 93px;
            margin-top: 26px;
        }

        .logo {
            width: 48px;
            height: 48px;
            position: relative;
            display: block;
            width: 55px;
            height: 55px;
            overflow: hidden;
            background-color: #ff6700;
        }

        .header-title {
            float: left;
            margin-top: 26px;
            font-size: 12px;
        }

        .topbar-info {
            margin-top: 30px;
            line-height: 40px;
        }

        .link {
            padding: 0 5px;
            color: #757575;
            text-decoration: none;
        }

        .hid {
            overflow: hidden;
        }

        .left {
            float: left;
        }

        .box_head {
            position: relative;
            margin: 0;
            height: 50px;
            font-size: 30px;
            font-weight: 400;
            color: #757575;
            border-top: 1px solid #e0e0e0;
        }

        .box_head span {
            position: absolute;
            top: -20px;
            left: 372px;
            height: 40px;
            width: 482px;
            line-height: 40px;
            text-align: center;
            display: block;
            background-color: #f5f5f5;
            font-size: 30px;
        }

        #box {
            width: 1240px;
            margin: 20px auto;
        }

        #box ul {
            margin-right: -14px;
            overflow: hidden;
        }

        #box li {
            width: 234px;
            float: left;
            margin-right: 14px;
            padding: 24px 0 20px;
            background: #FFF;
            text-align: center;
            position: relative;
            cursor: pointer;
            margin-bottom: 14px;
        }

        .pro_img {
            width: 150px;
            height: 150px;
            margin: 0 auto 18px;
        }

        .pro_name {
            display: block;
            text-overflow: ellipsis;
            white-space: nowrap;
            overflow: hidden;
            font-weight: 400;
        }

        .pro_name a {
            color: #333;
        }

        .pro_price {
            color: #ff6700;
            margin: 10px;
        }

        .pro_rank {
            color: #757575;
            margin: 10px;
        }

        #box li:hover .add_btn {
            display: block;
        }

        #box li:hover .pro_rank {
            opacity: 0;
        }

        #box li .add_btn:hover {
            background-color: #f60;
            color: white;
        }
        
        #box li input{
        width: 80px;
        
        }



        .add_btn {
            height: 22px;
            position: absolute;
            width: 122px;
            bottom: 28px;
            left: 50%;
            margin-left: -61px;
            line-height: 22px;
            display: none;
            color: #F60;
            font-size: 12px;
            border: 1px solid #f60;
        }

        .car {
            width: 1240px;
            margin: 20px auto;
            background: #FFF;
        }

        .car .check {
            width: 50px;

        }

        .car .check i {
            color: #fff;
            display: inline-block;

            width: 18px;
            height: 18px;
            line-height: 18px;
            border: 1px solid #e0e0e0;
            margin-left: 24px;
            background-color: #fff;
            font-size: 16px;
            text-align: center;
            vertical-align: middle;
            position: relative;
            top: -1px;
            cursor: pointer;
            font-family: "iconfont";
        }

        .i_acity {

            border-color: #ff6700 !important;
            background-color: #ff6700 !important;
        }

        .car .img {
            width: 190px;
        }

        .car .img img {
            display: block;
            width: 80px;
            height: 80px;
            margin: 3px auto;
        }

        .car .name {
            width: 300px;
        }

        .car .name span {
            line-height: 1;
            margin-top: 8px;
            margin-bottom: 8px;
            font-size: 18px;
            font-weight: normal;
            text-overflow: ellipsis;
            white-space: nowrap;
            overflow: hidden;
        }

        .car .price {
            width: 144px;
            text-align: right;
            padding-right: 84px;
        }

        .car .price span {
            color: #ff6700;
            font-size: 16px;
        }

        .car .number {
            width: 150px;
        }

        .car .subtotal {
            width: 130px;

        }

        .car .ctrl {
            width: 105px;
            padding-right: 25px;
            text-align: center;
        }

        .car .ctrl a {
            font-size: 20px;
            cursor: pointer;
            display: block;
            width: 26px;
            height: 26px;
            margin: 30px auto;
            line-height: 26px;
        }

        .car .ctrl a:hover {
            color: #FFF;
            background: #ff6700;
            border-radius: 50%;
        }

        .head_row {
            height: 70px;
            line-height: 70px;
        }

        .head_row,
        .row {
            border-bottom: solid 1px #e0e0e0;
        }

        .row {
            height: 86px;
            line-height: 86px;
            padding: 15px 0;
            margin: 0px;
        }

        #sum_area {
            width: 1240px;
            height: 60px;
            background: white;
            margin: 20px auto;
        }

        #sum_area #pay {
            width: 250px;
            height: 60px;
            text-align: center;
            float: right;
            line-height: 60px;
            font-size: 19px;
            background: #FF4B00;
            color: white;
        }

        #sum_area #pay_amout {
            width: 250px;
            height: 60px;
            text-align: center;
            float: right;
            line-height: 60px;
            font-size: 16px;
            color: #FF4B00;
        }

        #sum_area #pay_amout #price_num {
            width: 100px;
            height: 60px;
            font-size: 25px;
            color: #FF4B00;
            /*	float: left;*/
        }

        .item_count_i {
            height: 85px;
            width: 10%;
            /*border: 1px solid black;*/
            float: left;
            margin-right: 25px;
        }

        .num_count {
            width: 150px;
            height: 40px;
            border: 1.2px solid #E0E0E0;
            float: right;
            margin-top: 21px;

        }

        .count_i {
            width: 30%;
            height: 40px;
            line-height: 40px;
            float: left;
            text-align: center;
            font-size: 21px;
            color: #747474;
        }

        .count_i:hover {
            width: 30%;
            height: 40px;
            line-height: 40px;
            float: left;
            text-align: center;
            font-size: 21px;
            color: #747474;
            background: #E0E0E0;
            cursor: pointer;
        }

        .c_num {
            width: 40%;
            height: 40px;
            line-height: 40px;
            float: left;
            text-align: center;
            font-size: 16px;
            color: #747474;
        }

        .count_d {
            width: 30%;
            height: 40px;
            line-height: 40px;
            float: left;
            text-align: center;
            font-size: 25px;
            color: #747474;
        }

        .count_d:hover {
            width: 30%;
            height: 40px;
            line-height: 40px;
            float: left;
            text-align: center;
            font-size: 25px;
            color: #747474;
            background: #E0E0E0;
            cursor: pointer;
        }

        .i_acity2 {
            border-color: #ff6700 !important;
            background-color: #ff6700 !important;
        }
        
        
    </style>
</head>

<body>
<form action="<c:url value='/QueryAllCart.do'/>" method="get">
<td><input type="submit" value="購物車" /></td>
</form>

    <script>
        window.onload = function () {
            var aData = [{
                "imgUrl": "http://localhost:8080/ispan_car/img/03-car-01.jpg",
                "proName": " 輪胎 ",
                "proPrice": "800",
                "proComm": "1"
            },
            {
                "imgUrl": "http://localhost:8080/ispan_car/img/03-car-02.jpg",
                "proName": " 機油 ",
                "proPrice": "100",
                "proComm": "2"
            },
            {
                "imgUrl": "http://localhost:8080/ispan_car/img/03-car-03.jpg",
                "proName": "打磨機 ",
                "proPrice": "65",
                "proComm": "3"
            },
            {
                "imgUrl": "http://localhost:8080/ispan_car/img/03-car-04.jpg",
                "proName": " 雨刷 ",
                "proPrice": "149",
                "proComm": "4"
            },
            {
                "imgUrl": "http://localhost:8080/ispan_car/img/03-car-05.jpg",
                "proName": "行車紀錄器  ",
                "proPrice": "750",
                "proComm": "5"
            },
            {
                "imgUrl": "http://localhost:8080/ispan_car/img/03-car-06.jpg",
                "proName": " 車頂架  ",
                "proPrice": "199",
                "proComm": "6"
            },
            {
                "imgUrl": "http://localhost:8080/ispan_car/img/03-car-07.jpg",
                "proName": " 手機架",
                "proPrice": "20",
                "proComm": "7"
            },
            {
                "imgUrl": "http://localhost:8080/ispan_car/img/03-car-08.jpg",
                "proName": "  保養劑 ",
                "proPrice": "45",
                "proComm": "8"
            },
            {
                "imgUrl": "http://localhost:8080/ispan_car/img/03-car-09.jpg",
                "proName": "  腳踏墊  ",
                "proPrice": "207",
                "proComm": "9"
            },
            {
                "imgUrl": "http://localhost:8080/ispan_car/img/03-car-10.jpg",
                "proName": " 火星塞 ",
                "proPrice": "199",
                "proComm": "10"
            }
            ];
            var oBox = document.getElementById("box");
            var oCar = document.getElementById("car");
            var oUl = document.getElementsByTagName("ul")[0];

            for (var i = 0; i < aData.length; i++) {
                var oLi = document.createElement("li");
                var data = aData[i];
                var x = '/CartInsertServlet.do';
                var name = data["proName"];
                oLi.innerHTML += '<div class="pro_img"><img src="' + data["imgUrl"] + '" width="150" height="150"></div>';
                oLi.innerHTML += '<form action="<c:url value='/CartInsertServlet.do'/>"  method="POST" enctype="multipart/form-data">'
                +'會員編號: <input type=""  name="memberId" value=""><br>'+''
                +'商品編號: <input type="" name="productNumber" readonly="readonly" value="'+(i+1)+'"><br>'+''
                +'商品名稱: <input type="" name="productName" readonly="readonly" value='+name+'><br>'+''
                +'商品價格: <input type="" name="productPrice" readonly="readonly" value="'+data["proPrice"]+'"><br>'+''
                +'購買數量: <input type="" name="quantity" value=""><br>'+''
                +'<input type="submit"  value="加入購物車"><br>'+'';
                oUl.appendChild(oLi);

            }

        }

        function getClass(oBox, tagname) {
            var aTag = oBox.getElementsByTagName("*");
            var aBox = [];
            for (var i = 0; i < aTag.length; i++) {
                if (aTag[i].className == tagname) {
                    aBox.push(aTag[i]);
                }
            }
            return aBox;
        }


        var index = false;
        function checkAll() {
            var choose = document.getElementById("car").getElementsByTagName("i");
         
            if (choose.length != 1) {
                for (i = 1; i < choose.length; i++) {
                    if (!index) {
                        choose[0].classList.add("i_acity2")
                        choose[i].classList.add("i_acity");
                    } else {
                        choose[i].classList.remove("i_acity");
                        choose[0].classList.remove("i_acity2")
                    }
                }
                index = !index;
            }
            getAmount();
        }



        
        function getAmount() {
          
            ns = document.getElementsByClassName("i_acity");
            console.log(ns);
            sum = 0;
            
            document.getElementById("price_num").inner = sum;
            for (y = 0; y < ns.length; y++) {
                amount_info = ns[y].parentElement.parentElement.lastElementChild.previousElementSibling;
                num = parseInt(amount_info.inner);
                sum += num;
                document.getElementById("price_num").inner = sum;
            }
        }
    </script>
    </head>

    <body>
     

        <div id="box">
            <h2 class="box_head"><span>精選商品</span></h2>
            <ul>
            </ul>
        </div>

    
    </body>
    <script type="/javascript">
        function abc() {
            location.href = 'DingDan.html'
        }
    </script>

</html>