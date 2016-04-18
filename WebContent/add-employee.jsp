<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Add Employee</title>

    <!-- Bootstrap Core CSS - Uses Bootswatch Flatly Theme: http://bootswatch.com/flatly/ -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/freelancer.css" rel="stylesheet">

    <!-- Custom Fonts -->
   <!--  <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
 -->
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="page-top" class="index">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Floreo</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li class="page-scroll">
                        <a href="choice.html">Choice</a>
                    </li>
                   <!--  <li class="page-scroll">
                        <a href="#about">About</a>
                    </li> -->
                    <li class="page-scroll">
                        <a href="#contact">Contact</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

    <!-- Header -->
    <header>
        <div class="container">
            <div class="row">
                <div class="col-lg-12">	       
                    <div class="intro-text">
                        <hr class="star-light"><br><br>
                    <!--     <span class="skills">Type the last name of your employee: </span>
					 -->

						<c:choose>
							<c:when test="${! empty floreo}">

				<table>
							<form action="AddFloreo.do" method="GET">
								<input type="hidden" name="id" style="color:black;" value="">
      						<tr>
      							<td>First Name: <input type="text" name="fname" style="color:black;" value=""></td>
      							<td>Last Name: <input type="text" name="lname" style="color:black;" value=""></td>
      							<td>City: <input type="text" name="city" style="color:black;" value=""></td>
      							<td>Neighborhood: <input type="text" name="neighborhood" style="color:black;" value=""></td>
      						</tr>
      		</table>
      		<table>
      						<tr>
      							<td>Latitude: <input type="text" name="latitude" style="color:black;" value=""></td>
      							<td>Longitude: <input type="text" name="longitude" style="color:black;" value=""></td>
      							<td>Number of Jobs: <input type="text" name="jobsNum" style="color:black;" value=""></td>
      							<td>Motto: <input type="text"  name="motto"  style="color:black; width: 200px"; value=""></td>
							</tr>
			</table>
								<input type="submit" value="Submit" /><br>
							</form>
			
							</c:when>
							<c:otherwise>
								<p>Floreo not found</p>
							</c:otherwise>
						</c:choose>




					
							
							<%-- 	
					<table>			
					<c:if test="${! empty (floreo)}">
					 <img src="img/portfolio/${floreo.fname}.jpg" alt="" style="width: 50px;">
					 --%>
					 
<%-- 						<tr align ="left"><img align ="left" src="img/portfolio/${floreo.fname}.jpg" alt="" style="width: 70px;">${floreo.fname} ${floreo.lname} | ${floreo.neighborhood} ${floreo.city} | ${floreo.motto} 
						<a href="EditFloreo.do?id=${profile.id}"><button type="button" name="${floreo.id}" style="background-color: pink">Edit</button></a>
						<button type="submit" form="form1" value="Delete-${floreo.fname}" style="background-color: black">Delete</button></tr>
 --%>					
						<%--  <li>Google Link for: <a href="http://maps.google.com/?q=${floreo.latitude},${floreo.longitude}">${floreo.city}</a></li>  --%>
							<%-- </c:if> --%>
						<br><br><br><br>
						
						<hr class="star-light">
					</table>
						<!-- <script type="text/javascript"
		src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
	<script language="javascript" type="text/javascript">

    var map;
    var geocoder;
    function InitializeMap() {
	
        var myOptions =
        {
    		  zoom: 16,
              center: latlng,
              mapTypeId: google.maps.MapTypeId.ROADMAP,
              disableDefaultUI: true,
              zoomControl: true,
              fullscreenControl: true,
              streetViewControl: false,
              scaleControl: true   
        };
        map = new google.maps.Map(document.getElementById("map"), myOptions);
    }

    function FindLocaiton() {
        geocoder = new google.maps.Geocoder();
        InitializeMap();

        var address = document.getElementById("addressinput").value;
        geocoder.geocode({ 'address': address }, function (results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                map.setCenter(results[0].geometry.location);
                var marker = new google.maps.Marker({
                    map: map,
                    position: results[0].geometry.location
                });
            }
            else {
                alert("Geocode was not successful for the following reason: " + status);
            }
        });
    }

    function Button1_onclick() {
        FindLocaiton();
    }

    window.onload = InitializeMap;

</script> -->
</head>
<body>
<%-- 	<table>
		<img src="img/portfolio/${floreo.fname}.jpg" class="img-responsive" alt="" style="width: 250px;"><div id="map" style="height: 250px; width: 250px;"></div>
		<div class="my-marker">
			
		</div>
		<br>
		<form action="submit.do" method="GET">
			<INPUT TYPE="submit" name="next" VALUE="next">
		</form>
		
		</td>
		</tr>
	</table> --%>
</body>
		
					</div>
                </div>
            </div>
        </div>
    </header>

</html>