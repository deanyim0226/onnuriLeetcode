var diameterOfBinaryTree = function (root) {
  // helper function to recursively traverse
  const getDiameter = (node, dm) => {
      if (!node) return 0;

      const left = getDiameter(node.left, dm)
      const right = getDiameter(node.right, dm)

      dm[0] = Math.max(dm[0], left + right);

      return Math.max(left, right) + 1 //depth of current node
  }

  const dm = [0];
  getDiameter(root, dm);
  return dm[0];
};
