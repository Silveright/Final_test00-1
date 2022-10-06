<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>main</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<!-- Header/Nav -->
<jsp:include page="../include/header.jsp"></jsp:include>

<!-- Start Banner Hero -->
<div class="banner-wrapper bg-light">
   <div id="main" class="banner-vertical-center-index container-fluid pt-5">
      <!-- Start slider -->
      <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
         <ol class="carousel-indicators">
            <li data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"></li>
            <li data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"></li>
            <li data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"></li>
         </ol>
         <div class="carousel-inner">
            <div class="carousel-item active">
               <div class="py-5 row d-flex align-items-center">
                  <div class="banner-content col-lg-8 col-8 offset-2 m-lg-auto text-left py-5 pb-5">
                     <h1 class="banner-heading h1 text-secondary display-3 mb-0 pb-5 mx-0 px-0 light-300 typo-space-line">
                        Develop <strong>Strategies</strong> for 
                        <br>your business
                     </h1>
                     <p class="banner-body text-muted py-3 mx-0 px-0">
                        Purple Buzz is a corporate HTML template with Bootstrap 5 Beta 1. This CSS template is 100% free to download provided by <a rel="nofollow" href="https://templatemo.com/page/1" target="_parent">TemplateMo</a>. Total 6 HTML pages included in this template. Icon fonts by <a rel="nofollow" href="https://boxicons.com/" target="_blank">Boxicons</a>. Photos are from <a rel="nofollow" href="https://unsplash.com/" target="_blank">Unsplash</a> and <a rel="nofollow" href="https://icons8.com/" target="_blank">Icons 8</a>.
                     </p>
                     <a class="banner-button btn rounded-pill btn-outline-primary btn-lg px-4" href="#" role="button">Get Started</a>
                  </div>
               </div>
            </div>
            
            <div class="carousel-item">
               <div class="py-5 row d-flex align-items-center">
                  <div class="banner-content col-lg-8 col-8 offset-2 m-lg-auto text-left py-5 pb-5">
                     <h1 class="banner-heading h1 text-secondary display-3 mb-0 pb-3 mx-0 px-0 light-300">
                        HTML CSS Template with Bootstrap 5 Beta 1
                     </h1>
                     <p class="banner-body text-muted py-3">
                        You are not allowed to re-distribute this Purple Buzz HTML template as a downloadable ZIP file on any kind of Free CSS collection websites. This is strongly prohibited. Please contact TemplateMo for more information.
                     </p>
                     <a class="banner-button btn rounded-pill btn-outline-primary btn-lg px-4" href="#" role="button">Get Started</a>
                  </div>
               </div>
            </div>
                    
            <div class="carousel-item">
               <div class="py-5 row d-flex align-items-center">
                  <div class="banner-content col-lg-8 col-8 offset-2 m-lg-auto text-left py-5 pb-5">
                     <h1 class="banner-heading h1 text-secondary display-3 mb-0 pb-3 mx-0 px-0 light-300">
                        Cupidatat non proident, sunt in culpa qui officia
                     </h1>
                     <p class="banner-body text-muted py-3">
                        Ut enim ad minim veniam, quis nostrud exercitation ullamco
                        laboris nisi ut aliquip ex ea commodo consequat. Duis aute
                        irure dolor in reprehenderit in voluptate velit esse cillum
                        dolore eu fugiat nulla pariatur. Excepteur sint occaecat.
                     </p>
                     <a class="banner-button btn rounded-pill btn-outline-primary btn-lg px-4" href="#" role="button">Get Started</a>
                  </div>
               </div>
            </div>
         </div>
         <a class="carousel-control-prev text-decoration-none" href="#carouselExampleIndicators" role="button" data-bs-slide="prev">
            <i class='bx bx-chevron-left'></i>
            <span class="visually-hidden">Previous</span>
         </a>
         <a class="carousel-control-next text-decoration-none" href="#carouselExampleIndicators" role="button" data-bs-slide="next">
            <i class='bx bx-chevron-right'></i>
            <span class="visually-hidden">Next</span>
         </a>
      </div>
      <!-- End slider -->
   </div>
</div>

<!-- 로그인 했을 때 보여지는 화면 -->
<se:authorize access="hasAnyAuthority('ROLE_MEMBER','ROLE_ADMIN')">
<section class="service-wrapper py-3" style="background:#4C489D">
   <div class="container py-5" >
      <div class="row d-flex justify-content-center text-center">
         <div class="col-lg-2 col-12 text-light align-items-center">
            <span><img src="${pageContext.request.contextPath}/resources/img/group2.png" width="100px"></span>
         </div>
         <div class="col-lg-7 col-12 text-light pt-2">
            <h3 class="h4 light-300">모임</h3>
            <p class="light-300">원하는 모임이 없으신가요??</p>
         </div>
         <div class="col-lg-3 col-12 pt-4">
            <a href="${pageContext.request.contextPath}/group/groupMake" 
               class="btn btn-success rounded-pill btn-block shadow px-4 py-2">모임 만들러 가기 => </a>
         </div>
      </div>
   </div>
</section>
<!-- End View Work -->

<!-- Start Recent Work -->
<section class="container overflow-hidden py-5">
   <div class="container-fluid pb-3">
      <div class="row">
         <div class="service-header col-2 col-lg-3">
            <span><img src="${pageContext.request.contextPath}/resources/img/group3.png" width="50px"></span>
            <div class="service-heading col-10 col-lg-9 text-start float-end ">
               <h2 class="h3 pb-4 typo-space-line">&nbsp;가입한 모임</h2>
            </div>
         </div>   
      </div>
   </div>
   
   <div class="container-fluid pb-3">
      <div class="container">
      <div class="row gy-5 g-lg-5 mb-4">
         <!-- Start Recent Work -->
         <div class="col-md-4 mb-3">
            <a href="#" class="recent-work card border-0 shadow-lg overflow-hidden">
               <img class="recent-work-img card-img" src="${pageContext.request.contextPath}/resources/img/recent-work-01.jpg" alt="Card image">
               <div class="recent-work-vertical card-img-overlay d-flex align-items-end">
                  <div class="recent-work-content text-start mb-3 ml-3 text-dark">
                  <h3 class="card-title light-300">가입한 모임1</h3>
                  <p class="card-text">가입한 모임1 설명</p>
                  </div>
               </div>
            </a>
         </div>
         <!-- End Recent Work -->
      </div>
      </div>
   </div>
</section>
</se:authorize>
<!-- 로그인 했을 때 보여지는 화면 끝-->
<!-- End Banner Hero -->
<section class="service-wrapper py-3" style="background:#4C489D" >
   <div class="service-tag py-5" style="background:#4C489D">
      <div class="col-md-12" style="background:#4C489D">
         <ul class="nav d-flex justify-content-center">
            <li class="nav-item mx-lg-4">
               <a class="filter-btn nav-link btn-outline-primary active shadow rounded-pill text-light px-4 light-300" href="#" data-filter=".new">NEW</a>
            </li>
            <li class="nav-item mx-lg-4">
               <a class="filter-btn nav-link btn-outline-primary rounded-pill text-light px-4 light-300" href="#" data-filter=".best">BEST</a>
            </li>
            <li class="filter-btn nav-item mx-lg-4">
               <a class="filter-btn nav-link btn-outline-primary rounded-pill text-light px-4 light-300" href="#" data-filter=".all">ALL</a>
            </li>
         </ul>
      </div>
   </div>
</section>

<section class="container overflow-hidden py-5">
   <div class="container-fluid pb-3">
      <div class="row">
         <div class="service-header col-2 col-lg-3">
            <span><img src="${pageContext.request.contextPath}/resources/img/group.png" width="50px"></span>
            <div class="service-heading col-10 col-lg-9 text-start float-end ">
               <h2 class="h3 pb-4 typo-space-line">&nbsp;&nbsp;추천&nbsp;모임</h2>
            </div>
         </div>
      </div>
   </div>
   <div class="row gx-5 gx-sm-3 gx-lg-5 gy-lg-5 gy-3 pb-3 projects">
   <c:forEach var="b" items="${grouplist}">
      <!-- Start Recent Work -->
      <div class="col-xl-3 col-md-4 col-sm-6 project new best all">
         <a href="${pageContext.request.contextPath}/group/group_detail?num=${b.group_no}" onclick="isUser()" class="service-work card border-0 text-white shadow-sm overflow-hidden mx-5 m-sm-0">
            <img class="service card-img" src="<spring:url value = '/upload${b.group_img}'/>" alt="Card image">
            <div class="service-work-vertical card-img-overlay d-flex align-items-end">
               <div class="service-work-content text-left text-light">
                  <span class="btn btn-outline-light rounded-pill mb-lg-3 px-lg-4 light-300">${b.area_name}</span><br>
                  <span class="btn btn-outline-light rounded-pill mb-lg-3 px-lg-4 light-300">${b.group_name}</span>
               </div>
            </div>
         </a>
      </div>
      <!-- End Recent Work -->

   </c:forEach>   
   </div>
</section>




<!-- Footer -->
<jsp:include page="../include/footer.jsp"></jsp:include>


<!-- Bootstrap -->
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
<!-- Load jQuery require for isotope -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<!-- Isotope -->
<script src="${pageContext.request.contextPath}/resources/js/isotope.pkgd.js"></script>
<!-- Page Script -->
<script>
   function isUser(){
      if($('#loginid').text()==''){
         alert("로그인이 필요합니다.")
         event.preventDefault();
      }else{
         return true;
      }
   }
   $(window).load(function() {
      
      // init Isotope
      var $projects = $('.projects').isotope({
         itemSelector: '.project',
         layoutMode: 'fitRows'
      });
   
      $(".filter-btn").click(function() {
         var data_filter = $(this).attr("data-filter");
   
         $projects.isotope({
            filter: data_filter
      });

         $(".filter-btn").removeClass("active");
         $(".filter-btn").removeClass("shadow");
         $(this).addClass("active");
         $(this).addClass("shadow");
      return false;
      });
   });
</script>
<!-- Templatemo -->
<script src="${pageContext.request.contextPath}/resources/js/templatemo.js"></script>
<!-- Custom -->
<script src="${pageContext.request.contextPath}/resources/js/custom.js"></script>
</body>
</html>