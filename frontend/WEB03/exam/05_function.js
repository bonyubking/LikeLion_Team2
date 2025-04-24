
var x = 10;

function createFunction1() {
  const x = 20;
  return new Function("return x;"); // this x refers to global x
}

function createFunction2() {
  const x = 20;
  function f() {
    return x; // this x refers to the local x above
  }
  return f;
}

const f1 = createFunction1();
console.log(f1()); // 10
const f2 = createFunction2();
console.log(f2()); // 20

console.log("=========람다식으로 변경===============");

const test03 = (a, b) => {
  if (a === undefined && b === undefined) return 100;
  if (b === undefined) return a;
  return a + b;
};

console.log(test03());
console.log(test03(100));
console.log(test03(100, 200));


console.log("=========한줄로 변경===============");
const test04 = (a, b) =>   a === undefined  ?  100 :  b === undefined  ? a :   a + b; 

console.log(test04());
console.log(test04(100));
console.log(test04(100, 200));

// const  func = (parmas) => expression

// 함수 선언 시 블록스코프, typedef 확인 
// globalThis : 현재 실행 환경에서의 전역 객체 
// "foo" in globalThis -> foo가 전역변수로 등록되었는지 유무 확인 
console.log(
    'foo' name ${
      "foo" in globalThis ? "is" : "is not"
    } global. typeof foo is ${typeof foo},
  );
  if (true) {
    function foo() {
      return 1;
    }
  }

function myfun() { 
    console.log("myfun" in globalThis);
}