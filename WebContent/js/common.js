/**
 * 分页查询
 */
var page_size=2;//每页显示行数
var count_page=0;//页数
var curr_page;//当前页数

function pageSarch(){
			var data="";
			//var json=JSON.parse(data);
			//alert(data);
			$.ajax({
				//type:"POST",
				url:"../ajaxQueryAlltrip",
				data:"",
				cache:false,
				contentType:"application/json",
				success:function(aaa){
					var jsonObj=eval(aaa);
					alert(jsonObj.triplist[0].tripId);
					//alert(jsonObj[0].triplist.originator);
					/**
					for(var i=0;i<jsonObj.length;i++){
						$("#tablehead").append(
							"<tr>"
							+"<td>"+jsonObj[i].tripId+"</td>"
							+"<td>"+jsonObj[i].createdTime+"</td>"
							+"<td>"+jsonObj[i].originator+"</td>"
							+"<td>"+jsonObj[i].terminal+"</td>"
							+"<td>"+jsonObj[i].goOff+"</td>"
							+"<td>"+jsonObj[i].poll+"</td>"
							+"<td><a href=\"\"></a></td>"
							+"</td>"
						);
					}*/
				},
				dataType:"json",
				error:function(err){
					document.write("errorcode:"+err.readyState+" statusText:"+err.statusText);
				}
			});
		}
