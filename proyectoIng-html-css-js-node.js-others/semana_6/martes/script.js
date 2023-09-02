var nombre = "Andres";
var apellido = "Duran";
var edad = "22";
console.log("Mi nombre es: ");
console.log(nombre + " " +apellido);

// var parrafos = document.getElementsByTagName("p");
// console.log(parrafos);

var carros = ["Lexus", "Susuki", "Toyota"];
var cont0 = 0;
while (cont0 < carros.length){
    console.log("El carro es marca "+ carros [cont0]);
    cont0++;
}

var parrafos = document.getElementsByTagName("h1");
var cont1 = 0;

while (cont1 < parrafos.length) {
   console.log(parrafos[cont1]);
   cont1++;
}

var parrafos = document.getElementsByTagName("p");
 var cont2 = 0;

 while (cont2 < parrafos.length) {
    console.log(parrafos[cont2]);
    cont2++;
 }

 var parrafos = document.getElementsByTagName("p");
 var cont3 = 0;
 console.log("Impresion por TagName");
 while (cont3 < parrafos.length){
    console.log(parrafos[cont3]);
    cont3++;
 }


console.log("Impresion por ID");
var linkGoogle = document.getElementById("linkGoogle");
linkGoogle.href = "https://facebook.com";
console.log(linkGoogle.target);
linkGoogle.classList.remove("sin-decoracion");
linkGoogle.classList.add("texto-rojo");