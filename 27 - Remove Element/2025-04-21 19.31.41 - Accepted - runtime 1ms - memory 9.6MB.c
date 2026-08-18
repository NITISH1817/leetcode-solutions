int removeElement(int* nums, int numsSize, int val){
    int k = 0;  // Position to place next valid element

    for (int i = 0; i < numsSize; i++) {
        if (nums[i] != val) {
            nums[k] = nums[i];  // Move valid value to the front
            k++;
        }
    }

    return k;  // Number of elements not equal to val
}
