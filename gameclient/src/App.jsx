import React, { useState, useEffect, useRef } from 'react';

const PUBLIC_IP = process.env.REACT_APP_PUBLIC_IP
const PUBLIC_PORT = process.env.REACT_APP_PORT
const App = () => {
  const [messages, setMessages] = useState([]);
  const [input, setInput] = useState('');
  const ws = useRef(null);

  useEffect(() => {
    ws.current = new WebSocket(`ws://${PUBLIC_IP}:${PUBLIC_PORT}/GameProject/chat`); // EC2 IP로 바꾸기

    ws.current.onmessage = (event) => {
      setMessages(prev => [...prev, event.data]);
    };

    ws.current.onopen = () => {
      console.log(ws.current.readyState);
   
    };

    ws.current.onclose = () => {
      console.log('WebSocket 연결 종료');
    };

    return () => {
      console.log(ws.current);
      ws.current.close();
    };
  }, []);

  const sendMessage = () => {
    if (ws.current && input) {
      ws.current.send(input);
      setInput('');
    }
  };

  return (
    <div style={{ padding: 20 }}>
      <h2>실시간 채팅</h2>
      <div style={{ border: '1px solid #ccc', height: 200, overflowY: 'scroll', padding: 10 }}>
        {messages.map((msg, i) => <div key={i}>{msg}</div>)}
      </div>
      <input
        value={input}
        onChange={e => setInput(e.target.value)}
        onKeyDown={e => e.key === 'Enter' && sendMessage()}
      />
      <button onClick={sendMessage}>전송</button>
    </div>
  );
};

export default App;