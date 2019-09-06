$(document).ready(function(){
	$("#searchtable tr").addClass("row");
	$("#searchtable tr td").addClass("col-md-2 col-md-offset-4 col-lg-2 col-lg-offset-4");
	$("#tablehead tr th").addClass("col-md-2 col-md-offset-4 col-lg-2");
	$("#submit").click(
			function(){
					var data="{\"from\":\""+$("#from").val()+"\","+"\"to\":\""+$("#to").val()+"\","+"\"godate\":\""+$("#godate").val()+" 00:00:00\","+"\"returndate\":\""+$("#returndate").val()+" 00:00:00\"}";
					var json=JSON.parse(data);
					//alert(data);
					$.ajax({
						//type:"POST",
						url:"querySpecificTrip",
						data:json,
						cache:false,
						contentType:"application/json",
						success:function(aaa){
							var jsonObj=eval(aaa);
							if(jsonObj!=null){
								for(var i=0;i<jsonObj.length;i++){
									$("#tablehead .appendedresult").remove();
									$("#tablehead").append(
											"<tr class=\"row appendedresult\">"
										+"<td>"+jsonObj[i].tripId+"</td>"
										+"<td>"+jsonObj[i].originator+"</td>"
										+"<td>"+jsonObj[i].terminal+"</td>"
										+"<td>"+jsonObj[i].goOff+"</td>"
										+"<td>"+jsonObj[i].poll+"</td>"
										+"<td><a href=\"../Business/fillOrder.jsp?tripId="+jsonObj[i].tripId+"\">订票</a></td>"
										+"</tr>"
									);
								}
							}else{
								$("#tablehead .appendedresult").remove();
								alert("未查询到符合条件的相关数据!");
							}
							
							$("#tablehead tr td").addClass("col-md-1 col-md-offset-5 col-lg-1 col-lg-offset-5");
							$("#goOffTime").attr("class","col-md-2 col-md-offset-4 col-lg-2");
						},
						dataType:"json",
						error:function(err){
							document.write("error"+err);
						}
					});
			}
	);
});
