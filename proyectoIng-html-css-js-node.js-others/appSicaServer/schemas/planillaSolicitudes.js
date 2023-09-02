var mongoose = require('mongoose');

var planillaSolicitudesSchema = mongoose.Schema({
  _id: mongoose.Schema.Types.ObjectId, //String único aleatorio
  nombre: String,
  cedula: String,
  correo: String,
  telefono: String,
  nacimiento: String,
  sucursal: String,
  rol: String,
  ubicacion: String,
  estado: String,
  password: String,
});

module.exports = mongoose.model('planillaSolicitudes', planillaSolicitudesSchema, 'Planilla'); // Define el collection que se crea en la base de datos