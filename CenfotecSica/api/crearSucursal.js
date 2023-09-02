var express = require('express');
var router = express.Router();
var mongoose = require('mongoose');

var sucursal = require('../schemas/crearSucursal.js');

router.get('/listarSucursales', function(req, res) {
  sucursal.find().exec()
    .then(function(result){
      res.json(result);
    });
});

router.post('/insertarSucursales', function(req, res) {  
  var sucursalnueva = new sucursal({
    _id: new mongoose.Types.ObjectId(),
    nombre: req.body.nombre,
    descripcion: req.body.descripcion,
    ubicacion: req.body.ubicacion,
    fecha: req.body.fecha,
    estado: req.body.estado,
  });
  
  sucursalnueva.save()
    .then(
      function(result){
        res.json(result);
      }
    );
});

module.exports=router;
