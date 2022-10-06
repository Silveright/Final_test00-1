<%@ page language="java" contentType="text/html; charset=UTF-8"%> 
    
<!-- main contents -->
<main class=container>

<!-- Sidebar -->
<div class="left-bar" style="background-color:#776bcc59;">
 
<a href="${pageContext.request.contextPath}/group/group_detail?num=${group_no}" class="nav-link">모임 메인</a>
<a href="#" class="nav-link">게시판</a>
<a href="${pageContext.request.contextPath}/calendar/view2?group_no=${group_no}" class="nav-link">일정</a>
<a href="#" class="nav-link">채팅</a>
<%-- <a href="${pageContext.request.contextPath}/group/groupuserinfo?group_no=${groupdata.group_no}" class="nav-link">회원관리</a> --%>

 
</div>


</main>    
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
        if (response == '0') { //모임장유저
            str='<a href="${pageContext.request.contextPath}/group/groupuserinfo?group_no=${group_no}" class="nav-link">회원관리</a>'
            str+='<a href="${pageContext.request.contextPath}/group/groupjoinagree?group_no=${group_no}" class="nav-link">가입신청</a>'	
            		$('.left-bar').append(str);
        }
    },
    error: function (Http, status, error) {
        console.log("Http : " + Http + ", status : " + status + ", error : " + error);
    }
});

</script>