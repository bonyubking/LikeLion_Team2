import { useState } from "react";

export default function Counter() {
  const [count, setCount] = useState(0);
  return (
    <div>
      <p>현재 값: {count}</p>
      <button onClick={() => setCount(count + 1)}>증가</button>
      <button onClick={() => setCount(count - 1)}>감소</button>
      <button onClick={() => setCount(0)}>초기화</button>
    </div>
  );
}

// 색깔을 지정한 다음 랜덤으로 버튼의 배경색 변경
export function Counter02() {
  const [count, setCount] = useState(0);
  const [color, setColor] = useState("lightgray");


  const colors = ['blue', 'lightred', 'lightpink'];

  const handleIn = () => {
    setCount(count + 1);
    changeColor();
  };

  const handleDe = () => {
    setCount(count - 1);
    changeColor();
  };

  const handleInit = () => {
    setCount(0);
    changeColor();
  };

  const changeColor = () => { 
    const colorIndex = Math.floor(Math.random() * colors.length);
    setColor(colors[colorIndex]);
  };

  return (
    <div>
      <p>현재 값: {count}</p>
      <button onClick={handleIn} style={{ backgroundColor: color }}>증가</button>
      <button onClick={handleDe} style={{ backgroundColor: color }}>감소</button>
      <button onClick={handleInit} style={{ backgroundColor: color }}>초기화</button>
    </div>
  ) ;
}