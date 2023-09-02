document.addEventListener("DOMContentLoaded", function () {

  fetch('/sucursal/listarSucursales')
    .then(response => response.json())
    .then(data => {
      //listar activos
      fetch('/activo/listarActivos')
        .then(response => response.json())
        .then(data => {
          const url = window.location.href;
          const startIndex = url.indexOf("?") + 1;
          const idSolicitado = url.substring(startIndex);

          cargarTabla(data, idSolicitado);
        })
        .catch(error => console.error(error));
      // fin de listar activos

      // Obtener el select
      const select = document.getElementById("elegirSucursal");

      // Agregar la opción de Ver Todas
      const verTodas = document.createElement("option");
      verTodas.value = "0";
      verTodas.textContent = "Elegir Sucursal";
      verTodas.selected = true;
      verTodas.disabled = true;
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
  //mantener sesion y filtrar usuarios


  let email = localStorage.getItem("email");
  let rol = localStorage.getItem("rol");

  if (rol == "Proveeduría" || rol == "Inventario") {
    function cargarTabla(data, idSolicitado, valorSucursal) {
      const table = document.getElementById("activoMover").getElementsByTagName('tbody')[0];
      table.innerHTML = ''; // Limpiar la tabla

      // Filtrar el activo con el ID solicitado
      const activoSolicitado = data.find(activo => activo._id === idSolicitado);

      if (!activoSolicitado) {
        // Si no se encontró el activo solicitado, mostrar mensaje de error en la tabla
        const row = table.insertRow();
        const cell = row.insertCell();
        cell.colSpan = 9;
        cell.textContent = `No se encontró ningún activo con el ID ${idSolicitado}.`;
      } else {
        // Crear una fila para el activo solicitado
        const row = table.insertRow();

        row.innerHTML = `
        <td>${activoSolicitado._id}</td>
        <td>${activoSolicitado.nombre}</td>
        <td>${activoSolicitado.descripcion}</td>
        <td>${activoSolicitado.posicion}</td>
        <td>${activoSolicitado.sucursal}</td>
        <td>${activoSolicitado.tipo}</td>
      `;

        const sucursalElegidaElement = document.getElementById("elegirSucursal");
        const comentario = document.getElementById("comentario").value;

        var sucursalElegida;
        sucursalElegidaElement.addEventListener('change', function () {
          sucursalElegida = sucursalElegidaElement.selectedOptions[0].textContent;
        });

        // Agregar evento 'click' al botón de aceptar
        const enviarCambio = document.getElementById('aceptar');
        enviarCambio.addEventListener('click', function () {
          const url = `/activo/modificarEstadoMovimientoSolicitud/${idSolicitado}`;
          const data = {
            estado: 'Procesando movimiento',
            sucursalProvisional: sucursalElegida,
            coment: comentario,
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
              window.location.href = 'activos.html';
              // location.reload(); // Recargar la página después de modificar el estado
            })
            .catch(error => console.error(error));
        });
      }
    }
  }
  if (rol == "Jefatura" || rol == "Jefe de Proveeduría") {
    function cargarTabla(data, idSolicitado, valorSucursal) {
      const table = document.getElementById("activoMover").getElementsByTagName('tbody')[0];
      table.innerHTML = ''; // Limpiar la tabla

      // Filtrar el activo con el ID solicitado
      const activoSolicitado = data.find(activo => activo._id === idSolicitado);

      if (!activoSolicitado) {
        // Si no se encontró el activo solicitado, mostrar mensaje de error en la tabla
        const row = table.insertRow();
        const cell = row.insertCell();
        cell.colSpan = 9;
        cell.textContent = `No se encontró ningún activo con el ID ${idSolicitado}.`;
      } else {
        // Crear una fila para el activo solicitado
        const row = table.insertRow();

        row.innerHTML = `
        <td>${activoSolicitado._id}</td>
        <td>${activoSolicitado.nombre}</td>
        <td>${activoSolicitado.descripcion}</td>
        <td>${activoSolicitado.posicion}</td>
        <td>${activoSolicitado.sucursal}</td>
        <td>${activoSolicitado.tipo}</td>
      `;

        const sucursalElegidaElement = document.getElementById("elegirSucursal");
        const comentario = document.getElementById("comentario").value;

        var sucursalElegida;
        sucursalElegidaElement.addEventListener('change', function () {
          sucursalElegida = sucursalElegidaElement.selectedOptions[0].textContent;
        });

        // Agregar evento 'click' al botón de aceptar
        const enviarCambio = document.getElementById('aceptar');
        enviarCambio.addEventListener('click', function () {
          const url = `/activo/modificarEstadoMovimiento/${idSolicitado}`;
          const data = {
            estado: 'En movimiento',
            sucursal: sucursalElegida,
            coment: comentario,
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
              window.location.href = 'activos.html';
              // location.reload(); // Recargar la página después de modificar el estado
            })
            .catch(error => console.error(error));
        });
      }
    }
  }
});

  // console.log(email);
  // console.log(rol);




