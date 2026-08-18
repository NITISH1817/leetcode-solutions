int strStr(char* haystack, char* needle) {
    if (!*needle) return 0;  // If needle is empty, return 0

    int i, j;
    for (i = 0; haystack[i] != '\0'; i++) {
        for (j = 0; needle[j] != '\0'; j++) {
            if (haystack[i + j] != needle[j]) break;
        }
        if (needle[j] == '\0') return i;  // Full match found
    }

    return -1;  // No match
}
