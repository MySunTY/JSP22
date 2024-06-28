<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>AJAX</title>
		<style>
			subject{
				border:1px solid black;
			}
		</style>
	</head>
	<body>
		<input type="button" value="iot" onclick="start('iot')">
		<input type="button" value="web" onclick="start('web')">
		<input type="button" value="app" onclick="start('app')">
		<h3 id="showData"></h3>
		
		
		<script>
			var XHR;
			var type="";
			var showData_text;
			
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
						clear();
						parseData(type);
					}
				}
			}
			function start(sub){
				type= sub;
				
				
				createXHR();
				
				XHR.onreadystatechange= handleStateChange;
				XHR.open("get","data.xml",true);
				XHR.send(null);
				
			}
			function parseData(type){
				var data = XHR.responseXML;
				var sub = "";
				var subject= "";
				
				var subs = data.getElementsByTagName(type)[0];
				
					for(var i = 0; i<3 ; i++){
						subject = subs.getElementsByTagName("subject")[i].firstChild.nodeValue;
						console.log(subject);	
						showData_text= document.createTextNode(subject);
						document.getElementById("showData").appendChild(showData_text);
					}
					
				
				
				
			}
			function clear(){
				var header = document.getElementById("showData");
				while(header.childNodes.length>0){
					header.removeChildNodes(header.childNodes[0]);
				}
			}
			
			
		</script>
	</body>
</html>