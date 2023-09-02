var mongoose = require('mongoose');

var activoSchema = mongoose.Schema({
  _id: mongoose.Schema.Types.ObjectId, //String único aleatorio
  nombre: String,
  descripcion: String,
  posicion: String,
  sucursal: String,
  estado: String,
  tipo: String,
  coment: String,
  sucursalProvisional: String,
});

module.exports = mongoose.model('activo', activoSchema, 'Activos'); // Define el collection que se crea en la base de datos