// 변수 정의 및 출력 
var name = "홍길동";
let age = 30;
const PI = 3.1415;

console.log("이름:", name);
console.log("나이:", age);
console.log("원주율:", PI);

// 연산
a = 100;
b = 200;

hap = a + b;
console.log(hap);

// 객체의 타입 확인 
console.log(typeof 123);
console.log(typeof function () { });
// null 값 평가 시 수치 맥락에선 0, boolean 맥락에선 false로 동작함
console.log(typeof null);

// 어떤 객체인지, 어떤 생성자로 생성되었는지 확인 
console.log([] instanceof Array);
console.log([] instanceof Object);

//정확한 타입 확인
console.log(Object.prototype.toString.call(null));
console.log(Object.prototype.toString.call([]));
console.log(Object.prototype.toString.call(new Date()));

