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