<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>판매자 회원정보 수정</title>
	<style>
	.wrapper{
	 	background-image: url("${pageContext.request.contextPath}/resources/image/background/signinbg.png");
	    background-size: cover; 
	    background-position: center; 
	    width: 100%;
	}
	</style>
	<link href="${pageContext.request.contextPath}/resources/css/signin.css" rel="stylesheet" />
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>	
</head>
<body>
	<div class="wrapper">
		<jsp:include page="/global/navbar.jsp"/>
		<div class="container register">
             <div class="row">
                 <div class="col-md-3 register-left">
                     <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>
                     <h3>반갑습니다!</h3>
                     <p>저희 매장 직원들은 여러분의 <br>회원가입을 적극 환영합니다!</p>
                 </div>
                 <div class="col-md-9 register-right">
                     <ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">
                          <li class="nav-item">
                             <a class="nav-link" id="profile-tab" data-toggle="tab" href="signinSeller" role="tab" aria-controls="profile" aria-selected="false">판매자</a>
                         </li> 
                     </ul>  
                     <div class="tab-content" id="myTabContent">
                         <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                             <h3 class="register-heading">회원정보 수정</h3>
                             <form action="updateSeller" class="row register-form" id="signupform" method="post" >
                                 <div class="col-md-6">
                                     <div class="form-group">
                                         <input type="text" class="form-control" name="name" placeholder="Name" value="" id="name" required/>
                                     </div>
                                     <div class="form-group">
                                         <input type="text" class="form-control" name="seller_id" placeholder="아이디를 입력하세요" value="${seller.sellerId}" id="seller_id" disabled/>
                                         <input type="text" class="form-control" name="seller_id" placeholder="아이디를 입력하세요" value="${seller.sellerId}" id="seller_id" hidden/>
                                     </div>
                                     <div class="form-group">
                                         <input type="password" class="form-control" name="password" placeholder="Password" value="" id="password" required/>
                                     </div>
                                     <div class="form-group">
                                         <input type="password" class="form-control" name="password_confirm" placeholder="Confirm Password *" value="" id="password" required/>
                                     </div>
                                     <div class="form-group">
                                         <input type="text" class="form-control" name="company_name" placeholder="회사명" value="" id="company_name"/>
                                     </div>
                                 </div>
                                 <div class="col-md-6">
                                     <div class="form-group">
                                     	<input type="text" name="postnum" placeholder="우편번호" id="sample6_postcode">
                                     	<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">                         
                                     </div>
                                     <div class="form-group">
										<input type="text" class="form-control" id="sample6_address" name="addr1" placeholder="주소">
                                     </div>
                                     <div class="form-group">
                                     	<input type="text" class="form-control" id="sample6_detailAddress" name="addr2" placeholder="상세주소">
                                     </div>
                                     <div class="form-group">
                                        <input type="text" class="form-control" placeholder="PhoneNum" value="" id="phone_number" name="phone_number"/>
                                     </div> 
                                     <div class="form-group">
                                        <input type="email" class="form-control" placeholder="Email" value="" id="email" name="email"/>
                                     </div>
                                 </div>
                                 <input type="submit" class="btnRegister" id="updateInfo" value="save"/>
                             </form>
                         </div>
                     </div>
                 </div>
             </div>
         </div>
         <br/><br/>
         <jsp:include page="/global/footer.jsp"/>
	</div>
	<script>
		const form = document.querySelector("#signupform");
		function idCheck(){		
			
			let id = document.querySelector("#id").value;
			const url = "check";
			const params = "id=" + id;
				
		    const xhr = new XMLHttpRequest();
		    xhr.onreadystatechange = () => {
		        if(xhr.readyState == xhr.DONE){
		            if(xhr.status == 200){
		                //응답 왔을 때
		                let students = JSON.parse(xhr.responseText);
		                renderHTML(result); //true(사용 가능), false(사용 불가능)
		            }
		        }
		    }
			        
		    xhr.open("post", url); //Post요청이기에 밑의 setrequestheader를 설정!
		    xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		    xhr.send(params);
		}
		
		const btn1 = document.querySelector("#btn1");
		btn1.addEventListener('click', idCheck);
		
		function renderHTML(result){
		    let output = '';
		    
		    if(result){
		    	output = result;
		    } else {
		    	output = "NO!";
		    }
		    document.querySelector("#result").innerHTML = output;
		} 
		
	    function sample6_execDaumPostcode() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                
	                let addr = ''; // 주소 변수
	
	                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    addr = data.roadAddress;
	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    addr = data.jibunAddress;
	                }  
	
	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('sample6_postcode').value = data.zonecode;
	                document.getElementById("sample6_address").value = addr;
	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById("sample6_detailAddress").focus();
	            }
	        }).open();
	    }
	    
	    const submitBtn = document.querySelector("#submitBtn");
	    submitBtn.addEventListener('click',()=>{        
            const inputId = form.querySelector("input[name='inputid']").value;
            const password = form.querySelector("input[name='password']").value;
            const confirmPassword = document.querySelector("#comfirmPassword").value;

            if(inputid === blank){
                errorMessage.textContent = "ID는 비어있으면 안됩니다.";
                // event.preventDefault();
                return false;  
            } 
            if (password === blank) {
                errorMessage.textContent = "비밀번호는 비어있으면 안됩니다.";
                console.log(password.value);
                event.preventDefault();
                return false;  
            } 
            if(confirmPassword === blank){
                errorMessage.textContent = "비밀번호확인은 비어있으면 안됩니다.";
                event.preventDefault();
                return false;  
            } 
            if (password !== confirmPassword) {
                errorMessage.textContent = "비밀번호와 비밀번호 확인이 일치하지 않습니다.";
                event.preventDefault();
                return false; 
            }    

            form.submit();
            return true;       

        });
	    
	</script>
</body>
</html>