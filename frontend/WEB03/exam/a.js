// 모듈당 하나
// 1. react 컴포넌트 만들때 해당컴포넌트를 export default를 사용함
// 2. 유틸리티 함수 모듈_날짜 포매팅, 문자열 처리
// 3. 해당모듈이 주로 사용하는 하나의 클래스를 export 하는 경우

export default function(name) { 
    return `Hellp, ${name}`
}