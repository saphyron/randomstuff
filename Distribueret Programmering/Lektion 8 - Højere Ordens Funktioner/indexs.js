
// Datastruktur
users = [
  {
    name: 'Yazeed',
    age: 25
  },
  {
    name: 'Sam',
    age: 30
  },
  {
    name: 'Bill',
    age: 20
  }
];

// Uden brug af HOF
getName = (user) => user.name;
usernames = [];

for (let i = 0; i < users.length; i++) {
  const name = users[i].name;
  usernames.push(name);
}

console.log(usernames);
// ["Yazeed", "Sam", "Bill"]


// Med brug af HOF
usernames = users.map(getName);

console.log(usernames);

// Uden brug af HOF
total = 0;

for (let i = 0; i < users.length; i++) {
  total += users[i].age;
}

console.log(total/users.length);

// Med brug af HOF
totalAge = users.reduce((total, user) => user.age + total, 0);

console.log(totalAge/users.length);

// find brugeren der starter med "b" UDEN brug af HOF
startsWithB = (string) => string.toLowerCase().startsWith('b');

namesStartingWithB = [];

for (let i = 0; i < users.length; i++) {
  if (startsWithB(users[i].name)) {
    namesStartingWithB.push(users[i]);
  }
}

console.log(namesStartingWithB);
// [{ "name": "Bill", "age": 20 }]


// og MED brug af HOF
namesStartingWithB = users.filter((user) => startsWithB(user.name));

console.log(namesStartingWithB);
// [{ "name": "Bill", "age": 20 }]

// sort
let tal = [30, 4, 10, 2, 0];

console.log(tal.sort()); // => [ 0, 10, 2, 30, 4 ]
console.log(tal); // => [ 0, 10, 2, 30, 4 ]

tal.sort((a, b) => a-b);
console.log(tal); // => [ 0, 2, 4, 10, 30 ]

tal.sort((a, b) => b-a);
console.log(tal); // => [ 30, 10, 4, 2, 0 ]

// Foreach HOF
tal = [1, 2, 3, 4, 5];

let sum = 0;
tal.forEach(element => sum += element);
console.log(sum); // => 15

tal.forEach((element) => element++);
console.log(tal); // => [ 1, 2, 3, 4, 5]

tal.forEach((element, index, array) => array[index]++);
console.log(tal); // => [ 2, 3, 4, 5, 6]

