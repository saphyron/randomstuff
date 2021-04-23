const express = require('express')
const app = express()
const morgan = require('morgan')


/**
 * HTML VERB
 * GET
 * POST
 * PUT
 * DELETE
 * PATCH
 */

function log (request, response, next) {
    console.log(request.method + ': ' + request.url)
    next()
}

app.use(log)
app.use(express.json())
app.use(express.static('filer'))
app.use(morgan('tiny'))
app.use(express.urlencoded())

app.get('/', (request, response)=>{
    //response.send('Hello from root')
    response.sendStatus(200)
})

app.post('/modtaget',  (request, response) =>{
    response.send(`Hejsa. Jeg kan se du hedder: ${request.body.username} og kodeord er ${request.body.password}`)
})

app.get('/about', (request, response)=>{
    response.send('Hello from TestLiveDemon')
})

app.get('/post', (req, res)=>{
    res.send([{"name":"John","age":"30"}])
})

app.get('/post/:name', (request, response)=>{
    response.send(`Hello from ${request.params.name}`)
})

app.listen(8081, ()=> console.info('Server started on port 8081'))