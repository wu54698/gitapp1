$(function(){
var navhtml = '<div class="container px-4 px-lg-5">'+
		           '<a class="navbar-brand colorchange" href="/index" style="color:white;font-size:1.3em;font-family: \'Noto Sans TC\', sans-serif;">首頁</a>'+
		            '<button class="navbar-toggler navbar-toggler-right" type="button" data-bs-toggle="collapse"'+
		                'data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"'+
		               'aria-label="Toggle navigation">'+
		               'Menu'+
		               '<i class="fas fa-bars"></i>'+
		           '</button>'+
		            '<div class="collapse navbar-collapse" id="navbarResponsive">'+
		               '<ul class="navbar-nav ms-auto">'+
		                   '<li class="nav-item"><b><a class="nav-link colorchange" href="/ShowAllCarFrontPage.controller" style="color:white;font-size:1.3em;font-family: \'Noto Sans TC\', sans-serif;">車輛</a></b></li>'+
		                    '<li class="nav-item"><b><a class="nav-link colorchange" href="#about" style="color:white;font-size:1.3em;font-family: \'Noto Sans TC\', sans-serif;">保養廠</a></b></li>'+
		                    '<li class="nav-item"><b><a class="nav-link colorchange" href="#about" style="color:white;font-size:1.3em;font-family: \'Noto Sans TC\', sans-serif;">論壇</a></b></li>'+
		                    '<li class="nav-item"><b><a class="nav-link colorchange" href="#about" style="color:white;font-size:1.3em;font-family: \'Noto Sans TC\', sans-serif;">商城</a></b></li>'+
		                    '<li class="nav-item"><b><a class="nav-link colorchange" href="#about" style="color:white;font-size:1.3em;font-family: \'Noto Sans TC\', sans-serif;"><i class="fa-solid fa-cart-shopping"></i></a></b></li>'+
		                    '<li class="nav-item login-info"><b><a class="nav-link colorchange" href="/login" style="color:white;font-size:1.3em;font-family: \'Noto Sans TC\', sans-serif;">登入</a></b></li>'+
		                '</ul>'+
		            '</div>'+
		        '</div>';
		  
		  $('#mainNav').html(navhtml);  
		  
//	    $('#mainNav').after(headerhtml);
// (typeof $('#logincheck').val()) != "undefined" || 
			if($('#logincheck').val() != ""){
	    		var account = $('#logincheck').val();
    			var name = $('#loginName').val();
	    		var loginhtml = '<b><a class="nav-link colorchange" href="/userinfo" id="userDropdown" role="button"'+
	                'data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color:white;font-size:1.3em;font-family: \'Noto Sans TC\', sans-serif;">'+name+'&nbsp'+
	    		'<img class="img-profile rounded-circle" id="myImage" width="25px" src="/showimageforthismember.controller\?accountnumber='+account+'"></a></b>';
	    		
	    		var logouttext = '<li class="nav-item"><b><a class="nav-link colorchange" style="color:white;font-size:1.3em;font-family: \'Noto Sans TC\', sans-serif;" href="/logout.controller">登出</a></b></li>';
	    		
	    		$('.login-info').html(loginhtml).after(logouttext);
	    	}else{
	    		var loginhtml='<b><a class="nav-link colorchange" href="/login" style="color:white;font-size:1.3em;font-family: \'Noto Sans TC\', sans-serif;">登入</a></b>';
	    		$('.login-info').html()
	    	}
	    	
	    	
	    	$(window).on('scroll',function(){
				if($(window).scrollTop()==0){$('.navbar').css({"background":"none"})}
	    		$('.colorchange').css('color','white')
	    		$('.navbar-shrink').css({"background-color":"white"}).find('.colorchange').css('color','black')
	    	})
	    	
	    	$('a.colorchange').on('mouseover',function(){
    		$(this).css({'font-size':'1.4em'})
	    	})
	    	$('a.colorchange').on('mouseleave',function(){
	    		$(this).css({'font-size':'1.3em'})
	    	})
})