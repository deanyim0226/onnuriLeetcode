function longestConsecutive(nums) {
  const set = new Set(nums);
  let maxConsecutive = 0;

  for (const num of nums) {
    if (set.has(num + 1)) continue;

    let longestConsecutive = 1,
      current = num;

    while (set.has(current - 1)) {
      current -= 1;
      longestConsecutive++;
    }
    maxConsecutive = Math.max(longestConsecutive, maxConsecutive);
  }

  return maxConsecutive;
}
