package lotto.domain;

public enum Rank implements RankOperation {

    MISS(0, 0, "0"){
        @Override
        public boolean matches(int count, boolean bonus) {
            return count < FIFTH.getCount();
        }
    },
    FIFTH(3, 5_000L, "5,000") {
        @Override
        public boolean matches(int count, boolean bonus) {
            return count == getCount();
        }
    },
    FOURTH(4, 50_000L, "50,000") {
        @Override
        public boolean matches(int count, boolean bonus) {
            return count == getCount();
        }
    },
    THIRD(5, 1_500_000L, "1,500,000") {
        @Override
        public boolean matches(int count, boolean bonus) {
            return count == getCount() && !bonus;
        }
    },
    SECOND(5, 30_000_000L, "30,000,000") {
        @Override
        public boolean matches(int count, boolean bonus) {
            return count == getCount() && bonus;
        }
    },
    FIRST(6, 2_000_000_000L, "2,000,000,000") {
        @Override
        public boolean matches(int count, boolean bonus) {
            return count == getCount();
        }
    };

    private final int count;
    private final long prize;
    private final String convertPrize;

    private static final String ERROR_MESSAGE = "[ERROR]";

    Rank(int count, long prize, String convertPrize) {
        this.count = count;
        this.prize = prize;
        this.convertPrize = convertPrize;
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

    public static Rank determineRank(int count, boolean bonus) {

        for (Rank rank : values()) {
            if (rank.matches(count, bonus)) {
                return rank;
            }
        }
        throw new IllegalArgumentException(ERROR_MESSAGE);
    }
}
