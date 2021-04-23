const personer = [
    {name: 'Test1', age: 10},
    {name: 'Test2', age: 11},
    {name: 'Test3', age: 12},
    {name: 'Test4', age: 13},
    {name: 'Test5', age: 14},
    {name: 'Test6', age: 15},
    {name: 'Test7', age: 16},
    {name: 'Test8', age: 17},
    {name: 'Test9', age: 18}
];

let fillTable = document.querySelector('table');
let id = 1;
for (brugere of personer) {
    let navne = brugere.name;
    let alder = brugere.age;
    fillTable.innerHTML += '<tr ' + 'id=' + id +'><td>' + navne + ' </td><td>' + alder + ' </td></tr>';
    id++;
}

let fillAlder = document.querySelector('alder');
let totalAlder = Number();
let totalPersoner = Number();
for (brugere of personer) {
    totalAlder += brugere.age;
    totalPersoner++;
}
fillAlder.innerHTML = '<br><br>Gennemsnit er: ' + totalAlder/totalPersoner;

let elements = document.getElementsByTagName('tbody');
for(let i = 0; i < elements.length; i++) {
    (elements)[i].addEventListener('click', function() {
        recalculateAlder(this.textContent.split(' '))
        //console.log(this.textContent.split(' '));
        this.remove(this.innerHTML);
        
    })
}

function recalculateAlder(slettet){
    let fillAlder = document.querySelector('alder');
    let totalAlder = Number();
    let totalPersoner = Number();
    for (brugere of personer) {
        totalAlder += brugere.age;
        totalPersoner++;
    }
    totalAlder = totalAlder - slettet[1];
    totalPersoner--;
    fillAlder.innerHTML = '<br><br>Gennemsnit er: ' + totalAlder/totalPersoner;
}


//Redegør for DOM

/**
 * DOM er Document Object Model. 
 * DOM kan bruges til at inkorporere Scripts ind i HTML, så tingene opdateres live på hjemmesiden.
 * DOM gør arbejdet meget dynamisk.
 * DOM kan bruges til at ændre alle værdier af HTML
 * DOM kan bruges til at komme til eller se alle værdier af HTML
 * I andre ord DOM er en standard for CRUD i HTML
 * 
 */