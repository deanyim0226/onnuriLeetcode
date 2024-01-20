var topKFrequent = function (nums, k) {
  // create a count of nums
  const count = nums.reduce((obj, num) => {
    obj[num] = (obj[num] || 0) + 1;
    return obj;
  }, {});

  const pairs = Object.keys(count).map((num) => {
    return [Number(num), count[num]];
  });

  // create tuple and sort by count
  return pairs
    .sort((a, b) => {
      return b[1] - a[1];
    })
    .map((tup) => tup[0])
    .slice(0, k);
};
