package tech.diana.domain;

public class Squad {
    private int sSize;
    private  String sName;
    private String sCause;
    private int sId;

    public Squad(int sSize, String sName, String sCause, int sId) {
        this.sSize = sSize;
        this.sName = sName;
        this.sCause = sCause;
        this.sId = sId;
    }

    public int getsSize() {
        return sSize;
    }

    public void setsSize(int sSize) {
        this.sSize = sSize;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsCause() {
        return sCause;
    }

    public void setsCause(String sCause) {
        this.sCause = sCause;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }
}