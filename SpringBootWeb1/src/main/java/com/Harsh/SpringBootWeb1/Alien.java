package com.Harsh.SpringBootWeb1;

public class Alien {
    private int aid;
    private String aname;

    public int getId() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "id=" + aid +
                ", aname='" + aname + '\'' +
                '}';
    }
}
