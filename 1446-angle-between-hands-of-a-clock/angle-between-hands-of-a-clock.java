class Solution {
    public double angleClock(int hour, int minutes) {
        double hourAngle = 30 * (hour % 12) + 0.5 * minutes;
        double minuteAngle = 6 * minutes;

        double diff = Math.abs(hourAngle - minuteAngle);
        return Math.min(diff, 360 - diff);
    }
}