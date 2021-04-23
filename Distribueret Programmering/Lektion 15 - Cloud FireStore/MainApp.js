//init
const express = require('express');
const app = express();
const morgan = require('morgan');
const config = require('./config');
app.set("view engine", "pug"); // Template Engine

//use
app.use(morgan('tiny'));
app.use(express.static('assets')); 
app.use(express.json()); //Data Encoding
app.use(express.urlencoded()); //Data Encoding

// Session opsætning
session = require('express-session');
app.use(session({
  secret: config.secret
}))

// Middleware

// Login check

// Routes
const loginRouter = require('./routes/login');
app.use('/login', loginRouter);






// Listener
app.listen(config.serverPort, ()=>console.log(`Server started on port ${config.serverPort}`));