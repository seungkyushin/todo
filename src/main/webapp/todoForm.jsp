<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>Insert title here</title>
</head>
<body class="registerpage">

    <header >
            <div><h1>할일 등록</h1></div>
    </header>

    <section >
        <article >
            <form method="POST" action="./todoadd" >
            <p>어떤 일인가요?</p>
            <input type="text" id="title" name="title" maxlength="24" placeholder="swift 공부하기(24글자)" required> 

            <p>누가 할일 인가요?</p>
            
            <input type="text" id="name" name="name" maxlength="24" placeholder="홍길동" readonly value="${cookie.email.value}"> 
            
            
            <p>우선순위를 선택하세요</p>
            <input type="radio" name="sequence" value="1" required> 1순위
            <input type="radio" name="sequence" value="2" required> 2순위
            <input type="radio" name="sequence" value="3" required> 3순위

            <br><br>

           
            <a href="./main.jsp"><input class="next" type="button" name="pre" value="< 이전"></a>
            <input class="button" type="submit" value="제출">
            <input class="button" type="reset" value="다시작성">

            </form>

            
            
        </article>
    </section>
        

    
</body>

<script>
</script>
</html>