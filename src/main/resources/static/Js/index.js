$(document).ready(function(){
	$('#tblP').DataTable();
});

$('#btnFind').click(function () {
	var b=$("#txtPrice").val();
	window.location.href = "/pricefind/"+b;
	});
	


$('#btnBuscar').click(function () {
	
	var b=$("#txtBrand").val();
	if (b.length>0){
		
		fetch("/brand/"+b,{
  method: 'GET',
  
  headers:{
    'Content-Type': 'application/json'
  }
}).then((resp) => resp.json())
.then(function(data) {
	
	if(data.id==null){
		swal({
  				title: "The Brand isn't exist!",
  				text: "Write other Brand",
  				icon: "error",
			});
	
	}else{
		swal({
  				title: "Success!",
  				text: "Id="+data.id,
  				icon: "success",
			});
	
	}
	
 
  });
	}else{
		swal({
  				title: "WARNING!",
  				text: "You must complete the form correctly!",
  				icon: "warning",
			});
	}
	
	});	
	
	

