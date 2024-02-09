var isValid = function (s) {
  // check to see if parenthesis are closed properly

  // when encounter an open parenthesis -> add to array
  // when encounter a close parenthesis, pop off most recent open parenthesis and check if it's the correct parenthesis
  // if false -> return false
  const closeToOpen = { ')': '(', '}': '{', ']': '[' };
  let openParenthesis = [];
  for (let i = 0; i < s.length; i++) {
    let currentChar = s[i];

    // is close parenthesis
    if (currentChar in closeToOpen) {
      let prevOpen = openParenthesis.pop();
      if (prevOpen !== closeToOpen[currentChar]) return false;
    } else openParenthesis.push(currentChar);
  }

  return openParenthesis.length === 0;
};
