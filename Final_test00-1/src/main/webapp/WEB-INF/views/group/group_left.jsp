<%@ page language="java" contentType="text/html; charset=UTF-8"%> 
    
<!-- main contents -->
<style>
body {
  font-family: "Lato", sans-serif;
}

.sidenav {
  width: 150px;
  z-index: 1;
  top: 200px;
  left: 10px;
  background: rgb(119, 107, 204);
  overflow-x: hidden;
  padding: 8px 0;
  text-align:center
}

.sidenav a {
  padding: 6px 8px 6px 16px;
  text-decoration: none;
  font-size: 25px;
  color:white;
  display: block;
}

.sidenav a:hover {
  color: #064579;
}

.main {
  margin-left: 140px; /* Same width as the sidebar + left position in px */
  font-size: 28px; /* Increased text to enable scrolling */
  padding: 0px 10px;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}
</style>
<!-- Sidebar -->
<div class="sidenav">
 
<a href="${pageContext.request.contextPath}/group/group_detail?num=${group_no}" class="nav-link">모임 메인</a>
<a href="${pageContext.request.contextPath}/group/groupboardlist?group_no=${group_no}" class="nav-link">게시판</a>
<a href="${pageContext.request.contextPath}/calendar/view2?group_no=${group_no}" class="nav-link">일정</a>
<a href="${pageContext.request.contextPath}/group/chatt?group_no=${group_no}" class="nav-link">채팅</a>
<%-- <a href="${pageContext.request.contextPath}/group/groupuserinfo?group_no=${groupdata.group_no}" class="nav-link">회원관리</a> --%>

 
</div>


<script>

$.ajax({
    url: "../group/main",
    data: {
        userid: $("#loginid").text(),
        group_no: '${group_no}'
    },
    type: "get",
    success: function (response) {
        authority = response;
        var loginid = $('#loginid').text();
        console.log(response);
        console.log($("#loginid").text())
        if (response.role == '0') { //모임장유저
            str='<a href="${pageContext.request.contextPath}/group/groupuserinfo?group_no=${group_no}" class="nav-link">회원관리</a>'
            str+='<a href="${pageContext.request.contextPath}/group/groupjoinagree?group_no=${group_no}" class="nav-link">가입신청</a>'	
            		$('.sidenav').append(str);
        }
    },
    error: function (Http, status, error) {
        console.log("Http : " + Http + ", status : " + status + ", error : " + error);
    }
});

</script>