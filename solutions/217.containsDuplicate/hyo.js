function containsDuplicate(num) {
  // TODO: Write your code here
  const count = {};
  for (let num of nums) {
    if (count[num]) return true;
    count[num] = 1;
  }
  return false;
}
