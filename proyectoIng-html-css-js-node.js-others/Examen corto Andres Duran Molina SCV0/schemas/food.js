var mongoose = require('mongoose');

var recetaSchema = mongoose.Schema({
  _id: mongoose.Schema.Types.ObjectId, //String único aleatorio
  name: String,
  ingre1: String,
  ingre2: String,
  ingre3: String,
  ingre4: String,
  ingre5: String,
  ingre6: String,
  ingre7: String,
  ingre8: String,
  precio: String,
});

module.exports = mongoose.model('food', recetaSchema, 'platillos'); // Define el collection que se crea en la base de datos