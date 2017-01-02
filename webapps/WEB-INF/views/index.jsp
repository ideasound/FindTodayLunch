<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="${cPath }/js/jquery-1.10.2.js"></script>
    <script src="${cPath }/js/bootstrap.js"></script>
    <script src="${cPath }/js/bootstrap-select.js"></script>
    <script type="text/javascript" src="${cPath }/js/jquery.validate.js"></script>
	<script src="${cPath }/js/bootstrap-datepicker.js"></script>
	<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    <link href="${cPath }/css/bootstrap.css" rel="stylesheet" media="screen">
    <link href="${cPath}/css/bootstrap-select.css" rel="stylesheet">
    <link href="${cPath }/css/datepicker.css" rel="stylesheet">
    <link href="${cPath }/css/etc.css" rel="stylesheet">
<%--     <link href="${cPath}/css/common.css" rel="stylesheet"> --%>
    
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/fullcalendar/2.2.3/fullcalendar.min.css" />
	<script src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.8.4/moment.min.js" type="text/javascript"></script>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/fullcalendar/2.2.3/fullcalendar.min.js" type="text/javascript"></script>
    
<!--     <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet"> -->
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="${cPath}/assets/js/ie-emulation-modes-warning.js"></script>
<!--     <link rel="icon" href="../../favicon.ico"> -->

    <title>ARGOBOB</title>
  </head>

  <body>
<script type="text/javascript">

		$(function(){
	    	$("#quickBtn").on("click", function(){
	    		$.ajax({
		    		url: '${cPath}/quick/quickSelect.do',
		    		type: 'POST',
		    		dataType: 'JSON',
		    		success: function(obj){
		    			
		    			var res = "";
		    			$("#restaurant_id").val(obj.id);
		    			res = obj.name;
		    			res += "<br/>";
						res += "<img src=\"${cPath}/css/img/Apartment.png\"/>";
		    			$("#quickRes p").html(res);
		    			$('#quickModal').modal('toggle') ;
		    		},
		    		error: function(message){
		    			alert("실패");
		    		}
	    		});
	    	});
	    	
// 	    	$("#historyInsert_btn").on("click", function(){
// 	    		var param = $("#historyInsertForm").serialize();
// 	    		$.ajax({
// 		    		url: '${cPath }/history/historyInsert.do',
// 		    		data: param,
// 		    		type: 'POST',
// 		    		dataType: 'JSON',
// 		    		success: function(obj){
// 		    			alert(obj);
// 		    		},
// 		    		error: function(message){
// 		    			alert("전송실패");
// 		    		}
// 	    		});	    		
// 	    	});

			$("#historyInsert_btn").on("click", function(){
				$("#historyInsertForm").submit();
			});
			
	    	<%
	    	String message = (String) request.getAttribute("message");
	    		if(message!=null){
	    	%>
	    			alert('<%=message%>');
	    	<%
	    		}
	    	%>
	    	
// 	    	$("#weather_btn").on("click", function(){
// 			});
	    	
	    	$("#advsch_btn").on("click",function(){
	    		$.ajax({
	    			url: '${cPath}/search/advancedSearch.do',
	    			data: $("#advanced_search_form").serialize(),
	    			type: 'get',
	    			dataType: 'JSON',
	    			success: function(dataList){
	    				var res = "";
	    				$.each(dataList, function(i, data) {
	    					$.each(data.menuList, function(j, obj) {
	    				    	res += obj.name+",";
	    					});
	    				})
	    				res = res.substring(0, res.length-1);
	    				alert(res);
	    			},
	    			error: function(message){
	    				alert("통신실패");
	    				
	    			}
	    		});
	    	});
	    	
// 	    	$("#value1").draggable();
	    	 
// 	    	$("#cateCode").on("change", function(){
// 	    		$.ajax({
// 	    			url: '${cPath}/'
	    			
// 	    		});
// 	    	});
		});
		$(function(){
          $("#weather_btn").on("click", function(){
            $.getJSON("http://api.openweathermap.org/data/2.5/weather?id=1835235?id=user&callback=?", function(data) {
                 $("#weather").val(data.weather[0].id);
                 
                 var param=$("#weatherForm").serialize();
                 $.ajax({
                   url: '${cPath}/weather/foodSelect.do',
                   type: 'POST',
                   dataType: 'JSON',
                   data:param,
                   success: function(lists){
                	   var html = "";
                	   $.each(lists, function(i, obj){
                		   html += obj.menu_name+":";
                		   $.each(obj.restaurantList, function(j, rest){
                			  html += rest.name+"("+rest.addr+")"; 
                		   });
                		   html += "<br/>";
                	   });
						html += "<img src=\"${cPath}/css/img/Food-Dome.png\"/>";
                	   $("#weatherRes").html(html);
                	   $('#weatherModal').modal('toggle') ;
                   },
                   error: function(message){
                      alert("실패");
                   }
                   
                });
            });
         });
          
          $.getJSON("http://api.openweathermap.org/data/2.5/weather?id=1835235?id=user&callback=?", function(data) {
				
				//"weather":[{"id":803,"main":"Clouds","description":"broken clouds","icon":"04n"}],
				
				/*{"coord":{"lon":139,"lat":35},
					"sys":{"country":"JP","sunrise":1369769524,"sunset":1369821049},
					"weather":[{"id":804,"main":"clouds","description":"overcast clouds","icon":"04n"}],
					"main":{"temp":289.5,"humidity":89,"pressure":1013,"temp_min":287.04,"temp_max":292.04},
					"wind":{"speed":7.31,"deg":187.002},
					"rain":{"3h":0},
					"clouds":{"all":92},
					"dt":1369824698,
					"id":1851632,
					"name":"Shuzenji",
					"cod":200}
				*/
// 				alert(data.weather[0].main);
				var html = "";
				if( data.weather[0].main == 'Rain' ) {
					html = "<img src=\"${cPath}/css/img/umbrella.png\" class=\"weather_icon\"/>"
				}else {
					html = "<img src=\"${cPath}/css/img/weather_sun.png\" class=\"weather_icon\"/>"
				}
				$("#weather_icon_area").html(html);
				
			});
      });
	</script>
	
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" 
          			data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${cPath }">ARGOBOB</a>
        </div>
<!--         <div id="navbar" class="navbar-collapse collapse"> -->
<!--           <form class="navbar-form navbar-right"> -->
<!--             <div class="form-group"> -->
<!--               <input type="text" placeholder="Email" class="form-control"> -->
<!--             </div> -->
<!--             <div class="form-group"> -->
<!--               <input type="password" placeholder="Password" class="form-control"> -->
<!--             </div> -->
<!--             <button type="submit" class="btn btn-success">Sign in</button> -->
<!--           </form> -->
<!--         </div> -->
        <!--/.navbar-collapse -->
      </div>
    </nav>

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h1>ARGOBOB DOO-BI-DOO-BOB</h1>
        <p>Argonet의 새로운 거처! 탑립동 878에서의 점심 이슈 해결 프로그램 ARGOBOB</p>
        <p>
        	<button type="button" class="btn btn-primary btn-lg" 
        			data-toggle="modal"
        			id="quickBtn">
  				구내식당 Quick!
			</button>
		</p>
		<p>
        	<button type="button" class="btn btn-primary btn-lg" 
        			data-toggle="modal"
        			id="weather_btn">
  				현재날씨 기준 찾기!
			</button><div id="weather_icon_area">
			
			</div>
			
		</p>
		  <form id="weatherForm">
			  <input id="weather" name="weather" type="hidden" value="" />
			</form>
			
			<div class="modal fade" id="quickModal" tabindex="-1" role="dialog" aria-labelledby="quickModalLabel">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="quickModalLabel">Today's lunch</h4>
			      </div>
			      <div class="modal-body" id="quickRes">
			      	<p></p>
					<form action="${cPath }/history/historyInsert.do" method="post" id="historyInsertForm">
						<input type="hidden" value="" name="restaurant_id" id="restaurant_id">
					</form>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
			        <button type="button" class="btn btn-primary" id="historyInsert_btn">결정</button>
			      </div>
			    </div>
			  </div>
			</div>
        	<div class="modal fade" id="weatherModal" tabindex="-1" role="dialog" aria-labelledby="weatherModalLabel">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="weatherModalLabel">Today's lunch</h4>
			      </div>
			      <div class="modal-body" id="weatherRes">
			      	<p></p>
			      </div>
			      <div class="modal-footer">
<!-- 			        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button> -->
<!-- 			        <button type="button" class="btn btn-primary" id="historyInsert_btn">결정</button> -->
			      </div>
			    </div>
			  </div>
			</div>
      </div>
    </div>

	<div class="container">
		<div class="row">
			<!-- Example row of columns -->
			<div class="col-md-8">
				<div class="panel panel-default">
					<div class="panel-heading">상세검색</div>
					<div class="panel-body">
						<!--           <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p> -->
						<form action="${cPath }/search" method="get"
							id="advanced_search_form">
							<div class="cateName">
								<%
									int count = 0;
								%>
								<c:forEach items="${cateCodeList }" var="cateCode"
									varStatus="outCnt">
									<dl class="mgb_5">
										<dt>${cateCode.name }</dt>
										<dd>
											<c:forEach items="${cateCode.valueList }" var="value"
												varStatus="inCnt">
												<%
													count++;
												%>
												<input type="checkbox" name="value_id"
													value="${value.value_id }" draggable="true"
													class="ui-widget-content" id="value<%=count%>">
												<label for="value<%=count%>">${value.value }</label>
											</c:forEach>
										</dd>
									</dl>
									<br />
								</c:forEach>
							</div>
							<%-- 				<c:forEach items="${valueCodeList }" var="valueCode" varStatus="cnt"> --%>

							<%-- 					<div class="valueRect"><input type="checkbox" name="value_id" value="${valueCode.value_id }" draggable="true" class="ui-widget-content" id="value${cnt.count }">${valueCode.value }</div> --%>

							<%-- 				</c:forEach> --%>
						</form>
						<p>
							<button class="btn btn-default" role="button" id="advsch_btn">Search!!!</button>
						</p>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">Visit History</div>
					<div class="panel-body">
						<table class="table table-striped">
							<c:forEach items="${historyList }" var="history" varStatus="i">
								<tr>
									<td>${i.count }</td>
									<td>${history.visitDate  }</td>
									<td>
										<c:if test="${history.nightORday=='N' }">
											저녁
										</c:if>
										<c:if test="${history.nightORday=='D' }">
											점심
										</c:if>
									</td>
									<td>${history.restaurantName }</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
		<hr>

		<footer>
			<p>&copy; ARGONET 2015</p>
		</footer>
	</div>
	<!-- /container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="${cPath }/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${cPath }/assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
