package com.lyz.domain.response;

import com.lyz.domain.Member;
import com.lyz.domain.Rank;

import java.io.Serializable;
import java.util.List;

public class RankMember extends Rank implements Serializable {
    private List<Member> members;

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
