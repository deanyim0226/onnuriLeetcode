var TimeMap = function () {
  this.map = new Map();
};

/**
 * @param {string} key
 * @param {string} value
 * @param {number} timestamp
 * @return {void}
 */
TimeMap.prototype.set = function (key, value, timestamp) {
  const keyValArr = this.map.get(key) || [];
  keyValArr.push({ ts: timestamp, val: value });
  this.map.set(key, keyValArr);
};

/**
 * @param {string} key
 * @param {number} timestamp
 * @return {string}
 */
TimeMap.prototype.get = function (key, timestamp) {
  const keyValArr = this.map.get(key) || [];
  let left = 0,
    right = keyValArr.length - 1,
    mid = null;
  let found = null;

  // BS
  while (left <= right) {
    mid = Math.floor((left + right) / 2);
    if (keyValArr[mid].ts <= timestamp) {
      found = keyValArr[mid].val;
      left = mid + 1; //to find value with largest timestamp
    } else right = mid - 1;
  }
  return found || '';
};
