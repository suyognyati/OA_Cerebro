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

function setActiveOnSubMenu(id) {
	var activeelement = $("#submenu #" + id);
	$('#submenu > ul > li').removeClass('active');
	activeelement.addClass('active');
}