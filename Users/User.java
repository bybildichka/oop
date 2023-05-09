package Users;
public abstract class User {
    private String username;
    private String password;
    private boolean isPremium;

    public User(String username, String password, boolean isPremium) {
        this.username = username;
        this.password = password;
        this.isPremium = isPremium;
    }

    public abstract boolean validate(String username, String password);

    public void extendSubscription(int days_extending){}
    public double SubscriptionDaysLeft(){
        return Double.MIN_VALUE;
    }
    public boolean getIsPremium(){
        return isPremium;
    }
}