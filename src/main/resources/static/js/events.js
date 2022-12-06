$('document').ready(function(){	
	$('.table #editButton').on('click',function(event){	
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(event,status){
			$('#editEventModal #idEdit').val(event.id); 
			$('#editEventModal #nameEdit').val(event.name); 
			$('#editEventModal #descriptionEdit').val(event.description); 
			$('#editEventModal #locationEdit').val(event.location); 
			$('#editEventModal #dateTimeEdit').val(event.dateTime); 
		});
		$('#editEventModal').modal();				
	});	
	
	$('.table #deleteButton').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteEventModal #delRef').attr('href', href);	
		$('#deleteEventModal').modal();
	});
	
});