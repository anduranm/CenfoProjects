fetch("/login/listarUsuarios")
  .then(function(data){
    return data.json();
  })
  .then(function(json){
    console.log(json.length);
    
    const resetContra = document.getElementById('resetPassword');

    resetContra.addEventListener('click', function () {
      const correoUsuario = document.getElementById('usuario').value;
      let usuarioEncontrado = null;

      for (let i = 0; i < json.length; i++) {
        if (json[i].correo == correoUsuario) {
          usuarioEncontrado = json[i];
          break;
        }
      }

      if (usuarioEncontrado) {
        const codigoUsuario = usuarioEncontrado._id;
        const url = `/planilla/restablecerContra/${codigoUsuario}`;
        const data = {
          estado: usuarioEncontrado.estado,
          nombre: usuarioEncontrado.nombre,
          correo: usuarioEncontrado.correo,
          _id: usuarioEncontrado._id,
        };

        fetch(url, {
          method: 'PUT',
          body: JSON.stringify(data),
          headers: {
            'Content-Type': 'application/json'
          }
        })
        .then(response => response.json())
        .then(result => {
          
          
        })
        .catch(error => console.error(error));
        alert('Se ha enviado el correo de restablecimiento');
      } else {
        alert('Usuario no encontrado');
      }
    });
  });


  document.addEventListener("DOMContentLoaded", function () {

    fetch("/login/listarUsuarios")
        .then(function (data) {
            return data.json();
        })
        .then(function (json) {
            console.log(json.length);
            let email = localStorage.getItem("email");
            let tipeUser = localStorage.getItem("rol");


            for (let i = 0; i < json.length; i++) {
                if (json[i].correo == email && json[i].rol == tipeUser) {
                    window.location.href = '/html/indexSica.html';

                }
            }
            console.log(email);
        })


});