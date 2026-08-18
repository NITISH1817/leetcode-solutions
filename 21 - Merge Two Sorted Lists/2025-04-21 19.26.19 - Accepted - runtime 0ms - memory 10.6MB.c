struct ListNode* mergeTwoLists(struct ListNode* list1, struct ListNode* list2) {
    // Create a dummy node to act as the head of the new list
    struct ListNode dummy;
    struct ListNode *tail = &dummy;
    dummy.next = NULL;

    // Traverse both lists
    while (list1 != NULL && list2 != NULL) {
        if (list1->val < list2->val) {
            tail->next = list1;
            list1 = list1->next;
        } else {
            tail->next = list2;
            list2 = list2->next;
        }
        tail = tail->next;
    }

    // Attach the remaining part of the list that is not empty
    tail->next = (list1 != NULL) ? list1 : list2;

    return dummy.next;
}
