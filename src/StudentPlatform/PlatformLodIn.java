package StudentPlatform;

public class PlatformLodIn {
    String name;
    String password;
    String number;
    String phonenumber;
    public PlatformLodIn() {
    }

    public PlatformLodIn(String name, String password, String number, String phonenumber) {
        this.name = name;
        this.password = password;
        this.number = number;
        this.phonenumber = phonenumber;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return number
     */
    public String getNumber() {
        return number;
    }

    /**
     * 设置
     * @param number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * 获取
     * @return phonenumber
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * 设置
     * @param phonenumber
     */
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String toString() {
        return "LodIn{name = " + name + ", password = " + password + ", number = " + number + ", phonenumber = " + phonenumber + "}";
    }
}
