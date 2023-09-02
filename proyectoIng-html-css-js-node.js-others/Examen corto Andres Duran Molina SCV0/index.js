var express = require('express');
var path = require('path');
var app = express();

var mongoose = require('mongoose');

mongoose.connect('mongodb+srv://aduranm:Room111@examen.xpn4h6j.mongodb.net/restaurant?retryWrites=true&w=majority', { useNewUrlParser: true, useUnifiedTopology: true });

// Permite el uso de JSON como parámetros del POST
app.use(express.json());

var folder = path.join(__dirname, 'public');
app.use(express.static(folder));

// Agrega una ruta que maneje la página de inicio
app.get('/', function(req, res) {
  res.sendFile(path.join(__dirname, 'public', 'index.html'));
});

app.use('/recetas', require('./api/food'));

app.listen(5003, function() {
  console.log('Servidor corriendo en puerto 5003...')
});
