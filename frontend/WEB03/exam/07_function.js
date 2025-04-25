// Hosting : 코드가 실행되기 전에 변수 선언과 함수선언을 스코프 최상단으로 끌어올리는 
console.log(x);
var x = 5;
console.log(x);

prn();
function prn(){ 
    console.log("=====prn=====");
}

// 함수 표현식은 호스팅이 되지 않음 
// 아래와 같이 작성할 경우 오류 발생함 
// sayHello();
// var sayHello = function () {
//     console.log("====sayHello====");
// };

// 함수 표현식은 호이스팅이 안됨
sayHello();
var sayHello = function() {
    console.log("===sayHello===")
};