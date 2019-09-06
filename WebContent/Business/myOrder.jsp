<%@page import="java.util.List"%>
<%@include file="../html/head.jsp" %>
<%@include file="../html/navigationbar.jsp" %>
<%@page language="java"   contentType="text/html; charset=UTF-8" %>
<div class="container">
	<table class="table table-striped">
		<tr>
			<th>订单号</th>
			<th>创建时间</th>
			<th>订单状态</th>
			<th>乘客</th>
			<th>电话</th>
			<th>车次</th>
			<th>出发地</th>
			<th>目的地</th><!--  
			<th>发车时间</th>-->
			<th>操作</th>
		</tr>
		<c:forEach items="${myOrderList}" var="myorder" >
			<tr>
				<td>${myorder.orderId}</td>
				<td>${myorder.createdTime}</td>
				<td>${myorder.paymentStatus}</td>
				<td>${myorder.realName}</td>
				<td>${myorder.tel}</td>
				<td>${myorder.tripId}</td>
				<td>${myorder.originator}</td>
				<td>${myorder.terminal}</td>
				<td>
					<c:if test="${myorder.paymentStatus == \"未支付\"}">
						<button type="button" class="btn btn-info" onClick="location.href='<%=baseUrl%>/Business/pay.jsp?orderId=${myorder.orderId}'">去支付</button>
						<button type="button" class="btn btn-info" onClick="#">取消订单</button>
					</c:if>
					<c:if test="${myorder.paymentStatus == \"已支付\"}">
						<button type="button" class="btn btn-warning" onClick="javascript:location.href='../order/delOrder?orderId=${myorder.orderId}'";>退票</button>
					</c:if>
					<c:if test="${myorder.paymentStatus == \"待审核\"}">
						<button type="button" class="btn"  onClick=”#“>审核中</button>
					</c:if>
					<c:if test="${orderlist.paymentStatus == \"支付超时\"}">
						<button type="button" class="btn" onClick=”#“>支付超时</button>
					</c:if>
					<c:if test="${orderlist.paymentStatus == \"已取消\"}">
						<button type="button" class="btn">已取消</button>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
<%@ include file="../html/foot.jsp" %>