var express = require('express');
var router = express.Router();
var mongoose = require('mongoose');

var usuarios = require('../schemas/registro.js');

router.get('/listarUsuarios', function(req, res) {
  usuarios.find().exec()
    .then(function(result){
      res.json(result);
    });
});

router.post('/insertarUsuarios', function(req, res) {  
  var usuario_nuevo = new usuarios({
    _id: new mongoose.Types.ObjectId(),
    nombre: req.body.nombre,
    cedula: req.body.cedula,
    correo: req.body.correo,
    telefono: req.body.telefono,
    nacimiento: req.body.nacimiento,
    sucursal: req.body.sucursal,
    rol: req.body.rol,
    ubicacion: req.body.ubicacion,
    estado: req.body.estado,
    password: req.body.password
  });
  
  usuario_nuevo.save()
    .then(
      function(result){
        res.json(result);
      }
    );
});

module.exports=router;