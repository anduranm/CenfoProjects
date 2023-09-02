var express = require('express');
var path = require('path');
var app = express();

var mongoose = require('mongoose');

mongoose.connect('mongodb+srv://Aduran:cenfotec@cluster0.kupi6io.mongodb.net/Sica?retryWrites=true&w=majority', { useNewUrlParser: true, useUnifiedTopology: true });

// Permite el uso de JSON como parámetros del POST
app.use(express.json());

var folder = path.join(__dirname, 'public');
app.use(express.static(folder));

app.get('/', function(req, res) {
  res.sendFile(path.join(__dirname, 'public', 'html', 'landingpage.html'));
});

app.use('/activoeditar', require ('./api/activoseditar.js'))
app.use('/registrologin',require('./api/registros.js'));
app.use('/nuevasucursal', require('./api/crearSucursal.js'))
app.use('/sucursal', require('./api/sucursal.js'));
app.use('/activo', require('./api/activo.js'));
app.use('/login',require('./api/login.js'));
app.use('/planilla',require('./api/planilla.js'));
app.use('/sucursalEditar', require('./api/sucursalEditar.js'))
app.use('/planillaEditar', require('./api/planillaEditar.js'))
app.use('/planillaSolicitudes',require('./api/planillaSolicitudes.js'));




app.listen(5000, function() {
  console.log('Servidor corriendo en puerto 5000...')
});