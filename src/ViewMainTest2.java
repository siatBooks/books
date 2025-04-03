import java.util.Scanner;
import java.util.Random;

public class ViewMainTest2 {
    private static final Random random = new Random();
    private static final String BORDER = "✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧";
    private static final String SUB_BORDER = "───────────────────────────────────────────";

    // 데이터베이스 연결을 위한 템플릿 (추후 구현)
    static class Book {
        String title;
        String author;
        int price;
        String type;
        
        public Book(String title, String author, int price, String type) {
            this.title = title;
            this.author = author;
            this.price = price;
            this.type = type;
        }
    }

    static class MockDB {
        static Book[] getBooks(String searchType) {
            // 실제 DB 연결시 이 부분 구현
            return new Book[]{
                new Book("Java Master", "홍길동", 25000, "베스트셀러"),
                new Book("Spring Boot Guide", "이순신", 30000, "신간"),
                new Book("Python AI", "장영실", 28000, "전체")
            };
        }
    }

    // 독서 통계 메시지
    private static final String[] STATS_MSG = {
        "📊 지금까지 읽은 페이지: 에베레스트 %.1f배",
        "⏳ 독서 시간: 서울→부산 KTX %d회 왕복",
        "🌳 전자책으로 나무 %d그루 구출"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        clearScreen();
        
        printHeader("온라인 서점 시스템");
        printSection("로그인");
        System.out.print("├─ 성명: ");
        scanner.nextLine();
        System.out.print("├─ 비밀번호: ");
        scanner.nextLine();
        
        home(scanner);
    }

    private static void home(Scanner scanner) {
        while(true) {
            clearScreen();
            printHeader("메인 메뉴");
            printMenu(new String[]{
                "1. 도서 검색", 
                "2. 회원 정보", 
                "3. 주문 이력", 
                "4. 장바구니",
                "99. 종료"
            });
            
            try {
                System.out.print("\n▶ 메뉴 선택: ");
                switch(scanner.nextInt()) {
                    case 1: searchFlow(scanner); break;
                    case 2: userFlow(scanner); break;
                    case 3: orderFlow(scanner); break;
                    case 4: cartFlow(scanner); break;
                    case 99: exit(scanner); break;
                    default: errorMsg("잘못된 입력");
                }
            } catch (Exception e) {
                errorHandler(scanner, e);
            }
        }
    }

    private static void searchFlow(Scanner scanner) {
        while(true) {
            clearScreen();
            printHeader("도서 검색");
            printMenu(new String[]{
                "1. 베스트셀러", 
                "2. 신간 도서", 
                "3. 전체 검색",
                "0. 홈으로",
                "99. 종료"
            });

            System.out.print("\n▶ 검색 유형: ");
            int type = scanner.nextInt();
            scanner.nextLine();
            
            if(type == 0) return;
            if(type == 99) exit(scanner);
            
            System.out.print("\n🔍 검색어 입력: ");
            String keyword = scanner.nextLine();
            
            // 데이터베이스에서 실제 검색
            Book[] results = MockDB.getBooks(getSearchType(type));
            displayResults(results, keyword, scanner);
        }
    }

    private static void displayResults(Book[] books, String keyword, Scanner scanner) {
        clearScreen();
        printHeader("검색 결과");
        System.out.printf("├─ 검색어: %s\n", keyword);
        System.out.println(SUB_BORDER);
        
        for(int i=0; i<books.length; i++) {
            System.out.printf("%d. %s\n", i+1, books[i].title);
            System.out.printf("├─ 저자: %s\n", books[i].author);
            System.out.printf("├─ 가격: %,d원\n", books[i].price);
            System.out.println(SUB_BORDER);
        }
        
        printMenu(new String[]{
            "1. 상세보기", 
            "2. 정렬 변경", 
            "0. 이전 메뉴",
            "99. 종료"
        });
        
        handleResultAction(scanner, books);
    }

    private static void handleResultAction(Scanner scanner, Book[] books) {
        System.out.print("\n▶ 액션 선택: ");
        switch(scanner.nextInt()) {
            case 1: 
                showDetail(scanner, books[0]); // 실제 구현시 인덱스 처리 필요
                break;
            case 2: 
                sortResults(scanner);
                break;
            case 0: return;
            case 99: exit(scanner);
            default: errorMsg("잘못된 선택");
        }
    }

    private static void showDetail(Scanner scanner, Book book) {
        clearScreen();
        printHeader("도서 상세");
        System.out.printf("├─ 제목: %s\n", book.title);
        System.out.printf("├─ 저자: %s\n", book.author);
        System.out.printf("├─ 가격: %,d원\n", book.price);
        System.out.println(SUB_BORDER);
        System.out.println("📈 " + getRandomStat());
        
        printMenu(new String[]{
            "1. 장바구니 담기", 
            "2. 바로 구매", 
            "0. 돌아가기"
        });
        
        handlePurchase(scanner, book);
    }

    private static void handlePurchase(Scanner scanner, Book book) {
        System.out.print("\n▶ 선택: ");
        switch(scanner.nextInt()) {
            case 1: 
                addToCart(scanner, book);
                break;
            case 2: 
                processPayment(scanner, book);
                break;
            case 0: return;
        }
    }

    private static void addToCart(Scanner scanner, Book book) {
        System.out.print("\n▶ 수량 입력: ");
        int qty = scanner.nextInt();
        System.out.printf("\n✅ %s %d권 장바구니 추가\n", book.title, qty);
        pause(scanner);
    }

    private static void processPayment(Scanner scanner, Book book) {
        System.out.print("\n▶ 수량 입력: ");
        int qty = scanner.nextInt();
        System.out.printf("\n✅ %s %d권 구매 완료\n", book.title, qty);
        System.out.println("📊 " + getRandomStat());
        pause(scanner);
    }

    // 기타 메서드들...
    
    private static String getRandomStat() {
        return STATS_MSG[random.nextInt(STATS_MSG.length)]
            .formatted(random.nextDouble()*10, random.nextInt(50)+1, random.nextInt(20)+1);
    }

    private static void printHeader(String title) {
        System.out.println(BORDER);
        System.out.printf("✦\t%s\n", title);
        System.out.println(BORDER);
    }

    private static void printMenu(String[] items) {
        System.out.println("\n" + SUB_BORDER);
        for(String item : items) {
            System.out.printf("│ %s\n", item);
        }
        System.out.println(SUB_BORDER);
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void pause(Scanner scanner) {
        System.out.print("\n계속하려면 엔터를 누르세요...");
        scanner.nextLine();
    }

    private static void errorMsg(String msg) {
        System.out.println("\n⚠ " + msg);
    }

    private static void exit(Scanner scanner) {
        System.out.println("\n❤ 이용해주셔서 감사합니다!");
        System.exit(0);
    }
}
