

export default function(name){ // default export 는 파일 1개당 하나만
   return `Hello ${name}`;
}

// default export 하는 경우 (함수 이름은 외부에서 IMPORT 되지않음)
function greet(name){
   return `Hello ${name}`;
}


export const PI = 3.14;
export function add(a ,b){
      return a + b;
}


export class Person{
 constructor(tname, taddress, phone){
    this.tname =tname;
    this.taddress  = taddress;
    this.phone   = phone ;
 }

 printInfo(){  
      console.log(`${this.tname}  ${this.taddress}   ${this.phone}`);
   }

 toString(){  
      return `${this.tname}  ${this.taddress}   ${this.phone}`;
   }


}

const  p1 = new Person('111' ,'111','1111');
p1.printInfo();
console.log(p1 + " ");//문자열 연산형식으로  " "를 붙여서 출력 자동으로 재정의 toString()호출  
console.log(p1 );

const  p_list  = [ new Person('111' ,'111','1111'),new Person('222' ,'111','1111'),new Person('333' ,'111','1111') ];
p_list.forEach((p,index) =>{
      console.log(`${index +1 }  ${p.toString()} `);   
}
);
