fetch('/sucursal/listarSucursales')
    .then(response => response.json())
    .then(data => {
        // Obtener el select
        const select = document.getElementById("sucursalNuevo");

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


document.addEventListener("DOMContentLoaded", function () {

    fetch('/sucursal/listarSucursales')
        .then(response => response.json())
        .then(data => {
            //listar activos
            fetch('/planilla/listarPlanilla')
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


            if (rol == "Jefatura" || rol == "Proveeduría") {
                function cargarContenido(data, idSolicitado) {
                    var nombre = document.getElementById('nombre');
                    var cedula = document.getElementById('cedula');
                    var correo = document.getElementById('correo');
                    var telefono = document.getElementById('telefono');
                    var nacimiento = document.getElementById('nacimiento');
                    var sucursal = document.getElementById('sucursalNuevo');
                    var rol = document.getElementById('rolNuevo');

                    // Filtrar el activo con el ID solicitado
                    const planillaSolicitado = data.find(activo => activo._id === idSolicitado);

                    if (!planillaSolicitado) {
                        // Si no se encontró el activo solicitado, mostrar mensaje de error en la tabla
                        const row = table.insertRow();
                        const cell = row.insertCell();
                        cell.colSpan = 9;
                        cell.textContent = `No se encontró ningún activo con el ID ${idSolicitado}.`;
                    } else {
                        console.log(planillaSolicitado.nombre);
                        // Seleccionar el elemento input


                        // Agregar el placeholder
                        nombre.placeholder = planillaSolicitado.nombre;
                        cedula.placeholder = planillaSolicitado.cedula;
                        correo.placeholder = planillaSolicitado.correo;
                        telefono.placeholder = planillaSolicitado.telefono;
                        nacimiento.value = new Date(planillaSolicitado.nacimiento).toISOString().slice(0, 10);

                        const seleccionSucursal = document.getElementById("sucursalNuevo");
                        const options = seleccionSucursal.options;
                        for (let i = 0; i < options.length; i++) {
                            if (options[i].textContent === planillaSolicitado.sucursal) {
                                options[i].selected = true;
                                break;
                            }
                        }
                        const seleccionRol = document.getElementById("rolNuevo");
                        const opciones = seleccionRol.options;
                        for (let i = 0; i < opciones.length; i++) {
                            if (opciones[i].textContent === planillaSolicitado.rol) {
                                opciones[i].selected = true;
                                break;
                            }
                        }

                        const nombreNuevo = document.getElementById('nombre');
                        const cedulaNuevo = document.getElementById('cedula');
                        const correoNuevo = document.getElementById('correo');
                        const telefonoNuevo = document.getElementById('telefono');
                        const nacimientoNuevo = document.getElementById('nacimiento');
                        const sucursalNuevo = document.getElementById("sucursalNuevo");
                        const rolNuevo = document.getElementById("rolNuevo");

                        var nombre;
                        nombre = planillaSolicitado.nombre;
                        nombreNuevo.addEventListener('input', function () {
                            nombre = nombreNuevo.value;
                        });
                        var cedula;
                        cedula = planillaSolicitado.cedula;
                        cedulaNuevo.addEventListener('input', function () {
                            cedula = cedulaNuevo.value;
                        });
                        var correo;
                        correo = planillaSolicitado.correo;
                        correoNuevo.addEventListener('input', function () {
                            correo = correoNuevo.value;
                        });
                        var telefono;
                        telefono = planillaSolicitado.telefono;
                        telefonoNuevo.addEventListener('input', function () {
                            telefono = telefonoNuevo.value;
                        });
                        var nacimiento;
                        nacimiento = planillaSolicitado.nacimiento;
                        nacimientoNuevo.addEventListener('input', function () {
                            nacimiento = nacimientoNuevo.value;
                        });
                        var sucursal;
                        sucursal = planillaSolicitado.sucursal;
                        sucursalNuevo.addEventListener('change', function () {
                            sucursal = sucursalNuevo.selectedOptions[0].textContent;
                        });
                        var rol;
                        rol = planillaSolicitado.rol;
                        rolNuevo.addEventListener('change', function () {
                            rol = rolNuevo.selectedOptions[0].textContent;
                        });


                        // Agregar evento 'click' al botón de aceptar
                        const enviarCambio = document.getElementById('aceptar');
                        enviarCambio.addEventListener('click', function () {
                            if (nombre.value === "" || cedula.value === "" || correo.value === "" || telefono === "") {
                                alert("Por favor rellenar todos los campos");
                            }
                            const url = `/planillaEditar/planillaEditar/${idSolicitado}`;
                            const data = {
                                nombre: nombre,
                                cedula: cedula,
                                correo: correo,
                                telefono: telefono,
                                nacimiento: nacimiento,
                                sucursal: sucursal,
                                rol: rol
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
                                    window.location.href = 'planilla.html';
                                    // location.reload(); // Recargar la página después de modificar el estado
                                })
                                .catch(error => console.error(error));
                        });
                    }
                }
            }
        })
});