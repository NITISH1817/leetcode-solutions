#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

bool isValid(char * s){
    int len = strlen(s);
    if (len % 2 != 0) return false;  // Odd length can't be valid

    char *stack = (char *)malloc(len);
    int top = -1;

    for (int i = 0; i < len; i++) {
        char c = s[i];
        if (c == '(' || c == '{' || c == '[') {
            stack[++top] = c;  // Push
        } else {
            if (top == -1) return false;  // No matching opener

            char open = stack[top--];  // Pop
            if ((c == ')' && open != '(') ||
                (c == '}' && open != '{') ||
                (c == ']' && open != '[')) {
                return false;
            }
        }
    }

    bool isValid = (top == -1);
    free(stack);
    return isValid;
}
