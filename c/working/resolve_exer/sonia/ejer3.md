# Algoritmo en C

~~~c
const
    MIN_SUPPORTERS: integer = 1; {Min. number of supporters}
    MAX_SUPPORTERS: integer = 10; {Max. number of supporters}
    BASE_MEMBERSHIP_YEARS: integer = 5; {Max. years base membership}
    SILVER_MEMBERSHIP_YEARS: integer = 10; {Max. years silver membership}
end const

type
    tMembershipType = {BASE, SILVER, GOLD}
end type
algorithm UOCStadium
    {Variable definitions}
    var
        supporterIds: vector[MAX_SUPPORTERS] of integer;
        supporterAges: vector[MAX_SUPPORTERS] of integer;
        supporterRecords: vector[MAX_SUPPORTERS] of boolean;
        membershipYears: integer;
        i: integer;
        numSupporters: integer;
        recoveredSupporters: vector[MAX_SUPPORTERS] of integer;
        supporterMembershipTypes: vector[MAX_SUPPORTERS] of tMembershipType;

        /********/
        
        /********/
    end var
    {Exercise 2.1}
    {Data input}
    writeString("INPUT DATA");
    writeString("NUMBER OF SUPPORTERS(1-10)?");
    numSupporters := readInteger();
    {Data validation}
        /********/
        do
            if(numSupporters < MIN_SUPPORTERS) or (numSupporters > MAX_SUPPORTERS) then
                writeString("LOS DATOS NO SON VALIDOS");
        while(numSupporters >= MIN_SUPPORTERS) and (numSupporters <= MAX_SUPPORTERS);
        /********/
    {Exercise 2.2}
    {Data input}
    for i := 1 to numSupporters do
        /********/
        writeString("SUPPORTER #");
        writeString("Introduce el ID":)
        supportesID[i] :=readInteger();
        PEDIR EDAD
        writeString("Introduce los años de membresia");
        membershipYears[i] :=readInteger();
        SI membershipYears <= BASE_MEMBERSHIP_YEARS then
            supporterMembershipTypes[i] := Base;
        else if ---
        else
            ---
        /********/
    end for
    {Calculate the average age}
    /********/
        mediaEdad = sum(supporterAges) / numSupporters;
    /********/
    {Exercise 2.3}
    {Data input}
    writeString("LOOKING FOR SUPPORTERS");
    writeString("MEMBERSHIP TYPE (1-BASE, 2-SILVER, 3-GOLD)?");
    /********/
    membershipType = LEER MEMBERSHIP
    {Data Processing}
    for i := 1 to numberSupporters do
    begin
        if(supporterMembershipTypes[i] = membershipType) and (not supporterRecords[i])
            recoveredSupporters[i] := i;
    end
    /********/
    {Data processing and Data Outputs}
    {Exercise 2.4}
    writeString("RESULTS");
    writeString("AVERAGE SUPPORTER AGE:");
    /********/
    if length(recoveredSupporters) = 0 then
        writeString("NO HAY SUPPORTERS")
    else
        for length(recoveredSupporters) do
        begin
            IMPRIMIR LOS DATOS DE SUPPORTER ID, EDAD, HAS RECORDS, MEMBRESIA

end algorithm
~~~
