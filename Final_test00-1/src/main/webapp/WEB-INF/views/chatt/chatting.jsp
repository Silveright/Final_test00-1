<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
@charset "UTF-8";

*{
	box-sizing: border-box;
}

#chatt{
	width: 800px;
	margin: 20px auto;
}

#chatt #talk{
	width: 800px;
	height: 400px;
	overflow: scroll;
	border : 1px solid #aaa;
}
#chatt #msg{
	width: 740px;
	height:100px;
	display: inline-block;
}

#chatt #sendZone > *{
	vertical-align: top;
	
}
#chatt #btnSend{
	width: 54px;
	height: 100px;
}

#chatt #talk div{
	width: 70%;
	display: inline-block;
	padding: 6px;
	border-radius:10px;
	
}

#chatt .me{
	background-color : #ffc;
	margin : 1px 0px 2px 30%;	
}

#chatt .other{
	background-color : #eee;
	margin : 2px;
}
</style>
</head>
<body>
<jsp:include page="/WEB-INF/views/include/header.jsp"/>
	<div id='chatt'>
	<aside>
		<input type="hidden" id="active" value="${active }">
		<jsp:include page="../group/group_left.jsp" />
	</aside>
		<h1><h1> 채팅방</h1></h1>
		<input type='text' id='mid' value='홍길동'>
		<input type='button' value='로그인' id='btnLogin'>
		<br/>
		<div id='talk'></div>
		<div id='sendZone'>
			<textarea id='msg' value='hi...' ></textarea>
			<input type='button' value='전송' id='btnSend'>
		</div>
	</div>
<script>
function getId(id){
	return document.getElementById(id);
}

var data = {};//전송 데이터(JSON)

var ws ;
var mid = getId('mid');
var btnLogin = getId('btnLogin');
var btnSend = getId('btnSend');
var talk = getId('talk');
var msg = getId('msg');

btnLogin.onclick = function(){
	ws = new WebSocket("ws://" + location.host + "/test/group/chatt?group_no=" + ${group_no});
	
	ws.onmessage = function(msg){
		var data = JSON.parse(msg.data);
		console.log("msg.data="+data)
		console.log("data.msg="+data.msg)
		var css;
		
		if(data.mid == mid.value){
			css = 'class=me';
		}else{
			css = 'class=other';
		}
		
		var item = "<div " + css + ">"+
		              "<span><b>" + data.mid+  "</b></span>" + "["+ data.date + " ]" + "<br/>"
                   +   "<span>" + data.msg + "</span></div>";
		console.log(item)			
		talk.innerHTML += item;
		talk.scrollTop=talk.scrollHeight;//스크롤바 하단으로 이동
	}
}

msg.onkeyup = function(ev){
	if(ev.keyCode == 13){
		send();
	}
}

btnSend.onclick = function(){
	send();
}

function send(){
	if(msg.value.trim() != ''){
		data.mid = getId('mid').value;
		data.msg = msg.value;
		data.date = new Date().toLocaleString();
		var temp = JSON.stringify(data);
		ws.send(temp);
	}
	msg.value ='';
	
}
</script>
</body>
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
</html>
