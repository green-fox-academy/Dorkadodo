document.getElementById("submitLogin").addEventListener("click",
function loginFunction() {
    let username = document.getElementById("username");
    let password = document.getElementById("password");

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "/authenticate");
    xhr.setRequestHeader("Content-Type", "application/json");

    var data = JSON.stringify({"username": username.value, "password": password.value});
    xhr.send(data);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            localStorage.setItem('JWT_AUTH', JSON.parse(this.responseText).jwt);
            getJWT();
        }
    };
})

function getJWT() {
    let xhr = new XMLHttpRequest();
    xhr.open("GET", "/");
    xhr.setRequestHeader('Authorization', 'Bearer ' + localStorage.getItem('JWT_AUTH'));
    xhr.setRequestHeader('Location', '/');
    xhr.send();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            this.responseText.
        }
    };
}