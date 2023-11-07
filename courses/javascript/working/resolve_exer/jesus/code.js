document.addEventListener("DOMContentLoaded", setup);

let number1 = "";
let number2 = "";
let operador = "";
let resultadoAnterior = null; // Variable para almacenar el resultado anterior

function setup() {
    const pantalla = document.querySelector("#pantalla");
    pantalla.value = 0;

    const number = document.querySelectorAll(".number");
    number.forEach(function (numbers) {
        numbers.addEventListener("click", (e) => {
            declararNumero(e.target.textContent);
        });
    });

    const operacion = document.querySelectorAll(".operacion");
    operacion.forEach(function (operaciones) {
        operaciones.addEventListener("click", (e) => {
            declararOperador(e.target.textContent);
        });
    });

    const igual = document.querySelector("#tButIgual").addEventListener("click", () => {
        calcular();
    });
}

function declararNumero(numero) {
    if (operador === "") {
        number1 += numero;
        document.querySelector("#pantalla").value = number1;
        console.log(number1);
    } else {
        number2 += numero;
        document.querySelector("#pantalla").value += number2;
        console.log(number2);
    }
}

function declararOperador(op) {
    if (number1 !== "") {
        operador = op;
        document.querySelector("#pantalla").value += operador;
        console.log(operador);
    }
}

function calcular() {
    if (number1 !== "" && number2 !== "") {
        const n1 = parseFloat(number1);
        const n2 = parseFloat(number2);
        let resultado;
        
        switch (operador) {
            case "+":
                resultado = n1 + n2;
                break;
            case "-":
                resultado = n1 - n2;
                break;
            case "*":
                resultado = n1 * n2;
                break;
            case "/":
                resultado = n1 / n2;
                break;
        }


        console.log(resultado);
        document.querySelector("#pantalla").value = resultado;
        number1 = "";
        number2 = "";
        operador = "";
    }
}
