const test =(...args) => {
    switch(args.length){
        case 0: return 100;
        case 1: return args[0];
        case 2: return args[0] + args[1];
        default: return NaN;
    }
}

console.log(test());
console.log(test(10));
console.log(test(10,20));
console.log(test(1,2,3));


// 함수 선언시 블록스코프 typeof 확인
// globalThis : 현재 실행 환경에서의 전역 객체
// "foo" in globalThis : foo가 전역 변수로 등록 되었는지 유무 확인
{
    foo();
    function foo(){
        console.log("foo");
    }
}

console.log(
    `foo name ${
      "foo" in globalThis ? "is" : "is not"
    } global. typeof foo is ${typeof foo}`
  );
  if (true) {
    function foo() {
      return 1;
    }
  }
