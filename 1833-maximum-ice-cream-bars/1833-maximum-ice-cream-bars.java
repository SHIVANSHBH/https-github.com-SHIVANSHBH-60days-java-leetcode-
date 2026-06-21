class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max = 0;
        for (int c : costs) max = Math.max(max, c);
        
        int[] freq = new int[max + 1];
        for (int c : costs) freq[c]++;
        
        int count = 0;
        for (int price = 1; price <= max && coins >= price; price++) {
            int canBuy = Math.min(freq[price], coins / price);
            count += canBuy;
            coins -= canBuy * price;
        }
        return count;
    }
}