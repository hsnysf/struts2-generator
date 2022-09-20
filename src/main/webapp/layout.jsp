<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
	<head>
	
		<title>Manager Management</title>
		
		<meta http-equiv="Expires" content="-1">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">

		<meta charset="UTF-8">
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="viewport" content="width = device-width, initial-scale = 1, user-scalable = no">

		<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
		
	    <link rel="shortcut icon" href="https://upload.wikimedia.org/wikipedia/en/thumb/3/30/Java_programming_language_logo.svg/800px-Java_programming_language_logo.svg.png">
		<link rel="apple-touch-icon" href="https://upload.wikimedia.org/wikipedia/en/thumb/3/30/Java_programming_language_logo.svg/800px-Java_programming_language_logo.svg.png">
		<link rel="apple-touch-startup-image" href="https://upload.wikimedia.org/wikipedia/en/thumb/3/30/Java_programming_language_logo.svg/800px-Java_programming_language_logo.svg.png">
		<link rel="apple-touch-icon-precomposed" href="https://upload.wikimedia.org/wikipedia/en/thumb/3/30/Java_programming_language_logo.svg/800px-Java_programming_language_logo.svg.png">
	
	</head>
	<body>
		<div class="container-fluid mb-5">
			<tiles:insertAttribute name = "header" />
			<s:if test="hasActionMessages()">
			<div class="alert alert-success fw-bold text-center mt-3" role="alert">
				<s:property value="actionMessages[0]"/>
			</div>
			</s:if>
			<s:if test="hasActionErrors()">
			<div class="alert alert-danger fw-bold text-center mt-3" role="alert">
				<s:property value="actionErrors[0]"/>
			</div>
			</s:if>
			<div id="alert" class="alert alert-danger fw-bold text-center mt-3" role="alert" style="display:none">
			</div>
	      	<tiles:insertAttribute name="page" />
	      	<tiles:insertAttribute name="footer" />
		</div>
		<script type="text/javascript" src="js/common.js"></script>
	</body>
</html>