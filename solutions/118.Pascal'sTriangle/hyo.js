// ITERATIVE
var generate = function (numRows) {
  let result = [[1]];

  while (result.length !== numRows) {
    // 2 pointers, sum up
    let previousRow = result[result.length - 1];
    let newRow = [1];
    let i = 0,
      j = 1;

    // build new row
    while (j != previousRow.length) {
      let sum = previousRow[i] + previousRow[j];
      newRow.push(sum);
      i++;
      j++;
    }
    newRow.push(1);
    result.push(newRow);
  }

  return result;
};

// RECURSION
var generate_recursive = function (numRows) {
  if (numRows === 1) return [[1]];

  let result = generate_recursive(numRows - 1);
  let previousRow = result[result.length - 1];
  let newRow = [1];

  for (let i = 0; i < previousRow.length - 1; i++) {
    newRow.push(previousRow[i] + previousRow[i + 1]);
  }
  newRow.push(1);
  result.push(newRow);

  return result;
};
