fetch('/sucursal/listarSucursales')
.then(response => response.json())
.then(data => {
  // Obtener el select
  const select = document.getElementById("sucursal");

  // Crear una opción para cada sucursal
  data.forEach(sucursal => {
    if (sucursal.estado == "Activa") {
      const option = document.createElement("option");
      option.value = sucursal._id;
      option.textContent = sucursal.nombre;
      select.appendChild(option);
    }
  });
})
.catch(error => console.error(error));
function insertar() {
  var nombre = document.getElementById("nombre").value;
  var cedula = document.getElementById("cedula").value;
  var correo = document.getElementById("correo").value;
  var telefono = document.getElementById("telefono").value;
  var nacimiento = document.getElementById("nacimiento").value;
  var sucursal = document.getElementById("sucursal").selectedOptions[0].textContent;
  var rol = document.getElementById("rol").selectedOptions[0].textContent;
  var estado = "Procesando";
  var password = "default";

  // Validar campos obligatorios
  if (nombre === '' || cedula === '' || correo === '') {
    alert('Por favor complete todos los campos obligatorios.');
    return;
  }

  // Validar formato de correo electrónico
  var correoValido = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
  if (!correo.match(correoValido)) {
    alert('Por favor ingrese una dirección de correo electrónico válida.');
    return;
  }

  var xhr = new XMLHttpRequest();
  xhr.open("POST", "/registrologin/insertarUsuarios", true);
  xhr.setRequestHeader("Content-Type", "application/json");

  xhr.onreadystatechange = function() {
    if (xhr.readyState === 4 && xhr.status === 200) {
      console.log(xhr.responseText);
      window.location.href = "registrocompleto.html";
    }
  };

  var data = JSON.stringify({
    nombre: nombre,
    cedula: cedula,
    correo: correo,
    telefono: telefono,
    nacimiento: nacimiento,
    sucursal: sucursal,
    rol: rol,
    estado: estado,
    password: password,
  });

  xhr.send(data);
}

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