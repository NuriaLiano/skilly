#include <stdio.h>
#include <conio.h>

//contante para definir el año actual
#define ANIO_ACTUAL 2023

int main(){
    
    //definir variables
    char matricula[20]; //4567ABC
    char estado; //A, B, C, D
    int anio_fabricacion;
    int kilometraje;
    float precio_compra;

    //Pedir datos
    printf("Introduce la matricula: "); //imprime el mensaje
    scanf("%s", matricula); //recoges la matricula

    printf("Introduce el año de fabricacion");
    scanf("%d", &anio_fabricacion);

    printf("Introduce el kilometraje");
    scanf("%d", &kilometraje);

    printf("Introduce el precio de compra");
    scanf("%f", &precio_compra);

    printf("Introduce el estado");
    scanf("%c", &estado);

    //saber la antiguedad del vehiculo
   
    int antiguedad = ANIO_ACTUAL - anio_fabricacion; // el vechiculo tiene x años de antiguedad

    //saber que porcentaje tenemos que restar
    //1 año de antiguedad -> -10%
    //20 años de antiguedad -> ??

    float porcentajeDevaluacion = antiguedad * 10.0;

    //saber el porcentaje devaluacion por kilometro
    int tramos = (kilometraje -1)/50000 +1;
    porcentajeDevaluacion = porcentajeDevaluacion + tramos * 5.0;  

    //creamos variable para obtener el porcentaje de factor segun el estado
    float factorEstado;

    //mi coche tiene estado A - mi coche puede devaluar por km y por años pero no por estado
    //mi coche tiene estado B - mi coche puede (devaluar por km y por años)* porcentaje de FACTOR DE ESTADO


    //devaluacion por estado
    switch(estado){
        case 'A':
            factorEstado = 1.0;
            break;
        case 'B':
            factorEstado = 1.2;
            break;
        case 'C':
            factorEstado = 1.25;
            break;
        case 'D':
            factorEstado = 1.4;
            break;
    }

    porcentajeDevaluacion = porcentajeDevaluacion * factorEstado;

    //Calcular el precio actual
    float precio_actual = precio_compra *(100 - porcentajeDevaluacion) / 100;

    //crear el fichero
    FILE *archivo = fopen("coche.txt", "w");

    // Escribir en un fichero
    fprintf(archivo, "Matricula: %s", matricula);

    //cerrar el fichero
    fclose(archivo);


    return 0;
}


