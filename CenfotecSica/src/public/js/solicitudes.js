document.addEventListener("DOMContentLoaded", function () {
  const select = document.getElementById("despliegueSucursal");
  select.addEventListener("change", function () {
    const valorSucursal = select.selectedOptions[0].textContent;
    const valorSeleccionado = parseInt(Filtro.value);

    fetch(`/activo/listarActivos?filtro=${valorSeleccionado}&sucursal=${valorSucursal}`)
      .then(response => response.json())
      .then(data => cargarTabla(data, valorSeleccionado, valorSucursal))
      .catch(error => console.error(error));
  });

  //inicio
const btnBusqueda = document.getElementById("iniciarBusqueda");
btnBusqueda.addEventListener("click", function () {
  const valorBusqueda = document.getElementById("buscador").value.toLowerCase();
  filtrarActivos(valorBusqueda);
});

function filtrarActivos(valorBusqueda) {
  const activos = document.querySelectorAll("#solicitudesTable tbody tr");
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
//fin de buscador

  const table = document.getElementById("solicitudesTable").getElementsByTagName('tbody')[0];
  const Filtro = document.getElementById("filtroSolicitudes");

  Filtro.addEventListener("change", function () {
    const valorSeleccionado = parseInt(Filtro.value);
    const valorSucursal = select.selectedOptions[0].textContent;

    fetch(`/activo/listarActivos?filtro=${valorSeleccionado}&sucursal=${valorSucursal}`)
      .then(response => response.json())
      .then(data => cargarTabla(data, valorSeleccionado, valorSucursal))
      .catch(error => console.error(error));
  });

  fetch('/activo/listarActivos')
    .then(response => response.json())
    .then(data => cargarTabla(data, parseInt(Filtro.value), select.selectedOptions[0].textContent))
    .catch(error => console.error(error));

  function cargarTabla(data, valorSeleccionado, valorSucursal) {
    table.innerHTML = ''; // Limpiar la tabla


    // Obtener información del usuario
  var user = localStorage.getItem("rol");
  var sucursalUser = localStorage.getItem("sucursal");
  
  if(user === "Jefatura" || user === "Jefe de Proveeduría"){
    data = data.filter(activo => {
      if (valorSucursal === "Ver Todas" || activo.sucursal === valorSucursal) {
        switch (valorSeleccionado) {
          case 1:
            return activo.tipo === "Activo" && activo.estado == "Procesando";
          case 2:
            return activo.tipo === "Donacion" && activo.estado == "Procesando";
          default:
            return true;
        }
      } else {
        return false;
      }
    });
  }else if(user === "Inventario" || user === "Proveeduría"){
    data = data.filter(activo => {
      if (valorSucursal === sucursalUser || activo.sucursal === sucursalUser) {
        switch (valorSeleccionado) {
          case 1:
            return activo.tipo === "Activo" && activo.estado == "Procesando";
          case 2:
            return activo.tipo === "Donacion" && activo.estado == "Procesando";
          default:
            return true;
        }
      } else {
        return false;
      }
    });
    };

    

    data.forEach(activo => {
      if (activo.estado == "Procesando") {
        const row = table.insertRow();
        row.innerHTML = `
        <td>${activo._id}</td>
        <td>${activo.nombre}</td>
        <td>${activo.descripcion}</td>
        <td>${activo.posicion}</td>
        <td>${activo.sucursal}</td>
        <td>${activo.tipo}</td>
        <td>${activo.coment}</td>
        <td><a href="#" class="btnAceptar" data-id="${activo._id}"><img src="../media/check.png" alt="Aceptar"></a></td>
        <td><a href="" class="btnRechazar" data-id="${activo._id}"><img src="../media/X icon.png" alt="Rechazar"></a></td>
      `;
      }



      let paraEliminar = {
        _id: activo._id,
        nombre: activo.nombre,
        descripcion: activo.descripcion,
        posicion: activo.posicion,
        estado: activo.estado,
        sucursal: activo.sucursal,
        tipo: activo.tipo,
        coment: activo.coment,
        sucursalProvisional: activo.sucursalProvisional,
      }


      // Agregar evento 'click' al botón de aceptar
      const btnAceptar = document.querySelectorAll('.btnAceptar');
      btnAceptar.forEach(aceptar => {
        aceptar.addEventListener('click', function () {
          const codigoActivo = this.getAttribute('data-id');
          const url = `/activo/modificarEstado/${codigoActivo}`;
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



        // Agregar evento 'click' al botón de eliminar
        const btnRechazar = document.querySelectorAll('.btnRechazar');
        btnRechazar.forEach(rechazar => {
          rechazar.addEventListener('click', function () {
            const codigoUsuario = this.getAttribute('data-id');
            const url = `/activo/rechazarActivo/` + paraEliminar._id;

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


            console.log(data);
          });
        })
      })
    })
  }
});
