import React from "react";
import MyAddress from './MyAddress';
import Hello from './react01_Hello';

function App() {
  return (
    <div>
      <h1>App 입니다</h1>
      <Hello name="홍길동" nic_name="hong" />
      <MyAddress name="홍길동" addr="서울" phone="02-000" />
    </div>
  );
}

export default App;
