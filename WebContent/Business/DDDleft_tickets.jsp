<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java"   contentType="text/html; charset=UTF-8" import="DAO.*" import="Bean.*"%>

<jsp:useBean id="triplistBean" scope="page" class="DAO.TripImp"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<script src="../js/jquery-1.9.1.min.js" type="text/javascript" charset="utf-8"></script>
	<title></title>
</head>
<body>
<div>
		<form action="abc" method="get" >
			<label for="single_trip">单程<input type="radio" name="single_trip" value="single"></label>
			<label for="single_trip">双程<input type="radio" name="round_trip" value="double"></label>
			<label for="start_off">出发地<input type="text" name="start_off" value="start"></label>
			<label for="destination">终点<input type="text" name="destination" value="des"></label>
			<label for="when2go">出发日<input type="text" name="when2go" value="" placeholder=""></label>
			<label for="when2return">返程日<input type="text" name="when2return" value="" placeholder=""></label>
			<input type="submit" name="" value="查询" placeholder="">
		</form>
</div>
<div>
	<table>
		<tr >
		<th >车次</th>
		<th >出发站</th>
		<th>到达站</th>
		<th >出发时间</th>
		<th >剩余数量</th>
		<th >操作</th>
		</tr>
		
		<% /**
			List<Trip> triplist=triplistBean.readAll();
			Iterator<Trip> it=triplist.iterator();
			int amount=triplist.size();
			for(int i=0;i<amount;i++){
				Trip oneTrip=null;
				if(it.hasNext()){
					oneTrip=it.next();
				}
				out.println("<tr>");
				out.print("<td>"+String.valueOf(oneTrip.getTripId())+"</td>");
				out.print("<td>"+oneTrip.getOriginator()+"</td>");
				out.print("<td>"+oneTrip.getTerminal()+"</td>");
				out.print("<td>"+oneTrip.getGoOff().toString()+"</td>");
				out.print("<td>"+String.valueOf(oneTrip.getPoll())+"</td>");
				out.print("<td><a href='#'>订票</a></td>");
				out.println("</tr>");
			}
			*/
		%>
	</table>
</div>
</body>
</html>