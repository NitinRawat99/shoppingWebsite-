

console.log("this is script file")

const toggleSidebar=()=>{
console.log("hello")

if($(".sidebar").is(":visible")){

$(".sidebar").css("display","none");
$(".content").css("margin-left","0%");

}
else
{

$(".sidebar").css("display","block");
$(".content").css("margin-left","20%");


}



}

const signupButton = document.getElementById("signup");
signupButton.addEventListener('click',function(){
    window.location.href="/register";
})