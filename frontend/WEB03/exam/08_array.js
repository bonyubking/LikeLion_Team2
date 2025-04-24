// Array.forEach(callbackFn)
// Arra.forEach(callbackFn, thisArg)
// ${ } -> 변수, 표현식을 삽입할 때 사용하는 템플릿 리터럴
// ex) 문자열 중앙에 ${값 또는 표현식} 이름:${name}, ${a+b}, ${fn()}

const a = 10;
const b = 20;
console.log('hap=${a+b}');
console.log(`hap=${a + b}`);

// case 1 : 단순 출력 
const fruits = ["사과", "바나나", "포도"];
fruits.forEach(fruit => {
    console.log(fruit);
});

// case 2 : 인덱스 출력 callbackfn: (value: string, index:number, array: string[])
fruits.forEach((fruit, index) => {
    console.log(`인덱스 ${index} : ${fruit}`);
});

// case 3 : 인덱스 출력 callbackfn: (value: string, index: number, array: string[])
fruits.forEach((fruit, index, array) => { 
    console.log(`인덱스 ${index}: ${fruit} 전체 배열: ${array}`);
});

// case 4 : 배열의 속성으로 출력 

