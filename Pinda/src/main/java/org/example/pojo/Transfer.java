package org.example.pojo;

public class Transfer {
    private String transfer;
    private Integer dishd;
    private Integer disdb;
    private Integer disxb;
    private Integer dishb;
    private Integer diszn;
    private Integer disxn;

    public String getTransfer() {
        return transfer;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }

    public Integer getDishd() {
        return dishd;
    }

    public void setDishd(Integer dishd) {
        this.dishd = dishd;
    }

    public Integer getDisdb() {
        return disdb;
    }

    public void setDisdb(Integer disdb) {
        this.disdb = disdb;
    }

    public Integer getDisxb() {
        return disxb;
    }

    public void setDisxb(Integer disxb) {
        this.disxb = disxb;
    }

    public Integer getDishb() {
        return dishb;
    }

    public void setDishb(Integer dishb) {
        this.dishb = dishb;
    }

    public Integer getDiszn() {
        return diszn;
    }

    public void setDiszn(Integer diszn) {
        this.diszn = diszn;
    }

    public Integer getDisxn() {
        return disxn;
    }

    public void setDisxn(Integer disxn) {
        this.disxn = disxn;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "transfer='" + transfer + '\'' +
                ", dishd=" + dishd +
                ", disdb=" + disdb +
                ", disxb=" + disxb +
                ", dishb=" + dishb +
                ", diszn=" + diszn +
                ", disxn=" + disxn +
                '}';
    }
}
