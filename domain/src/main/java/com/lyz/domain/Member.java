package com.lyz.domain;

import com.lyz.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable {
    private int id;
    private String username;
    private String password;
    private String sex;
    private int phoneNumber;
    private String email;
    private String address;
    private int status;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date createDate;
    private String createDateStr;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date updateDate;
    private String updateDateStr;
    private int memberRank;
    private Rank rank;

    public Member() {
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", createDate=" + createDate +
                ", createDateStr='" + createDateStr + '\'' +
                ", updateDate=" + updateDate +
                ", updateDateStr='" + updateDateStr + '\'' +
                ", memberRank=" + memberRank +
                ", rank=" + rank +
                '}';
    }

    public String getCreateDateStr() {
        if(createDate != null){
            createDateStr = DateUtils.date2String(createDate,"yyyy-MM-dd HH:mm:ss");
        }
        return createDateStr;
    }

    public void setCreateDateStr(String createDateStr) {
        this.createDateStr = createDateStr;
    }

    public String getUpdateDateStr() {
        if (updateDate != null){
            updateDateStr = DateUtils.date2String(updateDate,"yyyy-MM-dd HH:mm:ss");
        }
        return updateDateStr;
    }

    public void setUpdateDateStr(String updateDateStr) {
        this.updateDateStr = updateDateStr;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public int getMemberRank() {
        return memberRank;
    }

    public void setMemberRank(int memberRank) {
        this.memberRank = memberRank;
    }

}
