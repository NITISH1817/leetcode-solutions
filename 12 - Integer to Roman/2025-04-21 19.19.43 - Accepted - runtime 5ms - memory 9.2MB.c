char * intToRoman(int num){
    // Define Roman numeral symbols and their corresponding values
    int values[] =    {1000,  900, 500, 400, 100,  90,  50, 40, 10,  9,   5,  4,  1};
    char *symbols[] = {"M",  "CM", "D", "CD", "C", "XC", "L","XL","X","IX","V","IV","I"};

    // Allocate enough space for the largest possible Roman numeral (e.g. 3888 = "MMMDCCCLXXXVIII")
    char *result = malloc(20 * sizeof(char));
    result[0] = '\0'; // Initialize empty string

    for (int i = 0; i < 13 && num > 0; i++) {
        while (num >= values[i]) {
            strcat(result, symbols[i]);
            num -= values[i];
        }
    }

    return result;
}
