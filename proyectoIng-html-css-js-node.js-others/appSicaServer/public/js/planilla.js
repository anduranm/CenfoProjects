document.addEventListener("DOMContentLoaded", function () {

  fetch('/planilla/listarplanilla')
    .then(response => response.json())
    .then(data => cargarTabla(data, 0, select.selectedOptions[0].textContent))
    .catch(error => console.error(error));
});

//inicio de buscar
const busquedaInput = document.getElementById("buscador");
busquedaInput.addEventListener("input", function () {
  const valorBusqueda = busquedaInput.value.toLowerCase().trim();
  const rows = document.querySelectorAll("#planillaTable tbody tr");

  rows.forEach(row => {
    const nombre = row.cells[3].textContent.toLowerCase();
    if (nombre.includes(valorBusqueda)) {
      row.style.display = "";
    } else {
      row.style.display = "none";
    }
  });
});

//fin de buscar

const select = document.getElementById("despliegueSucursal");
select.addEventListener("change", function () {
  const valorSucursal = select.selectedOptions[0].textContent;
  fetch(`/planilla/listarplanilla?sucursal=${valorSucursal}`)
    .then(response => response.json())
    .then(data => cargarTabla(data, 0, valorSucursal))
    .catch(error => console.error(error));
});

function cargarTabla(data, valorSeleccionado, valorSucursal) {
  const table = document.getElementById("planillaTable").getElementsByTagName('tbody')[0];
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

  data.forEach(usuario => {
    if (usuario.estado == "Activo") {

      const row = table.insertRow();
      if(user === "Jefatura" || user === "Jefe de Proveeduría"){
        row.innerHTML = `
      <td>${usuario._id}</td>
      <td>${usuario.rol}</td>
      <td>${usuario.sucursal}</td>
      <td>${usuario.nombre}</td>
      <td>${usuario.cedula}</td>
      <td>${usuario.correo}</td>
      <td>${usuario.estado}</td>
  
      <td><a href="planillaEditar.html?${usuario._id}"><img class="editarBtn" src="../media/editar.png" alt="Editar"></a></td>
      <td><a href="#" class="deshabilitarBtn" data-id="${usuario._id}"><img class="deshabilitarBtn" src="../media/deshabilitar.png" alt="Deshabilitar"></a></td>
      `;
      };
      if(user === "Proveeduría"){
        row.innerHTML = `
      <td>${usuario._id}</td>
      <td>${usuario.rol}</td>
      <td>${usuario.sucursal}</td>
      <td>${usuario.nombre}</td>
      <td>${usuario.cedula}</td>
      <td>${usuario.correo}</td>
      <td>${usuario.estado}</td>
  
      <td><a href="planillaEditar.html?${usuario._id}"><img class="editarBtn" src="../media/editar.png" alt="Editar"></a></td>
      `;
      };
      

      // Agregar evento 'click' a todos los botones de deshabilitar
      const deshabilitarBtns = document.querySelectorAll('.deshabilitarBtn');
      deshabilitarBtns.forEach(btn => {
        btn.addEventListener('click', function () {
          const codigoSucursal = this.getAttribute('data-id');
          const url = `/planilla/modificarEstado/${codigoSucursal}`;
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
