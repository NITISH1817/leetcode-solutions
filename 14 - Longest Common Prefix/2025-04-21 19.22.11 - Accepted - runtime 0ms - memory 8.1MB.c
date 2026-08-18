char * longestCommonPrefix(char ** strs, int strsSize){
    if (strsSize == 0) return "";

    for (int i = 0; strs[0][i]; i++) {
        char c = strs[0][i];
        for (int j = 1; j < strsSize; j++) {
            if (strs[j][i] != c || strs[j][i] == '\0') {
                // Allocate memory for the prefix and return it
                char *prefix = (char *)malloc(i + 1);
                strncpy(prefix, strs[0], i);
                prefix[i] = '\0';
                return prefix;
            }
        }
    }

    // If we finish the loop, the first string is the common prefix
    return strdup(strs[0]);
}
