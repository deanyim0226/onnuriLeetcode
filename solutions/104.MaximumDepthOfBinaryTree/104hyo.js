var maxDepth = function (root) {
  if (!root) return 0;

  let left = 1 + maxDepth(root.left);
  let right = 1 + maxDepth(root.right);

  return Math.max(left, right);
};
