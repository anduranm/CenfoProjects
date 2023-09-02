var express = require('express');
var router = express.Router();
var mongoose = require('mongoose');

var usuarios = require('../schemas/login.js');

router.get('/listarUsuarios', function(req, res) {
  usuarios.find().exec()
    .then(function(result){
      res.json(result);
    });
});


module.exports = router;