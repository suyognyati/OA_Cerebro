function setActiveElementOnLeftNav(id) {
	var activeelement = $("#" + id);
	if (!activeelement.hasClass('active')) {
		$('.subnavbg .subnav li').removeClass('active');
		activeelement.addClass('active');
	}
}

function setActiveElementOnTopNav(id) {
	var activeelement = $("#" + id);
	if (!activeelement.hasClass('active')) {
		$('.headernav nav ul li a').removeClass('active');
		activeelement.addClass('active');
	}
}

$(document).ready(function(){
	$('.subnavbg .subnav li a').click(function(e) {
        var $parent = $(this).parent();
        setActiveElementOnLeftNav($parent.attr('id'));       
    });
    
    $('.headernav nav ul li a').click(function(e) {
        var $parent = $(this);
        setActiveElementOnTopNav($parent.attr('id'));
    });    
});