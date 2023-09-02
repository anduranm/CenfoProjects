var mongoose = require('mongoose');

var sucursalnueva = mongoose.Schema({
  _id: mongoose.Schema.Types.ObjectId, //String único aleatorio
  nombre: String,
  descripcion: String,
  ubicacion: String,
  fecha: String,
  estado: String
});

module.exports = mongoose.model('sucursalnueva', sucursalnueva, 'Sucursales');