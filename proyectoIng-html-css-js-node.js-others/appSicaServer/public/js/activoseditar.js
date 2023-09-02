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

                    cargarContenido(data, idSolicitado);
                })
                .catch(error => console.error(error));
            // fin de listar activos

        
                 function cargarContenido(data, idSolicitado, valorSucursal) {
                   var nombre = document.getElementById('nombreactivo');
                   var descripcion = document.getElementById('descripcion');
                   var posicion = document.getElementById('posicionfisica');
                   var comentario = document.getElementById('coment');

                    // Filtrar el activo con el ID solicitado
                    const activoSolicitado = data.find(activo => activo._id === idSolicitado);

                    if (!activoSolicitado) {
                        // Si no se encontró el activo solicitado, mostrar mensaje de error en la tabla
                        const row = table.insertRow();
                        const cell = row.insertCell();
                        cell.colSpan = 9;
                        cell.textContent = `No se encontró ningún activo con el ID ${idSolicitado}.`;
                    } else {
                            console.log(activoSolicitado.nombre);
                        // Seleccionar el elemento input
                        

                        // Agregar el placeholder
                        nombre.placeholder = activoSolicitado.nombre;
                        descripcion.placeholder =activoSolicitado.descripcion;
                        posicion.placeholder = activoSolicitado.posicion;
                        comentario.placeholder = activoSolicitado.coment;

                        const cambiarNombre = document.getElementById("nombreactivo");
                        const descripcionNuevo = document.getElementById("descripcion");
                        const posicionNuevo = document.getElementById("posicionfisica");
                        const comentarioNuevo = document.getElementById('coment')

                        var nombre;
                        nombre = activoSolicitado.nombre;
                        cambiarNombre.addEventListener('input', function (){
                            nombre = cambiarNombre.value;
                        });
                        var descripcion;
                        descripcion = activoSolicitado.descripcion;
                        descripcionNuevo.addEventListener('input', function(){
                            descripcion= descripcionNuevo.value;
                        });
                        var posicion;
                        posicion = activoSolicitado.posicion;
                        posicionNuevo.addEventListener('input', function(){
                            posicion= posicionNuevo.value;
                        });
                        var comentario;
                        comentario = activoSolicitado.coment;
                        comentarioNuevo.addEventListener('input', function () {
                            comentario = comentarioNuevo.value;
                        });
                       

                        // Agregar evento 'click' al botón de aceptar
                        const enviarCambio = document.getElementById('aceptar');
                        enviarCambio.addEventListener('click', function () {
                            const url = `/activoeditar/activoeditar/${idSolicitado}`;
                            const data = {
                                nombre: nombre,
                                descripcion: descripcion,
                                posicion: posicion,
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
            
        })
});