var maxArea = function (height) {
  let i = 0,
    j = height.length - 1;

  i;
  let maxArea = -Infinity;
  while (i < j) {
    let area = Math.min(height[i], height[j]) * (j - i);
    area;
    maxArea = Math.max(area, maxArea);

    if (height[i] < height[j]) i++;
    else j--;
  }
  return maxArea;
};
