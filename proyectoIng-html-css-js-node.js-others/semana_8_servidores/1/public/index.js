fetch("heroes.json")
      .then(function(response){
        return response.json();
      })
      .then(function(data){
        // Código custom
        for(var i=0; i<data.length; i++) {
          var fila = "<li>"+data[i].superhero+"</li>";
          document.getElementById("heroes").insertAdjacentHTML("beforeend", fila);
        }
      });