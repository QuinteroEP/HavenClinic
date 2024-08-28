
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

    function handleCancel() {
        window.location.href = '/'; // Cambia '/otraPagina' por la URL a la que deseas redirigir
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

    // Star animation
    const starContainer = document.querySelector(".stars");
    const starCount = 100; // Number of stars

    for (let i = 0; i < starCount; i++) {
        const star = document.createElement("div");
        star.classList.add("star");
        star.style.top = `${Math.random() * 100}%`;
        star.style.left = `${Math.random() * 100}%`;
        starContainer.appendChild(star);
    }

}