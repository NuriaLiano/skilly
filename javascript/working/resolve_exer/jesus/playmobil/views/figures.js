import { PlaymobilService } from "../services/PlaymobilService.js";
import "https://cdn.jsdelivr.net/npm/jsbarcode@3.11.0/dist/JsBarcode.all.min.js";

document.addEventListener("DOMContentLoaded", retrieveFigures);

async function retrieveFigures() {
    const services = new PlaymobilService();
    const id = getId();
    const figures = await services.getBoxesId(id);
    const details = await services.showFigures(figures);
    renderFigures(details);    
    // document.querySelector("#tButLog").addEventListener("click", _ => window.location = '/views/box.html');
}

function getId() {
    const params = new URLSearchParams(window.location.search);
    const boxUuid = params.get('box');
    return boxUuid;
}

function renderFigures(figures) {
    const nTable = document.querySelector("#tTabFigures>tbody");

    figures.forEach(({name, barcode}) => {
        const nTr = document.createElement("tr");
        nTable.appendChild(nTr);

        const nTdName = document.createElement("td");
        nTr.appendChild(nTdName);
        // nTdName.dataset.box = box.uuid;
        nTdName.textContent = name;

        const nTdBarcode = document.createElement("svg");
        nTr.appendChild(nTdBarcode);
        const svgElement = document.createElementNS("http://www.w3.org/2000/svg", "svg");
        // nTdBarcode.textContent = barcode;

        nTdBarcode.appendChild(svgElement);
        JsBarcode(svgElement, barcode);
    });
}

