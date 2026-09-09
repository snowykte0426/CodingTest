class Solution {

    private static final int ICE_AMERICANO_PRICE = 5500;

    public int[] solution(int money) {
        int coffeeNumber = maxBuyCoffee(money);
        int change = getAfterBuyChange(money, coffeeNumber);
        int[] answer = { coffeeNumber, change };
        return answer;
    }

    private int maxBuyCoffee(int money) {
        return money / ICE_AMERICANO_PRICE;
    }

    private int getAfterBuyChange(int money, int coffeeNumber) {
        return money - coffeeNumber * ICE_AMERICANO_PRICE;
    }
}
