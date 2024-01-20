var groupAnagrams = function (strs) {
  let sortedWords = {};
  for (let word of strs) {
    let sorted = word.split('').sort().join('');
    if (sorted in sortedWords) {
      let anagrams = sortedWords[sorted];
      anagrams.push(word);
      sortedWords[sorted] = anagrams;
    } else sortedWords[sorted] = [word];
  }
  return Object.values(sortedWords);
};
