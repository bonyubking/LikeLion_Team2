import {Person} from './10_class.js';

class Employee extends Person{
    constructor(tname, taddress, phone, salary){
        super(tname, taddress, phone); // 부모 클래스의 생성자 호출
        this.salary = salary;
    }

    printJob(){
        console.log(`${this.tname}  ${this.taddress}의 연봉은 ${this.salary}`);
    }
    

    toString(){  
        return (`${this.tname} 의 연봉은 ${this.salary}`); 
    }
}

const emp = new Employee("홍길동", "서울", "010-1234-5678", 5000);

emp.printInfo(); // 부모 클래스의 메서드 호출
emp.printJob(); // 자식 클래스의 메서드 호출

console.log(emp.toString()); // toString() 메서드 호출