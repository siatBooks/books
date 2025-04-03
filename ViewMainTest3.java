import java.util.*;
import java.util.stream.Collectors;

public class ViewMainTest3 {
    private static final Random random = new Random();
    private static final String BORDER = "✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦";
    private static final String SUB_BORDER = "───────────────────────────────────────────";

    static class Book {
        String id;
        String title;
        String author;
        int basePrice;
        String type;
        String condition;
        String publicationDate;
        Integer reviewRank;

        public Book(String id, String title, String author, int basePrice, 
                   String type, String condition, String publicationDate, Integer reviewRank) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.basePrice = basePrice;
            this.type = type;
            this.condition = condition;
            this.publicationDate = publicationDate;
            this.reviewRank = reviewRank;
        }

        public int getPrice() {
            return switch(condition) {
                case "상" -> (int)(basePrice * 0.7);
                case "중" -> (int)(basePrice * 0.5);
                case "하" -> (int)(basePrice * 0.3);
                default -> basePrice;
            };
        }
    }

    static class MockDB {
        private static final List<Book> masterBooks = Arrays.asList(
            new Book("B001", "Java Master", "홍길동", 35000, "베스트셀러", "new", "2025-01-15", 1),
            new Book("B002", "Effective Java", "Joshua Bloch", 45000, "베스트셀러", "상", "2024-12-01", 2),
            new Book("B003", "Spring Boot Guide", "이순신", 30000, "신간", "new", "2025-03-20", null),
            new Book("B004", "React for Beginners", "Dan Abramov", 35000, "전체", "하", "2023-05-11", null),
            new Book("B005", "Python AI", "장영실", 28000, "전체", "new", "2025-02-28", null)
        );

        private static List<Book> availableBooks = new ArrayList<>(masterBooks);

        static List<Book> getBooks(String searchType) {
            return availableBooks.stream()
                .filter(book -> searchType.equals("전체") || book.type.equals(searchType))
                .collect(Collectors.toList());
        }

        static void removeBook(String bookId) {
            availableBooks.removeIf(book -> book.id.equals(bookId));
        }
    }

    static class CartItem {
        Book book;
        int quantity;

        public CartItem(Book book, int quantity) {
            this.book = book;
            this.quantity = quantity;
        }

        public int getTotalPrice() {
            return book.getPrice() * quantity;
        }
    }

    static class MockCartDB {
        private static List<CartItem> cart = new ArrayList<>();

        static void addItem(Book book, int quantity) {
            cart.add(new CartItem(book, quantity));
        }

        static List<CartItem> getCart() {
            return new ArrayList<>(cart);
        }

        static void clearCart() {
            cart.clear();
        }
    }

    private static final String[] PURCHASE_MESSAGES = {
        "지금까지 읽으신 책의 총 페이지를 쌓으면 에베레스트 높이의 3배에 달합니다.",
        "당신이 읽은 책들을 쌓으면 남산타워 15개를 세운 높이입니다."
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

    // printSection 메서드 구현
    private static void printSection(String title) {
        System.out.println("\n" + BORDER);
        System.out.printf("✦ %s ✦\n", title);
        System.out.println(BORDER + "\n");
    }

    private static void home(Scanner scanner) {
        while(true) {
            clearScreen();
            printHeader("메인 메뉴");
            System.out.println("└─ 원하는 메뉴를 선택하세요");
            System.out.println(SUB_BORDER);
            
            printMenu(new ArrayList<>(Arrays.asList(
                "1. 도서 검색", 
                "2. 장바구니 관리", 
                "99. 종료"
            )));
            
            try {
                System.out.print("\n▶ 메뉴 선택: ");
                int choice = getValidNumber(scanner, 1, 99);
                switch(choice) {
                    case 1: searchFlow(scanner); break;
                    case 2: cartFlow(scanner); break;
                    case 99: exit(scanner); break;
                }
            } catch (Exception e) {
                errorHandler(e);
            }
        }
    }

    private static void searchFlow(Scanner scanner) {
        while(true) {
            clearScreen();
            printHeader("도서 검색");
            System.out.println("└─ 검색할 도서 종류를 선택하세요");
            System.out.println("───────────────────────────────────────────");
            printMenu(new ArrayList<>(Arrays.asList(
                "1. 베스트셀러", 
                "2. 신간", 
                "3. 전체"
            )));
            System.out.print("\n▶ 검색할 도서 종류 (0: 뒤로가기): ");

            int choice = getValidNumber(scanner, 0, 3);
            if(choice == 0) return;
            
            String searchType = switch(choice) {
                case 1 -> "베스트셀러";
                case 2 -> "신간";
                case 3 -> "전체";
                default -> "";
            };

            System.out.print("\n🔍 검색어 입력: ");
            String keyword = scanner.next();
            
            List<Book> results = MockDB.getBooks(searchType).stream()
                .filter(book -> book.title.contains(keyword))
                .collect(Collectors.toList());
                
            handleSearchResults(results, searchType, keyword, scanner);
        }
    }

    private static void handleSearchResults(List<Book> books, String type, String keyword, Scanner scanner) {
        clearScreen();
        printHeader("'" + keyword + "' 검색 결과 (" + type + ")");

        if(books.isEmpty()) {
            System.out.println("\n⚠ 검색 결과가 없습니다");
            pause(scanner);
            return;
        }

        System.out.println("\n[정렬 옵션]");
        List<String> sortOptions = new ArrayList<>(Arrays.asList(
            "1. 가격 낮은 순", 
            "2. 가격 높은 순", 
            "3. 출판일 최신순"
        ));
        
        if(type.equals("베스트셀러")) {
            sortOptions.add("4. 리뷰 순위 순");
        }
        sortOptions.add("0. 기본 정렬(가나다순)");
        printMenu(sortOptions);

        int sortChoice = getValidNumber(scanner, 0, sortOptions.size());
        sortBooks(books, sortChoice, type);

        displayBooks(books);
        handleBookSelection(books, scanner);
    }

    private static void sortBooks(List<Book> books, int sortChoice, String type) {
        switch(sortChoice) {
            case 1 -> books.sort(Comparator.comparingInt(Book::getPrice));
            case 2 -> books.sort((b1, b2) -> b2.getPrice() - b1.getPrice());
            case 3 -> books.sort((b1, b2) -> b2.publicationDate.compareTo(b1.publicationDate));
            case 4 -> {
                if(type.equals("베스트셀러")) {
                    books.sort(Comparator.comparingInt(b -> b.reviewRank));
                }
            }
            default -> books.sort(Comparator.comparing(b -> b.title));
        }
    }

    private static void displayBooks(List<Book> books) {
        int index = 1;
        for(Book book : books) {
            System.out.printf("\n%d. %s\n", index++, book.title);
            System.out.printf("├─ ID: %s\n", book.id);
            System.out.printf("├─ 저자: %s\n", book.author);
            System.out.printf("├─ 가격: %,d원\n", book.getPrice());
            System.out.printf("├─ 상태: %s\n", getConditionText(book.condition));
            System.out.printf("├─ 출판일: %s\n", book.publicationDate);
            if(book.reviewRank != null) {
                System.out.printf("└─ 리뷰 순위: %d위\n", book.reviewRank);
            }
            System.out.println(SUB_BORDER);
        }
    }

    private static String getConditionText(String condition) {
        return switch(condition) {
            case "new" -> "신상품";
            case "상" -> "중고-상";
            case "중" -> "중고-중"; 
            case "하" -> "중고-하";
            default -> "알 수 없음";
        };
    }

    private static void handleBookSelection(List<Book> books, Scanner scanner) {
        System.out.print("\n▶ 상세보기 할 도서 번호 (0: 뒤로가기): ");
        int choice = getValidNumber(scanner, 0, books.size());
        if(choice != 0) showBookDetail(books.get(choice-1), scanner);
    }

    private static void showBookDetail(Book book, Scanner scanner) {
        clearScreen();
        printHeader("[상세 정보] " + book.title);
        System.out.printf("├─ ISBN: %s\n", book.id);
        System.out.printf("├─ 저자: %s\n", book.author);
        System.out.printf("├─ 정가: %,d원\n", book.basePrice);
        System.out.printf("├─ 판매가: %,d원\n", book.getPrice());
        System.out.printf("├─ 상태: %s\n", getConditionText(book.condition));
        System.out.printf("├─ 출판일: %s\n", book.publicationDate);
        if(book.reviewRank != null) {
            System.out.printf("├─ 리뷰 순위: %d위\n", book.reviewRank);
        }
        System.out.println(SUB_BORDER);


        printMenu(new ArrayList<>(Arrays.asList("1. 전체 구매", "2. 장바구니 비우기", "0. 뒤로가기"))); // new String[]{"1. 전체 구매", "2. 장바구니 비우기", "0. 뒤로가기"}

        handlePurchaseChoice(book, scanner);
    }

    private static void handlePurchaseChoice(Book book, Scanner scanner) {
        int choice = getValidNumber(scanner, 0, 2);
        switch(choice) {
            case 1 -> handleAddToCart(book, scanner);
            case 2 -> processPurchase(book, scanner);
        }
    }

    private static void handleAddToCart(Book book, Scanner scanner) {
        System.out.print("\n▶ 수량 입력: ");
        int quantity = getValidNumber(scanner, 1, 10);
        MockCartDB.addItem(book, quantity);
        System.out.printf("\n✅ %s %d권 장바구니 추가 완료!\n", book.title, quantity);
        pause(scanner);
    }

    private static void processPurchase(Book book, Scanner scanner) {
        System.out.print("\n▶ 수량 입력: ");
        int quantity = getValidNumber(scanner, 1, 10);
        
        System.out.println("\n================ 결제 정보 ================");
        System.out.printf("도서명: %s\n", book.title);
        System.out.printf("수량: %d권\n", quantity);
        System.out.printf("결제금액: %,d원\n", book.getPrice() * quantity);
        System.out.println("-----------------------------------------");
        System.out.println("1. 신용카드 결제 | 2. 계좌이체 | 0. 취소");
        
        int paymentType = getValidNumber(scanner, 0, 2);
        if(paymentType != 0) {
            System.out.println("✅ 결제가 완료되었습니다!");
            MockDB.removeBook(book.id);
            System.out.println("📊 " + getRandomMessage());
        }
        pause(scanner);
    }

    private static void cartFlow(Scanner scanner) {
        while(true) {
            clearScreen();
            printHeader("장바구니 관리");
            List<CartItem> cart = MockCartDB.getCart();
            
            if(cart.isEmpty()) {
                System.out.println("\n🛒 장바구니가 비어 있습니다");
                pause(scanner);
                return;
            }

            cart.forEach(item -> {
                System.out.printf("\n📘 %s\n", item.book.title);
                System.out.printf("├─ 수량: %d개\n", item.quantity);
                System.out.printf("├─ 단가: %,d원\n", item.book.getPrice());
                System.out.printf("└─ 소계: %,d원\n", item.getTotalPrice());
                System.out.println(SUB_BORDER);
            });

            printMenu(new ArrayList<>(Arrays.asList("1. 전체 구매", "2. 장바구니 비우기", "0. 뒤로가기"))); // new String[]{"1. 전체 구매", "2. 장바구니 비우기", "0. 뒤로가기"}
            handleCartAction(scanner);
        }
    }

    private static void handleCartAction(Scanner scanner) {
        int choice = getValidNumber(scanner, 0, 2);
        switch(choice) {
            case 1 -> processBulkPurchase(scanner);
            case 2 -> {
                MockCartDB.clearCart();
                System.out.println("\n✅ 장바구니를 비웠습니다");
                pause(scanner);
            }
        }
    }

    private static void processBulkPurchase(Scanner scanner) {
        System.out.println("\n================ 총 결제 정보 ================");
        int total = MockCartDB.getCart().stream()
                .mapToInt(CartItem::getTotalPrice)
                .sum();
        System.out.printf("총 결제금액: %,d원\n", total);
        System.out.println("-----------------------------------------");
        System.out.println("1. 신용카드 결제 | 2. 계좌이체 | 0. 취소");
        
        int paymentType = getValidNumber(scanner, 0, 2);
        if(paymentType != 0) {
            System.out.println("✅ 전체 결제가 완료되었습니다!");
            MockCartDB.clearCart();
        }
        pause(scanner);
    }

    // 유틸리티 메서드
    private static void printHeader(String title) {
        System.out.println(BORDER);
        System.out.println("✦\t" + title + "\t✦");
        System.out.println(BORDER);
    }

    private static void printMenu(List<String> items) {
        System.out.println(SUB_BORDER);
        for(int i=0; i<items.size(); i++) {
            System.out.printf("%2d. %s\n", i+1, items.get(i));
        }
        System.out.println(SUB_BORDER);
    }
    // 기존 printMenu(String[]) 유지
    private static void printMenu(String[] items) {
        System.out.println(SUB_BORDER);
        for (int i = 0; i < items.length; i++) {
            System.out.printf("%2d. %s\n", i + 1, items[i]);
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

    private static int getValidNumber(Scanner scanner, int min, int max) {
        while(true) {
            try {
                int input = scanner.nextInt();
                if(input >= min && input <= max) return input;
                System.out.printf("⚠ %d~%d 사이 숫자 입력 필요\n", min, max);
            } catch (InputMismatchException e) {
                System.out.println("⚠ 숫자만 입력 가능합니다");
                scanner.nextLine();
            }
        }
    }

    private static String getRandomMessage() {
        return PURCHASE_MESSAGES[random.nextInt(PURCHASE_MESSAGES.length)];
    }

    private static void errorHandler(Exception e) {
        System.out.println("\n[시스템 오류] " + e.getMessage());
    }

    private static void exit(Scanner scanner) {
        System.out.println("\n❤ 이용해주셔서 감사합니다!");
        scanner.close();
        System.exit(0);
    }
}
