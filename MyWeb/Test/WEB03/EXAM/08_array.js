const a = 10;
const b = 20;
console.log('hap = ${a+b}');
console.log(`hap = ${a+b}`); // ES6에서 추가된 템플릿 리터럴


const fruits = ['사과', '바나나', '체리'];
    fruits.forEach(fruit =>{
        console.log(fruit);
    });


    fruits.forEach((fruit, index) => {
        console.log(`인덱스 ${index} : ${fruit}`);
    });


    fruits.forEach((fruit, index, array) => {
        console.log(`인덱스 ${index} : ${fruit}`);
        console.log(array);
    });