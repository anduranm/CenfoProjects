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
    const activos = document.querySelectorAll("#activosDeshabilitadoTable tbody tr");
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
  
//fin

  const select = document.getElementById("despliegueSucursal");
  select.addEventListener("change", function () {
    const valorSucursal = select.selectedOptions[0].textContent;
    fetch(`/activo/listarActivos?sucursal=${valorSucursal}`)
      .then(response => response.json())
      .then(data => cargarTabla(data, 0, valorSucursal))
      .catch(error => console.error(error));
  });
  
  function cargarTabla(data, valorSeleccionado, valorSucursal) {
    const table = document.getElementById("activosDeshabilitadoTable").getElementsByTagName('tbody')[0];
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
      if (activo.estado == "Inhabilitado") {

        const row = table.insertRow();

        row.innerHTML = `
        <td>${activo._id}</td>
        <td>${activo.nombre}</td>
        <td>${activo.descripcion}</td>
        <td>${activo.posicion}</td>
        <td>${activo.sucursal}</td>
        <td>${activo.tipo}</td>
        <td><a href=""><button class="btnHabilitar btnSucursal" data-id="${activo._id}">Habilitar</button></a></td>
        `;

         // Agregar evento 'click' al botón de deshabilitar
        const habilitarBtn = row.querySelector('.btnhabilitar');
        habilitarBtn.addEventListener('click', function () {
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
      }

    });
  }
  