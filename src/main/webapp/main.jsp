<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/Todo/css/style.css">

</head>


<body>


 

 <header>
        <div class="header">내가 해야 할일</div>
        <button class="newtodobutton" type="button"><b>새로운 TODO 등록</b></button>

    </header>

    <section>
        <article>
            <table>
                <tr>
                    <th>TODO</th>
                    <th>DOING</th>
                    <th>DONE</th>
                </tr>

                <tr>
                    <td>
                        <p>
                            <b>내용 1</b>
                        </p>
                        <span>내용 1</span>
                        <button type="button" class="arrowbutton">→</button>

                    </td>
                    <td>
                        <p>
                            <b>내용 1</b>
                        </p>
                        <span>내용 1</span>
                        <button type="button" class="arrowbutton">→</button>

                    </td>
                    <td>
                        <p>
                            <b>내용 1</b>
                        </p>
                        <span>내용 1</span>
                        <button type="button" class="arrowbutton">→</button>

                    </td>
                </tr>

                <tr>
                    <td>
                        <p>
                            <b>내용 1</b>
                        </p>
                        <span>내용 1</span>
                        <button type="button" class="arrowbutton">→</button>

                    </td>
                    <td>
                        <p>
                            <b>내용 1</b>
                        </p>
                        <span>내용 1</span>
                        <button type="button" class="arrowbutton">→</button>

                    </td>
                    <td>
                        <p>
                            <b>내용 1</b>
                        </p>
                        <span>내용 1</span>
                        <button type="button" class="arrowbutton">→</button>

                    </td>
                </tr>
            </table>
        </article>
    </section>
    
<script>

var newtodobtn = document.querySelector(".newtodobutton");
function move(){}
newtodobtn.addEventListener("click",function(e){
	location.href="/Todo/todoForm.jsp";
},false);

</script>


</body>
</html>