const MOUNTAINS = [
    {name: "Kilimanjaro", height: 5895, place: "Tanzania"},
    {name: "Everest", height: 8848, place: "Nepal"},
    {name: "Mount Fuji", height: 3776, place: "Japan"},
    {name: "Vaalserberg", height: 323, place: "Netherlands"},
    {name: "Denali", height: 6168, place: "United States"},
    {name: "Popocatepetl", height: 5465, place: "Mexico"},
    {name: "Mont Blanc", height: 4808, place: "Italy/France"}
];
document.body.outerHTML = '<table></table>';
let opg46 = document.querySelector('table');
for(mountain in MOUNTAINS) {
    let navne = mountain.name;
    let hojde = mountain.height;
    let location = mountain.place;
    opg46.innerHTML += '<tr><td>' + navne + ' </td><td>' 
    + hojde + ' </td><td>' 
    + location + '</td></tr>';
}
