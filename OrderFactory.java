package Order;


public class OrderFactory {
    public static Order createOrder(String orderString) {
        switch (orderString){
            case "abs": return new absOrder();
            case "type": return new typeOrder();
            case "size": return new sizeOrder();
            default: return new absOrder();
        }
    }
}
