package codingon.spring_boot_default.IoCT;

public class SMSNotificationService implements NotificationService{
  @Override
  public void sendingNotification() {
    System.out.println("Sending SMS Notification : your order has been processed");
  }
}
