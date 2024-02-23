/**
 * @param {number[]} temperatures
 * @return {number[]}
 */
var dailyTemperatures = function (temperatures) {
  // add tuples, [temperature, day]
  let prev = [];
  let answer = [];
  for (let i = 0; i < temperatures.length; i++) {
    let currentTemp = temperatures[i];
    // check if current temperature is highers than days in prev
    while (prev.length && prev[prev.length - 1].temp < currentTemp) {
      let prevDay = prev.pop();
      answer[prevDay.position] = i - prevDay.position;
    }
    // add current day to prev
    prev.push({ temp: currentTemp, position: i });
  }

  while (prev.length != 0) {
    let remainingDay = prev.pop();
    answer[remainingDay.position] = 0;
  }

  return answer;
};
