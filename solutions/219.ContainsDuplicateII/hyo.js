var containsNearbyDuplicate = function (nums, k) {
  const map = new Map();
  for (let idx = 0; idx < nums.length; idx++) {
    // Check if the difference between duplicates is less than k
    if (idx - map.get(nums[idx]) <= k) {
      return true;
    }
    map.set(nums[idx], idx);
  }
  return false;
};
