const admin = require("firebase-admin");
const serviceAccount = require("./ServiceAccountKey.json");
const express = require('express');
const app = express();
app.set("view engine", "pug")


// init firebase
admin.initializeApp({
    credential: admin.credential.cert(serviceAccount),
    databaseURL: "https://lektion-15-firebase.firebaseio.com"
});

//db ref
const db = admin.firestore();
app.use(express.static('assets'))

// Dette er post data encoding
app.use(express.json())
app.use(express.urlencoded())

// Session opsætning
session = require('express-session');
app.use(session({
  secret: 'ADCC58BA-6703-4795-B94D-6C562784DAEB'
}))


app.post('/auth', (req, res)=> {
  const username = req.body.username
  const password = req.body.password
  if (username && password) {
    req.session.isLoggedIn = true
    req.session.username = username
    res.redirect('/')
    res.end()
  } else {
    res.send('Lacking login information...')
    res.end()
  }

})

app.get('/', (req, res)=>{
  if (req.session.isLoggedIn) {
    res.send(`Velkommen ${req.session.username}`)
  } else {
    res.redirect('/login')
  }
  res.end()
})

app.get('/login', (req, res) => {
    res.render('login');
    res.end();
})


//actions

app.get('/test/insert', (req, res) => {
    db.collection('users').doc().set({
        name : 'Magnus',
        birthyear : 1966
    }).then(() => {
        res.send('Du har nu indsat data i databasen.');
        res.end();
    })
});

app.get('/test/insert2', (req, res) => {
    db.collection('users').doc().set({
        name : 'Kaj',
        birthyear : 1966
    }).then(() => {
        res.send('Du har nu indsat data i databasen.');
        res.end();
    })
});

app.get('/test/read', (req, res) => {
    db.collection('users').doc().get().then(snapshot => {
        console.log(`Data: ${JSON.stringify(snapshot.data())}`);
        res.send(`Har hentet data fra ${snapshot.data().name}`);
        res.end();
    })
});

//Find specifict
app.get('/test/query/specific/:id', (req, res) => {
    const id = req.params.id;
    let query = db.collection('users').where('name', '==', id).orderBy('name', 'asc');
    query.get().then(snapshot => {
        let users = [];
        snapshot.forEach(doc => {
            console.log(`Fandt doc: ${JSON.stringify(doc.data())}`);
            let user = doc.data();
            user.id = doc.id;
            users.push(user);
        })
        res.render('liste', {users: users});
    })
});

//Find alle
app.get('/test/query/all', (req, res) => {
    let query = db.collection('users').orderBy('name', 'asc');
    db.collection('users').get().then(snapshot => {
        let users = [];
        snapshot.forEach(doc => {
            console.log(`Fandt doc: ${JSON.stringify(doc.data())} med id: ${doc.id}`);
            let user = doc.data();
            user.id = doc.id;
            users.push(user);
        })
        res.render('liste', {users: users});
    })
});

app.get('/test/delete/:id', (req, res) => {
    const id = req.params.id;
    db.collection('users').doc(id).delete().then(doc => {
        res.send('Har nu slettet');
        res.end();
    })
})

app.listen(8080, ()=>console.log('Server started on port 8080'));