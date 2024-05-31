<!doctype html>
<html lang="en">
<head>
<title>Caesar Cipher - NLP</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="//use.fontawesome.com/releases/v5.0.7/css/all.css">
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link href="./resources/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
	<nav class="navbar navbar-dark bg-primary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">CAESAR CIPHER - NLP</a>
		</div>
	</nav>
	<div class="container mt-2">
		<div class="card p-3">
			<div class="mb-2">
				<form action="main" method="post">
					<div class="col-sm-12">
						<div class="mb-3">
							<label for="textOrigin" class="form-label">Ingrese el
								texto que desea analizar</label>
							<textarea class="form-control" name="textOrigin" id="textOrigin"
								rows="10" required></textarea>
						</div>
					</div>
					<div class="col-sm-4">
						<input type="submit" class="btn btn-outline-primary"
							value="Analizar" />
					</div>
				</form>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>
