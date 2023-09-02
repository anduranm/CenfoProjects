var mongoose = require("mongoose");

var estudianteSchema = mongoose.Schema({
  _id: mongoose.Schema.Types.ObjectId,
  nombre: String,
  carrera: String,
  edad: Number
});

module.exports = mongoose.model("Estudiante", estudianteSchema, "Estudiantes");