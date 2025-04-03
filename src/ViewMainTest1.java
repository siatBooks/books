import java.util.*;
import java.util.stream.Collectors;

public class ViewMainTest1 {
    private static final Random random = new Random();
    private static final String BORDER = "==================================================";
    private static final String SUB_BORDER = "---------------------------------------------------";

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
        "당신이 읽은 책들을 쌓으면 남산타워 15개를 세운 높이입니다.",
        "올해 독서에 투자한 시간은 서울에서 부산까지 KTX로 20번 왕복할 수 있는 시간입니다."
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        clearScreen();
        
        printHeader("온라인 서점 시스템");
        System.out.print("성명: ");
        scanner.nextLine();
        System.out.print("비밀번호: ");
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
                System.out.print("\n>> 메뉴 선택: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                
                switch(choice) {
                    case 1: searchFlow(scanner); break;
                    case 2: userFlow(scanner); break;
                    case 3: orderFlow(scanner); break;
                    case 4: cartFlow(scanner); break;
                    case 99: exit(scanner); break;
                    default: errorMsg("잘못된 입력입니다.");
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
                "1. 베스트셀러 검색",
                "2. 신간 도서 검색", 
                "3. 전체 검색",
                "0. 홈으로 돌아가기",
                "99. 종료"
            });

            System.out.print("\n>> 검색 유형: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            if(choice == 0) return;
            if(choice == 99) exit(scanner);
            
            String searchType = switch(choice) {
                case 1 -> "베스트셀러";
                case 2 -> "신간";
                case 3 -> "전체";
                default -> "";
            };

            System.out.print("\n>> 검색어 입력: ");
            String keyword = scanner.next();
            scanner.nextLine();
            
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
            System.out.println("\n[알림] 검색 결과가 없습니다");
            pause(scanner);
            return;
        }

        System.out.println("\n[정렬 옵션]");
        printMenu(new String[]{
            "1. 가격 낮은 순", 
            "2. 가격 높은 순", 
            "3. 출판일 최신순",
            "0. 홈으로 돌아가기",
            "99. 종료"
        });

        System.out.print("\n>> 정렬 선택: ");
        int sortChoice = scanner.nextInt();
        scanner.nextLine();
        
        if(sortChoice == 0) return;
        if(sortChoice == 99) exit(scanner);
        
        sortBooks(books, sortChoice);
        displayBooks(books);
        
        System.out.println("\n[액션 메뉴]");
        printMenu(new String[]{
            "1. 상세보기", 
            "2. 재검색", 
            "0. 홈으로 돌아가기", 
            "99. 종료"
        });
        
        System.out.print("\n>> 선택: ");
        int actionChoice = scanner.nextInt();
        scanner.nextLine();
        
        switch(actionChoice) {
            case 0: return;
            case 1: 
                System.out.print(">> 도서 번호 입력: ");
                int bookNum = scanner.nextInt();
                if(bookNum > 0 && bookNum <= books.size()) {
                    showBookDetail(books.get(bookNum-1), scanner);
                }
                break;
            case 99: exit(scanner); break;
        }
    }

    private static void sortBooks(List<Book> books, int choice) {
        switch(choice) {
            case 1 -> books.sort(Comparator.comparingInt(Book::getPrice));
            case 2 -> books.sort((b1, b2) -> b2.getPrice() - b1.getPrice());
            case 3 -> books.sort((b1, b2) -> b2.publicationDate.compareTo(b1.publicationDate));
        }
    }

    private static void displayBooks(List<Book> books) {
        for(int i=0; i<books.size(); i++) {
            Book book = books.get(i);
            System.out.printf("\n%d. %s\n", i+1, book.title);
            System.out.printf("├─ 가격: %,d원\n", book.getPrice());
            System.out.printf("└─ 출판일: %s\n", book.publicationDate);
            System.out.println(SUB_BORDER);
        }
    }

    private static void showBookDetail(Book book, Scanner scanner) {
        clearScreen();
        printHeader("[상세 정보] " + book.title);
        System.out.printf("├─ ISBN: %s\n", book.id);
        System.out.printf("├─ 저자: %s\n", book.author);
        System.out.printf("├─ 가격: %,d원\n", book.getPrice());
        System.out.printf("└─ 상태: %s\n", getConditionText(book.condition));
        System.out.println(SUB_BORDER);

        printMenu(new String[]{
            "1. 장바구니 추가", 
            "2. 바로구매", 
            "0. 돌아가기", 
            "99. 종료"
        });
        
        System.out.print("\n>> 선택: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch(choice) {
            case 0: return;
            case 1: 
                System.out.print(">> 수량 입력: ");
                int qty = scanner.nextInt();
                MockCartDB.addItem(book, qty);
                System.out.printf("\n[완료] %d권 추가 완료!\n", qty);
                break;
            case 99: exit(scanner); break;
        }
        pause(scanner);
    }

    private static void cartFlow(Scanner scanner) {
        while(true) {
            clearScreen();
            printHeader("장바구니 관리");
            List<CartItem> cart = MockCartDB.getCart();
            
            if(cart.isEmpty()) {
                System.out.println("\n[알림] 장바구니가 비어 있습니다");
                pause(scanner);
                return;
            }

            cart.forEach(item -> {
                System.out.printf("\n[도서] %s\n", item.book.title);
                System.out.printf("├─ 수량: %d개\n", item.quantity);
                System.out.printf("└─ 소계: %,d원\n", item.getTotalPrice());
                System.out.println(SUB_BORDER);
            });

            printMenu(new String[]{
                "1. 전체 구매", 
                "2. 장바구니 비우기", 
                "0. 뒤로가기", 
                "99. 종료"
            });
            
            System.out.print("\n>> 선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch(choice) {
                case 0: return;
                case 1: processBulkPurchase(scanner); break;
                case 2: 
                    MockCartDB.clearCart();
                    System.out.println("\n[완료] 장바구니 비움");
                    break;
                case 99: exit(scanner); break;
            }
            pause(scanner);
        }
    }

    private static void processBulkPurchase(Scanner scanner) {
        int total = MockCartDB.getCart().stream()
            .mapToInt(CartItem::getTotalPrice)
            .sum();
        
        System.out.println("\n================ 결제 정보 ================");
        System.out.printf("총 결제금액: %,d원\n", total);
        System.out.println("-----------------------------------------");
        
        printMenu(new String[]{
            "1. 신용카드 결제", 
            "2. 계좌이체", 
            "0. 취소", 
            "99. 종료"
        });
        
        System.out.print("\n>> 선택: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        if(choice == 1 || choice == 2) {
            System.out.println("[완료] 결제 완료!");
            MockCartDB.clearCart();
        }
        pause(scanner);
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

    private static void userFlow(Scanner scanner) {
        System.out.println("\n[알림] 회원 정보 기능은 준비 중입니다.");
        pause(scanner);
    }

    private static void orderFlow(Scanner scanner) {
        System.out.println("\n[알림] 주문 이력 기능은 준비 중입니다.");
        pause(scanner);
    }

    private static void exit(Scanner scanner) {
        System.out.println("\n이용해주셔서 감사합니다!");
        scanner.close();
        System.exit(0);
    }

    private static void printHeader(String title) {
        System.out.println(BORDER);
        System.out.println("| " + title + " |");
        System.out.println(BORDER);
    }

    private static void printMenu(String[] items) {
        System.out.println(SUB_BORDER);
        for(String item : items) {
            System.out.println(item);
        }
        System.out.println(SUB_BORDER);
    }

    private static void clearScreen() {
        for(int i=0; i<50; i++) System.out.println();
    }

    private static void pause(Scanner scanner) {
        System.out.print("\n계속하려면 엔터를 누르세요...");
        scanner.nextLine();
    }

    private static void errorMsg(String msg) {
        System.out.println("\n[경고] " + msg);
    }

    private static void errorHandler(Scanner scanner, Exception e) {
        System.out.println("\n[오류] " + e.getMessage());
        scanner.nextLine();
    }
}
