var removeNthFromEnd = function (head, n) {
  // add a node before head
  const firstNode = new ListNode(0);
  firstNode.next = head;

  let fast = firstNode,
    slow = firstNode;

  for (let i = 0; i <= n; i++) fast = fast.next;

  //wait until fast reaches end of list
  while (fast != null) {
    fast = fast.next;
    slow = slow.next;
  }

  if (!slow.next) return null;

  slow.next = slow.next.next || null; //remove
  return firstNode.next;
};
