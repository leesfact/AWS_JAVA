

window.onload = () => {

}


let a = function() {
    console.log("a 함수 호출");
}

// 이런 방법도 가능
// function a() {
//     console.log("a 함수 호출");
// }

a();

console.log(typeof a);


let b = function(f){
    console.log("테스트가 프린트 되기 전에 무조건 실행");
    f();
}

b(a); //a function() 을 넣음 


//  callback function
b(function(){console.log("test")});


// 즉시 실행함수
(function(){console.log("즉시 실행함수")}());


let d = (f) => {
    console.log("화살표 함수 실행");
    f();
}