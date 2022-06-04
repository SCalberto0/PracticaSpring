$('#btnClean').click(function () {
	$("#txtName").val('');
    $("#txtBrand").val('');
    $("#txtMade").val('');
	$("#txtPrice").val(0.0);
	});
var den;
$('#btnBack').click(function () {
	window.location.href = "/";
	});
	
	
$('#btnSave').click(function () {
	den=0;
	enviar();
	});	

function enviar(){
	validar();
	
	if(den>0){
		swal({
  				title: "WARNING!",
  				text: "You must complete the form correctly!",
  				icon: "warning",
			});
	}else{
		$("#formnuevoProducto").submit(); 
	}
	
}

function validar(){
	var l=0;
	l=$("#txtName").val().length;
	
	if (l==0) {
		
		den=1;
	}
	l=$("#txtBrand").val().length;
	
	if (l==0) {
		
		den=2;
	}
	l=$("#txtMade").val().length;
	
	if (l==0) {
		
		den=3;
	}
	l=$("#txtPrice").val();
	
	if (l==0) {
		
		den=4;
	}
	
}