<%@page import="java.util.List"%>
<%@include file="../html/head.jsp" %>
<%@include file="../html/navigationbar.jsp" %>
<%@page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8" %>
<div class="container">
<form method="post" action="<%=baseUrl%>/admin/addTrip">
  <div class="form-group">
    <label for="originator">始发站</label>
    <input type="text" class="form-control" id="originator" name=“originator” placeholder="如：广州">
  </div>
  <div class="form-group">
    <label for="terminal">终点站</label>
    <input type="text" class="form-control" id="terminal" name=“terminal” placeholder="如：丰顺">
  </div>
    <div class="form-group">
    <label for="goOff">出发时间</label>
    <input type="text" class="form-control" id="goOff" name="goOff" placeholder="严格参照以下格式:2016-05-06 12:35:11">
  </div>
   <div class="form-group">
    <label for="poll">座位数</label>
    <input type="text" class="form-control" id="poll" name="poll" placeholder="如：45">
  </div>
    <div class="form-group">
    <label for="remark">备注</label>
    <input type="text" class="form-control" id="remark" name=“remark” placeholder="如：丰顺">
  </div>
  </div>
    <div class="chargedUid">
    <label for="chargedUid">车次管理员id</label>
    <%
    	int uid=(int)request.getSession().getAttribute("loginedUser");
    	pageContext.setAttribute("manger", uid);
    %>
    <input type="text" class="form-control" id="chargedUid" name=“chargedUid” placeholder="默认是管理员自己的id" value="${manger}">
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form>
</div>
<%@ include file="../html/foot.jsp" %>