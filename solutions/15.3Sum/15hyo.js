var threeSum = function (nums) {
  if (nums.length < 3) return answer;

  nums.sort((a, b) => a - b);

  let answer = [];
  let lastIndexMap = new Map();

  for (let i = 0; i < nums.length; i++) {
    lastIndexMap.set(nums[i], i);
  }

  for (let i = 0; i < nums.length - 2; i++) {
    if (nums[i] > 0) {
      break;
    }

    for (let j = i + 1; j < nums.length - 1; j++) {
      let complement = 0 - (nums[i] + nums[j]);

      if (lastIndexMap.has(complement) && lastIndexMap.get(complement) > j) {
        answer.push([nums[i], nums[j], complement]);
      }
      j = lastIndexMap.get(nums[j]);
    }
    i = lastIndexMap.get(nums[i]);
  }

  return answer;
};

threeSum([-1, 0, 1, 2, -1, -4]);
