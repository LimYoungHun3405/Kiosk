package src;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Lv1~2: 메뉴 아이템 생성
        Menu burgers = new Menu("Burgers");
        burgers.addItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.addItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.addItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.addItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Menu drinks = new Menu("Drinks");
        drinks.addItem(new MenuItem("Coke", 2.5, "시원한 코카콜라"));
        drinks.addItem(new MenuItem("Sprite", 2.5, "청량한 스프라이트"));

        Menu desserts = new Menu("Desserts");
        desserts.addItem(new MenuItem("Ice Cream", 3.9, "바닐라 아이스크림"));
        desserts.addItem(new MenuItem("Shake", 4.5, "달콤한 쉐이크"));

        List<Menu> allMenus = new ArrayList<>();
        allMenus.add(burgers);
        allMenus.add(drinks);
        allMenus.add(desserts);

        // Lv3~도전Lv1: Kiosk 실행
        Kiosk kiosk = new Kiosk(allMenus);
        kiosk.start();
    }
}
