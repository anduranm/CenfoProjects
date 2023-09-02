var express = require('express');
var router = express.Router();
var mongoose = require('mongoose');

var activo = require('../schemas/activo.js');

router.get('/listarActivos', function (req, res) {
  activo.find().exec()
    .then(function (result) {
      res.json(result);
    });
});

router.post('/insertarActivo', function (req, res) {
  var activo_nuevo = new activo({
    _id: new mongoose.Types.ObjectId(),
    nombre: req.body.nombre,
    descripcion: req.body.descripcion,
    posicion: req.body.posicion,
    estado: req.body.estado,
    sucursal: req.body.sucursal,
    tipo: req.body.tipo,
    coment: req.body.coment,
    sucursalProvisional: req.body.sucursalProvisional,
  });

  activo_nuevo.save()
    .then(
      function (result) {
        res.json(result);
      }
    );
});

router.put('/modificarEstado/:id', function (req, res) {
  const id = req.params.id;
  const nuevoEstado = req.body.estado;

  activo.findByIdAndUpdate(id, { estado: nuevoEstado }, { new: true })
    .exec()
    .then(function (result) {
      res.json(result);
    })
    .catch(function (error) {
      console.error(error);
      res.status(500).send('Error interno del servidor');
    });
});

router.put('/modificarEstadoMovimiento/:id', function (req, res) {
  const id = req.params.id;
  const nuevoEstado = req.body.estado;
  const nuevaSucursalJefatura = req.body.sucursal;
  const nuevaSucursal = req.body.sucursalProvisional;
  const nuevoComentario = req.body.coment;

  activo.findByIdAndUpdate(id, { sucursal: nuevaSucursalJefatura, estado: nuevoEstado, sucursalProvisional: nuevaSucursal, coment: nuevoComentario }, { new: true })
    .exec()
    .then(function (result) {
      res.json(result);
    })
    .catch(function (error) {
      console.error(error);
      res.status(500).send('Error interno del servidor');
    });
});

router.put('/modificarEstadoMovimientoRechazar/:id', function (req, res) {
  const id = req.params.id;
  const nuevoEstado = req.body.estado;
  const nuevaSucursal = req.body.sucursalProvisional;
  const nuevoComentario = req.body.coment;

  activo.findByIdAndUpdate(id, { estado: nuevoEstado, sucursalProvisional: nuevaSucursal, coment: nuevoComentario }, { new: true })
    .exec()
    .then(function (result) {
      res.json(result);
    })
    .catch(function (error) {
      console.error(error);
      res.status(500).send('Error interno del servidor');
    });
});

router.put('/modificarEstadoMovimientoSolicitud/:id', function (req, res) {
  const id = req.params.id;
  const nuevoEstado = req.body.estado;
  const nuevaSucursal = req.body.sucursalProvisional;
  const nuevoComentario = req.body.coment;

  activo.findByIdAndUpdate(id, { estado: nuevoEstado, sucursalProvisional: nuevaSucursal, coment: nuevoComentario }, { new: true })
    .exec()
    .then(function (result) {
      res.json(result);
    })
    .catch(function (error) {
      console.error(error);
      res.status(500).send('Error interno del servidor');
    });
});

const model=mongoose.model('activo','Activos');

router.delete('/rechazarActivo/:_id',async function(req,res){

    await model.findByIdAndDelete(req.params._id);

})
module.exports = router;
