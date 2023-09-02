document.addEventListener("DOMContentLoaded", function () {

  fetch('/activo/listarActivos')
    .then(response => response.json())
    .then(data => cargarTabla(data, 0, select.selectedOptions[0].textContent))
    .catch(error => console.error(error));
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
  const table = document.getElementById("activosMovimientos").getElementsByTagName('tbody')[0];
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
    if (activo.estado == "En movimiento") {

      const row = table.insertRow();

      row.innerHTML = `
        <td>${activo._id}</td>
        <td>${activo.nombre}</td>
        <td>${activo.descripcion}</td>
        <td>${activo.posicion}</td>
        <td>${activo.sucursal}</td>
        <td>${activo.tipo}</td>
        <td><a href="#" class="btnAceptar" data-id="${activo._id}"><img src="../media/check.png" alt="Aceptar"></a></td>
        `;
    }
    
    // Agregar evento 'click' al botón de aceptar
    const btnAceptar = document.querySelectorAll('.btnAceptar');
    btnAceptar.forEach(aceptar => {
      aceptar.addEventListener('click', function () {
        const codigoActivo = this.getAttribute('data-id');
        const url = `/activo/modificarEstado/${codigoActivo}`;
        const data = {
          estado: 'Activa',
          
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


  })
})};
