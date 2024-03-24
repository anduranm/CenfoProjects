function insertar() {
      var nombre = document.getElementById("nombre").value;
      var descripcion = document.getElementById("descripcion").value;
      var ubicacion = document.getElementById("ubicacion").value;
      var fecha = document.getElementById("fecha").value;
      var estado = "Activa";
     
    
      // Validar campos obligatorios
      if (nombre === '' || descripcion === '' || ubicacion === '') {
        alert('Por favor complete todos los campos obligatorios.');
        return;
      }
    
      var xhr = new XMLHttpRequest();
      xhr.open("POST", "/nuevasucursal/insertarSucursales", true);
      xhr.setRequestHeader("Content-Type", "application/json");
    
      xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
          console.log(xhr.responseText);
          window.location.href = "http://localhost:5000/html/sucursales.html";
        }
      };

      var data = JSON.stringify({
        nombre: nombre,
        descripcion: descripcion,
        ubicacion: ubicacion,
        fecha: fecha,
        estado: estado,
      });
    
      xhr.send(data);
    }
    

