<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>원페이지 레이아웃</title>
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<style>
			#wrap{
				width:100%;
				height:100%;
				position:absolute;
				top:0;
				left:0;
				
				overflow:hidden;
			}
			.pan{
				position:relative;
				height:100%;
				top:0px;
			}
			
			
			.pan >div{
				width:100%;
				height:100%;
				
			}
			.A{
				background-color:red;
			}
			.B{
				background-color:orange;
			}
			.C{
				background-color:yellow;
			}
			.D{
				background-color:green;
			}
		</style>
	</head>
	<body>
		<div id="wrap">
			<div class="pan">
				<div class="A"></div>
				<div class="B"></div>
				<div class="C"></div>
				<div class="D"></div>
			</div>
		</div>
		<script>
			window.addEventListener("wheel",function(e){
				e.preventDefault(); // 화면의 스크롤기능 제거
			},{passive:false}); 	// 브라우저의 패시브 기능 제거
			var wrap = document.getElementById("wrap");
			var posY=0;  			// 현재 보여주고 있는 페이지의 위치
			wrap.addEventListener("wheel",function(e){
				if($(".pan").is(":animated")){
					return;
				}
				console.log(e.deltaY);
				move(e);
			});
			
			function move(e){
				if(e.deltaY>0){
					posY-= 100;
				}else if(e.deltaY<0){
					posY+= 100;
				}
				if(posY>0){
					posY=0;
				}
				if(posY<-300){
					posY=-300;
				}
				$(".pan").animate({"top":posY+"%"},1000);
			}
		</script>
	</body>
</html>