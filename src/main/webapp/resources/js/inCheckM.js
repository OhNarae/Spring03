function idCheck(){
	var id = $("#id").val();
	alert(id);
	if (id.length < 3 | id.length > 20) {
		alert('길이가 올바르지 않습니다.');
		$("#id").focus();
		return;
	} else if (!/^[A-Za-z0-9_-]{3,20}$/.test(id)) {
		alert('id는 알파벳,숫자, \'_\' , \'-\' 만 가능합니다.');
		$("#id").focus();
		return;
	}
	
	var url = "/Spring03/idcheck.do?id=" + id;
	window.open(url, "_blank", "toolbar=no, menubar=no, scrollbars=yes, resizable=yes, width=400, height=300");
}





