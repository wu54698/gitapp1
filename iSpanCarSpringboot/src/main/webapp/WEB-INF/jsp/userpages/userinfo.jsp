<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="utf-8" />
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
            <meta name="description" content="" />
            <meta name="author" content="" />
            <title>Grayscale - Start Bootstrap Theme</title>
            <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
            <!-- Font Awesome icons (free version)-->
            <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
            <!-- Google fonts-->
            <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesh0eet" />
            <link
                href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
                rel="stylesheet" />
            <!-- Core theme CSS (includes Bootstrap)-->
            <link href="http://localhost:8080/iSpanCar/script/css/styles.css" rel="stylesheet" />
            <script src="http://localhost:8080/iSpanCar/script/vendor/jquery/jquery.min.js"></script>
            <script src="http://localhost:8080/iSpanCar/script/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
            <link rel="preconnect" href="https://fonts.googleapis.com">
            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
            <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@900&display=swap" rel="stylesheet">
            <link rel="icon" href="img/Fevicon.png" type="image/png">
<!-- 			  <link rel="stylesheet" href="http://localhost:8080/iSpanCar/script/vendors/bootstrap/bootstrap.min.css"> -->
<!-- 			  <link rel="stylesheet" href="http://localhost:8080/iSpanCar/script/vendors/fontawesome/css/all.min.css"> -->
<!-- 				<link rel="stylesheet" href="http://localhost:8080/iSpanCar/script/vendors/themify-icons/themify-icons.css"> -->
<!-- 				<link rel="stylesheet" href="http://localhost:8080/iSpanCar/script/vendors/linericon/style.css"> -->
<!-- 			  <link rel="stylesheet" href="http://localhost:8080/iSpanCar/script/vendors/owl-carousel/owl.theme.default.min.css"> -->
<!-- 			  <link rel="stylesheet" href="http://localhost:8080/iSpanCar/script/vendors/owl-carousel/owl.carousel.min.css"> -->
<!-- 			  <link rel="stylesheet" href="http://localhost:8080/iSpanCar/script/vendors/nice-select/nice-select.css"> -->
<!-- 			  <link rel="stylesheet" href="http://localhost:8080/iSpanCar/script/vendors/nouislider/nouislider.min.css"> -->

        </head>

        <body id="page-top" style="display:none">
            <c:set value="${LoginOK}" var="login" />
            <c:set value="${login.memberPosition.permissionsofposition}" var="memberPosition" />
            <input type="hidden" value="${login.accountnumber}" id="logincheck">
            <!-- Navigation-->
            <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
            </nav>

            <header class="masthead2">
                <div class="container px-4 px-lg-5 d-flex h-100 align-items-center justify-content-center">
                    <div class="d-flex justify-content-center">
                        <div class="text-center">
                            <h2 class="mx-auto my-0 text-uppercase"
                                style="color:white;font-size:6em;font-family: 'Noto Sans TC', sans-serif;">用戶資訊</h2>
                            <!--                     <h2 class=" mx-auto mt-2 mb-5" style="color:white;font-size:2em;font-family:DFKai-SB;font-family: 'Noto Sans TC', sans-serif;">資車國際</h2> -->
                        </div>
                    </div>
                </div>
            </header>

            <!--     content -->
            <div class="bg-black" id="content">
                <div class="row rounded">
                    <div class="col-1"></div>
                    <div class="col-10 bg-white justify-content-center rounded mb-2">

                        <div class="row pl-4">

                            <div class="col-6" style="margin-left:70px;margin-top:1em;">
                                <form style="display: inline;">
                                <table class="table justify-content-center">
						            <thead>
						              <tr>
						                <th scope="col"><h5>欄位</h5></th>
						                <th scope="col"><h5>資訊</h5></th>
						              </tr>
						            </thead>
						            <tbody>
						              <tr>
						                <td>
						                  <h4 >帳號:</h4>
						                </td>
						                <td>
						                  <h5>${login.accountnumber}<input type="hidden" id="accountnumber" name="accountnumber" value="${login.accountnumber}"></h5>
						                </td>
						              </tr>
						              <tr>
						                <td>
						                  <h4>姓名:</h4>
						                </td>
						                <td>
						                  <h5 class="d-inline">${login.memberName}<input type="hidden" id="memberName" name="memberName" value="${login.memberName}"></h5>
						                  <button class="btn-primary btn-sm edit" style="float:right;">編輯</button>
						                </td>
						              </tr>
						              <tr>
						                <td>
						                  <h4>電話:</h4>
						                </td>
						                <td>
						                  <h5 class="phonenumber d-inline">${login.phonenumber}<input type="hidden" id="phonenumber" name="phonenumber" value="${login.phonenumber}"></h5>
						                  <button class="btn-primary btn-sm edit" id="phonebtn" style="float:right;">編輯</button>
						                </td>
						              </tr>
						              <tr>
						                <td>
						                  <h4>email:</h4>
						                </td>
						                <td>
						                  <h5 class="d-inline">${login.email}<input type="hidden" id="email" name="email" value="${login.email}"></h5>
						                  <button class="btn-primary btn-sm edit" style="float:right;">編輯</button>
						                </td>
						              </tr>
						              <tr>
						                <td>
						                  <h4>地址:</h4>
						                </td>
						                <td>
						                  <h5 class="d-inline">${login.memberaddress}<input type="hidden" id="memberaddress" name="memberaddress" value="${login.memberaddress}"></h5>
						                	<button class="btn-primary btn-sm edit" style="float:right;">編輯</button>
						                </td>
						              </tr>
						              <tr>
						                <td>
						                  <h4>車牌:</h4>
						                </td>
						                <td>
						                  <h5 class="d-inline">${login.platenumber}<input type="hidden" id="platenumber" name="platenumber" value="${login.platenumber}"></h5>
						                  <button class="btn-primary btn-sm edit" style="float:right;">編輯</button>
						                </td>
						              </tr>
						              <tr>
						                <td>
						                  <h4>身分證字號:</h4>
						                </td>
						                <td>
						                  <h5 class="idnumber d-inline">${login.idnumber}<input type="hidden" id="idnumber" name="idnumber" value="${login.idnumber}"></h5>
						                  <button class="btn-primary btn-sm edit" id="idnumberbtn" style="float:right;">編輯</button>
						                </td>
						              </tr>
						              <tr>
						                <td>
						                  <h4>生日:</h4>
						                </td>
						                <td>
						                  <h5 class="birthday d-inline">${login.birthday}<input type="hidden" id="birthday" name="birthday" value="${login.birthday}"></h5>
						                  <button class="btn-primary btn-sm edit" style="float:right;">編輯</button>
						                </td>
						              </tr>
						              <tr>
						                <td>
						                  <h4>信用卡號:</h4>
						                </td>
						                <td>
						                  <h5 class="cardnumber d-inline">${login.cardnumber}<input type="hidden" id="cardnumber" name="cardnumber" value="${login.cardnumber}"></h5>
						                  <button class="btn-primary btn-sm edit" id="cardnumberbtn" style="float:right;">編輯</button>
						                </td>
						              </tr>
						            </tbody>
						          </table>
                                </form>
                            </div>
                            <div class="col-5 mt-6 pt-5 justify-content-center">
                           	<div class="text-center"><h4 class="d-inline">個人照片</h4><button class="btn-primary btn-sm" style="float:right;margin-right:24px">編輯</button></div>
                           		<div class="text-center">
                                	<form id="imgform" class="imgform" enctype="multipart/form-data"><label><input
                                            type='hidden' class='file' id='file' name='file' style='display:none'><img
                                            id="imgshow" class="imgshow"
                                            src="/showimage.controller?accountnumber=${login.accountnumber}" width="460"
                                            height="460" /></label></form>
                                 </div>
                            </div>
                        </div>
                        <div class="text-center"><button class="btn-success btn-sm">儲存</button></div>
                        <div>&nbsp</div>
                    </div>
                </div>
            </div>

            <div class="col-1"></div>

            <!-- 	footer -->
            <div id="footertext"></div>


            <script src="http://localhost:8080/iSpanCar/script/js/scripts.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
            <script src="http://localhost:8080/iSpanCar/script/js/scripts.js"></script>
            <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>

            <script src="http://localhost:8080/iSpanCar/script/js/navhtml.js"></script>
            <script src="http://localhost:8080/iSpanCar/script/js/footerhtml.js"></script>
<!--             <script src="http://localhost:8080/iSpanCar/script/vendors/jquery/jquery-3.2.1.min.js"></script> -->
<!-- 		  <script src="http://localhost:8080/iSpanCar/script/vendors/bootstrap/bootstrap.bundle.min.js"></script> -->
<!-- 		  <script src="http://localhost:8080/iSpanCar/script/vendors/skrollr.min.js"></script> -->
<!-- 		  <script src="http://localhost:8080/iSpanCar/script/vendors/owl-carousel/owl.carousel.min.js"></script> -->
<!-- 		  <script src="http://localhost:8080/iSpanCar/script/vendors/nice-select/jquery.nice-select.min.js"></script> -->
<!-- 		  <script src="http://localhost:8080/iSpanCar/script/vendors/jquery.ajaxchimp.min.js"></script> -->
<!-- 		  <script src="http://localhost:8080/iSpanCar/script/vendors/mail-script.js"></script> -->
<!-- 		  <script src="http://localhost:8080/iSpanCar/script/js/main.js"></script> -->

            <script type="text/javascript">
                $(function () {
                	$('.birthday').each(function(){
                		var birthstr = $(this).text();
                		var str = birthstr.substring(0,10);
                		$(this).html(str+'<input type="hidden" id="birthday" name="birthday" value="'+str+'">');
                	})
                	//隱藏電話
                	var phonenumber = $('.phonenumber').text();
                	var phonetext = phonenumber.substring(0,phonenumber.length-4) +'****'+'<input type="hidden" id="phonenumber" name="phonenumber" value="${login.phonenumber}">';
                	$('.phonenumber').html(phonetext);
                	//隱藏身分證
                	var idnumber = $('.idnumber').text();
                	var idnumbertext = idnumber.substring(0,idnumber.length-4) +'****'+'<input type="hidden" id="idnumber" name="idnumber" value="${login.idnumber}">';
                	$('.idnumber').html(idnumbertext);
                	//隱藏信用卡
                	var cardnumber = $('.cardnumber').text();
                	var cardnumbertext = cardnumber.substring(0,cardnumber.length-9) +'****-****'+'<input type="hidden" id="cardnumber" name="cardnumber" value="${login.cardnumber}">';
                	$('.cardnumber').html(cardnumbertext);
                	//顯示Body
                	$('body').css("display","");
            
                })
                $(function(){
                	$('#content').on('click','.edit',function(e){
                		e.preventDefault();
                		var originval = $(this).prev().children('input').val();
                		$(this).prev().html('<input type="text" value='+originval+'>');
                		$(this).removeAttr('class').attr('class','confirm btn-primary btn-sm').text('確認');
                		//if($(this).attr('id'))
                	})
                	$('#content').on('click','.confirm',function(e){
                		e.preventDefault();
                		var newval = $(this).prev().children('input').val();
                		
                		
                		$(this).prev().html(newval+'<input type="hidden" class="memberinfo" value="'+newval+'">')
//                 		$(this).prev().html('<input type="text" value='+originval+'>');
                		$(this).removeAttr('class').attr('class','edit btn-primary btn-sm').text('編輯');
                		
                		
                	})
                })

            </script>
        </body>

        </html>