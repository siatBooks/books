import java.util.*;
import java.util.stream.Collectors;

public class ViewMain {
    private static final Random random = new Random();
    private static final String BORDER = "✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦✧✦";
    private static final String SUB_BORDER = "───────────────────────────────────────────";

    // 도서 정보 클래스
    static class Book {
        String id;
        String title;
        String author;
        int basePrice;
        String type;
        String condition;
        String publicationDate;  // 추가된 필드
        Integer reviewRank;      // 베스트셀러 전용 필드

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

    // 개선된 Mock 데이터베이스
    static class MockDB {
        private static final List<Book> masterBooks = Arrays.asList(
            // 베스트셀러 (리뷰 순위 포함)
            new Book("B001", "Java Master", "홍길동", 35000, "베스트셀러", "new", "2025-01-15", 1),
            new Book("B002", "Effective Java", "Joshua Bloch", 45000, "베스트셀러", "상", "2024-12-01", 2),
            new Book("B002-1", "Effective Java", "Joshua Bloch", 45000, "베스트셀러", "중", "2024-12-01", 2),
            
            // 신간 도서
            new Book("B003", "Spring Boot Guide", "이순신", 30000, "신간", "new", "2025-03-20", null),
            new Book("B003-1", "Spring Boot Guide", "이순신", 30000, "신간", "상", "2025-03-20", null),
            
            // 중고 도서
            new Book("B004", "React for Beginners", "Dan Abramov", 35000, "전체", "하", "2023-05-11", null),
            new Book("B005", "Python AI", "장영실", 28000, "전체", "new", "2025-02-28", null),
            new Book("B006", "Clean Code", "Robert C. Martin", 40000, "전체", "상", "2024-10-01", null),
            new Book("B007", "디자인 패턴의 정석", "GoF", 50000, "베스트셀러", "중", "2023-07-22", 3)
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

    // 장바구니 아이템 클래스
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

    // 장바구니 DB
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

    // 독서 통계 메시지
    private static final String[] PURCHASE_MESSAGES = { /* 이전과 동일 */ };

    // 시스템 메인 흐름
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

    // 도서 검색 및 정렬 시스템
    private static void searchFlow(Scanner scanner) {
        while(true) {
            clearScreen();
            printHeader("도서 검색 시스템");
            printMenu(new String[]{
                "1. 베스트셀러 검색",
                "2. 신간 도서 검색", 
                "3. 전체 검색",
                "0. 홈으로 돌아가기",
                "99. 시스템 종료"
            });

            int choice = getValidNumber(scanner, 0, 99);
            if(choice == 0) return;
            if(choice == 99) exit(scanner);
            
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

        // 정렬 옵션 표시
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
            case 1:
                books.sort(Comparator.comparingInt(Book::getPrice));
                break;
            case 2:
                books.sort((b1, b2) -> b2.getPrice() - b1.getPrice());
                break;
            case 3:
                books.sort((b1, b2) -> b2.publicationDate.compareTo(b1.publicationDate));
                break;
            case 4:
                if(type.equals("베스트셀러")) {
                    books.sort(Comparator.comparingInt(b -> b.reviewRank));
                }
                break;
            default:
                books.sort(Comparator.comparing(b -> b.title));
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
        
        if(choice != 0) {
            Book selected = books.get(choice-1);
            showBookDetail(selected, scanner);
        }
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

        printMenu(new String[]{
            "1. 장바구니 추가", 
            "2. 바로구매", 
            "0. 돌아가기"
        });
        
        handlePurchaseChoice(book, scanner);
    }

    private static void handlePurchaseChoice(Book book, Scanner scanner) {
        int choice = getValidNumber(scanner, 0, 2);
        switch(choice) {
            case 1:
                handleAddToCart(book, scanner);
                break;
            case 2:
                processPurchase(book, scanner);
                break;
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
            System.out.println("📊 " + getRandomMessage(PURCHASE_MESSAGES));
        }
        pause(scanner);
    }

    // 장바구니 관리 시스템
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

            printMenu(new String[]{
                "1. 전체 구매", 
                "2. 수량 변경", 
                "3. 장바구니 비우기",
                "0. 뒤로가기"
            });
            
            handleCartAction(scanner);
        }
    }

    private static void handleCartAction(Scanner scanner) {
        int choice = getValidNumber(scanner, 0, 3);
        switch(choice) {
            case 1:
                processBulkPurchase(scanner);
                break;
            case 2:
                modifyQuantity(scanner);
                break;
            case 3:
                MockCartDB.clearCart();
                System.out.println("\n✅ 장바구니를 비웠습니다");
                pause(scanner);
                break;
            case 0:
                return;
        }
    }

    // 유틸리티 메서드들 (앞선 코드와 동일)
    // ...// 헤더 출력
    private static void printHeader(String title) {
        System.out.println("====================" + "=".repeat(title.length()*2));
        System.out.println("= " + title + " =");
        System.out.println("====================" + "=".repeat(title.length()*2));
    }

    // 메뉴 출력
    private static void printMenu(String[] items) {
        System.out.println("\n---------------------");
        for (int i = 0; i < items.length; i++) {
            System.out.printf("%2d. %s\n", i+1, items[i]);
        }
        System.out.println("---------------------");
    }

    // 화면 클리어
    private static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    // 일시 정지
    private static void pause(Scanner scanner) {
        System.out.print("\n계속하려면 엔터를 누르세요...");
        scanner.nextLine();
    }

    // 에러 메시지 출력
    private static void errorMsg(String message) {
        System.out.println("\n[!] " + message);
    }

    // 시스템 종료
    private static void exit(Scanner scanner) {
        System.out.println("\n시스템을 종료합니다.");
        scanner.close();
        System.exit(0);
    }

    // 검색 타입 변환
    private static String getSearchType(int typeCode) {
        return switch (typeCode) {
            case 1 -> "베스트셀러";
            case 2 -> "신간";
            case 3 -> "전체";
            default -> "";
        };
}

// 예외 처리 핸들러
private static void errorHandler(Exception e) {
    System.out.println("\n[시스템 오류] " + e.getMessage());
    System.out.println("잠시 후 다시 시도해주세요.");
}

}
