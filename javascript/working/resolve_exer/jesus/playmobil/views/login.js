import { AuthenticationService } from "../services/AuthenticationService.js";
import { openSpinner, closeSpinner } from "../views/spinner.lib.js";


document.addEventListener("DOMContentLoaded", setupButton);

function setupButton() {
    document.querySelector("#tButValidate").addEventListener("click", async _ => {
        await validate();
    });
}

async function validate() {
    try {
        openSpinner();
        const service = new AuthenticationService();
        const username = document.querySelector("#tTxtUsername").value;
        const password = document.querySelector("#tPasPassword").value;
        const token = await service.validateUser(username, password);
        window.sessionStorage.setItem("token", token);
        console.log(token);
        // const decodedToken = service.decodeToken(token);
        // alert(`Bienvenido, Sr/Sra ${decodedToken.firstname} ${decodedToken.lastname}`);
        const { firstname, lastname } = service.decodeToken(token);
        console.log(firstname, lastname);
        window.sessionStorage.setItem("token", token);
        window.sessionStorage.setItem("fullname", `${firstname} ${lastname}`);
        closeSpinner();
        window.location = "/views/series.html";
    } catch(error) {
        closeSpinner();
        console.log(error.message);
        return;
    }
}

