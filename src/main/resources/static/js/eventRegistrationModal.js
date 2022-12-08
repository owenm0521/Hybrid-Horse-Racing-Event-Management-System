$('document').ready(function(){	
	
	$("td.registerBtn a:contains('Register')").on('click',function(event){	
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(event){
			$(".modal-header").html("Sign Up For " + event.name + ":");
			$('#eventRegistrationModal #eventId').val(event.id); 
		});
		$('#eventRegistrationModal').modal();				
	});	
	
	$('#eventRegistrationModal').on('submit',function(event){	
		event.preventDefault(); 
		var regSuccess = false; 
		$.ajax({
			type:"PUT",
			url:"/events/registerForEvent",
			data: $("#eventRegistrationForm").serialize(),
			success: function(){
				$('#eventRegistrationModal').modal('hide');
				regSuccess = true; 
			},
			error: function(){
				alert('Error processing registration. Pleasy try again.');
			}
		}); 
		$(this).on('hidden.bs.modal',function(){
			if(regSuccess){
				alert('Your registration has been processed successfully!');
				regSuccess = false; 
			}
		}); 
	});	
	
	$('#eventRegistrationModal').on('hidden.bs.modal',function(){
		$(this).find('form').trigger('reset');
	}); 
	
});