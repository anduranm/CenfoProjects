var express = require('express');
var router = express.Router();
var mongoose = require('mongoose');

var Estudiante = require('../schemas/food');

router.get('/listar', function (req, res) {
  Estudiante.find().exec()
    .then(function (result) {
      res.json(result);
    });
});

router.post('/insertar', function (req, res) {
  var estudiante_nuevo = new Estudiante({
    _id: new mongoose.Types.ObjectId(),
    name: req.body.name,
    ingre1: req.body.ingre1,
    ingre2: req.body.ingre2,
    ingre3: req.body.ingre3,
    ingre4: req.body.ingre4,
    ingre5: req.body.ingre5,
    ingre6: req.body.ingre6,
    ingre7: req.body.ingre7,
    ingre8: req.body.ingre8,
    precio: req.body.precio,
  });

  estudiante_nuevo.save()
    .then(
      function (result) {
        res.json(result);
      }
    );
});

module.exports = router;