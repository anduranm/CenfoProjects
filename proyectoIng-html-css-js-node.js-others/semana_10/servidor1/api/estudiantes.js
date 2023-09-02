var express = require("express");
var router = express.Router();

var Estudiante = require("../schemas/estudiante.js");

router.get("/listar", function(req, res) {
  Estudiante.find().exec()
    .then(function(result){
      res.json(result);
    })
});

module.exports = router;