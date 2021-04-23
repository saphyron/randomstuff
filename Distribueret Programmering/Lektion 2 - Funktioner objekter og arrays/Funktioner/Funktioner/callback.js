// callback.js
function afvent(v) {
    function callback(){console.log(v);}
    setTimeout(callback, 1000);
    console.log('afvent ...');
}
afvent(1); // => afvent ...
afvent(2); // => afvent ...
// => 1
// => 2
