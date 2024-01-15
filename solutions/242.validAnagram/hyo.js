let isAnagram = (s, t) => {
  // edge case
  if (s.length !== t.length) return false;

  // create a map for s to store letter - freq and key-value pair
  let freq = s.split('').reduce((obj, letter) => {
    obj[letter] = (obj[letter] || 0) + 1;
    return obj;
  }, {});

  for (let letter of t) {
    if (!freq[letter]) return false;
    freq[letter] -= 1;
  }

  // check to make sure all original letters used up, none left
  return Object.values(freq).every((count) => count === 0);
};
