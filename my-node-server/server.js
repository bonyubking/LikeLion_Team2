const express = require('express');
const cors = require('cors');
const bodyParser = require('body-parser');

const app = express();
const port = 7777; // 원하는 포트 번호

app.use(cors());
app.use(bodyParser.json());

// 간단한 데이터 (나중에 데이터베이스 연동 등을 할 수 있습니다.)
const data = { message: 'Hello from Node.js server!' };

// GET 요청 처리 (예시)
app.get('/api/data', (req, res) => {
  res.json(data);
});

// POST 요청 처리 (예시)
app.post('/api/data', (req, res) => {
  console.log('Received data:', req.body);
  res.json({ received: req.body });
});

// POST 요청 처리 (예시2_ 텍스트 전송)
app.post('/api/text', (req, res) => {
  const { text } = req.body;
  console.log('Received data:', text);
  res.json({ received: req.body });
});

// POST 요청 처리 (예시2_ 유저 정보)
app.post('/api/user', (req, res) => {
  const { username, email, addr } = req.body;
  console.log('Received data:', username, email, addr);
  res.json({ status: 'success', user: req.body });
});

// 템플릿 엔진 설정 app.set()

// Error
function errorHandle(err, req, res, next) {
  //log
  if (!next) console.error(err.stack);

  res.status(500);
  res.send('Internal Server Error');
}

app.get('/', function () {
  throw new Error('something broke');
});

// POST 요청 처리(예시4_클라이언트에서 이름을 받아 전송)
app.post('/api/name', (req, res) => {
  const { name } = req.body.name;
  res.json({ received: `${name}` });
});

//등록 -> 에러 핸들러는 반드시 라우터 정의 후 가장 마지막에 app.use()로 등록해야
app.use(errorHandle);

// 3. 서버시작
app.listen(port, () => {
  console.log(`Node.js 서버가 http://localhost:${port} 에서 실행 중입니다.`);
});
