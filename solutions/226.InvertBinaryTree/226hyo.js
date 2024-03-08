var invertTree = function (root) {
  if (!root) return root;

  let prevLeft = root.left;
  // swap left and right
  root.left = invertTree(root.right);
  root.right = invertTree(prevLeft);
  return root;
};
