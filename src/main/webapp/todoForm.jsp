<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/Todo/css/style.css">
<title>Insert title here</title>
</head>
<body class="registerpage">

    <header >
            <div><h1>할일 등록</h></div>
    </header>

    <section >
        <article >
            <form method="POST" action="/Todo/todoadd" >
            <p>어떤 일인가요?</p>
            <input type="text" id="title" name="title" maxlength="24" placeholder="swift 공부하기(24글자)" required> 

            <p>누가 할일 인가요?</p>
            <input type="text" id="name" name="name"maxlength="10" placeholder="홍길동" required> 
            
            <p>우선순위를 선택하세요</p>
            <input type="radio" name="sequence" value="1"> 1순위
            <input type="radio" name="sequence" value="2"> 2순위
            <input type="radio" name="sequence" value="3"> 3순위

            <br><br>

           
            <input class="next" type="button" name="pre" value="< 이전">
            <input class="button" type="submit" value="제출">
            <input class="button" type="reset" value="다시작성">

            </form>

            
            
        </article>
    </section>
        

    
</body>
</html>