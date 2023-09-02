var mongoose = require('mongoose');

var usuarios = mongoose.Schema({
  _id: mongoose.Schema.Types.ObjectId, //String único aleatorio
  nombre: String,
  cedula: String,
  correo: String,
  telefono: String,
  nacimiento: Date,
  sucursal: String,
  rol: String,
  estado: String,
  password: String
});

module.exports = mongoose.model('registro', usuarios, 'Planilla'); // 