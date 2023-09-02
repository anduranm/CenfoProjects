var express = require('express');
var router = express.Router();
var mongoose = require('mongoose');

var activo = require('../schemas/activo.js');

router.put('/activoeditar/:id', function (req, res) {
    const id = req.params.id;
    const nuevoNombre = req.body.nombre;
    const nuevaDescripcion = req.body.descripcion;
    const nuevaPosicion = req.body.posicion;
    const nuevoComentario = req.body.coment;

    activo.findByIdAndUpdate(id, { nombre: nuevoNombre, descripcion: nuevaDescripcion, posicion: nuevaPosicion, coment: nuevoComentario }, { new: true })
      .exec()
      .then(function (result) {
        res.json(result);
      })
      .catch(function (error) {
        console.error(error);
        res.status(500).send('Error interno del servidor');
      });
  });
  
  
  module.exports = router;