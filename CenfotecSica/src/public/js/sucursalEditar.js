
document.addEventListener("DOMContentLoaded", function () {

    fetch('/sucursal/listarSucursales')
        .then(response => response.json())
        .then(data => {
            //listar activos
            fetch('/sucursal/listarSucursales')
                .then(response => response.json())
                .then(data => {
                    const url = window.location.href;
                    const startIndex = url.indexOf("?") + 1;
                    const idSolicitado = url.substring(startIndex);

                    cargarContenido(data, idSolicitado);
                })
                .catch(error => console.error(error));
            // fin de listar activos

            //mantener sesion y filtrar usuarios

            let email = localStorage.getItem("email");
            let rol = localStorage.getItem("rol");

            if (rol == "Proveeduría") {

            }

            if (rol == "Jefatura") {
                function cargarContenido(data, idSolicitado) {
                    var nombre = document.getElementById('nombre');
                    var descripcion = document.getElementById('descripcion');
                    var ubicacion = document.getElementById('ubicacion');
                    var fecha = document.getElementById('fecha');
                    
                
                    // Filtrar el activo con el ID solicitado
                    const sucursalSolicitado = data.find(activo => activo._id === idSolicitado);

                    if (!sucursalSolicitado) {
                        // Si no se encontró el activo solicitado, mostrar mensaje de error en la tabla
                        const row = table.insertRow();
                        const cell = row.insertCell();
                        cell.colSpan = 9;
                        cell.textContent = `No se encontró ningún activo con el ID ${idSolicitado}.`;
                    } else {
                        console.log(sucursalSolicitado.nombre);
                        // Seleccionar el elemento input

                        // Agregar el placeholder
                        nombre.placeholder = sucursalSolicitado.nombre;
                        descripcion.placeholder = sucursalSolicitado.descripcion;
                        ubicacion.placeholder = sucursalSolicitado.ubicacion;
                        fecha.value = new Date(sucursalSolicitado.fecha).toISOString().slice(0, 10);

                        const nombreNuevo = document.getElementById('nombre');
                        const descripcionNuevo = document.getElementById('descripcion');
                        const ubicacionNuevo = document.getElementById('ubicacion');
                        const fechaNuevo = document.getElementById('fecha');
                       

                        var nombre;
                        nombre = sucursalSolicitado.nombre
                        nombreNuevo.addEventListener('input', function () {
                            nombre = nombreNuevo.value;
                        });
                        var descripcion;
                        descripcion = sucursalSolicitado.descripcion;
                        descripcionNuevo.addEventListener('input', function () {
                            descripcion = descripcionNuevo.value;
                        });
                        var ubicacion;
                        ubicacion = sucursalSolicitado.descripcion;
                        ubicacionNuevo.addEventListener('input', function () {
                            ubicacion = ubicacionNuevo.value;
                        });
                        var fecha;
                        fecha=sucursalSolicitado.fecha;
                        fechaNuevo.addEventListener('input', function () {
                            fecha = fechaNuevo.value;
                        });
                        
    
                        // Agregar evento 'click' al botón de aceptar
                        const enviarCambio = document.getElementById('aceptar');
                        enviarCambio.addEventListener('click', function () {
                            if (nombre.value==="" || descripcion.value==="" || ubicacion.value==="")
                            {
                                alert("Por favor rellenar todos los campos");
                            }
                            const url = `/sucursalEditar/sucursalEditar/${idSolicitado}`;
                            const data = {
                                nombre: nombre,
                                descripcion: descripcion,
                                ubicacion: ubicacion,
                                fecha: fecha,
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
                                    window.location.href = 'sucursales.html';
                                    // location.reload(); // Recargar la página después de modificar el estado
                                })
                                .catch(error => console.error(error));
                        });
                    }
                }
            }
        })
});