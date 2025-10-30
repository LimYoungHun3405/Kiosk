package src;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<MenuItem> cartItems = new ArrayList<>();

    public void addItem(MenuItem item) {
        cartItems.add(item);
        System.out.println(item.getName() + "이(가) 장바구니에 추가되었습니다.");
    }

    public void showCart() {
        System.out.println("\n[ 장바구니 목록 ]");
        if (cartItems.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
            return;
        }
        double total = 0;
        for (MenuItem item : cartItems) {
            System.out.println("- " + item);
            total += item.getPrice();
        }
        System.out.printf("총 금액: W %.1f\n", total);
    }

    public void clearCart() {
        cartItems.clear();
        System.out.println("장바구니가 비워졌습니다.");
    }

    public boolean isEmpty() {
        return cartItems.isEmpty();
    }
}
