class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > num * 9) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        while (sum >= 9) {
            result.append('9');
            sum -= 9;
        }

        if (sum > 0) {
            result.append(sum);
        }

        while (result.length() < num) {
            result.append('0');
        }

        return result.toString();
    }
}