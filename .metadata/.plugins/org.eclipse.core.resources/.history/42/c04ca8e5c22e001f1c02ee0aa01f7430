<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Dynamic XML parse</title>
		<!-- 쇼핑몰에서 가격대 번위 설정해서 검색해보는 거 만들어보기 -->
	</head>
	<body>
	<h1>원하시는 가격대를 선택해 주세요</h1>
	
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
	<div id="header"></div>
	
	
		<script>
			var XHR;
			function createXMLHttpRequest(){
				if(window.ActiveXObject){
					XHR=new ActiveXObject("microsoft.XMLHTTP");
				}else if(window.XMLHttpRequest){
					XHR=new XMLHttpRequest();  
				}
			}
			 
			
			function search(){
				createXMLHttpRequest();
				XHR.onreadystatechange=handleStateChange;
				XHR.open("GET","sample.xml",true);
				XHR.send(null)
				
				
			}
			function handleStateChange(){
				if(XHR.readyState==4){
					if(XHR.status==200){
						//console.log(XHR.responseXML);
						parseResult();
					}
				}
			}
			function parseResult(){ //XHR.responseXML을 통해 들어온 XML을 DOM으로 쪼개어 원하는 결과만 추출
				var result = XHR.responseXML;
				var product = null; // product는 object / object를 초기값 null로 잡아서 아래 데이터들(name등등)과 한눈에 구분
				var name="";
				var price = "";
				var comments="";
				
				var products= result.getElementsByTagName("product");
				for(var i = 0 ; i<products.length; i++){
					product = products[i];
					name = product.getElementsByTagName("name")[0].firstChild.nodeValue;
					price = product.getElementsByTagName("price")[0].firstChild.nodeValue;
					comments = product.getElementsByTagName("comments")[0].firstChild.nodeValue;
					addTable(name,price,comments);
					
				}
				//태그를 제작해서 화면에 출력하는 방법
				var header = document.createElement("h2");
				var headerText= document.createTextNode("검색 결과 : ");
				header.appendChild(headerText);
				document.getElementById("header").appendChild(header);
				
				
			}
			//검색 기준점을 받아 해당하는 내용을 테이블로 그리는 함수
			
			function addTable(name,price,comments){
				var min = document.getElementsByTagName("select")[0].value; //검색 최소값
				var max = document.getElementsByTagName("select")[1].value; //검색 최대값
				var int_price = parseInt(price);
				//console.log("검색 최소값 : "+min);
				//console.log("검색 최대값 : "+max);
				//console.log(name+"가격 "+price);
				//console.log("검색 여부 " +(min<=int_price && int_price<=max));
				if(min<=int_price && int_price<=max){
					console.log("검색 결과물 : "+name);
					
				}
				
			}
		</script>
		
	
	</body>
</html>