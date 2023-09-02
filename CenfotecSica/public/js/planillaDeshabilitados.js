document.addEventListener("DOMContentLoaded", function() {
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
  
    data = data.filter(activo => {
      return (valorSucursal === "Ver Todas" || activo.sucursal === valorSucursal);
    });
  
    data.forEach(usuario => {
      if (usuario.estado == "Inhabilitado") {

        const row = table.insertRow();

        row.innerHTML = `
        <td>${usuario._id}</td>
        <td>${usuario.rol}</td>
        <td>${usuario.sucursal}</td>
        <td>${usuario.nombre}</td>
        <td>${usuario.cedula}</td>
        <td>${usuario.correo}</td>
        <td>${usuario.estado}</td>
       
        <td><a href=""><button class="btnHabilitar btnSucursal" data-id="${usuario._id}">Habilitar</button></a></td>
        `;
        console.log(data)
        // Agregar evento 'click' al botón de deshabilitar
        const habilitarBtn = row.querySelector('.btnhabilitar');
        habilitarBtn.addEventListener('click', function () {
          const codigoActivo = this.getAttribute('data-id');
          const url = `/planilla/modificarEstado/${codigoActivo}`;
          const data = {
            estado: 'Activo'
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
      }

    });
  }
  