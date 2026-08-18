#include <stdio.h>
#include <string.h>

int lengthOfLastWord(char* s) {
    int length = 0;
    int i = strlen(s) - 1;  // Start from the end of the string

    // Skip trailing spaces
    while (i >= 0 && s[i] == ' ') {
        i--;
    }

    // Count the length of the last word
    while (i >= 0 && s[i] != ' ') {
        length++;
        i--;
    }

    return length;
}
