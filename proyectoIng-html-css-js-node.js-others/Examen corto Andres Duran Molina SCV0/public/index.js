
fetch('/recetas/listar')
  .then(response => response.json())
  .then(data => {
    // Obtener la tabla
    const table = document.getElementById("recetasTable").getElementsByTagName('tbody')[0];
    table.innerHTML = ''; // Limpiar la tabla

    // Crear una fila para cada food
    data.forEach(food => {

      const row = table.insertRow();

      row.innerHTML = `
        <td>${food.name}</td>
        <td>${food.ingre1}</td>
        <td>${food.ingre2}</td>
        <td>${food.ingre3}</td>
        <td>${food.ingre4}</td>
        <td>${food.ingre5}</td>
        <td>${food.ingre6}</td>
        <td>${food.ingre7}</td>
        <td>${food.ingre8}</td>
        <td>${food.precio}</td>
      `;
    });
    console.log(data);
  })
  .catch(error => console.error(error)
  );

  
function insertar() {

  var nombre = document.getElementById("nombre");
  var precio = document.getElementById("precio");

  var ingre1 = document.querySelector('input[name="ingre1"]:checked');
var ingre2 = document.querySelector('input[name="ingre2"]:checked');
var ingre3 = document.querySelector('input[name="ingre3"]:checked');
var ingre4 = document.querySelector('input[name="ingre4"]:checked');
var ingre5 = document.querySelector('input[name="ingre5"]:checked');
var ingre6 = document.querySelector('input[name="ingre6"]:checked');
var ingre7 = document.querySelector('input[name="ingre7"]:checked');
var ingre8 = document.querySelector('input[name="ingre8"]:checked');

if (!ingre1 || !ingre2 || !ingre3 || !ingre4 || !ingre5 || !ingre6 || !ingre7 || !ingre8) {
  Swal.fire({
    title: 'Error',
    text: 'Faltan ingredientes por marcar',
    icon: 'error',
    confirmButtonText: 'Ok'
  });
}

  // Validar que se haya ingresado un nombre y un precio
  if (nombre.value === '') {
    Swal.fire({
      title: 'Error',
      text: 'El campo de nombre no puede estar vacío',
      icon: 'error',
      confirmButtonText: 'Ok'
    });
    return;
  }

  if (precio.value === '') {
    Swal.fire({
      title: 'Error',
      text: 'El campo de precio no puede estar vacío',
      icon: 'error',
      confirmButtonText: 'Ok'
    });
    return;
  }


  data = {
    name: document.getElementById("nombre").value,
    ingre1: document.querySelector('input[name="ingre1"]:checked').value,
    ingre2: document.querySelector('input[name="ingre2"]:checked').value,
    ingre3: document.querySelector('input[name="ingre3"]:checked').value,
    ingre4: document.querySelector('input[name="ingre4"]:checked').value,
    ingre5: document.querySelector('input[name="ingre5"]:checked').value,
    ingre6: document.querySelector('input[name="ingre6"]:checked').value,
    ingre7: document.querySelector('input[name="ingre7"]:checked').value,
    ingre8: document.querySelector('input[name="ingre8"]:checked').value,
    precio: document.getElementById("precio").value,
  }



  fetch('recetas/insertar', {
    method: 'post',
    headers: { 'Accept': 'application/json, text/plain, */*', 'Content-Type': 'application/json' },
    body: JSON.stringify(data)
  })
    .then(function (response) {
      return response.json();
    })
    .then(function (json) {
      location.reload();
    })
}


