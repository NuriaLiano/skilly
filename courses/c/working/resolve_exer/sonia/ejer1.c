#include<stdio.h>
#include<stdbool.h>
#define EDADMINIMA_NOADULTO 16
#define EDADMINIMA_CONADULTO 14
#define EDADMAXIMA_CONADULTO 15
#define ALTURA_MINIMA 1.40
#define ALTURA_MAXIMA 1.95
int main(){
    int age, healthStatus, accompaniedByAdult;
    float height;
    printf("INPUT\n");
    printf("AGE?\n");
    scanf("%d", &age);
    
    printf("ACCOMPANIED BY AN ADULT (0-FALSE, 1-TRUE)?\n");
    scanf("%d", &accompaniedByAdult);

    // Preguntar la altura
    printf("HEIGHT?\n");
    scanf("%d", &height);

    // Preguntar el estado de salud
    printf("HEALTH STATUS (0-OK, 1-FEAR OF HEIGHTS, 2-FEAR OF HIGH SPEEDS)?\n");
    scanf("%d", &healthStatus);


    int canRide=0;
    int edadSinAdulto=age>=EDADMINIMA_NOADULTO;
    int edadConAdulto=age>=EDADMINIMA_CONADULTO && age<=EDADMAXIMA_CONADULTO && accompaniedByAdult;
    int condicionSalud=height>=ALTURA_MINIMA && height<=ALTURA_MAXIMA && healthStatus==0;

    canRide=(edadSinAdulto||edadConAdulto)&&condicionSalud;
    printf("OUTPUT\n");
    printf("CAN RIDE (0-FALSE, 1-TRUE): %d\n", canRide);

    return 0; 






    }