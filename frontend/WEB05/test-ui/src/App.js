import React from 'react';
// import MyAddress from './MyAddress';
import { MyHello, MyBye, MyConnect } from './React_Basic/react01_Hello';
import Welcome, { MyCalc } from './React_Basic/react02_Props';

function App() {
  return react02();
}

function react02() {
  return (
    <>
      <Welcome name="홍길동" />
      <MyCalc num1={10} num2={5} />
    </>
  );
}

//jsx 호출할 때 import 시 컴포넌트 명의 첫글자는 대문자로 설정 필요
function react01() {
  return (
    <>
      <MyHello />
      <MyBye />
      <MyConnect />
    </>
  );
}

export default App;