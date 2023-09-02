/* Var es para variables que nunca cambian*/
var middle = [
  {
    'src' : 'img/blog1.jpg',
    'title' : '7 Places you need to visit again',
    'author' : 'Andres Duran',
  },
  {
    'src' : 'img/blog2.jpg',
    'title' : 'The once in a lifetime experience',
    'author' : 'Mike Salas',
  },
];
var final = [
  'img/instagram1.jpg',
  'img/instagram2.jpg',
  'img/instagram3.jpg',
  'img/instagram4.jpg',
  'img/instagram5.jpg',
  'img/instagram6.jpg', 
];
/*const son variables tipo cache se reservan en cache y nunca cambia*/ 
const imagesContainer = document.getElementById("imagesAjson");
/*let son variables temporales y se usan para for cosas que solo son momentaneas */
for (let i = 0; i < middle.length; i++){
  let containerDiv = document.createElement('div');
  // Creacion de elementos HTML en javascript
  let image = document.createElement('img');
  let title = document.createElement('h2');
  let author = document.createElement('p');
  
  // Añadir clases
  containerDiv.classList.add('middleItem');
  image.classList.add('middleItemImg');
  title.classList.add('middleItemTitle');
  author.classList.add('middleItemAuthor');

  // Insertar la fuente de la imagen desde json
  image.src = middle[i].src;
  
  // Insertar textos desde json
  title.innerText = middle[i].title;
  author.innerHTML = "by " + middle[i].author;
  
  containerDiv.append(image);
  containerDiv.append(title);
  containerDiv.append(author);
  
  imagesContainer.append(containerDiv);
}

const imagesContain2 = document.getElementById("imagesBjson");
for (var i = 0; i < final.length; i++){
  let containerDiv2 = document.createElement('div');
  let image = document.createElement('img');

  containerDiv2.classList.add('finalItem');
  image.classList.add('finalItemImg');
  image.src = final[i];

  //apepnd inserta el elemento al final mientras que 
  // preppend  los agrega antes pero en estos casos no se usa
  containerDiv2.append(image);
  imagesContain2.append(containerDiv2);
}