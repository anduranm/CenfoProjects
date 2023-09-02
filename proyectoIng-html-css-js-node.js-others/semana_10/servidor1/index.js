var express = require("express");
var path = require("path");
var app = express();
var mongoose = require("mongoose");

//mongoose.connect("mongodb+srv://armando_user:@armandodb.tkbov.mongodb.net/Universidad?retryWrites=true&w=majority");
mongoose.connect("mongodb+srv://aduranm:Room111@compilationone.gupgn6e.mongodb.net/Universidad?retryWrites=true&w=majority");

app.use(express.static(path.join(__dirname, "public")));
app.use("/estudiantes", require("./api/estudiantes.js"));

app.listen(5000, function(){
  console.log("Servidor corriendo en puerto 5000");
})