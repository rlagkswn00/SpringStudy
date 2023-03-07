package hello.core.order;

public interface OrderService {
    Order creataeOrder(Long memberId, String itemName, int itemPrice);
}
