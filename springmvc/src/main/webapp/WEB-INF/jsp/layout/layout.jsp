<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<!-- 包含css与js -->
		<jsp:include page="/WEB-INF/jsp/base/base.jsp"></jsp:include>
	</head>
	<body>
	
		<h1>页面1</h1>
		<tiles:insertAttribute name="page1"></tiles:insertAttribute>
		<h1>页面2</h1>
		<tiles:insertAttribute name="page2"></tiles:insertAttribute>
		<h1>页面3</h1>
		<tiles:insertAttribute name="page3"></tiles:insertAttribute>
	
	</body>
</html>