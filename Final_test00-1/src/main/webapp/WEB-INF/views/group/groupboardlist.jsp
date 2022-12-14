<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
a{text-decoration:none; color:black}
</style>
<!-- <script src="js/jquery-3.6.0.js"></script> -->
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js" integrity="sha384-ODmDIVzN+pFdexxHEHFBQH3/9/vQ9uori45z4JjnFsRydbmQbmL5t1tQ0culUzyK" crossorigin="anonymous"></script>
<script srca="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.js"></script>

</head>
<style>
.subjectname{text-decoration: none;
			 color:inherit}
.subjectname:hover{color:black};

input{border:1px solid black}
b{font-size:0.9em}
a{text-decoration:none !important}
.btn-secondary {
    --bs-btn-color: #fff;
    --bs-btn-bg: #776bcc;
    --bs-btn-border-color: #776bcc;
    --bs-btn-hover-color: #fff;
    --bs-btn-hover-bg: #5646c9;
    --bs-btn-hover-border-color: #776bcc;
    --bs-btn-focus-shadow-rgb: 49,132,253;
    --bs-btn-active-color: #fff;
    --bs-btn-active-bg: #776bcc;
    --bs-btn-active-border-color: #776bcc;
    --bs-btn-active-shadow: inset 0 3px 5pxrgba(0, 0, 0, 0.125);
    --bs-btn-disabled-color: #fff;
    --bs-btn-disabled-bg: #776bcc;
    --bs-btn-disabled-border-color: ##776bcc;}
    .page-link {
    position: relative;
    display: block;
    padding: var(--bs-pagination-padding-y) var(--bs-pagination-padding-x);
    font-size: var(--bs-pagination-font-size);
    color: #776bcc;
    text-decoration: none;
    background-color: var(--bs-pagination-bg);
    border: var(--bs-pagination-border-width) solid var(--bs-pagination-border-color);
    transition: color .15s ease-in-out,background-color .15s ease-in-out,border-color .15s ease-in-out,box-shadow .15s ease-in-out;
}
.pagination {
    --bs-pagination-padding-x: 0.75rem;
    --bs-pagination-padding-y: 0.375rem;
    --bs-pagination-font-size: 1rem;
    --bs-pagination-color: var(--bs-link-color);
    --bs-pagination-bg: #fff;
    --bs-pagination-border-width: 1px;
    --bs-pagination-border-color: #dee2e6;
    --bs-pagination-border-radius: 0.375rem;
    --bs-pagination-hover-color: var(--bs-link-hover-color);
    --bs-pagination-hover-bg: #e9ecef;
    --bs-pagination-hover-border-color: #dee2e6;
    --bs-pagination-focus-color: var(--bs-link-hover-color);
    --bs-pagination-focus-bg: #e9ecef;
    --bs-pagination-focus-box-shadow: 0 0 0 0.25remrgba(13, 110, 253, 0.25);
    --bs-pagination-active-color: #fff;
    --bs-pagination-active-bg: #776bcc;
    --bs-pagination-active-border-color: #776bcc;
    --bs-pagination-disabled-color: #6c757d;
    --bs-pagination-disabled-bg: #fff;
    --bs-pagination-disabled-border-color: #dee2e6;
    display: flex;
    padding-left: 0;
    list-style: none;
}
.cat{float:right;}
.table-active{
	background-color :#6266ea8a!important; 
    color: white !important;
}

</style>
<title>?????? ???????????????</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/include/header.jsp"/>
<br>

   <div class="container" style="height:700px;">
   
      <div class="row align-items-center justify-content-center">
      <div class="col-sm-2 text-center">
            <aside>
               <input type="hidden" id="active" value="${active }">
               <jsp:include page="group_left.jsp" />
            </aside>
         </div>
          
         <div class="col-sm-9 ">
         <!-- 
         <form action="memberinfocat" method="post" class="cat">            
            
            <input type="button" class="btn btn-secondary" value="?????? ??????"
                  onclick="location.href='groupuserinfo'">
                  
            <input type="button" class="btn btn-secondary" value="?????? ??????"
                  onclick="location.href='groupjoinagree'">      
            
            <input type="button" class="btn btn-secondary" value="?????? ??????"
                  onclick="location.href='groupDisband'">
         </form>
         -->
         
         
            <%-- ???????????? ?????? ?????? --%>
	<c:if test="${listcount > 0 }">
		
		<form action="groupboardlistsearch" method="get">
               <div class="input-group center-block">
               <input type="hidden" name="group_no" value="${param.group_no}"
										id="group_no">
                  <select id="viewcount" name="search_field">
                     <option value='0' selected>??????</option>
                     <option value='1'>?????????</option>
                  </select>
                  <input id="search" name="search_word" type="text"  placeholder="????????? ???????????????" value="${search_word }">
                  <button class="btn btn-sm btn-outline-secondary search" type="submit"><i class="bx bx-search bx-sm"></i></button>
               	  
               </div>
         </form>
 		
            <table class="table table-bordered text-center">
               <colgroup>
                  <col width="10%"/>
                  <col width="40%"/>
                  <col width="20%"/>
                  <col width="15%"/>
                  <col width="15%"/>
               </colgroup>
                 
               <thead>  
               <tr>
					<th colspan="3">???????????????</th>
					<th colspan="2"> 
						<font size="3">??? ?????? : ${listcount}</font>
					</th>
			   </tr>
               <tr class="table-active">
                  	<th>??????</th>
                  	<th>??????</th>
                    <th>?????????</th>
                    <th>??????</th>
                    <th>?????????</th>
               </tr>
               </thead>
               <tbody>
				<c:set var="num" value="${listcount - (page - 1) * limit}"/>
				<c:forEach var="b" items="${groupboardlist}">
					<tr>
						<td><%-- ?????? --%>
							<c:out value="${num}"/><%-- num ?????? --%>
							<c:set var="num" value="${num - 1}"/><%-- num = num - 1; ?????? --%>
						</td>
						<td><%-- ?????? --%>
							<div>									 
								 <a href="groupboarddetail?num=${b.BOARD_NUM}&group_no=${group_no}" class="subjectname">
								 	
								 	<c:if test="${b.BOARD_SUBJECT.length()>=20}">
							 			<c:out value="${b.BOARD_SUBJECT.substring(0,20)}..."/>
							 		</c:if>
							 		<c:if test="${b.BOARD_SUBJECT.length()<20}">
							 			<c:out value="${b.BOARD_SUBJECT}"/>
							 		</c:if>
							 		<span class="gray small">[<c:out value="${b.CNT}"/>]</span>
								 </a>
							</div>
						</td>
						<td><div>${b.BOARD_NAME}</div></td>
						<td><div>${b.BOARD_DATE}</div></td>
						<td><div>${b.BOARD_READCOUNT}</div></td>
		
					</tr>
				</c:forEach>
			</tbody>
               
               <%-- <tbody>
                  <c:set var="num" value="${listcount-(page-1)*limit }"/>
                  <c:forEach var="m" items="${memberlist }">
                  <tr>
                     <td>
                        <c:out value="${m.rnum }"/>
                     </td>
                        <td><a href="info?id=${m.userid }">${m.userid }</a></td>
                     <td>${m.gender }</td>
                     <td>${m.joindate}</td>
                     <td><input type="checkbox" name="selectAgreement" value="${m.userid }"></td>
                  </tr>
                  </c:forEach>
               </tbody> --%>
            </table>         
            
            <div class="center-block">
       <ul class="pagination justify-content-center">
          <c:if test="${page <=1 }"> <!-- ?????? ???????????? 1?????? -->
             <li class="page-item">
                <a class="page-link gray">??????&nbsp; </a>
             </li>
          </c:if>
          <c:if test="${page > 1 }"> <!-- ?????? ???????????? 1?????? ?????? ????????? ????????? ???????????????-1 ???????????? ?????? -->
             <li class="page-item">
                <a href="groupboardlist?page=${page-1}&group_no=${group_no}" 
                class="page-link">??????&nbsp; </a>
             </li>
          </c:if>
          
          <c:forEach var="a" begin="${startpage }" end="${endpage }">
             <c:if test="${a==page}"> 
                <li class="page-item active">
                   <a class="page-link">${a } </a>
                </li>
             </c:if>
             <c:if test="${a!=page}"> 
                <li class="page-item">
                   <a href="groupboardlist?page=${a}&group_no=${group_no}" 
                   class="page-link">${a } </a>
                </li>
             </c:if>
          </c:forEach>
          
             <c:if test="${page >=maxpage}"> 
                <li class="page-item">
                   <a class="page-link gray">&nbsp;?????? </a>
                </li>
             </c:if>
             <c:if test="${page <maxpage}"> 
                <li class="page-item">
                   <a href ="groupboardlist?page=${page+1}&group_no=${group_no}" 
                   class="page-link">&nbsp;?????? </a>
                </li>
             </c:if>
       </ul>
    </div>
    <button type="button" class="btn btn-secondary" 
    		style="float:right; color: #212529; 
    		background-color: #e5e3f8; 
			border-color: #4232c2;" 
    		onclick="location.href='groupboardwrite?group_no=${group_no}'">?????????</button>
    </c:if>
    <%-- ???????????? ?????? ?????? --%>
	<c:if test="${listcount == 0}">
	<section class="py-5"><br><br>
		<font size=5>????????? ?????? ????????????.</font><br><br>
		<button type="button" class="btn btn-secondary float-right" 
				style="color: #212529; 
    			background-color: #e5e3f8; 
				border-color: #4232c2;" 
				onclick="location.href='groupboardwrite?group_no=${group_no}'">?????????</button>
	</section>
	</c:if>
         </div>
      </div>
      <!-- <section class="py-5">
       <font size=5>????????? ???????????? ????????????.</font><br><br>
       <a href="main.net"><button type="button" class="btn btn-secondary float-left back">????????????</button></a>
       </section> -->
   </div>
   <script>
$(document).ready(function() { 
   loadRequest(1);

var group_no="${group_no}"
    console.log(group_no)
   function go(page){
      var limit = $('#viewcount').val();
      var data = "limit="+ limit + "&state=ajax&page=" + page;
      ajax(data);
   } 
});

   
   
</script>
<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>