var isPowerOfTwo = function (n) {
  if (n === 1 || n === 2) return true;

  if (n === 0 || n % 2 !== 0) return false; //if odd, not a power of 2

  return isPowerOfTwo(n / 2);
};
