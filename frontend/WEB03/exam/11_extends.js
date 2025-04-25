import test, { Person, PI as p_PI, add } from './10_class.js';

console.log(p_PI);
console.log(add(1, 2));

class Employee extends Person { 
    constructor(tname, taddress, phone, position) { 
        super(tname, taddress, phone);
        this.position = position;
    }

    printJob() { 
        console.log(`${this.name}의 직책은 ${this.position}입니다.`);
    }

    toString() { 
        return super.toString() + `/ 직책: ${this.position}`;
    }
}

const emp = new Employee("홍길동", "서울시 강남구", "010-1234-5678", "매니저");

emp.printInfo();
emp.printJob();

console.log(emp.toString());