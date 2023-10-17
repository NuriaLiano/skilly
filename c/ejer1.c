#include %3Cstdio.h%3E
#include <stdbool.h>

// Definición de constantes
#define EDAD_MINIMA 16
#define EDAD_MINIMA_CON_ADULTO 12
#define EDAD_MAXIMA_CON_ADULTO 15
#define ALTURA_MINIMA 1.40
#define ALTURA_MAXIMA 1.95

int main() {
    int edad, acompanado, estres_por_alturas, estres_por_velocidades;
    float altura;

    // Entrada de datos ESTA ENTRADA ESTA BIEN PERO EL VALIDADOR DE LA UOC QUIERE UN FORMATO CONCRETO
    // printf("Introduce tu edad: ");
    // scanf("%d", &edad);

    // printf("¿Vienes acompañado de un adulto? (1 para SI, 0 para NO): ");
    // scanf("%d", &acompanado);

    // printf("Introduce tu altura (por ejemplo, 1.75): ");
    // scanf("%f", &altura);

    // printf("¿Te estresan las alturas? (1 para SI, 0 para NO): ");
    // scanf("%d", &estres_por_alturas);

    // printf("¿Te estresan las altas velocidades? (1 para SI, 0 para NO): ");
    // scanf("%d", &estres_por_velocidades);

     // Preguntar la edad
    printf("INPUT\n");
    printf("AGE?\n");
    scanf("%d", &age);

    // Preguntar si está acompañado por un adulto
    printf("ACCOMPANIED BY AN ADULT (0-FALSE, 1-TRUE)?\n");
    scanf("%d", &accompaniedByAdult);

    // Preguntar la altura
    printf("HEIGHT?\n");
    scanf("%d", &height);

    // Preguntar el estado de salud
    printf("HEALTH STATUS (0-OK, 1-FEAR OF HEIGHTS, 2-FEAR OF HIGH SPEEDS)?\n");
    scanf("%d", &healthStatus);

    int ageCondition1 = age >= MIN_AGE_NO_ADULT;
    int ageCondition2 = age >= MIN_AGE_WITH_ADULT && age <= MAX_AGE_WITH_ADULT && accompaniedByAdult;
    int heightCondition = height >= MIN_HEIGHT && height <= MAX_HEIGHT && healthStatus == 0;

    int canRide = (ageCondition1 || ageCondition2) && heightCondition;

    // Imprimir el resultado
    printf("OUTPUT\n");
    printf("CAN RIDE (0-FALSE, 1-TRUE): %d\n", canRide);

    return 0;
}