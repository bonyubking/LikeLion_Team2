function Hello() {
  return <h1>Hello, React!</h1>;
}

function Bye() { 
  return <h1>Hello, React 또 만나</h1>;
}

function Connect() { 
  return <h1>Hello, Connect</h1>;
}

export { Hello as MyHello, Bye as MyBye, Connect as MyConnect };
  
// 비추천
// export default function Hello() {
//   return <h1>Hello, React!</h1>;
// }

// export function Bye() { 
//   return <h1>Hello, React 또 만나</h1>;
// }

// export function connect() { 
//   return <h1>Hello, Connect</h1>;
// }