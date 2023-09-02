var express = require('express');
var router = express.Router();
var mongoose = require('mongoose');

var activo = require('../schemas/planillaSolicitudes.js');

router.get('/listarSolicitudesPlanilla', function (req, res) {
  activo.find().exec()
    .then(function (result) {
      res.json(result);
    });
});

router.post('/insertarSolicitudesPlanilla', function (req, res) {
  var activo_nuevo = new activo({
    _id: new mongoose.Types.ObjectId(),
    nombre: req.body.nombre,
    cedula: req.body.cedula,
    correo: req.body.correo,
    telefono: req.body.telefono,
    nacimiento: req.body.nacimiento,
    sucursal: req.body.sucursal,
    rol: req.body.rol,
    ubicacion: req.body.ubicacion,
    // estado: req.body.estado,
  });

  activo_nuevo.save()
    .then(
      function (result) {
        res.json(result);
      }
    );
});



/*
router.delete('/eliminar/:id', function(req, res) {
  const id = req.params.id;

  activo.findByIdAndDelete(id, function(err, planilla) {
    if (err) {
      res.status(500).json({
        message: 'Error al eliminar planilla',
        error: error
      });
    } else {
      res.json({
        message: `Planilla con ID ${id} eliminada exitosamente`
      });
    }
  });
});
*/

const model=mongoose.model('planillaSolicitudes','Planilla');

router.delete('/rechazarUsuario/:_id',async function(req,res){

    await model.findByIdAndDelete(req.params._id);

})


module.exports = router;