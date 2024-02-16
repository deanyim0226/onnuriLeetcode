var binarySearch = function (nums, target) {
  if (!nums) return false;

  let start = 0,
    end = nums.length - 1;

  while (start <= end) {
    let mid = start + Math.floor((end - start) / 2);

    if (nums[mid] === target) return true;

    if (target > nums[mid]) start = mid + 1;
    else end = mid - 1;
  }
  return false;
};

var searchMatrix = function (matrix, target) {
  // first find which array to search for
  let start = 0,
    end = matrix.length - 1;

  let mid = Math.floor(matrix.length / 2);

  while (start <= end) {
    let low = matrix[mid][0];
    let high = matrix[mid][matrix[mid].length - 1];

    if (target >= low && target <= high) break; //found array to search
    if (target < low) end = mid - 1;
    if (target > high) start = mid + 1;

    mid = start + Math.floor((end - start) / 2);
  }
  // perform binary search within array
  return binarySearch(matrix[mid], target);
};
