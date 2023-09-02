var mongoose = require('mongoose');

var sucursalSchema = mongoose.Schema({
  _id: mongoose.Schema.Types.ObjectId, //String único aleatorio
  nombre: String,
  descripcion: String,
  ubicacion: String,
  fecha: String,
  estado: String
});

module.exports = mongoose.model('sucursal', sucursalSchema, 'Sucursales'); // Define el collection que se crea en la base de datos