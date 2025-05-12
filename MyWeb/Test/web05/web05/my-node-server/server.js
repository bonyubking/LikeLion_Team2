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

app.post('/api/text', (req, res) => {
    const { text } = req.body;
    console.log('Received text:', text);
    res.json({msg : `서버가 받은 텍스트 : ${text}`});
  });

  app.post('/api/user', (req, res) => {
    const { username, email, addr } = req.body;
    console.log(`Received text:, ${username} ${email} ${addr}`);
    res.json({status : 'success', user: req.body});
  });


  app.post('/api/time', (req, res) => {
    const now = new Date();
    res.json({ serverTIme: now.toISOString() });
  }
  );

  //React09_FORMSUBMIT
  app.post('/api/name', (req, res) => {
    const { name } = req.body;
    console.log('Received name:', name);
    res.json({msg : `서버가 받은 이름 : ${name}`});
  });

app.listen(port, () => {
  console.log(`Node.js 서버가 http://localhost:${port} 에서 실행 중입니다.`);
});

function errorhandle(err, req, res, next){
    console.error(err.stack);
    res.status(500).send('Something broke!');
  }

app.get('/', function() {
    throw new Error('BROKEN'); // Express will catch this on its own.
});

app.use(errorhandle);



