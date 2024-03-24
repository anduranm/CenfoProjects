fetch('/planilla/listarPlanilla')
    .then(response => response.json())
    .then(data => {

        const url = window.location.href; // Obtener la URL actual
        const startIndex = url.indexOf("?") + 1; // Encontrar el índice del primer carácter después del '?'
        const idUrl = url.substring(startIndex, startIndex + 24); // Leer los primeros 24 caracteres después del '?'
        const contrasena = document.getElementById('contraseña');
        const confirmacionContrasena = document.getElementById('contraseñaConfirmacion');
        const restablecerBtn = document.querySelector('.restablece');
        restablecerBtn.addEventListener('click', function () {
            if (contrasena.value !== confirmacionContrasena.value) {
                alert('Las contraseñas no coinciden');
                return;
            }
            const id = idUrl; // Set the id variable to the idUrl
            const url = `/planilla/modificarContrasena/${id}`; // Fix the URL
            const data = {
                password: contrasena.value // Add the new password to the data object
            };

            fetch(url, {
                method: 'PUT',
                body: JSON.stringify(data),
                headers: {
                    'Content-Type': 'application/json'
                }
            })
                .then(function (response) {
                    return response.json();
                })
                .then(function (data) {
                    alert('Contraseña modificada exitosamente');
                    window.location.href = 'inicio.html';
                })
                .catch(function (error) {
                    console.error(error);
                    alert('Error al modificar la contraseña');
                });
        });

    });


document.addEventListener("DOMContentLoaded", function () {

    fetch("/login/listarUsuarios")
        .then(function (data) {
            return data.json();
        })
        .then(function (json) {
            console.log(json.length);
            let email = localStorage.getItem("email");
            let tipeUser = localStorage.getItem("rol");


            for (let i = 0; i < json.length; i++) {
                if (json[i].correo == email && json[i].rol == tipeUser) {
                    window.location.href = '/html/indexSica.html';

                }
            }
            console.log(email);
        })


});