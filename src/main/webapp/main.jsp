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
        <form method="POST" action="/Todo/todoform">
        <input type="submit" class="newtodobutton" value="새로운 TODO 등록">
        </form>
        
    </header>


    <section>
        <article>
            <table id="viewlist-todo">
            </table>
            
            <table id="viewlist-doing">
            </table>
            
            <table id="viewlist-done">
            </table>
        </article>
    </section>
    
<script>
window.onload = function(){
	ajax("http://localhost:8080/Todo/main","GET", "");
};

//< 리스트 갱신
function ajax(url,method,data) {
	 var xhr = new XMLHttpRequest();
	 xhr.addEventListener("load", function(e) {
		 if(this.readyState == 4 && this.status == 200){
			  	var resObj = JSON.parse(this.responseText);
			    var strTodo = "";
			    var strDoing = "";
			    var strDone = "";
			    var totalstr = "";
			  	var viewtodo = document.querySelector("#viewlist-todo");
			  	var viewdoing = document.querySelector("#viewlist-doing");
			  	var viewdone = document.querySelector("#viewlist-done");
		
			 
			  	
			  	for(var i=0; i<resObj.length; i++){
			  				
		
			  		if( resObj[i].todoType == "TODO" ){
			  			strTodo +="<tr> <td>";
			  			strTodo +="<p> <b>" + resObj[i].todoTitle + "</b> </p>";
			  			strTodo +="<span class='subtitle'> 등록날짜:" + resObj[i].todoRegdate + ", "
				  		       + resObj[i].todoName + ", " 
				  		       + "우선순위:" + resObj[i].todoSequence + "</span>";
				  		     strTodo += "<button data-view='" + resObj[i].todoId + "'";
				  		   strTodo += "data-type='" + resObj[i].todoType + "'";
				  		 strTodo += "type='button' class='arrowbutton'>→</button>" 
				  			strTodo += "</td> </tr>";
						
			  		}
					 else if(resObj[i].todoType == "DOING"){
						 strDoing += "<tr> <td>";
						 strDoing +="<p> <b>" + resObj[i].todoTitle + "</b> </p>";
						 strDoing +="<span class='subtitle'> 등록날짜:" + resObj[i].todoRegdate + ", "
					  		       + resObj[i].todoName + ", " 
					 		       + "우선순위:" + resObj[i].todoSequence + "</span>";
					 	strDoing += "<button data-view='" + resObj[i].todoId + "'";
					 		 strDoing += "data-type='" + resObj[i].todoType + "'";
					 	 strDoing += "type='button' class='arrowbutton'>→</button>"  
					 	strDoing +="</td> </tr>";		
					 }
					 else if( resObj[i].todoType == "DONE"){
						 strDone += "<tr> <td>";
						 strDone +="<p> <b>" + resObj[i].todoTitle + "</b> </p>";
						 strDone +="<span class='subtitle'> 등록날짜:" + resObj[i].todoRegdate + ", "
					  		       + resObj[i].todoName + ", " 
					  		       + "우선순위:" + resObj[i].todoSequence + "</span>";
					  		     strDone +="</td> </tr>";
						}
			  		
			  	}
			  	viewtodo.innerHTML = "<tr><th>TODO</th></tr>" + strTodo;
			  	viewdoing.innerHTML = "<tr><th>DOING</th></tr>" + strDoing;
			  	viewdone.innerHTML = "<tr><th>DONE</th></tr>" + strDone;

		 }
			
		 var arrowbtnlist = document.getElementsByClassName("arrowbutton");
	
		 for(var index=0; index<arrowbtnlist.length; index++)
			 {
				arrowbtnlist[index].addEventListener("click",function(e){
				var data = "id=" + this.getAttribute('data-view') + "&";
				data += "type=" + this.getAttribute('data-type');
				ajax("http://localhost:8080/Todo/todotype","POST", data);
				},false);
			 } 
		

	 });

	 xhr.open(method, url);
	 
	 if( method == "POST")
	 xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	 
	 xhr.send(data);
	}


</script>


</body>
</html>