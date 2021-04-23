// typetjek.js
console.log(typeof 123 === 'number'); // => true
console.log(typeof '123' === 'number'); // => false
console.log(typeof ('123' - 0) === 'number'); // => true
console.log(typeof parseInt('123') === 'number'); // => true
console.log();
console.log(typeof parseFloat('123.5') === 'number');
console.log(typeof parseInt('123.5') === 'number');
console.log();
console.log(typeof 'abc' === 'string'); // => true
console.log(typeof true === 'boolean'); // => true

console.log(typeof null === 'null'); // => false
console.log(null === null) // => true

console.log(typeof undefined === 'undefined'); // => true
console.log(undefined === undefined) // => true
console.log(undefined === null) // => false
console.log(undefined == null) // => true
