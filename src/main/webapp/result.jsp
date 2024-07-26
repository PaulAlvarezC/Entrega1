<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
	String res = (String) request.getAttribute("result2");
	String[] results = res.split("/");
	if(res.equals("")){
	    res = "No existe Resultado";
	    response.sendRedirect("index.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//use.fontawesome.com/releases/v5.0.7/css/all.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap"
	rel="stylesheet">
<link href="./assets/css/styles.css" rel="stylesheet" type="text/css">
<title>Caesar Cipher</title>
</head>
<body>
	<nav class="navbar navbar-dark bg-primary">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">RESULTADOS</a>
		<form action="back" method="get">
			<div class="col-sm-4">
				<input type="submit" class="btn btn-primary" value="Regresar" />
			</div>
		</form>
	</div>
	</nav>
	<div class="container mt-2">
		<div class="accordion" id="accordionOptions">
			<div class="accordion-item">
				<h2 class="accordion-header" id="headingOne">
					<button class="accordion-button" type="button"
						data-bs-toggle="collapse" data-bs-target="#collapseOne"
						aria-expanded="true" aria-controls="collapseOne">ENTRADA
						DE DATOS</button>
				</h2>
				<div id="collapseOne" class="accordion-collapse collapse show"
					aria-labelledby="headingOne" data-bs-parent="#accordionExample">
					<div class="accordion-body">
						<p style="text-align: justify; text-justify: inter-word;"><%=session.getAttribute("textOrigin")%></p>
						<div class="row">
							<div class="col-lg-3">
								<strong>Total palabras: </strong>
								<p style="text-align: justify; text-justify: inter-word;"><%=session.getAttribute("wordCount")%></p>
							</div>
							<div class="col-lg-3">
								<strong>Letra más repetida: </strong>
								<p style="text-align: justify; text-justify: inter-word;"><%=session.getAttribute("letra")%></p>
							</div>
							<div class="col-lg-3">
								<strong>Indice Letra más repetida: </strong>
								<p style="text-align: justify; text-justify: inter-word;"><%=session.getAttribute("indiceMayorFreq")%></p>
							</div>
							<div class="col-lg-3">
								<strong>Veces: </strong>
								<p style="text-align: justify; text-justify: inter-word;"><%=session.getAttribute("mayor")%></p>
							</div>
						</div>
						<p style="text-align: justify; text-justify: inter-word;"><%=session.getAttribute("newMap")%></p>
					</div>
				</div>
			</div>
			<div class="accordion-item">
				<h2 class="accordion-header" id="headingTwo">
					<button class="accordion-button collapsed" type="button"
						data-bs-toggle="collapse" data-bs-target="#collapseTwo"
						aria-expanded="false" aria-controls="collapseTwo">TABLA
						DE FRECUENCIA</button>
				</h2>
				<div id="collapseTwo" class="accordion-collapse collapse"
					aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
					<div class="accordion-body">
						<div class="row">
							<div class="col col-lg-12">
								<div style="padding-left: 0px;">
									<p style="text-align: justify; text-justify: inter-word;"><%=session.getAttribute("map")%></p>
								</div>
							</div>
							<div class="col-lg-3">
								<strong>Letra mayor frecuencia: </strong>
								<p style="text-align: justify; text-justify: inter-word;"><%=session.getAttribute("letterMaxFreq")%></p>
							</div>
							<div class="col-lg-3">
								<strong>Indice Letra mayor frecuencia: </strong>
								<p style="text-align: justify; text-justify: inter-word;"><%=session.getAttribute("indexAbecedario")%></p>
							</div>
							<div class="col-lg-3">
								<strong>Porcentaje mayor: </strong>
								<p style="text-align: justify; text-justify: inter-word;"><%=session.getAttribute("perMaxFreq")%>
									%
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="accordion-item">
				<h2 class="accordion-header" id="headingThree">
					<button class="accordion-button collapsed" type="button"
						data-bs-toggle="collapse" data-bs-target="#collapseThree"
						aria-expanded="false" aria-controls="collapseThree">
						RESULTADOS</button>
				</h2>
				<div id="collapseThree" class="accordion-collapse collapse"
					aria-labelledby="headingThree" data-bs-parent="#accordionExample">
					<div class="accordion-body">
						<div class="row">
							<div class="col-lg-12">
								<strong>Transformación: </strong>
								<p style="text-align: justify; text-justify: inter-word;"><%=session.getAttribute("transformacion")%></p>
							</div>
							<div class="col col-lg-12">
								<strong>Salida: </strong>
								<div style="padding-left: 0px;">
									<%
										for(int x = 0; x < results.length; x++)
											out.println("->" + results[x] + "<br />");
									%>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"
		integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js"
		integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj"
		crossorigin="anonymous"></script>
</body>
</html>