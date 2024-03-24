// Obtener todos los enlaces del menú
const menuLinks = document.querySelectorAll('.amenu');
const btnMostrarBitacora = document.querySelector('.bitacora');
const miDivBitacora = document.querySelector('#bitacora');
const urlActual = document.title.toLowerCase().replace(/\s/g, '-');



//let lastActiveLink = menuLinks[1]; 
var lastActiveLink;
let bitacoraVisible = false;



// Iterar por cada enlace del menú
menuLinks.forEach(link => {
  // Añadir un evento de click a cada enlace
  link.addEventListener('click', function(event) {
    // event.preventDefault(); // Evitar el comportamiento por defecto del enlace
    if (link !== btnMostrarBitacora) { // Excluir la opción de Bitácora
      // Guardar el último enlace seleccionado
      lastActiveLink = link;
    }
    //Eliminar la clase 'active' de todos los enlaces
    clearMenuActive();
    // Añadir la clase 'active' al enlace que se ha hecho clic
     link.classList.add('active');
    // Ocultar la bitácora
    bitacoraVisible = false;
    ocultarBitacora();
    mostrarMain()
  });
});

function clearMenuActive() {
  menuLinks.forEach(link => {
    link.classList.remove('active');
  });
}

function mostrarBitacora() {
  miDivBitacora.style.display = 'block';
  document.body.style.backgroundColor = 'var(--gris)';
  main.classList.add('ocultar')
}

function ocultarBitacora() {
  miDivBitacora.style.display = 'none';
  document.body.style.backgroundColor = 'var(--blanco)';
  main.classList.remove('ocultar')
}

function mostrarMain(){
  main.classList.remove('ocultar')
}

if(!window.location.href.includes("reportes.html")){
  btnMostrarBitacora.addEventListener('click', function() {
    event.preventDefault();
    if (bitacoraVisible) {
      ocultarBitacora();
      bitacoraVisible = false;
      clearMenuActive();
      lastActiveLink.classList.add('active'); // Usar el último enlace seleccionado
    } else {
      mostrarBitacora();
      bitacoraVisible = true;
      clearMenuActive();
    }
  });

}

switch (urlActual){
  case 'index':

  break;
  
  case 'sica-sucursales':
  lastActiveLink = menuLinks[0];
  break;
  
  case 'sica-activos':
  lastActiveLink = menuLinks[1];
  break;

  case 'sica-planilla':
  lastActiveLink = menuLinks[2];
  break;
  case 'sica-solicitudes':
  lastActiveLink = menuLinks[3];
  break;
}

if (!window.location.href.includes("reportes.html") && !window.location.href.includes("indexSica.html") && !window.location.href.includes("activoscrearnuevo.html") && !window.location.href.includes("crearSucursal.html") && !window.location.href.includes("planillacrearnuevo.html") && !window.location.href.includes("planillaEditar.html?") && !window.location.href.includes("moverActivo.html?") && !window.location.href.includes("activosEditar.html?") && !window.location.href.includes("sucursales.html") && !window.location.href.includes("editarSucursal.html?") && !window.location.href.includes("sucursalesDeshabilitados.html")) {
  // Código a ejecutar si no se encuentra en la página "activoscrearnuevo.html"
  // ...
  fetch('/sucursal/listarSucursales')
  .then(response => response.json())
  .then(data => {
    // Obtener el select
    const select = document.getElementById("despliegueSucursal");

    // Agregar la opción de Ver Todas
    const verTodas = document.createElement("option");
    verTodas.value = "0";
    verTodas.textContent = "Ver Todas";
    verTodas.selected = true;
    select.appendChild(verTodas);

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
}


//cargar ultimos 7
document.addEventListener("DOMContentLoaded", function() {
  fetch('/activo/listarActivos')
  .then(response => response.json())
  .then(data => {
    // Obtener la tabla
    const table = document.getElementById("activosRecientes").getElementsByTagName('tbody')[0];
    table.innerHTML = ''; // Limpiar la tabla

    // Ordenar los elementos por fecha de creación descendente y limitar a 7
  data.sort((a, b) => new Date(b.fechaCreacion) - new Date(a.fechaCreacion));
  data = data.slice(0, 100);

  // Crear una fila para cada activo
  data.forEach(activo => {
    if (activo.estado == "Activa") {

      const row = table.insertRow();

      row.innerHTML = `
        <td>${activo._id}</td>
        <td>${activo.nombre}</td>
        <td>${activo.descripcion}</td>
        <td>${activo.posicion}</td>
        <td>${activo.sucursal}</td>
        <td>${activo.estado}</td>
      `;

    }
  });
})});

//obtenerNombre
const nameUser =localStorage.getItem("nombre");
// Obtener la tabla por su clase
var tabla = document.querySelector(".nombrePersona");

// Crear un nuevo td
var nuevoTd = document.createElement("td");

// Agregar contenido al nuevo td
nuevoTd.innerHTML = nameUser;

// Agregar el nuevo td a la tabla
tabla.appendChild(nuevoTd);





// vamos a definir por rol 

//mantener sesion y filtrar usuarios
document.addEventListener("DOMContentLoaded", function() {

  let email =localStorage.getItem("correo");
  let rol =localStorage.getItem("rol");

  if(rol == null || rol == undefined){
      window.location.href= '/html/login/inicio.html';
  }  
});



//filtrar por tipo de usuario Rol
document.addEventListener("DOMContentLoaded", function() {
  var user =localStorage.getItem("rol");
  var menuDespliegue = document.querySelector(".menuDespliegue");
  var reportesBtn = document.getElementById("reportesBtn");

  if (user == "Jefatura") {    //ajustes por roles jefatura tiene todo no se le mete nada
    //esta vacio porque tiene acceso a todo

    
  } else if(user == "Jefe de Proveeduría"){
    if(window.location.href.includes("sucursales.html")){
      hiddenNewSucursal.style.display = "none"; //boton de nueva sucursal
      hiddenDeshabilitadoSucursales.style.display = "none"; //boton de deshabilitados de sucursal
      hiddenDeshabilitarSucursal.style.display = "none"; // deshabilitar de table 
      hiddenEditarSucursal.style.display = "none";
    };

    

  } else if(user == "Proveeduría"){
    // menuDespliegue.disabled = true; 
    ocultarSucursales.style.display = "none";
    if(!window.location.href.includes("indexSica.html") && !window.location.href.includes("reportes.html")){
      menuDespliegue.style.display = "none";  
    }
    if(!window.location.href.includes("solicitudesMovimientos.html")){

        
        // hiddeDesh.style.display = "none"; //ocultar tabla

        if(window.location.href.includes("planilla.html")){
          nuevoUsuarioPlanilla.style.display = "none"; // btn nuevo usuario
          solicitudesPlanilla.style.display = "none"; //btn  solicitudes en planilla
          hiddeDesh.style.display = "none"; //ocultar de tabla deshabilitados en activos
          deshabilitadosBtn.style.display = "none"; //ocultar boton de deshabilitados en planilla
        }
      // if(window.location.href.includes("activos.html")){
      //   deshabilitadosBtn.style.display = "none"; //ocultar boton de deshabilitados en activos
      //   // hiddeDesh.style.display = "none"; //ocultar de tabla deshabilitados en activos
      // };
    }



  } else if(user == "Inventario") {
    // menuDespliegue.disabled = true; 
    menuDeNavegacion.style.display = "none"; // ocultar el menú de navegación
    reportesBtn.style.display = "none";
    if(!window.location.href.includes("moverActivo.html?")){
      menuDespliegue.style.display = "none";  
      deshabilitadosBtn.style.display = "none"; //ocultar boton de deshabilitados en activos
      movimientosBtn.style.display = "none"; // ocultar boton de movimientos en activos 
      hiddeEdit.style.display = "none";   //ocultar tabla de editar en activos 
      hiddeDesh.style.display = "none"; //ocultar de tabla deshabilitados en activos
      // hiddeMove.style.display = "none";  
    }
  }
});