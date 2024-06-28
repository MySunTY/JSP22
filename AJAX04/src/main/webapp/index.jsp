<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

	<head>

		<meta charset="UTF-8">

		<title>유효성 검증 예시</title>

	</head>

	<body>

		<h1>다음의 내용을 검증합니다</h1>

		생일을 입력해 주세요

		<input type="text" size="10" id="birthDate" onchange="validate()">

		<div id="msg"></div>

		<script>

			//Jquery 충돌문제가 있으니 Jquery ajax보다 일반 자바스크립트 방식을 공부하는게 좋

			var XHR;

			function createXMLHttpRequest(){

				if(window.ActiveXObject){

					XHR= new ActiveXObject('Microsoft.XMLHTTP');

				}else if(window.XMLHttpRequest){

					XHR=new XMLHttpRequest();

				}

				

			}

			

			function validate(){

				

				createXMLHttpRequest(); // XMLHttpRequest 객체제작,XML하고 통신가능 , Json,servlet

				var date= document.getElementById("birthDate");

				var url = "VServlet?birthDate="+date.value;

				XHR.onreadystatechange = handleStateChange; // ()가 들어가면 실행 리턴값을 저장

				XHR.open("GET",url,true); //XMLHttpRequest(method,url,Async)

				XHR.send(null);

				

				

				//프론트엔트 리엑트, 백엔드 node.js

			}

			function handleStateChange(){

				if(XHR.readyState==4){ //통신이 완료되었고

					if(XHR.status=200){ //목적지가 확보되었을때

						var msg =XHR.responseXML.getElementsByTagName("message")[0].firstChild.data;

						var passed = XHR.responseXML.getElementsByTagName("passed")[0].firstChild.data;

						console.log(passed);

						console.log(msg);

						setMessage(passed,msg);

					}

				}

			}

			function setMessage(p,m){

				var area = document.getElementById("msg");

				var fontColor = "red";

				if(p=="true"){

					fontColor="green";

				}

				area.innerHTML ="<span style='color:"+fontColor+";'>"+m+"</span>";

				//innerText이 경우 태그를 그리지 않고 그냥문자로 표기

			}

		</script>

	</body>

</html>