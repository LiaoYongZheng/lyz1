package com.lyz.domain.response;

import com.lyz.domain.Member;
import com.lyz.domain.Rank;

import java.io.Serializable;

public class MemberRank extends Member implements Serializable {
    private Rank rank;

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
}
