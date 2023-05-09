package Users;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class PremiumUser extends User {
    private LocalDateTime SubscribtionEnds = LocalDateTime.of(2023, 4, 11, 0, 0, 0);
    public PremiumUser(String username, String password) {
        super(username, password, true);
    }

    public boolean validate(String username, String password) {
        return ("2").equals(username) && ("2").equals(password);
    }
    @Override
    public void extendSubscription(int days_extending){
        SubscribtionEnds = SubscribtionEnds.plusDays(days_extending/2);
    }
    @Override
    public double SubscriptionDaysLeft(){
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(now, SubscribtionEnds);
        return duration.toDays() + ((double)duration.toHours() / 24);
    }
}

