import { PlaymobilService } from "../services/PlaymobilService.js";

document.addEventListener("DOMContentLoaded", retrieveBoxes);

async function retrieveBoxes() {
    const services = new PlaymobilService();
    const id = getId();
    const boxes = await services.getSeriesId(id);
    const details = await services.showBoxes(boxes);
    console.log(details);
    renderBoxes(details);
    document.querySelector('#tDivCartButton').addEventListener('click', _ => window.location = '/views/cart.html');
    document.querySelector("#tButLog").addEventListener("click", _ => window.location = '/views/series.html');
}

function getId() {
    const params = new URLSearchParams(window.location.search);
    const serieUuid = params.get('serie');
    return serieUuid;
}

function renderBoxes(boxes) {
    const nTable = document.querySelector("#tTabBoxes>tbody");

    boxes.forEach(({id, name, price}) => {
        const nTr = document.createElement("tr");
        nTable.appendChild(nTr);

        const nTdName = document.createElement("td");
        nTr.appendChild(nTdName);
        nTdName.dataset.id = id;
        nTdName.textContent = name;
        nTdName.addEventListener("click", goToFigures);

        const nTdPrice = document.createElement("td");
        nTr.appendChild(nTdPrice);
        nTdPrice.dataset.id = id;
        nTdPrice.textContent = price;

        nTdPrice.addEventListener("click", goToFigures);
        const nTdAdd = document.createElement("td");
        nTr.appendChild(nTdAdd);
        nTdAdd.textContent = "+";
        nTdAdd.setAttribute('data-id', id);
        nTdAdd.setAttribute('data-name', name);
        nTdAdd.setAttribute('data-price', price);
        nTdAdd.addEventListener('click', addProductToCart);

    });
}

function goToFigures(e) {
    const id = e.target.dataset.id;
    window.location = `/views/figures.html?box=${id}`;
}

function addProductToCart(e) {
    console.log(e.target);
    const productId = e.target.dataset.id;
    const productName = e.target.dataset.name;
    const productPrice = parseFloat(e.target.dataset.price);

    let cart = JSON.parse(window.sessionStorage.getItem('cart'));
    if (!cart) {
        cart = [];
    }

    cart.push({
        id: productId,
        name: productName,
        price: productPrice
    });
    window.sessionStorage.setItem('cart', JSON.stringify(cart));

    // recreateCart();
}

// function recreateCart() {
//     const cart = JSON.parse(window.sessionStorage.getItem('cart'));

//     if (cart) {
//         const nTbody = document.querySelector('#tTabBoxes>tbody');
//         nTbody.innerHTML = '';

//         cart.forEach(product => {
//             const nTr = document.createElement('tr');
//             nTbody.appendChild(nTr);

//             const nTdName = document.createElement('td')
//             nTr.appendChild(nTdName);
//             nTdName.textContent = product.name;

//             const nTdPrice = document.createElement('td')
//             nTr.appendChild(nTdPrice);
//             nTdPrice.textContent = product.price;
//         })
//     }
// }