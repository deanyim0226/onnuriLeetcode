var productExceptSelf = function (nums) {
  let leftProduct = [];
  for (let i = 0; i < nums.length; i++) {
    if (i === 0) leftProduct.push(1);
    else leftProduct.push(leftProduct[leftProduct.length - 1] * nums[i - 1]);
  }

  let rightProduct = [];
  for (let i = nums.length - 1; i >= 0; i--) {
    if (i === nums.length - 1) rightProduct.push(1);
    else rightProduct.push(nums[i + 1] * rightProduct[rightProduct.length - 1]);
  }

  let answer = [];
  for (
    let i = 0, j = rightProduct.length - 1;
    i < leftProduct.length;
    i++, j--
  ) {
    answer.push(leftProduct[i] * rightProduct[j]);
  }

  return answer;
};
