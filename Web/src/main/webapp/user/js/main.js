
var flag="close";
function toggle(){
	if(flag=="open"){
		openNav();
		flag="close";
	}else{
		closeNav();
		flag="open";
	}
}
function openNav() {
    document.getElementById("mySidenav").style.width = "25%";
	 document.getElementById("main-content").style.width = "75%";
for(i=0;i<=5;i++){
		document.getElementById("nav-text"+i).className="nav-text-display";
	}
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "5%";
	document.getElementById("main-content").style.width = "95%";
 	for(i=0;i<=5;i++){
		document.getElementById("nav-text"+i).className="nav-text-hide";
	}
}
$(document).ready(function(){
    $(window).bind('scroll', function() {
        var navHeight = $("header").height();
        ($(window).scrollTop() > navHeight) ? $('nav').addClass('stickToTop') : $('nav').removeClass('stickToTop');
		 
      
    });
    
    $('.left-nav .nav li a').click(function(e) {

        $('.left-nav .nav li').removeClass('active');

        var $parent = $(this).parent();
        if (!$parent.hasClass('active')) {
            $parent.addClass('active');
        }
       
    });
    
    $('.navbar-nav li a').click(function(e) {

        $('.navbar-nav li').removeClass('active');

        var $parent = $(this).parent();
        if (!$parent.hasClass('active')) {
            $parent.addClass('active');
        }
       
    });
    
});
