<%@page import="java.util.List"%>
<%@ include file="../html/head.jsp" %>
<%@ include file="../html/navigationbar.jsp" %>
<%@ page language="java"   contentType="text/html; charset=UTF-8" %>
<div class="container">
	<form action="<%=baseUrl%>/order/payValidateInfo">
	  <div class="form-group">
	    <label for="orderId">订单号:</label>
	    <c:if test="${empty param.orderId}">
	    	<input type="text" class="form-control"  name="orderId" id="orderId" placeholder="请输入您要登记支付的订单编号">
	    </c:if>
	    <c:if test="${not empty param.orderId}">
	    	<input type="text" class="form-control"  name="orderId" id="orderId" value="${param.orderId}">
	    </c:if>
	  </div>
	  <div class="form-group" id="payWayWrapdiv">
	    <label for="payWaySelect">支付方式:</label>
		    <select class="form-control" id="payWaySelect" name="payWay">
			  <option value="微信">微信转账</option>
			  <option value="支付宝">支付宝转账</option>
			  <option value="银联">银行转账</option>
			  <option value="现金">线下现金</option>
			</select>
	  </div >
	 <div class="form-group">
			<label for="trade_serial_number">交易流水号:</label>
			<input type="text" class="form-control" name="paySerialNumber” id="trade_serial_number" placeholder="第三方交易平台的交易流水号">
	</div>
			 
	 <div class="form-group">
		 <label for="tradeTime">交易时间:</label>
		 <input type="text" class="form-control"  id="tradeTime"  name="tradeTime" placeholder="例如:2016-10-01 12:58:05">
	</div>
	  <button type="submit" class="btn btn-default">提交审核单</button>
	</form>
	<div class="row">
		*交易订单号可以是微信/支付宝的交易订单号、银行交易流水号等
	</div>
	<div class="row">
		*交易时间请参照格式填写
	</div>
	<div class="row">
		*金额请参照格式填写
	</div>
	<div class="row">
		系统将在收到您的支付验证信息后尽快为您确认订单
	</div>
</div>

<%@ include file="../html/foot.jsp" %>