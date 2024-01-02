import { PlaymobilService } from "../services/PlaymobilService.js";

document.addEventListener("DOMContentLoaded", retrieveSeries);


async function retrieveSeries() {
    const services = new PlaymobilService();
    const series = await services.getResponse();
    // const user = window.sessionStorage.getItem("fullname");
    // console.log(user);
    // renderUser();
    renderSeries(series);
    document.querySelector("#tButLog").addEventListener("click", logout);
}

function logout() {
    sessionStorage.removeItem("token");
    window.location = "/views/login.html";
}

function renderSeries(series) {
    const nTable = document.querySelector("#tTabSeries>tbody");

    series.forEach(serie => {
        const nTr = document.createElement("tr");
        nTable.appendChild(nTr);

        const nTd = document.createElement("td");
        nTr.appendChild(nTd);
        nTd.dataset.id = serie.uuid;
        nTd.textContent = serie.denomination;
        nTd.addEventListener("click", goToBoxes);
    });
}

// function renderUser() {
//     // const nTbody = document.querySelector("#tTabUser>tbody");

//     // const nTr = document.createElement("tr");
//     // nTbody.appendChild(nTr);
//     // nTr.textContent = user;
//     const nDiv = document.getElementById("tUser");
//     nDiv.value = sessionStorage.getItem("fullname");
//     window.print(nDiv);
// }

function goToBoxes(e) {
    const id = e.target.dataset.id;
    window.location = `/views/box.html?serie=${id}`;
}