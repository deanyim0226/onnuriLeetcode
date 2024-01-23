var isValidSudoku = function (board) {
  let rows = new Map();
  let columns = new Map();
  let subBoxes = new Map();

  // check all rows
  for (let i = 0; i < board.length; i++) {
    for (let j = 0; j < board[i].length; j++) {
      let currentNum = board[i][j];

      if (currentNum === '.') continue;

      let currentRow = rows.get(i) || new Set();
      let currentCol = columns.get(j) || new Set();
      let boxKey = `${Math.floor(i / 3)},${Math.floor(j / 3)}`;
      let currentSubBox = subBoxes.get(boxKey) || new Set();

      // check for row
      if (currentRow.has(currentNum)) return false;
      currentRow.add(currentNum);
      rows.set(i, currentRow);

      // check for column
      if (currentCol.has(currentNum)) return false;
      currentCol.add(currentNum);
      columns.set(j, currentCol);

      // check for sub box
      if (currentSubBox.has(currentNum)) return false;
      currentSubBox.add(currentNum);
      subBoxes.set(boxKey, currentSubBox);
    }
  }
  return true;
};
