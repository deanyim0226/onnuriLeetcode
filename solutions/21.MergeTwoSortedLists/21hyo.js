var mergeTwoLists = function (list1, list2) {
  // base case: if current is null, return
  if (!list1) return list2;
  if (!list2) return list1;

  // both lists exist
  let newHead;
  if (list1.val < list2.val) {
    newHead = list1;
    newHead.next = mergeTwoLists(list1.next, list2);
  } else {
    newHead = list2;
    newHead.next = mergeTwoLists(list1, list2.next);
  }
  return newHead;
};
