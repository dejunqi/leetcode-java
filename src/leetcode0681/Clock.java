package leetcode0681;

import java.util.HashSet;
import java.util.Set;

public class Clock {
    private int hour;
    private int minute;
    private Set<Character> digits;

    Clock(String time) {
        String[] tmp = time.split(":");
        digits = new HashSet<>();
        hour = Integer.parseInt(tmp[0]);
        minute = Integer.parseInt(tmp[1]);
        for (String t : tmp) {
            digits.add(t.charAt(0));
            digits.add(t.charAt(1));
        }
    }

    public void addMinite() {
        minute++;
        if (minute == 60) {
            addHour();
            minute = 0;
        }
    }

    private void addHour() {
        hour++;
        hour %= 24;
    }

    public String getTime() {
        String h = Integer.toString(hour);
        if (h.length() < 2) {
            h = "0" + h;
        }
        String min = Integer.toString(minute);
        if (min.length() < 2) {
            min = "0" + min;
        }
        return h + ":" + min;
    }

    public boolean allCurrentDigitsReused(String time) {
        for (int i = 0; i < time.length(); i++) {
            if (time.charAt(i) != ':' && !digits.contains(time.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
