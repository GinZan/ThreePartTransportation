<%@page import="java.util.List"%>
<%@include file="../html/head.jsp" %>
<%@include file="../html/navigationbar.jsp" %>
<%@page language="java"   contentType="text/html; charset=UTF-8" %>
<div class="container">
	<div id="firstnav" >
		<button>新增班次</button>
	</div>
	<div id="tableContainer" >
		<table class="table table-striped">
			<tr>
				<th>班次号</th>
				<th>创建时间</th>
				<th>出发地</th>
				<th>目的地</th>
				<th>发车时间</th>
				<th>座位数</th>
				<th>状态</th>
				<th>订票情况</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${myTripList}" var="mytrip" >
				<tr>
					<td>${mytrip.tripId}</td>
					<td>${mytrip.createdTime}</td>
					<td>${mytrip.originator}</td>
					<td>${mytrip.terminal}</td>
					<td>${mytrip.goOff}</td>
					<td>${mytrip.poll}</td>
					<td>${mytrip.available}</td>
					<td>${mytrip.terminal}</td>
					<td>
						<c:if test="${mytrip.available ==0}">
							<button type="button" class="btn btn-info" onClick="location.href='<%=baseUrl%>/Business/pay.jsp?orderId=${mytrip.orderId}'">归档</button>
						</c:if>
						<c:if test="${mytrip.available ==1}">
							<button type="button" class="btn btn-warning" onClick="javascript:location.href='../order/delOrder?orderId=${mytrip.orderId}'";>更改</button>
							<button type="button" class="btn btn-warning" onClick="javascript:location.href='../order/delOrder?orderId=${mytrip.orderId}'";>删除</button>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
<%@ include file="../html/foot.jsp" %>