<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags" %>
<head>
    <title>Chting! = 취미 + 미팅</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="apple-touch-icon" href="${pageContext.request.contextPath}/assets/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/img/favicon.ico">
    <!-- Load Require CSS -->
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font CSS -->
    <link href="${pageContext.request.contextPath}/assets/css/boxicon.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;600&display=swap" rel="stylesheet">
    <!-- Load Tempalte CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/templatemo.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/custom.css">
    <!-- Select2 CSS -->
    <link href="${pageContext.request.contextPath}/assets/css/select2.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/assets/css/nice-select.css" rel="stylesheet"/>
    <!-- Sweetalert2 CSS -->
    <link href="${pageContext.request.contextPath}/assets/css/sweetalert2.css" rel="stylesheet"/>

</head>
<!-- Header -->
<nav id="main_nav" class="navbar navbar-expand-lg navbar-light bg-white shadow">
    <div class="container d-flex justify-content-between align-items-center" id="logoBox">
        <se:authorize access="!hasAnyAuthority('ROLE_USER','ROLE_ADMIN')">
            <a class="navbar_logo" href="${pageContext.request.contextPath}/index.do">
                <img src="${pageContext.request.contextPath}/resources/img/final_logo.png" width="150px"></span>
            </a>
        </se:authorize>
        <se:authorize access="hasAnyAuthority('ROLE_USER','ROLE_ADMIN')">
            <a class="navbar_logo" href="${pageContext.request.contextPath}/myGroup.do">
                <img class="logo_img" src="${pageContext.request.contextPath}/assets/img/demo_logo1.png" alt="logo">
            </a>
        </se:authorize>
        <button class="navbar-toggler border-0" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbar-toggler-success" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

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

            <div class="navbar align-self-center d-flex justify-content-center">
                <se:authorize access="!hasAnyAuthority('ROLE_MEMBER','ROLE_ADMIN')">
                    <a class="navbar-btn btn btn-primary" href="${pageContext.request.contextPath}/member/login">Login</a>
                </se:authorize>
                <se:authorize access="hasAuthority('ROLE_MEMBER')">
                    <a class="navbar-btn btn btn-primary" href="${pageContext.request.contextPath}/myPage.do">MyPage</a>&emsp;|&emsp;
                    <a class="navbar-btn btn btn-primary" href="${pageContext.request.contextPath}/member/logout" id="logout">Logout</a>
                </se:authorize>
                <se:authorize access="hasAuthority('ROLE_ADMIN')">
                    <a class="navbar-btn btn btn-primary" href="${pageContext.request.contextPath}/admin/dashboard">Admin</a>&emsp;|&emsp;
                    <a class="navbar-btn btn btn-primary" href="${pageContext.request.contextPath}/myPage.do">MyPage</a>&emsp;|&emsp;
                    <a class="navbar-btn btn btn-primary" href="${pageContext.request.contextPath}/member/logout" id="logout">Logout</a>
                </se:authorize>
            </div>
        </div>
    </div>
</nav>