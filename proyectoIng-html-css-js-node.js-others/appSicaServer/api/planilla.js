var express = require('express');
var router = express.Router();
var mongoose = require('mongoose');

var nodemailer=require('nodemailer');

var activo = require('../schemas/planilla.js');

router.get('/listarPlanilla', function (req, res) {
  activo.find().exec()
    .then(function (result) {
      res.json(result);
    });
});


router.put('/modificarContrasena/:id', function(req, res) {
  const id = req.params.id;
  const nuevaPassword = req.body.password;

  activo.findByIdAndUpdate(id, { password: nuevaPassword }, { new: true })
    .exec()
    .then(function(result) {
      res.json(result);
    })
    .catch(function(error) {
      console.error(error);
      res.status(500).send('Error interno del servidor');
    });
});



router.post('/insertarPlanilla', function (req, res) {
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
    estado: req.body.estado,
  });

  activo_nuevo.save()
    .then(
      function (result) {
        res.json(result);
      }
    );
});

router.put('/modificarEstado/:id', function(req, res) {
  const id = req.params.id;
  const nuevoEstado = req.body.estado;
  const nuevaPassword = req.body.password;

  activo.findByIdAndUpdate(id, { estado: nuevoEstado },{ new: true })
    .exec()
    .then(function(result) {
      res.json(result);
    })
    .catch(function(error) {
      console.error(error);
      res.status(500).send('Error interno del servidor');
    });
});




//enviar correo al aceptar 


const model=mongoose.model('planilla','Planilla');

router.put('/aceptarUsuario/:id', async function(req, res) {
  const id = req.params.id;
  const nuevoEstado = req.body.estado;

  await model.findOneAndUpdate(
    {_id:req.params._id},
    {$set:{
      _id: req.body._id,
      nombre: req.body.nombre,
      cedula: req.body.cedula,
      correo: req.body.correo,
      telefono: req.body.telefono,
      nacimiento: req.body.nacimiento,
      sucursal: req.body.sucursal,
      rol: req.body.rol,
      estado: req.body.estado,
      password: req.body.password,
    }}, 
    {new: true}

  )
console.log(req.body.correo);

  activo.findByIdAndUpdate(id, { estado: nuevoEstado }, { new: true })
    .exec()
    .then(function(result) {
      res.json(result);
    })
    .catch(function(error) {
      console.error(error);
      res.status(500).send('Error interno del servidor');
    });

    enviarMail= async () => {
      const config={
          host: 'smtp.gmail.com',
          port: 587,
          auth: {
              user: 'aduranm@ucenfotec.ac.cr',
              pass: 'rkmffhnocnrjxgzt'
          },
          // === add this === //
          tls : { rejectUnauthorized: false }
      }
  
      // Una cadena de texto con todos los caracter
      let cadena="abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQ!#$%&/()=?¡¿0123456789-_*{<>[]}+";
      let codigoAutogenerado="";
      // Math.random function return a randomnumber betwenn this range: Math.floor(Math.random() * 10);
  
      // Si Math.random devuelve un numero aleatorio itere en un ciclo 8 veces y o veces saque un numero aleatorio entre 
      // el rango de la cadena de texto 
  
      for(let i=0; i<8;i++){
        codigoAutogenerado+= cadena.charAt(Math.random() * cadena.length);
      }
  
  
      // guardela vara en una variable codigoautogenerado
  
  
      const mensaje={
          from: 'aduranm@ucenfotec.ac.cr',
          to: req.body.correo, // aqui pones req.body.email o la variable que se llama en tu documento
          subject: 'Bienvenido a Proveguard Sica',
          //text: 'Envio de correo con nodejs'
          html: `
                  <table id="idTableNodeMailer">
                  <tbody id="idTBodyNodeMailer">
                      <tr id="trNodeMailerId1" class="class-tr-nodemailer">
                          <td>Bienvenido usuario ${req.body.nombre}..!</td>
                      </tr>
                      <tr id="trNodeMailerId2" class="class-tr-nodemailer">
                          <td>Hemos confirmado y aceptado el proceso de registro que hiciste con nosotros.\nTe agradecemos por querer pertencer y unirte a nuestro equipo.</td>
                      </tr>
                      <tr id="trNodeMailerId3" class="class-tr-nodemailer">
                          <td>Tu contraseña es ${req.body.password}.</td>
                      </tr>
                      <tr id="trNodeMailerId4" class="class-tr-nodemailer">
                          <td>Por favor cambiar la contraseña en el siguiente link</td>
                      </tr>
                      <tr id="trNodeMailerId5" class="class-tr-nodemailer">
                          <td><a class="link-nodemailer" href="http://localhost:5000/html/login/restablecercontra2.html?${req.body._id}${codigoAutogenerado}">Cambiar Contraña.</a></td>
                      </tr>
                      </tbody>
                  </table>
                `
      }
  
      const transport=nodemailer.createTransport(config);
  
      const info= await transport.sendMail(mensaje);
  }
  enviarMail();
});


router.put('/restablecerContra/:id', async function(req, res) {
  const id = req.params.id;
  const nuevoEstado = req.body.estado;

  await model.findOneAndUpdate(
    {_id:req.params._id},
    {$set:{
      _id: req.body._id,
      nombre: req.body.nombre,
      cedula: req.body.cedula,
      correo: req.body.correo,
      telefono: req.body.telefono,
      nacimiento: req.body.nacimiento,
      sucursal: req.body.sucursal,
      rol: req.body.rol,
      estado: req.body.estado,
      password: req.body.password,
    }}, 
    {new: true}

  )
console.log(req.body.correo);

  activo.findByIdAndUpdate(id, { estado: nuevoEstado }, { new: true })
    .exec()
    .then(function(result) {
      res.json(result);
    })
    .catch(function(error) {
      console.error(error);
      res.status(500).send('Error interno del servidor');
    });

    enviarMail= async () => {
      const config={
          host: 'smtp.gmail.com',
          port: 587,
          auth: {
              user: 'aduranm@ucenfotec.ac.cr',
              pass: 'rkmffhnocnrjxgzt'
          },
          // === add this === //
          tls : { rejectUnauthorized: false }
      }
  
      // Una cadena de texto con todos los caracter
      let cadena="abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQ!#$%&/()=?¡¿0123456789-_*{<>[]}+";
      let codigoAutogenerado="";
      // Math.random function return a randomnumber betwenn this range: Math.floor(Math.random() * 10);
  
      // Si Math.random devuelve un numero aleatorio itere en un ciclo 8 veces y o veces saque un numero aleatorio entre 
      // el rango de la cadena de texto 
  
      for(let i=0; i<8;i++){
        codigoAutogenerado+= cadena.charAt(Math.random() * cadena.length);
      }
  
  
      // guardela vara en una variable codigoautogenerado
  
  
      const mensaje={
          from: 'aduranm@ucenfotec.ac.cr',
          to: req.body.correo, // aqui pones req.body.email o la variable que se llama en tu documento
          subject: 'Sica Cambio de Contraseña',
          //text: 'Envio de correo con nodejs'
          html: `
                  <table id="idTableNodeMailer">
                  <tbody id="idTBodyNodeMailer">
                      <tr id="trNodeMailerId1" class="class-tr-nodemailer">
                          <td>Reciba un cordial saludo${req.body.nombre}..!</td>
                      </tr>
                      <tr id="trNodeMailerId2" class="class-tr-nodemailer">
                          <td>Hemos recibido su petición de cambio de contraseña.\n En el siguiente enlace podrá realizar el cambio solicitado</td>
                      </tr>
                      <tr id="trNodeMailerId4" class="class-tr-nodemailer">
                          <td>Por favor cambiar la contraseña en el siguiente link</td>
                      </tr>
                      <tr id="trNodeMailerId5" class="class-tr-nodemailer">
                          <td><a class="link-nodemailer" href="http://localhost:5000/html/login/restablecercontra2.html?${req.body._id}${codigoAutogenerado}">Cambiar Contraña.</a></td>
                      </tr>
                      </tbody>
                  </table>
                `
      }
  
      const transport=nodemailer.createTransport(config);
  
      const info= await transport.sendMail(mensaje);
  }
  enviarMail();
});


module.exports = router;