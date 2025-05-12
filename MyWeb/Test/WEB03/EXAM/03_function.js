var x = 10;

function createFunction() {
    const x = 20;
    function f() {
        return x;
    }
    return f;
}

