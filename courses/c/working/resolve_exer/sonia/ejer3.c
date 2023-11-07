#include <stdio.h>

const int MIN_SUPPORTERS = 1;  // Min. number of supporters
const int MAX_SUPPORTERS = 10; // Max. number of supporters
const int BASE_MEMBERSHIP_YEARS = 5;   // Max. years base membership
const int SILVER_MEMBERSHIP_YEARS = 10; // Max. years silver membership

typedef enum {
    BASE,
    SILVER,
    GOLD
} tMembershipType;

int main() {
    // Variable definitions
    int supporterIds[MAX_SUPPORTERS];
    int supporterAges[MAX_SUPPORTERS];
    bool supporterRecords[MAX_SUPPORTERS];
    int membershipYears;
    int i;
    int numSupporters;
    int recoveredSupporters[MAX_SUPPORTERS];
    tMembershipType supporterMembershipTypes[MAX_SUPPORTERS];

    // Exercise 2.1
    // Data input
    printf("INPUT DATA\n");
    printf("NUMBER OF SUPPORTERS(1-10)?");
    scanf("%d", &numSupporters);

    // Data validation
    while (numSupporters < MIN_SUPPORTERS || numSupporters > MAX_SUPPORTERS) {
        printf("LOS DATOS NO SON VALIDOS\n");
        printf("NUMBER OF SUPPORTERS(1-10)?");
        scanf("%d", &numSupporters);
    }

    // Exercise 2.2
    // Data input
    for (i = 0; i < numSupporters; i++) {
        printf("SUPPORTER #%d\n", i + 1);
        printf("Introduce el ID: ");
        scanf("%d", &supporterIds[i]);

        // PEDIR EDAD
        printf("Introduce los años de membresia: ");
        scanf("%d", &membershipYears);

        if (membershipYears <= BASE_MEMBERSHIP_YEARS) {
            supporterMembershipTypes[i] = BASE;
        } else if (membershipYears <= SILVER_MEMBERSHIP_YEARS) {
            supporterMembershipTypes[i] = SILVER;
        } else {
            supporterMembershipTypes[i] = GOLD;
        }
    }

    // Calculate the average age
    int sumAges = 0;
    for (i = 0; i < numSupporters; i++) {
        printf("Introduce la edad de SUPPORTER #%d: ", i + 1);
        scanf("%d", &supporterAges[i]);
        sumAges += supporterAges[i];
    }
    float mediaEdad = (float)sumAges / numSupporters;

    // Exercise 2.3
    // Data input
    printf("LOOKING FOR SUPPORTERS\n");
    printf("MEMBERSHIP TYPE (1-BASE, 2-SILVER, 3-GOLD)?");
    int membershipType;
    scanf("%d", &membershipType);

    // Data Processing
    int recoveredCount = 0;
    for (i = 0; i < numSupporters; i++) {
        if (supporterMembershipTypes[i] == membershipType && !supporterRecords[i]) {
            recoveredSupporters[recoveredCount] = i;
            recoveredCount++;
        }
    }

    // Data processing and Data Outputs
    // Exercise 2.4
    printf("RESULTS\n");
    printf("AVERAGE SUPPORTER AGE: %.2f\n", mediaEdad);

    if (recoveredCount == 0) {
        printf("NO HAY SUPPORTERS\n");
    } else {
        printf("RECOVERED SUPPORTERS:\n");
        for (i = 0; i < recoveredCount; i++) {
            int supporterIndex = recoveredSupporters[i];
            printf("SUPPORTER ID: %d, AGE: %d, HAS RECORDS: %s, MEMBERSHIP: ",
                supporterIds[supporterIndex], supporterAges[supporterIndex],
                supporterRecords[supporterIndex] ? "YES" : "NO");

            switch (supporterMembershipTypes[supporterIndex]) {
                case BASE:
                    printf("BASE\n");
                    break;
                case SILVER:
                    printf("SILVER\n");
                    break;
                case GOLD:
                    printf("GOLD\n");
                    break;
            }
        }
    }

    return 0;
}
