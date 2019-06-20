package cn.byau.pojo;

public class User {
    private String userID;

    private String userName;

    private String password;

    private String email;

    private String userType;

    private String photo;

    private String contactsNo;
    
    private String contactsName; 

    public User(String userID, String userName, String password, String email, String userType, String photo, String contactsNo) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.userType = userType;
        this.photo = photo;
        this.contactsNo = contactsNo;

    }

    public User() {
        super();
    }


	public String getContactsName() {
		return contactsName;
	}

	public void setContactsName(String contactsName) {
		this.contactsName = contactsName;
	}

	public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID == null ? null : userID.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
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
        sb.append(", userID=").append(userID);
        sb.append(", userName=").append(userName);
        sb.append(", password=").append(password);
        sb.append(", email=").append(email);
        sb.append(", userType=").append(userType);
        sb.append(", photo=").append(photo);
        sb.append(", contactsNo=").append(contactsNo);
        sb.append("]");
        return sb.toString();
    }
}