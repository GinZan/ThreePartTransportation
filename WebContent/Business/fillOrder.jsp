<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="DAO.*" import="Bean.*"%>
<%@include file="../html/head.jsp" %>
<%@include file="../html/navigationbar.jsp" %> 
<%@page language="java"   contentType="text/html; charset=UTF-8"  %>
<div class="container">
	<form action="../order/makeAnOrder" method="post" >
			<table class="table table-striped">
			<jsp:useBean id="conList" scope="page" class="DAO.ContactImp"></jsp:useBean>
				<%
				int uid=(int)request.getSession().getAttribute("loginedUser");
				response.setHeader("Content-type", "text/html;charset=UTF-8");
				//PrintWriter out = respsonse.getWriter();
				if(uid==0){
					out.print("<script>alert('请登录');document.location.href=\""+baseUrl+"/login.jsp\";</script>");
					//response.sendRedirect(baseUrl+"/login.jsp");
				}else{
					List<Contact> result=conList.query(Integer.valueOf(uid));
					if(result!=null){
						Iterator<Contact> it=result.iterator();
						for(int i=0;i<result.size();i++){
							Contact oneContact=null;
							if(it.hasNext()){
								oneContact=it.next();
							}
							out.print("<tr>");
							out.print("<td><input name=\""+"passenger\" "+ "type=\""+"checkbox\" "+"value=\""+oneContact.getId()+"\"/>"+oneContact.getUserName()+" "+"</td>");
							out.print("</tr>");
						}
					}else{
						out.print("您暂时没有任何联系人，请点击"+"<a href=”#“>这里</a>");
					}
				}
			
				%>
			</table>
		<%
			String tid=request.getParameter("tripId");
			out.print("您选择的车次是："+tid+"<input type=\"hidden\" " +"name=\"tripId\" " +"value=\""+tid+"\"/>");
		%></br>
		<div>
			<button type="button" class="btn btn-default" onClick="sumit_form()">提交订单</button>
		</div>
	</form>
</div>
<script>
	function sumit_form(){
		$("form").submit();
	}
</script>
<%@ include file="../html/foot.jsp" %>