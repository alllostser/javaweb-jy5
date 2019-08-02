package pojo;



public class Users {
    private Integer uid;
    private String uname;
    private String psd;
    private String tel;
    private Integer type = 0;
    private Integer states = 0;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPas() {
        return psd;
    }

    public void setPas(String pas) {
        this.psd = pas;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStates() {
        return states;
    }

    public void setStates(Integer states) {
        this.states = states;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", pas='" + psd + '\'' +
                ", tel='" + tel + '\'' +
                ", type=" + type +
                ", states=" + states +
                '}';
    }
}
