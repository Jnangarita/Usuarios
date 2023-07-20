// la función DataTable() selecciona la tabla y la convierte en una tabla que tenga paginación y otras funciones

// (document).ready(function() se usa para decirle al navegador que ejecute el método
// luego de cargar la página
$(document).ready(function() {
   loadUser();
  $('#userTable').DataTable();
});

// para hacer un llamado al servidor se tiene que utilizar la función fetch que es la siguiente
async function loadUser(){// async se utiliza junto a await
    // await espera el resultado del llamado fetch, cuando termina lo guarda en la variable request
    const request = await fetch('api/usuarios', { // URL del método que se va a llamar en el controlador
      method: 'GET',
      headers: {
        'Accept': 'application/json',// indica que va a utilizar json
        'Content-Type': 'application/json', // indica que el contenido va a ser json
      }
    });
    const userList = await request.json(); // resultado de la variable request convertida a json

    console.log(userList);

    let listHTML = '';
    for(let user of userList){
        let userHTML = '<tr><td>'+ user.id +'</td><td>'+ user.name +' '+ user.lastName +'</td><td>'+ user.email +'</td><td>'+ user.phone +'</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>'

        listHTML += userHTML;
    }

    document.querySelector('#userTable tbody').outerHTML = listHTML;
}