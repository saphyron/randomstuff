// typeof.js
console.log(typeof 123); // => number
console.log(typeof "abc"); // => string
console.log(typeof true); // => boolean
console.log(typeof null); // => object
console.log(typeof undefined); // => undefined
console.log(typeof {}); // => object
console.log(typeof function(){}); // => function
console.log(typeof []); // => object

let x = null;
console.log(x === null); // => true
console.log(Array.isArray([])); // => true
