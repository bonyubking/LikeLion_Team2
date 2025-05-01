
const mysql = require('mysql2'); //mysql 플러그인 호출 
require('dotenv').config();

const pool = mysql.createPool({
  host: process.env.DB_HOST,
  user: process.env.DB_USER,
  password: process.env.DB_PASSWORD, // 실제 비밀번호로 변경
  database: process.env.DB_NAME //
});

module.exports = pool.promise(); //DB 연결 객체를 promise 기반으로 내보냄 