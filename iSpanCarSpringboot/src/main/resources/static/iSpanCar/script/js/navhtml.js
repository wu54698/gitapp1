$(function(){
var navhtml = '<div class="container px-4 px-lg-5">'+
		           '<a class="navbar-brand  text-light" href="#page-top">首頁</a>'+
		            '<button class="navbar-toggler navbar-toggler-right" type="button" data-bs-toggle="collapse"'+
		                'data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"'+
		               'aria-label="Toggle navigation">'+
		               'Menu'+
		               '<i class="fas fa-bars"></i>'+
		           '</button>'+
		            '<div class="collapse navbar-collapse" id="navbarResponsive">'+
		               '<ul class="navbar-nav ms-auto">'+
		                   '<li class="nav-item"><b><a class="nav-link text-light" href="#about">車廠</a></b></li>'+
		                    '<li class="nav-item"><b><a class="nav-link text-light" href="#projects">車輛</a></b></li>'+
		                    '<li class="nav-item"><b><a class="nav-link text-light" href="#projects">保養廠</a></b></li>'+
		                    '<li class="nav-item"><b><a class="nav-link text-light" href="#about">論壇</a></b></li>'+
		                    '<li class="nav-item"><b><a class="nav-link text-light" href="#about">商城</a></b></li>'+
		                    '<li class="nav-item"><b><a class="nav-link text-light" href="#signup">登入</a></b></li>'+
		                '</ul>'+
		            '</div>'+
		        '</div>';
		  
		  $('#mainNav').html(navhtml);  

})