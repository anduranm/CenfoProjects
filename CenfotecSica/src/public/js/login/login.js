let btnlogin = document.getElementById("btnlogin");

btnlogin.addEventListener('click',submitloginform);

function submitloginform(){

    let email=document.getElementById("usuario").value;
    let password=document.getElementById("contraseña").value;
    
    fetch("/login/listarUsuarios")
    .then(function(data){
        return data.json();
    })
    .then(function(json){
        console.log(json.length);
        
        for (let i = 0; i < json.length; i++) {
            if (json[i].estado == "Activo" && email == json[i].correo && password == json[i].password) {
                localStorage.setItem("email", json[i].correo);
                localStorage.setItem("rol", json[i].rol);
                localStorage.setItem("nombre", json[i].nombre);
                localStorage.setItem("sucursal", json[i].sucursal);

                if (json[i].rol === "Inventario"){
                    window.location.href = '/html/activos.html';
                }else{
                    window.location.href = '/html/indexSica.html';
                }

            }
        }

    })

}

// document.addEventListener("DOMContentLoaded", function () {

//     fetch("/login/listarUsuarios")
//         .then(function (data) {
//             return data.json();
//         })
//         .then(function (json) {
//             console.log(json.length);
//             let email = localStorage.getItem("email");
//             let tipeUser = localStorage.getItem("rol");


//             for (let i = 0; i < json.length; i++) {
//                 if (json[i].correo == email && json[i].rol == tipeUser) {
//                     window.location.href = '/html/indexSica.html';

//                 }
//             }
//             console.log(email);
//         })


// });