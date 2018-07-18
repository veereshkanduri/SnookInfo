package edu.cpp.cs499.snookinfo;

public class ReadData {
    String begin;
    String name1;
    String name2;
    String score1;
    String score2;

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getScore1() {
        return score1;
    }

    public void setScore1(String score1) {
        this.score1 = score1;
    }

    public String getScore2() {
        return score2;
    }

    public void setScore2(String score2) {
        this.score2 = score2;
    }

    public ReadData(String begin, String name1, String name2, String score1, String score2) {
        this.begin = begin;
        this.name1 = name1;
        this.name2 = name2;
        this.score1 = score1;
        this.score2 = score2;
    }
}
