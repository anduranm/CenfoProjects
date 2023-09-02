//salir de sersion
const salirSesionBtn = document.getElementById('salirSesion');

// Agregar un listener al botón
salirSesionBtn.addEventListener('click', clearLocalStorage);

document.addEventListener("DOMContentLoaded", function() {

  let email =localStorage.getItem("email");
  let rol =localStorage.getItem("rol");

  if(rol == null || email == undefined){
      window.location.href= '/login/inicio.html';
  }


  // console.log(email);
  // console.log(rol);

});
// Función para borrar el contenido del LocalStorage
function clearLocalStorage() {
  localStorage.clear();

  // redirecciona
  window.location.href= 'login/inicio.html';
}

document.getElementById('cancelar').addEventListener('click', function() {
  history.back();
});


document.addEventListener("DOMContentLoaded", function() {
  var user =localStorage.getItem("rol");
  var menuDespliegue = document.querySelector(".menuDespliegue");
  var reportesBtn = document.getElementById("reportesBtn");
  if (user == "Jefatura") {    //ajustes por roles jefatura tiene todo no se le mete nada
  
  }else if(user == "Jefe de Proveeduría"){
    ocultarSucursales.style.display = "none";
  } else if(user == "Proveeduría"){
      ocultarSucursales.style.display = "none";
  } else if(user == "Inventario") {
    // menuDespliegue.disabled = true; 
    menuDeNavegacion.style.display = "none"; // ocultar el menú de navegación
  }
});