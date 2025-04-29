import { useState } from 'react';

function Welcome(props) {
  return <h2>Welcome, {props.name}!</h2>;
}
function App() {
  return <Welcome name="홍길동 " />;
}

// Calc 컴포넌트 만들어 4칙연산 구현
function Calc(props) {}

// 버튼을 클릭하면 사칙연산 구현
function MyCalc(props) {
  const { num1, num2 } = props;

  // 계산 결과를 보여주는 상태
  const [showResult, setShowResult] = useState(false);

  // 버튼 클릭했을 때 계산 결과를 보여주는 이벤트
  const handleCalc = () => {
    setShowResult(true);
  };

  return (
    <div>
      <h2>사칙연산</h2>
      <button onClick={handleCalc}>계산하기</button>
      {showResult && (
        <>
          <p>
            {num1}+{num2}={num1 + num2}
          </p>
          <p>
            {num1}-{num2}={num1 - num2}
          </p>
          <p>
            {num1}*{num2}={num1 * num2}
          </p>
          <p>
            {num1}/{num2}={num2 !== 0 ? num1 / num2 : '0으로 나눌 수 없음'}
          </p>
        </>
      )}
    </div>
  );
}

export default Welcome;
export { MyCalc };
