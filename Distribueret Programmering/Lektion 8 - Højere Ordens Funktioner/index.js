users = [
    {
        name: 'John',
        age: 30,
        phone: 30303030,
        id: 1
    },
    {
        name: 'Mikkel',
        age: 29,
        phone: 29292929,
        id: 2
    },
    {
        name: 'Andrea',
        age: 26,
        phone: 26262626,
        id: 3
    },
    {
        name: 'Joakim',
        age: 20,
        phone: 20202020,
        id: 4
    }
];
// Opgave 1
const isPhone = (user, phone) => user.phone === phone;


specificPhone = users.filter((user) => isPhone(user,20202020));
console.log(specificPhone);

let young = users.sort((a,b) => a.age-b.age)[0];
console.log(young);

//const sortNames = (a,b) => a.name.localeCompare(b.name);
//const concat = (string, user) => `${string} ${user.name},`;
//csv = users.sort(sortNames).reduce(concat,"");
csv = users.sort((a,b) => a.name.localeCompare(b.name)).reduce((string,user) => `${string} ${user.name},`,"");
console.log(csv);