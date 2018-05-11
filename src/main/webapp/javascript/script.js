/**
 * 
 */

function ajax(data) {
 var oReq = new XMLHttpRequest();
 oReq.addEventListener("load", function() {
   console.log(this.responseText);
 });    
 oReq.open("POST", "http://www.example.org/getData?data=data");//parameter를 붙여서 보낼수있음. 
 oReq.send();
}

var newtodobtn = document.querySelector(".newtodobutton");
newtodobtn.addEventListener("click",function(e){
		response.sendRedirect("/Todo/todoForm.jsp");
},false);