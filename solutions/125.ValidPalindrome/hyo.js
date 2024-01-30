var isPalindrome = function (s) {
  // remove non-alphanumeric characters using replace (regex)
  const str = s.replace(/[^a-zA-Z0-9]/g, '').toLowerCase();
  let i = 0,
    j = str.length - 1;
  while (i < j) {
    if (str.charAt(i) !== str.charAt(j)) return false;
    i++;
    j--;
  }
  return true;
};
