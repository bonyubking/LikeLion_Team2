var name = "홍길동";
let age = 30;
const PI = 3.1415;
//document.write("이름: " + name + "<br>나이: " + age + "<br>원주율: " + PI);

console.log("이름: " + name);
console.log("나이: " + age);
console.log("원주율: " + PI);

a = 100;
b = 200;

hap = a + b;
console.log("a + b = " + hap);
console.log(typeof 123);
console.log(typeof hap);
console.log(typeof "123");
console.log(typeof 나비);
console.log(typeof true);
console.log(typeof null);
console.log(typeof function () {});
console.log(typeof undefined);

console.log(Object.prototype.toString.call(null));

const sym1 = Symbol();
const sym2 = Symbol("foo");
const sym3 = Symbol("foo");

console.log(sym1, sym2, sym3);