


$(document).ready(function(){
	

	
	$("#labelDevendo").maskMoney({
		
			showSymbol:true,
			symbol:"R$",
			decimal:".",
			thousands:""});

	jQuery.validator.setDefaults({
		debug:true,
		sucess:"valid"
	});

	

});
//////////////////////////////////////////////////////////
$("#formAdicionaCaloteiros").validate({
	   
    rules:{
      nome:{
      
        required: true, minlength: 2
      },
      email:{
     
        required: true, email: true
      },
      
      devendo:{
    	  required: true
      },
      
      dataDivida:{
    	  required: true
      }
      
     
    },
  
    messages:{
      nome:{
        required: "Digite o seu nome",
        minlength: "O seu nome deve conter, no mínimo, 2 caracteres"
      },
      email:{
        required: "Digite o seu e-mail para contato",
        email: "Digite um e-mail válido"
      },
      
      devendo:{
    	  required:"Digite o valor"
      },
      
      dataDivida:{
    	  required:"entre com a data"
      }
      
     
    }
  });




