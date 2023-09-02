var mongoose = require('mongoose');

var estudianteSchema = mongoose.Schema({
  _id: mongoose.Schema.Types.ObjectId, //String único aleatorio
  nombre: String,
  edad: Number,
  carrera: String
});

module.exports = mongoose.model('Estudiante', estudianteSchema, 'Estudiantes'); // Define el collection que se crea en la base de datos