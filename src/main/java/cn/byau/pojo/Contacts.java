package cn.byau.pojo;

public class Contacts {
    private String contactsNo;

    private String contactsName;

    public Contacts(String contactsNo, String contactsName) {
        this.contactsNo = contactsNo;
        this.contactsName = contactsName;
    }

    public Contacts() {
        super();
    }

    public String getContactsNo() {
        return contactsNo;
    }

    public void setContactsNo(String contactsNo) {
        this.contactsNo = contactsNo == null ? null : contactsNo.trim();
    }

    public String getContactsName() {
        return contactsName;
    }

    public void setContactsName(String contactsName) {
        this.contactsName = contactsName == null ? null : contactsName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", contactsNo=").append(contactsNo);
        sb.append(", contactsName=").append(contactsName);
        sb.append("]");
        return sb.toString();
    }
}