<%@page import="java.util.List"%>
<%@include file="../html/head.jsp" %>
<%@include file="../html/navigationbar.jsp" %>
<%@page language="java"   contentType="text/html; charset=UTF-8" %>
<div class="container-fluid">
	<table class="table table-striped">
		<tr>
			<th>订单号</th>
			<th>创建时间</th>
			<th>创建人</th>
			<th>乘客信息</th>
			<th>联系电话</th>
			<th>支付状态</th>
			<th>支付方式</th>
			<th>支付戳</th>
			<th>支付流水</th>
			<th>班次</th>
			<th>路线</th><!-- 包括始发&重点 -->
			<th>操作</th>
		</tr>
		<c:forEach items="${myManageOrderList}" var="oneOrder" >
			<tr>
				<td>${oneOrder.orderId}</td>
				<td>${oneOrder.createdTime}</td>
				<td>${oneOrder.operatorName}</td>
				<td>${oneOrder.passengerName}</td>
				<td>${oneOrder.tel}</td>
				<c:choose>
					<c:when test="${oneOrder.paymentStatus==\"待审核\"}">
						<td>${oneOrder.payTime}</td>
					</c:when>
					<c:when test="${oneOrder.paymentStatus== \"已支付\"}">
						<td>${oneOrder.payTime}</td>
					</c:when>
					<c:otherwise>
						<td>暂无支付信息</td>
					</c:otherwise>
				</c:choose>
				<td>${oneOrder.payWay}</td>
				<td>${oneOrder.payTime}</td>
				<td>${oneOrder.paySerialNumber}</td>
				<td>${oneOrder.tripId}</td>
				<td>${oneOrder.originator}——${oneOrder.terminal}</td>
				<td>
					<c:if test="${oneOrder.paymentStatus == \"未支付\"}">
						等待支付
					</c:if>
					<c:if test="${oneOrder.paymentStatus == \"已支付\"}">
						<button type="button" class="btn btn-warning" onClick="undoOrderPay(${oneOrder.orderId})">撤销审核</button>
					</c:if>
					<c:if test="${oneOrder.paymentStatus == \"待审核\"}">
						<button type="button" class="btn btn-warning" onClick="adminValidatePay(${oneOrder.orderId})">去审核</button>
					</c:if>
					<c:if test="${oneOrder.paymentStatus == \"支付超时\"}">
						<button type="button" class="btn" onClick=”“>支付超时</button>
					</c:if>
					<c:if test="${oneOrder.paymentStatus == \"已取消\"}">
						<button type="button" class="btn">已取消</button>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
   <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
   <!--  <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script> -->
   <script src="../js/jquery-1.9.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/common.js"></script>
    <script src="../js/jquery.noty.packaged.min.js"></script>
    <script src="../js/validateOrder.js"></script>
    
<c:if test="${validateOrderPayIsCalled eq 1}">
	<script>noty({text:"<c:out value="${resultMessage}" escapeXml="false"/>",type: 'error',timeout:1000});</script>
</c:if>

</body>
</html>