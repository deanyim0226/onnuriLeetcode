var longestCommonPrefix = function (strs) {
  let prefix = '';
  if (strs.length === 1) return strs[0];

  for (let i = 0; i < strs[0].length; i++) {
    let char = strs[0][i];
    for (let j = 1; j < strs.length; j++) {
      if (char !== strs[j][i]) return prefix;
      if (j === strs.length - 1) prefix += char;
    }
  }
  return prefix;
};
