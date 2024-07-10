
/************** CONSUMO API DE PELICULAS *************/

document.addEventListener("DOMContentLoaded", function() {
  function ejecutar(parametro) {
      const path = "https://image.tmdb.org/t/p/original/";
      const contenedor = document.getElementById("contenedorPeliculas");
      const API_KEY = "6ef51d843bfe08d642d218c1c25c2915";
      const URL_API = `https://api.themoviedb.org/3/search/movie?api_key=${API_KEY}&language=es-ES&query=${parametro}`;

      fetch(URL_API)
          .then((respuesta) => {
              if (!respuesta.ok) {
                  throw new Error('Error en la solicitud de la API');
              }
              return respuesta.json();
          })
          .then((resultado) => {
              console.log(resultado);
              contenedor.innerHTML = "";
              resultado.results.forEach(pelicula => {
                  if (pelicula.poster_path) {
                      const tarjeta = document.createElement('div');
                      tarjeta.id = 'tarjeta';
                      
                      const contenedorImagen = document.createElement('div');
                      contenedorImagen.id = 'contenedorImagen';
                      const imagen = document.createElement('img');
                      imagen.src = `${path}${pelicula.poster_path}`;
                      imagen.id = 'imagen';
                      contenedorImagen.appendChild(imagen);

                      const texto = document.createElement('div');
                      texto.id = 'texto';
                      const p = document.createElement('p');
                      p.textContent = pelicula.title;
                      texto.appendChild(p);

                      tarjeta.appendChild(contenedorImagen);
                      tarjeta.appendChild(texto);
                      contenedor.appendChild(tarjeta);
                  }
              });
          })
          .catch((error) => {
              console.error('Error:', error);
          });
  }

  ejecutar("lo ultimo");
});

/************** FUNCION MOSTAR DATOS DE LA DB *************/
document.addEventListener("DOMContentLoaded", function() {
    obtenerDatosTabla(); 
});

function obtenerDatosTabla() {
    const url = 'http://localhost:9001/movies';

    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json(); 
        })
        .then(data => {
            console.log('Datos recibidos:', data);
            actualizarTablaHTML(data); 
        })
        .catch(error => {
            console.error('Error en la solicitud:', error);
        });
}

function actualizarTablaHTML(data) {
    const tbody = document.querySelector('.tbody'); 

    
    tbody.innerHTML = '';

    
    data.forEach((item, index) => {

        const fila = document.createElement('tr'); 
        
        const celdaId = document.createElement('td');
        celdaId.textContent = index + 1; 
        
        const celdaTitulo = document.createElement('td');
        celdaTitulo.textContent = item.nombre; 

        const celdaDescripcion = document.createElement('td');
        celdaDescripcion.textContent = item.descripcion; 

        const celdaGenero = document.createElement('td');
        celdaGenero.textContent = item.genero; 

        const celdaCalificacion = document.createElement('td');
        celdaCalificacion.textContent = item.calificacion; 

        const celdaEstrella = document.createElement('td');
        celdaEstrella.textContent = convertirEstrellas(item.estrella);

        const celdaAnio = document.createElement('td');
        celdaAnio.textContent = item.anio; 

        const celdaDirector = document.createElement('td');
        celdaDirector.textContent = item.director; 

        
        fila.appendChild(celdaId);
        fila.appendChild(celdaTitulo);
        fila.appendChild(celdaDescripcion);
        fila.appendChild(celdaGenero);
        fila.appendChild(celdaCalificacion);
        fila.appendChild(celdaEstrella);
        fila.appendChild(celdaAnio);
        fila.appendChild(celdaDirector);

        
        tbody.appendChild(fila);


    });
}

function convertirEstrellas(numEstrellas) {
    let estrellas = '';
    for (let i = 0; i < numEstrellas; i++) {
        estrellas += '★';
    }
    return estrellas;
}

let buscarPelicula = document.getElementById("lupa");

buscarPelicula.addEventListener("click", function(event) {
    obtenerDatosTabla(); 
    mostrarContenedor();
});


function mostrarContenedor() {
    var contenedorPeliculas = document.getElementById("contenedorPeliculas");
    var contenedorTabla = document.querySelector(".tbody");

    if (contenedorTabla) { 
        if (contenedorPeliculas.style.display == "flex" || contenedorPeliculas.style.display == "") {
            contenedorPeliculas.style.display = "none";
            contenedorTabla.classList.toggle("active");
        } else {
            contenedorPeliculas.style.display = "flex";
            contenedorTabla.classList.toggle("active");
        }
    } else {
        console.error('No se encontró el elemento con clase "tbody"');
    }
}
