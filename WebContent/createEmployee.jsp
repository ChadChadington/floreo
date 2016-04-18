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

    <title>Create Employee</title>

    <!-- Bootstrap Core CSS - Uses Bootswatch Flatly Theme: http://bootswatch.com/flatly/ -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="css/freelancer.css" rel="stylesheet">

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
                    <h1>Create a New Employee</h1><br><br>
                        <hr class="star-light"><br><br>
                    <!--     <span class="skills">Type the last name of your employee: </span>
					 -->

					<%-- 	<c:choose>
							<c:when test="${! empty floreo}"> --%>

				<table>
							<form action="addFloreo.do" method="GET">
								<input align="left" type="hidden" name="id" style="color:black;" value="${floreo.id}">
      						
      							<tr><td align=left>First Name: <input type="text" name="fname" style="color:black;" value="${floreo.fname}"></td></tr>
      							<tr><td align=left>Last Name: <input type="text" name="lname" style="color:black;" value="${floreo.lname}"></td></tr>
      							<tr><td align=left>City: <input type="text" name="city" style="color:black;" value="${floreo.city}"></td></tr>
      							<tr><td align=left>Neighborhood: <input type="text" name="neighborhood" style="color:black;" value="${floreo.neighborhood}"></td></tr>
      							<tr><td align=left>Latitude: <input type="text" name="latitude" style="color:black;" value="${floreo.latitude}"></td></tr>
      							<tr><td align=left>Longitude: <input type="text" name="longitude" style="color:black;" value="${floreo.longitude}"></td></tr>
      							<tr><td align=left>Number of Jobs: <input type="text" name="jobsNum" style="color:black;" value="${floreo.jobsNum}"></td></tr>
      							<tr><td align=left>Motto: <input type="text"  name="motto"  style="color:black; width: 200px"; value="${floreo.motto}"></td></tr>
      							<input type="submit" value="Submit" />
							</form>					
			</table>
								
			
						<%-- 	</c:when>
							<c:otherwise>
								<p>Floreo not found</p>
							</c:otherwise> --%>
					<%-- 	</c:choose> --%>

						<br><br><br><br>
						
						<hr class="star-light">
					</table>
					
</head>
<body>

</body>
		
					</div>
                </div>
            </div>
        </div>
    </header>

</html>