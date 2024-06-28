<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>ajax</title>
		<style>
			
		</style>
	</head>
	<body>
		<h3>ajax연습</h3>
		<input type="button" value="데이터확인" onclick=makeT()>
		<div id="showData">
			
		</div>
		<script>
			var XHR;
			function createXHR(){
				if(window.ActiveXObject){
					XHR = new ActiveXObject('Microsoft.XMLHTTP');
				}else if(window.XMLHttpRequest){
					XHR = new XMLHttpRequest();
				}
			}
			
			function handleStateChange(){
				if(XHR.readyState==4){
					if(XHR.status==200){
						parseData();
					}
				}
			}
			function makeT(){
				createXHR();
				XHR.onreadystatechange = handleStateChange;
				XHR.open("GET","test.xml",true);
				XHR.send(null);
			}
			function parseData(){
				var data = XHR.responseXML;
				var mem = null;
				var name = "";
				var subject = "";
				var time = "";
				var student = data.getElementsByTagName("mem");
				
				for(var i = 0 ; i<student.length; i++){
					mem = student[i];
					name = mem.getElementsByTagName("name")[0].firstChild.nodeValue;
					subject = mem.getElementsByTagName("subject")[0].firstChild.nodeValue;
					time = mem.getElementsByTagName("time")[0].firstChild.nodeValue;
					
					console.log(time);
				}
			}
		
		
		
		</script>
	</body>
</html>