var email = localStorage.getItem("email");
var rol = localStorage.getItem("rol");
var sucursal = localStorage.getItem("sucursal");

fetch('/sucursal/listarSucursales')
  .then(response => response.json())
  .then(data => {
    // Obtener el select
    const select = document.getElementById("sucursalN");

    // Crear una opción para cada sucursal
    if(rol == "Inventario" || rol == "Proveeduría"){
      const option = document.createElement("option");
      option.value = "1";
      option.textContent = sucursal;
      option.selected
      select.appendChild(option);
    }else{data.forEach(sucursal => {
      if (sucursal.estado == "Activa") {
        const option = document.createElement("option");
        option.value = sucursal._id;
        option.textContent = sucursal.nombre;
        select.appendChild(option);
      }
    });}
  });


if (rol == "Inventario") {
  
  const enviarCambioJefatura = document.getElementById('aceptar');
  enviarCambioJefatura.addEventListener('click', function () {
    var nombre = document.getElementById("nombreactivo").value;
    var descripcion = document.getElementById("descripcion").value;
    var posicion = document.getElementById("posicionfisica").value;
    var estado = "Procesando"
    var sucursal = document.getElementById("sucursalN").selectedOptions[0].textContent;
    var tipo = document.querySelector('input[name="donacion"]:checked').value;
    var comentario = document.getElementById("coment").value;
    var sucursalProvisional = " ";


    // Validar campos obligatorios
    if (nombre === '' || descripcion === '' || posicion === '') {
      alert('Por favor complete todos los campos obligatorios.');
      return;
    }
    if (!tipo) {
      alert('Por favor seleccione una opción para el campo tipo.');
      return;
    }

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/activo/insertarActivo", true);
    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.onreadystatechange = function () {
      if (xhr.readyState === 4 && xhr.status === 200) {
        console.log(xhr.responseText);
        window.location.href = "activos.html";
      }
    };

    var data = JSON.stringify({
      nombre: nombre,
      descripcion: descripcion,
      posicion: posicion,
      estado: estado,
      sucursal: sucursal,
      tipo: tipo,
      coment: comentario,
      sucursalProvisional: sucursalProvisional,
    });

    xhr.send(data);
  });
} else if (rol == "Jefatura" || rol == "Jefe de Proveeduría" || rol == "Proveeduría") {
  const enviarCambioJefatura = document.getElementById('aceptar');
  enviarCambioJefatura.addEventListener('click', function () {
    var nombre = "", descripcion = "", posicion = "", estado = "", sucursal = "", tipo = "", comentario = "", sucursalProvisional = "";

    
    nombre = document.getElementById("nombreactivo").value;
    descripcion = document.getElementById("descripcion").value;
    posicion = document.getElementById("posicionfisica").value;
    estado = "Activa"
    sucursal = document.getElementById("sucursalN").selectedOptions[0].textContent;
    tipo = document.querySelector('input[name="donacion"]:checked').value;
    comentario = document.getElementById("coment").value;
    sucursalProvisional = " ";
    
    // Validar campos obligatorios
    if (nombre === "" || descripcion === "" || posicion === "") {
      alert('Por favor complete todos los campos obligatorios.');
      return;
    }
    if (!tipo) {
      alert('Por favor seleccione una opción para el campo tipo.');
      return;
    }

    

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/activo/insertarActivo", true);
    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.onreadystatechange = function () {
      if (xhr.readyState === 4 && xhr.status === 200) {
        console.log(xhr.responseText);
        window.location.href = "activos.html";
      }
    };

    var data = JSON.stringify({
      nombre: nombre,
      descripcion: descripcion,
      posicion: posicion,
      estado: estado,
      sucursal: sucursal,
      tipo: tipo,
      coment: comentario,
      sucursalProvisional: sucursalProvisional,
    });

    xhr.send(data);
  });
};