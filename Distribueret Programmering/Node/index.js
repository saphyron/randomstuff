let http = require('http')
let figlet = require('figlet')

http.createServer(function(request, response) {
    if (request.url === '/') {

    
        response.writeHead(200)

        figlet.text('Figlet Test!', (error, data)=>{
            if(error) throw Error(error)
            response.write(data)
            response.end()
        })
    }

    if (request.url === '/about') {
        response.writeHead(200, {'Content-Type':'text/html'})
        response.write('test')
            response.end()
    }
}).listen(8080)
console.log('Lytter på port 8080')