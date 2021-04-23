// Opgave 1.2
let list = ['John', 'Joakim', 'Erik', 'Allan', 'Andreas'];
function sortering(l1) {
for (let i = l1.length - 1; i >= 0; i--) {
    for (let j = 0; j <= i - 1; j++) {
        if (l1[j] > l1[j + 1]) {
            let temp = l1[j];
            l1[j] = l1[j+1];
            l1[j+1] = temp;
        }
    }
}
}
sortering(list);
console.log(list.toString()); 
// Opgave 1.3
function binsearch(test, key) {
    let found = false;
    let left = 0;
    let right = test.length - 1;
    let middle = -1;
    let kunde = null;
    while (!found && left <= right) {
        middle = Math.trunc((left + right) / 2);
        kunde = test[middle];
        if(kunde === key) {
            found = true;
        } else if(key < kunde) {
            right = middle - 1;
        } else {
            left = middle +1;
        }
    }
    if (found) {
        return middle;
    }
    else {
        return -1;
    }
}
let navn = 'Allan';
console.log( `${navn} can be found on index`,binsearch(list, navn));

//Opgave 1.4

function fletning(s1, s2) {
    let templist = [];
    let i1 = 0;
    let i2 = 0;

    while (i1 < s1.length && i2 < s2.length) {
        if(s1[i1] <= s2[i2]) {
            templist.push(s1[i1]);
            i1++;
        } else {
            templist.push(s2[i2]);
            i2++;
        }
    }

    while (i1 < s1.length) {
        templist.push(s1[i1]);
        i1++;
    }
    while (i2 < s2.length) {
        templist.push(s2[i2]);
        i2++;
    }
    return templist;
}

let list2 = ['Lisbeth', 'Stine', 'Sasha', 'Trixie', 'Diana'];

sortering(list2);
console.log(fletning(list, list2));

//Opgave 1.5
let max = 1000;

function primes(m1) {
    if (m1 < 2) {
        max = 2;
    }
    let counter = 0;
    let counter2 = 0;
    while (counter < max) {
        while (counter2 < max) {
            if (counter % counter2 === 0) {
                
            } else {
                console.log(counter);
            }
            counter2++;
        }
        counter++;
    }
}

primes(100);