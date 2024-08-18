
window.onload = () => {
    console.log("Script loaded");

    const loginForm = document.getElementById("loginForm");
    const registerForm = document.getElementById("registerForm");
    const darkOverlay = document.querySelector(".darker");

    const botonLogin = document.getElementById("LogIn");
    const botonCancelLogin = document.getElementById("cancel");
    const botonSignUp = document.getElementById("SignUp");
    const botonCancelRegister = document.getElementById("cancelRegister");

    botonLogin.addEventListener("click", loginPopUp);
    botonCancelLogin.addEventListener("click", closePopUp);
    botonSignUp.addEventListener("click", showRegisterForm);
    botonCancelRegister.addEventListener("click", hideRegisterForm);

    function loginPopUp() {
        console.log("Log in");

        loginForm.style.display = "block";
        darkOverlay.style.display = "block";
    }

    function closePopUp() {
        loginForm.style.display = "none";
        darkOverlay.style.display = "none";
    }

    function showRegisterForm() {
        console.log("Show register form");

        registerForm.style.display = "block";
        darkOverlay.style.display = "block";
    }

    function hideRegisterForm() {
        registerForm.style.display = "none";
        darkOverlay.style.display = "none";
    }

    loginForm.addEventListener("submit", (event) => {
        console.log("Redireccionando");

        event.preventDefault();
        window.location.href = "/menu";
    });
}