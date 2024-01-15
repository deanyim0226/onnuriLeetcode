/*
Use a hashmap -> find the complement of each element
 */
function twoSum(nums, target) {
  let seen = {};
  for (let i = 0; i < nums.length; i++) {
    let currentNum = nums[i];
    let complement = target - currentNum;

    if (complement in seen) return [i, seen[complement]];

    seen[currentNum] = i;
  }
}
