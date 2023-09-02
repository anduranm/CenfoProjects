fetch("/heroes/listar")
.then(function(data){
  return data.json();
})
.then(function(json){
  console.log(json);
})