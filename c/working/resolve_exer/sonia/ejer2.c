// #include <stdio.h>
// #define SIZE 3

// int main() {
//     int matrix[SIZE][SIZE];
//     int i, j, value;
//     int isSymmetric = 1; // Asumimos que es simétrica a menos que se demuestre lo contrario

//     // Rellenar la matriz desde la entrada estándar
//     for (int count = 0; count < SIZE * SIZE; count++) {
//         printf("I-COORD?\n");
//         scanf("%d", &i);
        
//         printf("J-COORD?\n");
//         scanf("%d", &j);

//         printf("VALUE?\n");
//         scanf("%d", &value);

//         matrix[i-1][j-1] = value; // Restamos 1 porque el usuario introduce coordenadas desde 1..3
//     }

//     // Comprobar si la matriz es simétrica
//     for (i = 0; i < SIZE; i++) {
//         for (j = 0; j < SIZE; j++) {
//             if (matrix[i][j] != matrix[j][i]) {
//                 isSymmetric = 0;
//                 break;
//             }
//         }
//         if (!isSymmetric) {
//             break;
//         }
//     }

//     if (isSymmetric) {
//         printf("La matriz es simetrica.\n");
//     } else {
//         printf("La matriz no es simetrica.\n");
//     }

//     return 0;
// }

// NECESITA HACERLO SIN FOR
#include <stdio.h>
#define SIZE 3

int main() {
    int matrix[SIZE][SIZE];
    int cordI, cordJ, value, isSymmetric = 1; // Asumimos que es simétrica a menos que se demuestre lo contrario

    // Rellenar la matriz desde la entrada estándar
    printf("I-COORD?\n");
    scanf("%d", cordI);
    printf("J-COORD?\n");
    scanf("%d", cordJ);
    printf("VALUE?\n");
    scanf("%d", value);
    matrix[cordI][cordJ] = value;

    printf("I-COORD?\n");
    scanf("%d", cordI);
    printf("J-COORD?\n");
    scanf("%d", cordJ);
    printf("VALUE?\n");
    scanf("%d", value);
    matrix[cordI][cordJ] = value;

    printf("I-COORD?\n");
    scanf("%d", cordI);
    printf("J-COORD?\n");
    scanf("%d", cordJ);
    printf("VALUE?\n");
    scanf("%d", value);
    matrix[cordI][cordJ] = value;

    printf("I-COORD?\n");
    scanf("%d", cordI);
    printf("J-COORD?\n");
    scanf("%d", cordJ);
    printf("VALUE?\n");
    scanf("%d", value);
    matrix[cordI][cordJ] = value;

    printf("I-COORD?\n");
    scanf("%d", cordI);
    printf("J-COORD?\n");
    scanf("%d", cordJ);
    printf("VALUE?\n");
    scanf("%d", value);
    matrix[cordI][cordJ] = value;

    printf("I-COORD?\n");
    scanf("%d", cordI);
    printf("J-COORD?\n");
    scanf("%d", cordJ);
    printf("VALUE?\n");
    scanf("%d", value);
    matrix[cordI][cordJ] = value;

    printf("I-COORD?\n");
    scanf("%d", cordI);
    printf("J-COORD?\n");
    scanf("%d", cordJ);
    printf("VALUE?\n");
    scanf("%d", value);
    matrix[cordI][cordJ] = value;

    printf("I-COORD?\n");
    scanf("%d", cordI);
    printf("J-COORD?\n");
    scanf("%d", cordJ);
    printf("VALUE?\n");
    scanf("%d", value);
    matrix[cordI][cordJ] = value;

    printf("I-COORD?\n");
    scanf("%d", cordI);
    printf("J-COORD?\n");
    scanf("%d", cordJ);
    printf("VALUE?\n");
    scanf("%d", value);
    matrix[cordI][cordJ] = value;

    

    // Comprobar si la matriz es simétrica
    if (matrix[0][1] != matrix[1][0] || matrix[0][2] != matrix[2][0] || matrix[1][2] != matrix[2][1]) {
        isSymmetric = 0;
    }

    printf("OUTPUT");
    printf("IS SYMMETRIC (0-FALSE, 1-TRUE)? %d\n");

    // if (isSymmetric) {
    //     printf("La matriz es simetrica.\n");
    // } else {
    //     printf("La matriz no es simetrica.\n");
    // }

    return 0;
}
