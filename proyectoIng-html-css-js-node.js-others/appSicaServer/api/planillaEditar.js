var express = require('express');
var router = express.Router();
var mongoose = require('mongoose');

var activo = require('../schemas/planilla.js');

router.put('/planillaEditar/:id', function (req, res) {
    const id = req.params.id;
    const nuevoNombre = req.body.nombre;
    const nuevocCedula = req.body.cedula;
    const nuevoCorreo = req.body.correo;
    const nuevoTelefono = req.body.telefono;
    const nuevoNacimiento = req.body.nacimiento;
    const nuevaSucursal = req.body.sucursal;
    const nuevoRol = req.body.rol;

    activo.findByIdAndUpdate(id, { nombre: nuevoNombre, cedula: nuevocCedula, correo: nuevoCorreo, telefono: nuevoTelefono, nacimiento:nuevoNacimiento, sucursal:nuevaSucursal, rol:nuevoRol   }, { new: true })
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