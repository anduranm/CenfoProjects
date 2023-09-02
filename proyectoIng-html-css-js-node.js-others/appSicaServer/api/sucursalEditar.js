var express = require('express');
var router = express.Router();
var mongoose = require('mongoose');

var sucursal = require('../schemas/sucursal.js');

router.put('/sucursalEditar/:id', function (req, res) {
    const id = req.params.id;
    const nuevoNombre = req.body.nombre;
    const nuevaDescripcion = req.body.descripcion;
    const nuevaUbicacion = req.body.ubicacion;
    const nuevaFecha= req.body.fecha;


    sucursal.findByIdAndUpdate(id, { nombre: nuevoNombre, descripcion: nuevaDescripcion, ubicacion: nuevaUbicacion, fecha: nuevaFecha }, { new: true })
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