var express = require('express');
var path = require('path');
var app = express();

var mongoose = require('mongoose');

mongoose.connect('mongodb+srv://aduranm:Room111@compilationone.gupgn6e.mongodb.net/Universidad?retryWrites=true&w=majority', { useNewUrlParser: true, useUnifiedTopology: true });

// Permite el uso de JSON como parámetros del POST
app.use(express.json());

app.use(express.static(path.join(__dirname, 'public')));

app.use('/estudiante', require('./api/estudiante'));

app.listen(5000, function() {
  console.log('Servidor corriendo en puerto 5000...')
});