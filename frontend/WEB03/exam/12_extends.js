// case 1 : 내장 클래스 상속 (Extending Built-in Classes)
console.log(' 내장 클래스 상속 ');
class MyArray extends Array {
  shuffle() {
    // 배열 섞는 로직
    for (let i = this.length - 1; i > 0; i--) {
      const j = Math.floor(Math.random() * (i + 1));
      [this[i], this[j]] = [this[j], this[i]];
    }
    return this;
  }
}

const myArray = new MyArray(1, 2, 3, 4, 5);
myArray.shuffle();
console.log(myArray);

//case2 : 상속  믹스인 (Mixins) -> 여러 객체의 속성과 메서드를 다른 객체에 복사하여 기능을 혼합하는 패턴
console.log(' Mixins ');
const canWalk = {
  walk: function () {
    console.log(`${this.name}이 걷는다.`);
  },
};

const canSwim = {
  swim: function () {
    console.log(`${this.name}이 수영한다.`);
  },
};

class Person {
  constructor(name) {
    this.name = name;
  }
}

// 믹스인 함수
// Object.assign() -> 속성복사하는 메소드 : 객체의 속성이 기본 타입일 경우 속성값을 복사해 참조시킴
function mixin(target, ...sources) {
  Object.assign(target.prototype, ...sources);
}

mixin(Person, canWalk, canSwim);

const person = new Person('홍길동');
person.walk();
person.swim();

console.log('==================================');

const ob1 = { a: 1 };
const ob2 = { b: 1 };
const ob3 = { c: 1 };

const mergeObj = Object.assign({}, ob1, ob2, ob3);
console.log(
  'case 1 : {}가 빈 상태일 경우 원본 객체 속성을 복사해 새로운 객체 생성',
  mergeObj,
);

const target = { a: 1, b: 2, c: 3 };
const sources = { d: 4, e: 5 };

const updateObj = Object.assign(target.sources);
console.log('case 2: 객체 속성을 덮어쓰기 확인');

console.log('Object assign() 클래스 ');

//case 3: 컴포지션 (Composition) -> 클래스가 다른 객체를 포함하고, 그 객체의 기능을 활용하는 방식
// has~a
console.log(' Composition ');
class Walker {
  walk(name) {
    console.log(`${name}이 걷는다.`);
  }
}

class Swimmer {
  swim(name) {
    console.log(`${name}이 수영한다.`);
  }
}

class Athlete {
  constructor(name) {
    this.name = name;
    this.walker = new Walker();
    this.swimmer = new Swimmer();
  }

  walk() {
    this.walker.walk(this.name);
  }

  swim() {
    this.swimmer.swim(this.name);
  }
}

const athlete = new Athlete('멍멍이');
athlete.walk();
athlete.swim();
