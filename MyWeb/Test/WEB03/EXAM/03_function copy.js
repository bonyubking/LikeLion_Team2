function test(){
    return 100;
}

function test(a){
    return a;
}

function test(a, b){
    return a + b;
}

console.log(test());

console.log(test(10));

console.log(test(10, 20));

console.log("====================");

const test03 = (a, b) => {
    if (a == undefined && b == undefined) return 100;
        if (b == undefined) return a;
        return a+b;
    
}


console.log(test03());
console.log(test03(10));
console.log(test03(10, 20));

console.log("====================");

const test04 = (a, b) => 

    a == undefined ? 100:
    b == undefined ? a: 
    a + b;
    



console.log(test04());
console.log(test04(10));
console.log(test04(10, 20));