/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function (s) {
  if (!s.length) return 0;

  let maxLength = 1;
  let start = 0;
  let seen = new Set(s[0]);

  for (let end = 1; end < s.length; end++) {
    let curLetter = s[end];
    if (seen.has(curLetter)) {
      // check length
      maxLength = Math.max(maxLength, end - start);
      // update start when same letter encountered
      start = end;
    }
    seen.add(curLetter);
  }
  return maxLength;
};

lengthOfLongestSubstring('pwwkew');
