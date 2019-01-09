

// Complete the getNode function below.

/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     int data;
 *     SinglyLinkedListNode next;
 * }
 *
 */
static int getNode(SinglyLinkedListNode head,int positionFromTail){
    SinglyLinkedListNode tail=head;
    for(int i=0;i<positionFromTail;i++)
    tail=tail.next;

    while(tail.next!=null){
    tail=tail.next;
    head=head.next;
    }
    return head.data;

    }

