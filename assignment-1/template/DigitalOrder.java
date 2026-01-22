package template;

public class DigitalOrder extends Order {
    @Override
    protected void deliver() {
        System.out.println("emailing download link to user");
    }
}
