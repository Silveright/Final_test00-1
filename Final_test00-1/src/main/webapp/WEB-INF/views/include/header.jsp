<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Load Require CSS -->
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<!-- Font CSS -->
<link href="${pageContext.request.contextPath}/resources/css/boxicon.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;600&display=swap" rel="stylesheet">
<!-- Load Tempalte CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/templatemo.css">
<!-- Custom CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/custom.css">
</head>
<body>
<!-- Header -->
<nav id="main_nav" class="navbar navbar-expand-lg navbar-light bg-white shadow">
	<div class="container d-flex justify-content-between align-items-center">
		<a class="navbar-brand h1" href="#">
			<span class="fs-4"><img src="${pageContext.request.contextPath}/resources/img/final_logo.png" width="150px"></span>
		</a>
		
		<div class="align-self-center collapse navbar-collapse flex-grow-1" id="navbar-toggler-success">
			<div class="navbar flex-fill mx-xl-5 d-flex justify-content-center">
				<div class="pe-lg-5" id="nav search">
					<form class="form-inline" action="${pageContext.request.contextPath}/search.do" method="get">
						<div class="input-group input-group-navbar justify-content-center" id="searchGroup">
							<select name="category" class="form-control form-select-sm search" aria-label="Search"
                                    id="searchSelect">
							<option value="">전체</option>
								<c:forEach items="${applicationScope.search_areaList}" var="area">
									<c:choose>
										<c:when test="${search_category != area.area_name}">
											<option value="${area.area_name}">${area.area_name}</option>
										</c:when>
										<c:otherwise>
											<option value="${area.area_name}" selected>${area.area_name}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
							<input name="search" id="searchValue" type="search"
									class="form-inline form-control form-control-sm"
									placeholder="Search…" aria-label="Search"
									value="<c:out value="${search_keyword}"></c:out>">
							<button id="searchButton" class="btn btn-sm btn-outline-secondary" type="submit"><i
									class="bx bx-search bx-sm"></i></button>
						</div>
					</form>
				</div>
			</div>
		</div>
		
		<!-- 로그인 버튼 -->
		<c:choose>
			<c:when test="${empty id}">
	            <a class="btn" href="${pageContext.request.contextPath}/member/login" role="button" style="background:#4C489D; color:white">Login</a>
	            <a class="btn" href="${pageContext.request.contextPath}/member/join" role="button" style="background:#4C489D; color:white">Join</a>
	            <a class="btn" href="${pageContext.request.contextPath}/admin/dashboard" role="button" style="background:#4C489D; color:white">Admin</a>
       		</c:when>
			<c:when test="${id == 'admin'}">
				<a class="btn" href="admin" role="button" style="background:#4C489D; color:white">Admin</a>
				<a class="btn" href="logout" role="button" style="background:#4C489D; color:white">Logout</a>
			</c:when>
			<c:otherwise>
				<a class="btn" href="admin" role="button" style="background:#4C489D; color:white">${id}님 </a>
				<a class="btn" href="mypage" role="button" style="background:#4C489D; color:white">Mypage</a>
				<a class="btn" href="logout" role="button" style="background:#4C489D; color:white">Logout</a>
			</c:otherwise>
		</c:choose>
	</div>		
</nav>
<!-- Close Header -->

</body>
</html>