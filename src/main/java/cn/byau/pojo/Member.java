package cn.byau.pojo;

public class Member {
    private Integer memberid;

    private String username;

    private String title;

    private String email;

    private String context;

    private String magdate;

    private String contactsNo;
    
    private String contactsName;

    public Member(Integer memberid, String username, String title, String email, String context, String magdate, String contactsNo) {
        this.memberid = memberid;
        this.username = username;
        this.title = title;
        this.email = email;
        this.context = context;
        this.magdate = magdate;
        this.contactsNo = contactsNo;
    }

    public Member() {
        super();
    }

    
    
    public String getContactsName() {
		return contactsName;
	}

	public void setContactsName(String contactsName) {
		this.contactsName = contactsName;
	}

	public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public String getMagdate() {
        return magdate;
    }

    public void setMagdate(String magdate) {
        this.magdate = magdate == null ? null : magdate.trim();
    }

    public String getContactsNo() {
        return contactsNo;
    }

    public void setContactsNo(String contactsNo) {
        this.contactsNo = contactsNo == null ? null : contactsNo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", memberid=").append(memberid);
        sb.append(", username=").append(username);
        sb.append(", title=").append(title);
        sb.append(", email=").append(email);
        sb.append(", context=").append(context);
        sb.append(", magdate=").append(magdate);
        sb.append(", contactsNo=").append(contactsNo);
        sb.append("]");
        return sb.toString();
    }
}