var mongoose = require('mongoose');

var planillaSchema = mongoose.Schema({
  _id: mongoose.Schema.Types.ObjectId, //String único aleatorio
  nombre: String,
  cedula: String,
  correo: String,
  telefono: String,
  nacimiento: String,
  sucursal: String,
  rol: String,
  estado: String,
  password: String,
});

module.exports = mongoose.model('planilla', planillaSchema, 'Planilla'); // Define el collection que se crea en la base de datos