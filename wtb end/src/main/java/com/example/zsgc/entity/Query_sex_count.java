package com.example.zsgc.entity;

public class Query_sex_count {
    private int boyCnt;
    private int girlCnt;

    public Query_sex_count(int boyCnt, int girlCnt) {
        this.boyCnt = boyCnt;
        this.girlCnt = girlCnt;
    }

    public int getBoyCnt() {
        return boyCnt;
    }

    public void setBoyCnt(int boyCnt) {
        this.boyCnt = boyCnt;
    }

    public int getGirlCnt() {
        return girlCnt;
    }

    public void setGirlCnt(int girlCnt) {
        this.girlCnt = girlCnt;
    }
}
