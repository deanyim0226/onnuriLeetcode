/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function (prices) {
  //sliding window
  let profit = 0;
  let buyPrice = prices[0];

  for (let sellPt = 1; sellPt < prices.length; sellPt++) {
    const currentPrice = prices[sellPt];

    profit = Math.max(profit, currentPrice - buyPrice);
    if (currentPrice < buyPrice) buyPrice = currentPrice;
  }

  return profit;
};

maxProfit([7, 1, 5, 3, 6, 4]);
