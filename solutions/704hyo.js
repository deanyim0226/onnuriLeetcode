const search = (array, target) => {
  //iterative solution
  let start = 0,
    end = array.length - 1;
  while (start <= end) {
    let mid = Math.floor((end + start) / 2);
    if (target == array[mid]) return mid;
    if (target < array[mid]) end = mid - 1;
    else start = mid + 1;
  }
  return -1;
};
search([-1, 0, 3, 5, 9, 12], 12);
