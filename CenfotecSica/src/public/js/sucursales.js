fetch('/sucursal/listarSucursales')
  .then(response => response.json())
  .then(data => {
    // Obtener la tabla
    const table = document.getElementById("sucursalesTable").getElementsByTagName('tbody')[0];
    table.innerHTML = ''; // Limpiar la tabla

    // Crear una fila para cada sucursal
    data.forEach(sucursal => {
      if (sucursal.estado == "Activa") {

        const row = table.insertRow();
        var user =localStorage.getItem("rol");

        if (user == "Jefatura"){
          row.innerHTML = `
            <td>${sucursal._id}</td>
            <td>${sucursal.nombre}</td>
            <td>${sucursal.descripcion}</td>
            <td>${sucursal.ubicacion}</td>
            <td>${sucursal.fecha}</td>
            <td>${sucursal.estado}</td>
            <td><a href="editarSucursal.html?${sucursal._id}"><img class="editarBtn" src="../media/editar.png" alt="Editar"></a></td>
            <td><a href="#" class="deshabilitarBtn" data-id="${sucursal._id}"><img class="deshabilitarBtn" src="../media/deshabilitar.png" alt="Deshabilitar"></a></td>
          `;
        }else if(user == "Jefe de Proveeduría"){
          row.innerHTML = `
          <td>${sucursal._id}</td>
          <td>${sucursal.nombre}</td>
          <td>${sucursal.descripcion}</td>
          <td>${sucursal.ubicacion}</td>
          <td>${sucursal.fecha}</td>
          <td>${sucursal.estado}</td>
        `;
        }
        
        // Agregar evento 'click' al botón de deshabilitar
        const deshabilitarBtn = row.querySelector('.deshabilitarBtn');
        deshabilitarBtn.addEventListener('click', function () {
          const codigoSucursal = this.getAttribute('data-id');
          const url = `http://localhost:5000/sucursal/modificarEstado/${codigoSucursal}`;
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
  const sucursales = document.querySelectorAll("#sucursalesTable tbody tr");
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
