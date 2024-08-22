package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Rank {

    // 등수별(1~5등) 당첨 개수
    private List<Integer> rankList = new ArrayList<>(5);

    public List<Integer> getRankList() {
        return rankList;
    }

    public void setRankList(List<Integer> rankList) {
        this.rankList = rankList;
    }
}
