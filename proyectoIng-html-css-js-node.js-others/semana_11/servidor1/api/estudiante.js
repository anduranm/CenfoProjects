var express = require('express');
var router = express.Router();
var mongoose = require('mongoose');

var Estudiante = require('../schemas/estudiante');

router.get('/listar', function(req, res) {
  Estudiante.find().exec()
    .then(function(result){
      res.json(result);
    });
});

router.post('/insertar', function(req, res) {  
  var estudiante_nuevo = new Estudiante({
    _id: new mongoose.Types.ObjectId(),
    nombre: req.body.nombre,
    edad: req.body.edad,
    carrera: req.body.carrera
  });

  estudiante_nuevo.save()
    .then(
      function(result){
        res.json(result);
      }
    );
});

module.exports = router;