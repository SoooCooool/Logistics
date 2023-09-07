package org.example.pojo;

public class Transfer {
    private String transfer;
    private Integer dis_hd;
    private Integer dis_db;
    private Integer dis_xb;
    private Integer dis_hb;
    private Integer dis_zn;
    private Integer dis_xn;

    public String getTransfer() {
        return transfer;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }

    public Integer getDis_hd() {
        return dis_hd;
    }

    public void setDis_hd(Integer dis_hd) {
        this.dis_hd = dis_hd;
    }

    public Integer getDis_db() {
        return dis_db;
    }

    public void setDis_db(Integer dis_db) {
        this.dis_db = dis_db;
    }

    public Integer getDis_xb() {
        return dis_xb;
    }

    public void setDis_xb(Integer dis_xb) {
        this.dis_xb = dis_xb;
    }

    public Integer getDis_hb() {
        return dis_hb;
    }

    public void setDis_hb(Integer dis_hb) {
        this.dis_hb = dis_hb;
    }

    public Integer getDis_zn() {
        return dis_zn;
    }

    public void setDis_zn(Integer dis_zn) {
        this.dis_zn = dis_zn;
    }

    public Integer getDis_xn() {
        return dis_xn;
    }

    public void setDis_xn(Integer dis_xn) {
        this.dis_xn = dis_xn;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "location='" + transfer + '\'' +
                ", dis_hd=" + dis_hd +
                ", dis_db=" + dis_db +
                ", dis_xb=" + dis_xb +
                ", dis_hb=" + dis_hb +
                ", dis_zn=" + dis_zn +
                ", dis_xn=" + dis_xn +
                '}';
    }
}
