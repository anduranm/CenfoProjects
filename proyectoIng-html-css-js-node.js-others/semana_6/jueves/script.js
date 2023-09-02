// Numero de enlaces de la pagina
var link = document.getElementsByTagName("a");
var i = 0;

console.log("Cantidad de links: " + link.length );

while (i < link.length) {
   console.log(i+1 +" "+link[i]);
   i++;
}


// Penultimo Link
console.log("Penultimo link: " + link[link.length-2]);

//numero de enlaces que enlazan a prueba  2 metosdos 
// metodos de desempeño 
// metodo 1 solo contar y aumentar variable 
var j=0;
var acumulador=0;
while (j < link.length) {
   if (link[j].href==="http://prueba/"){
      acumulador++;
   }
   j++;
}

console.log("Links a https://prueba/: " + acumulador);

// metodo 2 mandar a linkprueba todos los elementos que mantienen esa condicion para poder usar todos las propiedades y metodos del objeto.

var linkPrueba = document.querySelectorAll("a[href='http://prueba/']");

console.log("La cantidad de enlaces que enlanzan a https://prueba/  " + linkPrueba.length);

// Numero de enlaces del tercer parrafo
var parrafo3 = document.getElementsByTagName("p")[2];
var numeroDelElementosA = parrafo3.getElementsByTagName("a").length;

console.log("El tercer párrafo tiene " + numeroDelElementosA + " elementos 'a'.");

// operacion
var botonOperacion = document.getElementById("botonOperacion");
var selectorOperation = document.getElementById("selectOperacion");
var operacionValor = selectorOperation.value;

selectorOperation.addEventListener("change", function(){
   operacionValor = selectorOperation.value;
});

botonOperacion.addEventListener("click", function(){
   operacion();
});

function operacion (){ //scope 
   var a = document.getElementById("numeroA").value;
   var b = document.getElementById("numeroB").value;
   var resultado = document.getElementById("resultado");

   a = parseInt(a);
   b = parseInt(b);


   switch (operacionValor){
      case "sumar":
         resultado.value = sumar(a,b);
         break;
      case "restar":
         resultado.value = restar(a,b);
         break;
      case "multiplicar":
         resultado.value = multiplicar(a,b);
         break;
      case "dividir":
         resultado.value = dividir(a,b);
         break;
   }
}

function sumar(a,b){
   return a + b;
}function restar(a,b){
   return a - b;
}function dividir(a,b){
   return a / b;
}function multiplicar(a,b){
   return a * b;
}


