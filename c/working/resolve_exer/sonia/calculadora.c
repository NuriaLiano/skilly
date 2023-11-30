#include "calculadora.h"

//constante PI
#define PI 3.14

//Funcion para calcular el area del circulo
//tipo de dato a devolver     nombredeFuncion   (parametros1, parametros2, ...)

void calcularAreaCirculo (double radio, double* area){
    *area = PI * radio * radio;
}

void calcularPerimetroCirculo (double radio, double* perimetro){
    *perimetro = 2 * PI * radio;
}
void calcularAreaRectangulo (double largo, double ancho, double* area){
    *area = largo * ancho;
}
void calcularPerimetroRectangulo (double largo, double ancho, double* perimetro){
    *perimetro = 2 * (largo + ancho);
}