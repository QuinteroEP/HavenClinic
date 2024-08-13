window.onload = () =>{
    console.log("Script loaded");

    const loginForm = document.getElementById("loginForm");
    const darkOverlay = document.getElementById("darker");

    const botonLogin = document.getElementById("LogIn"); 
    const botonCancel = document.getElementById("cancel");

    botonLogin.addEventListener("click", loginPopUp);
    botonCancel.addEventListener("click", closePopUp);

    function loginPopUp(){
        console.log("Log in")

        loginForm.style.display = "block";
        darkOverlay.style.display = "block";
    }

    function closePopUp(){
        loginForm.style.display = "none";
        darkOverlay.style.display = "none";
    }

    loginForm.addEventListener("submit", (event) =>{
        console.log("Redireccionando");

        event.preventDefault();
        window.location.href = "mainMenu.html"
    })
}