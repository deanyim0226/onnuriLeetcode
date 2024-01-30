var reverseString = function (s) {
  let i = 0,
    j = s.length - 1;
  while (i < j) {
    [s[j], s[i]] = [s[i], s[j]];
    i++;
    j--;
  }
  return s;
};
