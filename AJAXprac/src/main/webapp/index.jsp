<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>dynamic xml parse</title>
		<style>
			th, td{
				border : 1px solid black;
			}
		</style>
	</head>
	<body>
		<h1>원하는 가격대를 선택해주세요</h1>
		<select>
			<option value="500000">500000</option>
			<option value="1500000">1500000</option>
			<option value="2500000">2500000</option>
		</select>
		에서
			<select>
			<option value="1000000">1000000</option>
			<option value="2000000">2000000</option>
			<option value="3000000">3000000</option>
		</select>
		까지
		<input type="button" value="조회" onclick="search()">
		<div id="header">
		
		</div>
		<p id="tableBody"></p>
		
		<script>
			var XHR;
			function createXMLHttpRequest(){
				if(window.ActiveXObject){
					XHR = new ActiveXObject('Microsoft.XMLHTTP');
				}else if(window.XMLHttpRequest){
					XHR = new XMLHttpRequest();
				}
				
				
			}
			
			function search(){
				createXMLHttpRequest();
				XHR.onreadystatechange = handleStateChange;
				XHR.open("get","sample.xml",true);
				XHR.send(null);
			}
			function handleStateChange(){
				if(XHR.readyState==4){
					if(XHR.status==200){
						clear();
						parseResult();
					}
				}
			}
			
			function parseResult(){
				var result = XHR.responseXML;
				var product = null ; 
				var name ="";
				var price = "";
				var comments="";
				
				var products = result.getElementsByTagName("product");
					for(var i = 0 ; i<products.length; i++ ){
						product = products[i];
						name = product.getElementsByTagName("name")[0].firstChild.nodeValue;
						price = product.getElementsByTagName("price")[0].firstChild.nodeValue;
						comments = product.getElementsByTagName("comments")[0].firstChild.nodeValue;
						
						addTable(name,price,comments);
					}
				
				var header = document.createElement("h2");
				var headerText = document.createTextNode("검색 결과 : ");
				header.appendChild(headerText);
				document.getElementById("header").appendChild(header);
					
			}
			
			function addTable(name,price,comments){
				var min = document.getElementsByTagName("select")[0].value; // 최소값
				var max = document.getElementsByTagName("select")[1].value; // 최대값
				var int_price = parseInt(price);
				
				if(min<=int_price && int_price<=max){
					var first_tr = document.createElement("tr");
					var th = document.createElement("th");
					var th_textnode = document.createTextNode("품목");
					th.appendChild(th_textnode);
					first_tr.appendChild(th);
					th = document.createElement("th");
					th_textnode= document.createTextNode("가격");
					th.appendChild(th_textnode);
					first_tr.appendChild(th);
					th = document.createElement("th");
					th_textnode= document.createTextNode("특징");
					th.appendChild(th_textnode);
					first_tr.appendChild(th);
					var tr = document.createElement("tr");
					var td = makeTd(name);
					tr.appendChild(td);
					td= makeTd(price);
					tr.appendChild(td);
					td = makeTd(comments);
					tr.appendChild(td);
					document.getElementById("tableBody").appendChild(first_tr);
					document.getElementById("tableBody").appendChild(tr);
					
					
				}//if
			}//addTable
			function makeTd(text){
				var td= document.createElement("td");
				var textNode = document.createTextNode(text);
				td.appendChild(textNode);
				return td;
			}
			function clear(){
				var header = document.getElementById("header");
				if(header.hasChildNodes()){
					header.removeChild(header.childNodes[0]);
				}
				var tableBody = document.getElementById("tableBody");
				while(tableBody.childNodes.length>0){
					tableBody.removeChild(tableBody.childNodes[0]);
				}
			}
		
		</script>
	</body>
</html>