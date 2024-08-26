package lotto.domain;

public enum Rank {

    MISS(0, 0, "0"),
    FIFTH(3, 5_000L, "5,000"),
    FOURTH(4, 50_000L, "50,000"),
    THIRD(5, 1_500_000L, "1,500,000"),
    SECOND(5, 30_000_000L, "30,000,000"),
    FIRST(6, 2_000_000_000L, "2,000,000,000");

    private final int count;
    private final long prize;
    private final String convertPrize;

    private static final String ERROR_MESSAGE = "[ERROR]";

    Rank(int count, long prize, String convertPrize) {
        this.count = count;
        this.prize = prize;
        this.convertPrize = convertPrize;
    }

    public Rank determineRank(int count, boolean bonus) {

        if (count < FIFTH.getCount()) { // 등수 없음
            return MISS;
        }
        if (count == THIRD.getCount() && bonus) { // 2등
            return SECOND;
        }
        for (Rank rank : values()) {
            if (count == rank.getCount() && rank != SECOND) {
                return rank;
            }
        }
        throw new IllegalArgumentException(ERROR_MESSAGE);
    }

    public int getCount() {
        return count;
    }

    public long getPrize() {
        return prize;
    }

    public String getConvertPrize() {
        return convertPrize;
    }
}
