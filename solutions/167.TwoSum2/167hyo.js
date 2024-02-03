var twoSum = function (numbers, target) {
  let i = 0,
    j = numbers.length - 1;

  while (i < j) {
    let sum = numbers[i] + numbers[j];
    if (sum === target) return [i, j];

    if (sum > target) j--;
    else i++;
  }
  return false; //not found
};

twoSum([2, 7, 11, 15], 9);
twoSum([2, 3, 4], 6);
twoSum([-1, 0], -1);
