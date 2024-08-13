document.addEventListener("DOMContentLoaded", () => {
    console.log("Script loaded");

    const botonlogOut = document.getElementById("cerrar");
    botonlogOut.addEventListener("click", logOut);
    

    function logOut(){
        window.location.href = "index.html"
    }
})