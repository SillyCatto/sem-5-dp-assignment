package template;

public class PhysicalOrder extends Order {
    @Override
    protected void deliver() {
        System.out.println("shipping physical book to order address");
    }
}
