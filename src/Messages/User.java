package Messages;

public class User {

    public static String STATUS_ONLINE = "online";
    public static String STATUS_OFFLINE = "offline";
    private String name;
    private String status;
    private boolean isAdmin;

    public User(String name, String status, boolean isAdmin) {
        this.name = name;
        switch (status) {
            case "offline":
                this.status=STATUS_OFFLINE;
                break;
            case "online":
                this.status=STATUS_ONLINE;
                break;
            default:
                throw new IllegalArgumentException("Wrong User Status!");
        }
        this.isAdmin = isAdmin;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }


}
