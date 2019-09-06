function admindelTrip(tid){
	var n = noty({
		layout: 'center',
	    animation: {
	        open: 'animated fadeInUpBig', // Animate.css class names
	        close: 'animated fadeOutDown', // Animate.css class names
	    },
	    text: '确定要删除吗?',
		buttons: [
			{addClass: 'btn btn-primary', text: '删除', onClick: function($noty) {
					// this = button element
					// $noty = $noty element
					$noty.close();
					location.href="./delTrip?tripId="+tid;
				}
			},
			{addClass: 'btn btn-danger', text: '放弃', onClick: function($noty) {
					$noty.close();
					noty({text: '您已放弃了删除操作', type: 'success',timeout:500});
				}
			}
		]
	});
}