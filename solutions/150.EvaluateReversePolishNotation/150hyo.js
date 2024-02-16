/**
 * @param {string[]} tokens
 * @return {number}
 */
var evalRPN = function (tokens) {
  // add numbers to a list until you reach an operand
  // if operand, pop out 2 most recent number + do operation, add back to numbers list

  let nums = [];
  let operators = ['+', '-', '*', '/'];

  let i = 0;
  while (i < tokens.length) {
    let token = tokens[i];
    let isOperator = operators.includes(token);

    if (isOperator) {
      let num2 = Number(nums.pop());
      let num1 = Number(nums.pop());
      let newNum;

      switch (token) {
        case '+':
          newNum = num1 + num2;
          break;
        case '-':
          newNum = num1 - num2;
          break;
        case '*':
          newNum = num1 * num2;
          break;
        case '/':
          newNum = Math.trunc(num1 / num2);
          break;
        default:
          break;
      }
      nums.push(newNum);
    } else nums.push(token);
    i++;
  }
  return nums.pop();
};

evalRPN(['10', '6', '9', '3', '+', '-11', '*', '/', '*', '17', '+', '5', '+']);
