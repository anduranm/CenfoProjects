var express = require("express"); // Incluyendo express
var path = require("path"); // Incluyendo path
var app =  express(); // Inicializando express
app.use(express.static(path.join(__dirname, 'public')));
app.use("/heroes", require("./api/heroes"));
app.listen(5000, function(){
    console.log('Servidor corriendo en puerto 5000...')
})