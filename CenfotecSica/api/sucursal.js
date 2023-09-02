var express = require('express');
var router = express.Router();
var mongoose = require('mongoose');

var sucursal = require('../schemas/sucursal.js');

router.get('/listarSucursales', function(req, res) {
  sucursal.find().exec()
    .then(function(result){
      res.json(result);
    });
});

router.post('/insertarSucursal', function(req, res) {  
  var sucursal_nuevo = new sucursal({
    _id: new mongoose.Types.ObjectId(),
    nombre: req.body.nombre,
    descripcion: req.body.descripcion,
    ubicacion: req.body.ubicacion,
    fecha: req.body.fecha,
    estado: req.body.estado
  });

  sucursal_nuevo.save()
    .then(
      function(result){
        res.json(result);
      }
    );
});


router.put('/modificarEstado/:id', function(req, res) {
  const id = req.params.id;
  const nuevoEstado = req.body.estado;

  sucursal.findByIdAndUpdate(id, { estado: nuevoEstado }, { new: true })
    .exec()
    .then(function(result) {
      res.json(result);
    })
    .catch(function(error) {
      console.error(error);
      res.status(500).send('Error interno del servidor');
    });
});




module.exports = router;