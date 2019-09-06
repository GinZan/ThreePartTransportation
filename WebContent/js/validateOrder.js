function adminDel(){
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
					noty({text: 'You clicked "删除" button', type: 'error',timeout:500});
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
function adminValidatePay(oid){
	var n = noty({
		layout: 'center',
	    animation: {
	        open: 'animated fadeInUpBig', // Animate.css class names
	        close: 'animated fadeOutDown', // Animate.css class names
	    },
	    text: '要验证此订单为已支付吗?',
		buttons: [
			{addClass: 'btn btn-danger', text: '确定', onClick: function($noty) {
					// this = button element
					// $noty = $noty element
					$noty.close();
					location.href="./validateOrderPay?orderId="+oid;
				}
			},
			{addClass: 'btn btn-primary', text: '放弃', onClick: function($noty) {
					$noty.close();
					noty({text: '您已放弃了该操作', type: 'error',timeout:500});
				}
			}
		]
	});
}
function undoOrderPay(oid){
	var n = noty({
		layout: 'center',
	    animation: {
	        open: 'animated fadeInUpBig', // Animate.css class names
	        close: 'animated fadeOutDown', // Animate.css class names
	    },
	    text: '要撤销此订单的支付信息吗?',
		buttons: [
			{addClass: 'btn btn-danger', text: '确定', onClick: function($noty) {
					// this = button element
					// $noty = $noty element
					$noty.close();
					location.href="./undoOrderPay?orderId="+oid;
				}
			},
			{addClass: 'btn btn-primary', text: '放弃', onClick: function($noty) {
					$noty.close();
					noty({text: '您已放弃了该操作', type: 'error',timeout:500});
				}
			}
		]
	});
}