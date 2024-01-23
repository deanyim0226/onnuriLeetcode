var majorityElement = function (nums) {
  // count occurrences in count object
  // find object with n/2 times (Math.floor)
  let count = {};
  for (num of nums) {
    count[num] = (count[num] || 0) + 1;
  }

  // loop through key-value pair
  for (num of Object.keys(count)) {
    if (count[num] > Math.floor(nums.length / 2)) return num;
  }
};
