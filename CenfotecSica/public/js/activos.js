document.addEventListener("DOMContentLoaded", function () {

  fetch('/activo/listarActivos')
    .then(response => response.json())
    .then(data => cargarTabla(data, 0, select.selectedOptions[0].textContent))
    .catch(error => console.error(error));
});

//inicio
const btnBusqueda = document.getElementById("iniciarBusqueda");
btnBusqueda.addEventListener("click", function () {
  const valorBusqueda = document.getElementById("buscador").value.toLowerCase();
  filtrarActivos(valorBusqueda);
});

function filtrarActivos(valorBusqueda) {
  const activos = document.querySelectorAll("#activosTable tbody tr");
  activos.forEach(activo => {
    const nombre = activo.querySelector("td:nth-child(2)").textContent.toLowerCase();
    const descripcion = activo.querySelector("td:nth-child(3)").textContent.toLowerCase();
    const fechaAdquisicion = activo.querySelector("td:nth-child(4)").textContent.toLowerCase();
    const categoria = activo.querySelector("td:nth-child(5)").textContent.toLowerCase();
    if (nombre.indexOf(valorBusqueda) === -1 &&
      descripcion.indexOf(valorBusqueda) === -1 &&
      fechaAdquisicion.indexOf(valorBusqueda) === -1 &&
      categoria.indexOf(valorBusqueda) === -1) {
      activo.style.display = "none";
    } else {
      activo.style.display = "";
    }
  });
}

const inputBusqueda = document.getElementById("buscador");
inputBusqueda.addEventListener("keyup", function () {
  const valorBusqueda = inputBusqueda.value.toLowerCase();
  filtrarActivos(valorBusqueda);
});



const select = document.getElementById("despliegueSucursal");
select.addEventListener("change", function () {
  const valorSucursal = select.selectedOptions[0].textContent;
  fetch(`/activo/listarActivos?sucursal=${valorSucursal}`)
    .then(response => response.json())
    .then(data => cargarTabla(data, 0, valorSucursal))
    .catch(error => console.error(error));
});

function cargarTabla(data, valorSeleccionado, valorSucursal) {
  const table = document.getElementById("activosTable").getElementsByTagName('tbody')[0];
  table.innerHTML = ''; // Limpiar la tabla
  
  // Obtener información del usuario
  var user = localStorage.getItem("rol");
  var sucursalUser = localStorage.getItem("sucursal");
  
  if(user === "Jefatura" || user === "Jefe de Proveeduría"){
    data = data.filter(activo => {
      return (valorSucursal === "Ver Todas" || activo.sucursal === valorSucursal);
    });
  }else if(user === "Inventario" || user === "Proveeduría"){
    data = data.filter(activo => {
      return (valorSucursal === sucursalUser || activo.sucursal === sucursalUser);
    });
  }
  
  

  // Crear una fila para cada activo
  data.forEach(activo => {
    if (activo.estado == "Activa") {
      
      // if(){
        
      // }
      const row = table.insertRow();
      if(user === "Proveeduría"){
        row.innerHTML = `
        <td>${activo._id}</td>
          <td>${activo.nombre}</td>
          <td>${activo.descripcion}</td>
          <td>${activo.posicion}</td>
          <td>${activo.sucursal}</td>
          <td>${activo.tipo}</td>
          <td><a href="activosEditar.html?${activo._id}"><img class="editarBtn" src="../media/editar.png" alt="Editar"></a></td>
          <td><a href="moverActivo.html?${activo._id}"><img class="moverBtn" src="../media/mover.png" alt="Mover"></a></td>
          <td><a href="#" class="deshabilitarBtn" data-id="${activo._id}"><img class="deshabilitarBtn" src="../media/deshabilitar.png" alt="Deshabilitar"></a></td>
          `;
      }
      if (user === "Jefe de Proveeduría" || user === "Jefatura") {
        row.innerHTML = `
      <td>${activo._id}</td>
        <td>${activo.nombre}</td>
        <td>${activo.descripcion}</td>
        <td>${activo.posicion}</td>
        <td>${activo.sucursal}</td>
        <td>${activo.tipo}</td>
        <td><a href="activosEditar.html?${activo._id}"><img class="editarBtn" src="../media/editar.png" alt="Editar"></a></td>
        <td><a href="moverActivo.html?${activo._id}"><img class="moverBtn" src="../media/mover.png" alt="Mover"></a></td>
        <td><a href="#" class="deshabilitarBtn" data-id="${activo._id}"><img class="deshabilitarBtn" src="../media/deshabilitar.png" alt="Deshabilitar"></a></td>
        `;
      }else if (user === "Inventario" ){
        row.innerHTML = `
      <td>${activo._id}</td>
        <td>${activo.nombre}</td>
        <td>${activo.descripcion}</td>
        <td>${activo.posicion}</td>
        <td>${activo.sucursal}</td>
        <td>${activo.tipo}</td>
        <td><a href="moverActivo.html?${activo._id}"><img class="moverBtn" src="../media/mover.png" alt="Mover"></a></td>
        `;
      }
    // else if(user === "Proveeduría"){
    //   row.innerHTML = `
    // <td>${activo._id}</td>
    //   <td>${activo.nombre}</td>
    //   <td>${activo.descripcion}</td>
    //   <td>${activo.posicion}</td>
    //   <td>${activo.sucursal}</td>
    //   <td>${activo.tipo}</td>
    //   <td><a href="activosEditar.html?${activo._id}"><img class="editarBtn" src="../media/editar.png" alt="Editar"></a></td>
    //   <td><a href="moverActivo.html?${activo._id}"><img class="moverBtn" src="../media/mover.png" alt="Mover"></a></td>
    //   `;
    // }


      // Agregar evento 'click' al botón de deshabilitar
      const deshabilitarBtns = row.querySelectorAll('.deshabilitarBtn');
      deshabilitarBtns.forEach(btn => {
        btn.addEventListener('click', function () {
          const codigoActivo = this.getAttribute('data-id');
          const url = `/activo/modificarEstado/${codigoActivo}`;
          const data = {
            estado: 'Inhabilitado'
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
              console.log(result);
              location.reload(); // Recargar la página después de modificar el estado
            })
            .catch(error => console.error(error));
        });
      });
    }
  })
};