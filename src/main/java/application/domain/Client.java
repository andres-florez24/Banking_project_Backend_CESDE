package application.domain;

public class Client {
    protected int id;
    protected String identification;
    protected String fullName;
    protected String cellPhone;
    protected String userName;
    protected String password;
    protected int failedIntents;
    protected boolean isBlocked;

    public Client(int id, String identification, String fullName, String cellPhone, String userName, String password, int failedIntents, boolean isBlocked) {
        this.id = id;
        this.identification = identification;
        this.fullName = fullName;
        this.cellPhone = cellPhone;
        this.userName = userName;
        this.password = password;
        this.failedIntents = failedIntents;
        this.isBlocked = isBlocked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFailedIntents() {
        return failedIntents;
    }

    public void setFailedIntents(int failedIntents) {
        this.failedIntents = failedIntents;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", identification=" + identification +
                ", fullName=" + fullName +
                ", cellPhone=" + cellPhone +
                ", userName=" + userName +
                ", failedIntents=" + failedIntents +
                ", isBlocked=" + isBlocked +
                "}";
    }
}
