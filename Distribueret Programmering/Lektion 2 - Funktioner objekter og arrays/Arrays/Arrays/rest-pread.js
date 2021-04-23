// rest-spread.js
function sum(a, b, ...rest) {
    let sum = a + b;
    for (let e of rest)
        sum += e;
    return sum;
}

console.log(sum(1)); // => NaN
console.log(sum(1, 2)); // => 3
console.log(sum(1, 2, 3, 4)); // => 10

let spread = [1, 2, 3];
console.log(spread); // => [ 1, 2, 3 ]
console.log([0, ...spread, 4]); // => [ 0, 1, 2, 3, 4 ]
