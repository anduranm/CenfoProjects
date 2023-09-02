document.addEventListener("DOMContentLoaded", function () {

  fetch('/planilla/listarplanilla')
    .then(response => response.json())
    .then(data => cargarTabla(data, 0, select.selectedOptions[0].textContent))
    .catch(error => console.error(error));
});

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
    if (usuario.estado == "Procesando") {

      const row = table.insertRow();

      row.innerHTML = `
      <td>${usuario._id}</td>
      <td>${usuario.rol}</td>
      <td>${usuario.sucursal}</td>
      <td>${usuario.nombre}</td>
      <td>${usuario.cedula}</td>
      <td>${usuario.correo}</td>
     
      <td><a href="#" class="btnAceptar" data-id="${usuario._id}"><img src="../media/check.png" alt="Aceptar"></a></td>
      <td><a href="" class="btnRechazar" data-id="${usuario._id}"><img src="../media/X icon.png" alt="Rechazar"></a></td>
      `;

      let paraEliminar = {
        _id: usuario._id,
        nombre: usuario.nombre,
        cedula: usuario.cedula,
        correo: usuario.correo,
        telefono: usuario.telefono,
        nacimiento: usuario.nacimiento,
        sucursal: usuario.sucursal,
        rol: usuario.rol,
        estado: usuario.estado,
        password: usuario.password,
      }
      console.log(paraEliminar);


      // Agregar evento 'click' al botón de aceptar
      const btnAceptar = document.querySelectorAll('.btnAceptar');
      btnAceptar.forEach(aceptar => {
        aceptar.addEventListener('click', function () {
          const codigoUsuario = this.getAttribute('data-id');
          const url = `/planilla/aceptarUsuario/${codigoUsuario}`;
          const data = {
            estado: 'Activo',
            nombre: usuario.nombre,
            correo: usuario.correo,
            password: usuario.password,
            _id: usuario._id,
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

        
        
        // Agregar evento 'click' al botón de eliminar
        const btnRechazar = document.querySelectorAll('.btnRechazar');
        btnRechazar.forEach(rechazar => {
          rechazar.addEventListener('click', function () {
            const codigoUsuario = this.getAttribute('data-id');
            const url = `/planillaSolicitudes/rechazarUsuario/`+paraEliminar._id;
            
          fetch(url, {
            method: 'DELETE',
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(paraEliminar) // la var de arriba data
          })
          .then(response => response.json())
          .then(result => {
            console.log(result);
            location.reload(); // Recargar la página después de eliminar el usuario
          })
          .catch(error => console.error(error));
        });




      });
        
        
      });
    }

  });
}
