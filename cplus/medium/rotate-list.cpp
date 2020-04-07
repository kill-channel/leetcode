
class Solution {
public:
    ListNode *rotateRight(ListNode *head, int k) {
        if (head == NULL) return NULL;
        if (k == 0) return head;
        ListNode *start = new ListNode(0);
        start->next = head;
        ListNode *tmpHead = start;
        ListNode *tmpRear = head;
        int len = 0, tmpK = k;
        while (tmpHead->next != NULL && tmpK > 0) {
            tmpK--;
            len++;
            tmpHead = tmpHead->next;
        }
        if (k % len == 0 && tmpHead->next == NULL)
            return head;
        if (tmpK == 0) {
            tmpHead = tmpHead->next;
            while (tmpHead->next != NULL) {
                tmpHead = tmpHead->next;
                tmpRear = tmpRear->next;
            }
        } else if (len < k)//②
        {
            tmpK = k % len;
            tmpHead = head;
            while (tmpK-- > 0) {
                tmpHead = tmpHead->next;
            }
            while (tmpHead->next != NULL) {
                tmpHead = tmpHead->next;
                tmpRear = tmpRear->next;
            }
        }
        tmpHead->next = start->next;
        start->next = tmpRear->next;
        tmpRear->next = NULL;
        return start->next;
    }
};
