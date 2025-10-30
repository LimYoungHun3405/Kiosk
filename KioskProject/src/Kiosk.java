package src;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus;
    private Cart cart;

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
        this.cart = new Cart();
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n[ MAIN MENU ]");
            for (int i = 0; i < menus.size(); i++) {
                System.out.println((i + 1) + ". " + menus.get(i).getCategoryName());
            }
            System.out.println("C. 장바구니 보기");
            System.out.println("0. 종료      | 종료");

            System.out.print("메뉴를 선택하세요: ");
            String input = sc.nextLine();

            try {
                if (input.equalsIgnoreCase("0")) {
                    System.out.println("프로그램을 종료합니다.");
                    running = false;
                } else if (input.equalsIgnoreCase("C")) {
                    cart.showCart();
                } else {
                    int choice = Integer.parseInt(input);
                    if (choice > 0 && choice <= menus.size()) {
                        showCategoryMenu(menus.get(choice - 1), sc);
                    } else {
                        System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자나 C를 입력해주세요.");
            }
        }
    }

    private void showCategoryMenu(Menu menu, Scanner sc) {
        boolean back = false;
        while (!back) {
            menu.showMenuItems();
            System.out.print("메뉴 번호를 선택하세요: ");
            String input = sc.nextLine();

            try {
                if (input.equalsIgnoreCase("0")) {
                    back = true;
                } else {
                    int num = Integer.parseInt(input);
                    if (num > 0 && num <= menu.getMenuItems().size()) {
                        MenuItem selected = menu.getMenuItems().get(num - 1);
                        System.out.println("선택한 메뉴: " + selected);
                        cart.addItem(selected);
                    } else {
                        System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }
    }
}
