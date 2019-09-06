<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@ include file="../html/head.jsp" %>
<%@ include file="../html/navigationbar.jsp" %>
<%@page import="DAO.*" import="Bean.*"%>
<%@ page language="java"   contentType="text/html; charset=UTF-8" %>
	<div class="container-fluid">
		<form  id="t1" action="#" method="post">
			<input type="hidden" name="method" value="querySpecficTrip"></input>
			<table  id="searchtable" class="table-hover"><!--js使radio控制返程日是否可用-->
			<!-- 	<tr >
					<td>单程<input type="radio" name="tripType" value="single" checked="true"/></td>
					<td>双程<input type="radio" name="tripType" value="round" /><br></td>
				</tr> -->
				<tr>
					<td>出发地</td>
					<td><input id="from" type="text" name="from" value="广州"></td>
				</tr>
				<tr>
					<td >目的地</td>
					<td><input id="to" type="text" name="to" value="福州"></td>
				</tr>
				<tr>
					<td>出发日</td>
					<td><input id="godate" type="text" name="date" value="2014-01-01"></td>
				</tr>
				<tr>
					<td>返程日</td>
					<td><input id="returndate" type="text" name="returnDate" value="2016-09-09"></td>
				</tr>
				<tr >
					<td colspan="2" align="center">
					<input id="submit" class="btn btn-primary" type="button" name="" value="提交"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div class="container-fluid">
		<table id="tablehead" class="table-striped  table-hover">
			<tr class="row">
				<th>班次编号</th>
				<th>出发地</th>
				<th>目的地</th>
				<th id="goOffTime">出发时间</th>
				<th>座位数</th>
				<th >操作</th>
			</tr>
		</table>
	</div>
<!-- 自定义foot -->
   <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
   <!--  <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script> -->
   <script src="../js/jquery-1.9.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/common.js"></script>
    <script src="../js/querytrip.js"  type="text/javascript"></script>
</body>
</html>