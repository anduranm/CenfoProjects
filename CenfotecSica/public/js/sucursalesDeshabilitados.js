fetch('/sucursal/listarSucursales')
  .then(response => response.json())
  .then(data => {
    // Obtener la tabla
    const table = document.getElementById("sucursalesDeshabilitadoTable").getElementsByTagName('tbody')[0];
    table.innerHTML = ''; // Limpiar la tabla

    // Crear una fila para cada sucursal
    data.forEach(sucursal => {
      if (sucursal.estado == "Inhabilitado") {

        const row = table.insertRow();

        row.innerHTML = `
          <td>${sucursal._id}</td>
          <td>${sucursal.nombre}</td>
          <td>${sucursal.descripcion}</td>
          <td>${sucursal.ubicacion}</td>
          <td>${sucursal.fecha}</td>
          <td>${sucursal.estado}</td>
          <td><a href=""><button class="btnhabilitar btnSucursal" data-id="${sucursal._id}">Habilitar</button></a></td>
        `;
        
        // Agregar evento 'click' al botón de deshabilitar
        const habilitarBtn = row.querySelector('.btnhabilitar');
        habilitarBtn.addEventListener('click', function () {
          const codigoSucursal = this.getAttribute('data-id');
          const url = `/sucursal/modificarEstado/${codigoSucursal}`;
          const data = {
            estado: 'Activa'
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
  })
  .catch(error => console.error(error));

  const btnBusqueda = document.getElementById("iniciarBusqueda");
btnBusqueda.addEventListener("click", function () {
  const valorBusqueda = document.getElementById("buscador").value.toLowerCase();
  filtrarSucursales(valorBusqueda);
});
function filtrarSucursales(valorBusqueda) {
  const sucursales = document.querySelectorAll("#sucursalesDeshabilitadoTable tbody tr");
  sucursales.forEach(sucursal => {
    const nombre = sucursal.querySelector("td:nth-child(2)").textContent.toLowerCase();
    const descripcion = sucursal.querySelector("td:nth-child(3)").textContent.toLowerCase();
    const ubicacion = sucursal.querySelector("td:nth-child(4)").textContent.toLowerCase();
    if (nombre.indexOf(valorBusqueda) === -1 &&
        descripcion.indexOf(valorBusqueda) === -1 &&
        ubicacion.indexOf(valorBusqueda) === -1) {
      sucursal.style.display = "none";
    } else {
      sucursal.style.display = "";
    }
  });
}
const inputBusqueda = document.getElementById("buscador");
inputBusqueda.addEventListener("keyup", function () {
  const valorBusqueda = inputBusqueda.value.toLowerCase();
  filtrarSucursales(valorBusqueda);
});

  