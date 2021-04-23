const config = require('../config');

// init firebase
const admin = require("firebase-admin");
admin.initializeApp({
    credential: admin.credential.cert(config.firestoreServiceAccount)
});
const db = admin.firestore(); //DB ref

exports.createUser = function(username, passwd) {
    // lav eventuelt et check om brugeren findes i forvejen
    return db.collection('users').doc().set({
        username: username,
        password: passwd,
        datecreated: (new Date().toISOString().slice(0,10))
    })
}

exports.authenticateUser = function(username, passwd) {
    db.collection('users')
    .where('username', '==', username)
    .where('password', '==', passwd)
    .get()
    .then((snapshot) => {
       if (snapshot.empty) {
           // db fandt ingen username/password
           // så redirect til object
           return
       } else {
           snapshot.forEach(document => {
               const user = document.data();
               user.id = document.id;
               return user;
           })
       }
    })
    .catch((err) => {
        return
    })
}