package cyber.hometown2.pojo;

//实体类
public class UserInfo {
    private Integer userid;
    private String username;
    private String password;
    private String power;

    public UserInfo() {
    }

    public UserInfo(Integer userid, String username, String password, String power) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.power = power;
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

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public Integer getUserid() {
        return userid;
    }
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
