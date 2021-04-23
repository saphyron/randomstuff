//opgave 4.1

let opg41 = document.querySelectorAll('p');
for (p of opg41) {
    p.style.color = 'red';
}

//opgave 4.2

let opg42 = document.querySelectorAll('h1');
for (h1 of opg42) {
    h1.nextElementSibling.nextElementSibling.style.color = 'brown';
}

//opgave 4.3

let opg43 = document.querySelectorAll('li');
let id = 1
for (let li of opg43) {
    li.className = id % 2 === 0 ? 'lige' : 'ulige';
    li.id = 'id' + id++;
    if (li.className === 'lige') {
        li.style.backgroundColor = 'lightgray';
    }
}

//opgave 4.4

let opg44 = document.querySelectorAll('h1');
for (h1 of opg44) {
    h1.nextElementSibling.outerHTML = '<h2>' + h1.nextElementSibling.innerHTML + '</h2>';
}

//opgave 4.5

document.body.previousElementSibling.outerHTML = 
'<div id="indhold"><h2>Indholdsfortegnelse:</h2> <br></div>';
let opg45 = document.querySelectorAll('h1, h2');
let hID = 1
let indhold = document.querySelector('#indhold');
for (h of opg45) {
    h.id = 'hID' + hID++;
    indhold.lastChild.outerHTML += '<a href="#hID' + hID 
    + '"> Overskrift ' + hID + '</a><br>';
}