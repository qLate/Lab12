package chainofresponsibility;

import lombok.Setter;

public class Handler {
    private final int quantity;
    @Setter
    private Handler next;

    public Handler(int quantity) {
        this.quantity = quantity;
    }

    public int process(int amount) {
        if (next != null)
            return next.process(amount % quantity);
        else if (amount % quantity > 0) {
            throw new IllegalArgumentException();
        }
        System.out.println(quantity + " * " + amount / quantity);
        return amount / quantity;
    }
}
