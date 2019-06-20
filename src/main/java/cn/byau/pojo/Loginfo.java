package cn.byau.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Loginfo {
    private Integer id;

    private String userid;

    private Date logintime;

    private String shebei;

    private String operation;

    private String ip;
    
    private User user;

    public Loginfo(Integer id, String userid, Date logintime, String shebei, String operation, String ip) {
        this.id = id;
        this.userid = userid;
        this.logintime = logintime;
        this.shebei = shebei;
        this.operation = operation;
        this.ip = ip;
    }

    
    
    public Loginfo(String userid, Date logintime, String shebei, String operation, String ip) {
		super();
		this.userid = userid;
		this.logintime = logintime;
		this.shebei = shebei;
		this.operation = operation;
		this.ip = ip;
	}



	public Loginfo() {
        super();
    }

    
    
    

	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getLogintime() {
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(logintime);
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public String getShebei() {
        return shebei;
    }

    public void setShebei(String shebei) {
        this.shebei = shebei == null ? null : shebei.trim();
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", logintime=").append(logintime);
        sb.append(", shebei=").append(shebei);
        sb.append(", operation=").append(operation);
        sb.append(", ip=").append(ip);
        sb.append("]");
        return sb.toString();
    }
}