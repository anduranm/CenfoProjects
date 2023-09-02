var express = require("express");
var router = express.Router();
var heroes = require("./heroesJson");

router.get("/listar", function(req, res){
    res.json(heroes);
})

module.exports = router;