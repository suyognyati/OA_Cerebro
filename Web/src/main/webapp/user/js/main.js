
var isLeftNavOpen = true;
var sideNavWidth = "25%";
var mainContentWidth = "75%";
var navHeight = 0;
function toggle() {
	if (isLeftNavOpen = !isLeftNavOpen) {
		sideNavWidth = "25%";
		mainContentWidth = "75%";
		openNav();
	} else {
		sideNavWidth = "5%";
		mainContentWidth = "95%";
		closeNav();
	}	
}

function openNav() {
	$("#mySidenav").css('width', sideNavWidth);
	$("#main-content").css('width', mainContentWidth);
	if($(window).scrollTop() > navHeight)
		$(".affix").css("right", mainContentWidth);
	for (i = 0; i <= 5; i++) {
		$("#nav-text" + i).attr("class", "nav-text-display");
	}
}

function closeNav() {
	$("#mySidenav").css('width', sideNavWidth);
	$("#main-content").css('width', mainContentWidth);
	if($(window).scrollTop() > navHeight)
		$(".affix").css("right", mainContentWidth);
	for (i = 0; i <= 5; i++) {
		$("#nav-text" + i).attr("class", "nav-text-hide");
	}
}

function setActiveElementOnLeftNav(id) {
	var activeelement = $("#" + id);
	if (!activeelement.hasClass('active')) {
		$('.left-nav .nav li').removeClass('active');
		activeelement.addClass('active');
	}
}

function setActiveElementOnTopNav(id) {
	var activeelement = $("#" + id);
	if (!activeelement.hasClass('active')) {
		$('.navbar-nav li').removeClass('active');
		activeelement.addClass('active');
	}
}

function refreshSelectPicker() {
	$(".selectpicker").selectpicker("refresh");
}

function refreshSelectPickerWithDelay(delay) {
	if(delay == null)
		delay = 100;
	
	setTimeout(function() {
		$(".selectpicker").selectpicker("refresh");
	}, delay);
}

$(document).ready(function(){
	$(window).bind('scroll', function() {
        navHeight = $("header").height();
        if($(window).scrollTop() >= navHeight) {
        	mainMenuHeight = $(".mainMenu").height()
        	$('nav').addClass('stickToTop');
        	$(".main-content").css("margin-top", mainMenuHeight);
        	$(".affix").css("right", mainContentWidth);
        	$(".affix").css("top", mainMenuHeight);
        } else {
        	$('nav').removeClass('stickToTop');
        	$(".main-content").css("margin-top", "");
        	$(".affix").css("right", "");
        	$(".affix").css("top", "");
        }
	});
    
	$('.submenu').affix({
		offset: {
			top: $('header').height()
		}
	}); 
    
    $('.left-nav .nav li a').click(function(e) {
        var $parent = $(this).parent();
        setActiveElementOnLeftNav($parent.attr('id'));       
    });
    
    $('.navbar-nav li a').click(function(e) {
        var $parent = $(this).parent();
        setActiveElementOnTopNav($parent.attr('id'));
    });    
});
