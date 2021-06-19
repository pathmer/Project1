function login() {
    let url = 'http://localhost:8080/Project1/login';

    // collect user input

    let usern = " ";
    let passw = " ";
    if (document.getElementById('userName').value != null) {
        usern = document.getElementById('userName').value
    }
    else {usern = " "}
    if (document.getElementById('userName').value != null) {
        passw = document.getElementById('password').value;
    }
    else {passw = " "}

    let userlist = [usern, passw]

    let user = {
        usernames: usern,
        passwords: passw,
    }

    let activeuser = {}
    let loginstatus = document.getElementById("loginstatus");

    // AJAX Call
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = recieveUser;
    xhttp.open("POST", url, true);
    //xhttp.setRequestHeader('Access-Control-Allow-Origin', '*');
    xhttp.setRequestHeader('Content-Type', 'application/json');
    xhttp.send(JSON.stringify(user));

    function recieveUser() {
        if (xhttp.readyState == 4) {
            if (xhttp.status == 200) {
                console.log('Server talking');
                let r = xhttp.responseText;
                    if (r == "Post requestnull") {
                        loginstatus.innerHTML = 'Login failed.';
                        console.log("null response");
                    }
                    else {
                        activeuser = r
                        loginstatus.innerHTML = 'Login successful.';
                        window.location = "/Project1/html/HomePage.html"
                        console.log("Booya");
                    }
            }
            else {
                loginstatus.innerHTML = 'Login failed.';
            }
        }

    }
}