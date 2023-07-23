$(document).ready(function() {
    // TO-DO
});

async function registerUser(){
    let userData = {};
    userData.name = document.getElementById('txtName').value;
    userData.lastName = document.getElementById('txtLastName').value;
    userData.email = document.getElementById('txtEmail').value;
    userData.password = document.getElementById('txtPassword').value;

    let txtConfirmPassword = document.getElementById('txtConfirmPassword').value;

    if(userData.password != txtConfirmPassword){
        alert("Las contraseñas no coinciden. Intentalo Nuevamente");
        return;
    }
    const request = await fetch('api/usuarios', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(userData)// toma cualquier objeto js y lo convierte a un String de JSON
    });
    const userList = await request.json();
}