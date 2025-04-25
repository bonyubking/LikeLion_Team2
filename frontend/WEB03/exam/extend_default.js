// 익명함수를 default export 로 선언 - 모듈 하나당 하나만 선언됨
// 1. react 컴포넌트 파일 만들 때, 해당 컴포넌트를 export default를 사용함
// 2. 유틸리티 함수 - 날짜 포매팅, 문자열 처리
// 3. 해당 모듈이 주로 사용하는 하나의 클래스를 export 하는 경우

export default function (name) { 
    return `Hello default, ${name}`;
}