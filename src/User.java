public class User {
    private String username;
    private int xp;

    public User(String username) {
        this.username = username;
        this.xp = 0;
    }

    public String getUsername() {
        return username;
    }

    public int getXp() {
        return xp;
    }

    public void addXp(int amount) {
        xp += amount;
    }
}