import java.util.Scanner;

public class ViewMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===================온라인 서점 시스템============");
        System.out.println(">> 로그인 >>");
        System.out.print("성명:");
        scanner.nextInt();
        System.out.println();

        System.out.print("비밀번호:");
        scanner.nextInt();
        System.out.println();

        while (true) {
            try {
                System.out.println("====================[홈페이지]====================");
                System.out.println("= 1. 도서 검색   ");
                System.out.println("= 2. 회원 정보 조회 ");
                System.out.println("= 3. 주문 이력 확인 ");
                System.out.println("= 4. 장바구니 보기  ");
                System.out.println("= 99. 종료     ");
                System.out.println("====================");
                // System.out.println("* 숫자 8을 입력하면 모든 화면에서 장바구니 보기 화면으로 넘어갑니다");
                int num = scanner.nextInt();

                switch (num) {
                    case 1:
                        search(); break;
                    case 2:
                        user(); break;
                    case 3:
                        System.out.println("주문 리스트");
                        System.out.println("주문 리스트");
                        System.out.println("주문 리스트");
                        System.out.println("주문 리스트");
                        break;
                    case 4:
                        System.out.println("주문 리스트");
                        System.out.println("주문 리스트");
                        System.out.println("주문 리스트");
                        System.out.println("주문 리스트");
                        break;
                
                    case 99:
                        exit();
                    
                    // 그외 모두는 종료버튼으로 간주해보자.
                    default:
                        exit();
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void exit() {
        System.out.println("시스템 종료? (y/n)");
        Scanner scanner1 = new Scanner(System.in);
        String str = scanner1.nextLine();
        if (str.equals("y")) {
            System.exit(0);
        } else if (str.equals("n")) {
            System.out.println("\n\n\n\n\n");
            System.out.println("초기 화면으로 돌아갑니다.");
        } else {
            System.out.println("\n\n\n\n\n");
            System.out.println("입력이 잘못 되었습니다. 초기 화면으로 돌아갑니다.");
        }
    }

    private static void user() {
        while (true) {
            try {
                System.out.println("> 유저 정보 조회");
                System.out.println("> 유저 정보 리스트");
                System.out.println("> 유저 정보 리스트");
                System.out.println("> 유저 정보 리스트");
                System.out.println("> 유저 정보 리스트");
                System.out.println("원하시는 번호를 선택하세요 : ");
                System.out.println("1 회원 정보 수정  2 상위 메뉴 이동 99 종료");
                System.out.println("* 숫자 8을 입력하면 모든 화면에서 장바구니 보기 화면으로 넘어갑니다");
                Scanner scanner = new Scanner(System.in);
                int num = scanner.nextInt();

                switch (num) {
                    case 1:
                        System.out.println("검색");
                        break;
                    case 2:
                        return;
                    case 99:
                        exit();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    private static void search() {
        while (true) {
            try {
                System.out.println("검색유형을 선택해주세요 : ");
                System.out.println("1 베스트셀러 검색  2 신간 검색 3 전체 검색 4 상위메뉴 이동 99 종료");
                System.out.println("* 숫자 8을 입력하면 모든 화면에서 장바구니 보기 화면으로 넘어갑니다");

                System.out.println("> 서적 검색");
                System.out.println("검색어를 입력해주세요 : ");
                System.out.println("> 서적 리스트1");
                System.out.println("> 서적 리스트2");
                System.out.println("> 서적 리스트3");
                System.out.println("> 서적 리스트4");
                System.out.println("정렬을 선택해주세요 : ");
                System.out.println("1 베스트셀러 순위  2 리뷰 순위 3 구매 순위 4 선택 99 종료");

                Scanner scanner = new Scanner(System.in);
                int num = scanner.nextInt();

                switch (num) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        return;
                    case 4:
                        detail();
                    case 99:
                        exit();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    private static void detail() {
        while (true) {
            try {
                System.out.println("> 책 상세 정보");
                System.out.println("- 서적명:");
                System.out.println("- 저자:");
                System.out.println("> 중고 서적 가격표");
                System.out.println("- 최상 : ");
                System.out.println("- 상 : ");
                System.out.println("- 중 : ");
                System.out.println("원하시는 번호를 선택하세요 : ");
                System.out.println("1 장바구니 담기  2 해당 서적 바로 구매 3 상위 메뉴 이동 99 종료");
                Scanner scanner = new Scanner(System.in);
                int num = scanner.nextInt();

                switch (num) {
                    case 1:
                        System.out.println("서적 상태 선택: ");
                        System.out.println("1 최상 2 상 3 중");
                        int i = scanner.nextInt();
                        System.out.println("수량 입력");
                        int j = scanner.nextInt();

                        System.out.println("장바구니에 담겼습니다");
                        break;
                    case 2:
                        System.out.println("서적 상태 선택: ");
                        System.out.println("1 최상 2 상 3 중");
                        int k = scanner.nextInt();
                        System.out.println("수량 입력");
                        int l= scanner.nextInt();

                        order();

                        break;
                    case 3:
                        return;
                    case 99:
                        exit();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    private static void order() {
        while (true) {
            try {
                System.out.println("> 주문 페이지");
                System.out.println("캡슐 문장");
                System.out.println("1 주문 2 상위 메뉴 이동 99 종료");
                System.out.println("원하시는 번호를 선택하세요 : ");

                Scanner scanner = new Scanner(System.in);
                int num = scanner.nextInt();

                switch (num) {
                    case 1:
                        System.out.println("주문 중입니다");
                        System.out.println("주문이 완료되었습니다");
                        break;
                    case 2:
                        return;
                    case 99:
                        exit();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
