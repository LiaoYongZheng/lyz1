package com.lyz.domain;

import java.io.Serializable;
import java.util.Date;

public class Rank implements Serializable {
    private int id;
    private String description;
    private String rankName;
    private Date createDate;
    private Date updateDate;
    private int status;

    public Rank() {
    }

    public Rank(int id, String description, String rankName, Date createDate, Date updateDate, int status) {

        this.id = id;
        this.description = description;
        this.rankName = rankName;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", rankName='" + rankName + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", status=" + status +
                '}';
    }
}
