package days.day2;

import java.util.HashMap;
import java.util.Map;

public enum HandPlay {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    private static final Map<String, HandPlay> mMap;

    static {
        mMap = new HashMap<String, HandPlay>();
        mMap.put("A", ROCK);
        mMap.put("B", PAPER);
        mMap.put("C", SCISSORS);
        mMap.put("X", ROCK);
        mMap.put("Y", PAPER);
        mMap.put("Z", SCISSORS);
    }

    private final int value;
    private HandPlay(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static HandPlay getPlayByCode(final String code) {
        if (mMap.containsKey(code)) {
            return mMap.get(code);
        }
        return null;
    }
}
