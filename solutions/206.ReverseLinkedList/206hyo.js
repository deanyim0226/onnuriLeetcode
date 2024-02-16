var reverseList = function (head) {
  if (!head) return head;
  let currNode = head;
  let prevNode = null;

  while (currNode != null) {
    let nextNode = currNode.next;
    currNode.next = prevNode;
    prevNode = currNode;
    currNode = nextNode;
  }
  return prevNode;
};
