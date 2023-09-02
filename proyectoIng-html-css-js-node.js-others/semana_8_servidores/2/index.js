var express = require("express"); // Incluyendo express
var app =  express(); // Inicializando express
var path = require("path"); // Incluyendo path
var folder = path.join(__dirname, "public"); // Incluya la carpeta public
app.use(express.static(folder)); // Use public como carpeta de contenido web
app.listen(5000); // Levanto servidor en puerto 5000