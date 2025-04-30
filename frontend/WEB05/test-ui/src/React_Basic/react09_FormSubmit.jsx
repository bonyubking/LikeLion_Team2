import { useState } from 'react';
export default function FormSubmit() {
  const [name, setName] = useState('');
  const handleSubmit = (e) => {
    e.preventDefault();
    alert('제출된 이름: ' + name);
  };
  return (
    <form onSubmit={handleSubmit}>
      <input value={name} onChange={(e) => setName(e.target.value)} />
      <button type="submit">제출</button>
    </form>
  );
}

export function SeverFormSubmit() {
  const [name, setName] = useState('');
  const [responseMsg, setResponseMsg] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const res = await fetch('http://localhost:7777/api/name', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
          name: { name },
        }),
      });
      const data = await res.json();
      setResponseMsg(data.received);
    } catch (err) {
      setResponseMsg('요청 실패');
    }
  };

  return (
    <>
      {' '}
      <form onSubmit={handleSubmit}>
        <input value={name} onChange={(e) => setName(e.target.value)} />
        <button type="submit">제출</button>
      </form>
      <p>{responseMsg}</p>
    </>
  );
}
