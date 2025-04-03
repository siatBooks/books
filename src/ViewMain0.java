import java.util.*;
import java.util.stream.Collectors;

public class ViewMain0 {
    private static final Random random = new Random();
    private static final String BORDER = "==================================================";
    private static final String SUB_BORDER = "---------------------------------------------------";

    // 도서 정보 클래스
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

    // Mock 데이터베이스
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
        
        // 재고 리셋 메서드 (테스트용)
        static void resetBooks() {
            availableBooks = new ArrayList<>(masterBooks);
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
    private static final String[] PURCHASE_MESSAGES = {
        "지금까지 읽으신 책의 총 페이지를 쌓으면 에베레스트 높이의 3배에 달합니다.",
        "당신이 읽은 책들을 쌓으면 남산타워 15개를 세운 높이입니다.",
        "올해 독서에 투자한 시간은 서울에서 부산까지 KTX로 20번 왕복할 수 있는 시간입니다.",
        "당신의 독서 시간은 넷플릭스 드라마 '오징어 게임' 시리즈를 35번 볼 수 있는 시간입니다.",
        "각 페이지가 한 걸음이라면, 당신은 서울에서 부산까지 두 번 왕복한 거리를 걸었습니다!",
        "당신이 읽은 책의 페이지를 일렬로 늘어놓으면 한강 길이의 5배에 해당합니다.",
        "당신의 전자책 독서 습관은 소나무 15그루를 살렸습니다—여의도 공원의 1/10에 해당하는 면적입니다.",
        "당신이 읽은 책들의 무게는 중형 승용차 한 대와 같습니다.",
        "올해 읽은 책의 두께를 모두 합치면 냉장고 높이의 2배입니다."
    };

    // 출판 트렌드 메시지
    private static final String[] TREND_MESSAGES = {
        "당신이 선호하는 장르의 평균 가격은 2020년 이후 15% 하락했습니다.",
        "A출판사는 시장 점유율 30%로 선두를 달리고, B출판사가 20%로 뒤를 잇고 있습니다.",
        "높은 평점을 받은 책들은 대체로 가격이 낮고 2020년 이후 출간된 경향이 있습니다.",
        "미스터리 장르는 다른 장르에 비해 일관되게 높은 평점을 받고 있습니다."
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        clearScreen();
        
        printHeader("온라인 서점 시스템");
        printSection("로그인");
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
            System.out.println("원하는 메뉴를 선택하세요");
            
            printMenu(new ArrayList<>(Arrays.asList(
                "도서 검색", 
                "회원 정보", 
                "주문 이력", 
                "장바구니",
                "종료"
            )));
            
            try {
                System.out.print("\n>> 메뉴 선택: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // 버퍼 비우기
                
                switch(choice) {
                    case 1: searchFlow(scanner); break;
                    case 2: userFlow(scanner); break;
                    case 3: orderFlow(scanner); break;
                    case 4: cartFlow(scanner); break;
                    case 5: exit(scanner); break;
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
            printHeader("도서 검색 시스템");
            printMenu(new ArrayList<>(Arrays.asList(
                "베스트셀러 검색",
                "신간 도서 검색", 
                "전체 검색",
                "홈으로 돌아가기",
                "시스템 종료"
            )));

            System.out.print("\n>> 검색 유형: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기
            
            if(choice == 4) return; // 홈으로 돌아가기
            if(choice == 5) exit(scanner); // 종료
            
            String searchType = switch(choice) {
                case 1 -> "베스트셀러";
                case 2 -> "신간";
                case 3 -> "전체";
                default -> "";
            };

            System.out.print("\n>> 검색어 입력: ");
            String keyword = scanner.nextLine();
            
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
        List<String> sortOptions = new ArrayList<>(Arrays.asList(
            "가격 낮은 순", 
            "가격 높은 순", 
            "출판일 최신순"
        ));
        
        if(type.equals("베스트셀러")) {
            sortOptions.add("리뷰 순위 순");
        }
        sortOptions.add("기본 정렬(가나다순)");
        
        printMenu(sortOptions);

        System.out.print("\n>> 정렬 선택: ");
        int sortChoice = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기
        
        if(sortChoice > 0 && sortChoice <= sortOptions.size()) {
            sortBooks(books, sortChoice, type);
        }
        
        displayBooks(books);
        
        System.out.println("\n[액션 메뉴]");
        printMenu(new ArrayList<>(Arrays.asList(
            "상세보기",
            "재검색",
            "홈으로 돌아가기",
            "종료"
        )));
        
        System.out.print("\n>> 선택: ");
        int actionChoice = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기
        
        switch(actionChoice) {
            case 1:
                System.out.print("\n>> 상세보기 할 도서 번호: ");
                int bookChoice = scanner.nextInt();
                scanner.nextLine(); // 버퍼 비우기
                
                if(bookChoice > 0 && bookChoice <= books.size()) {
                    showBookDetail(books.get(bookChoice-1), scanner);
                }
                break;
            case 2:
                return; // 재검색
            case 3:
                home(scanner); // 홈으로 돌아가기
                break;
            case 4:
                exit(scanner); // 종료
                break;
        }
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
                    books.sort(Comparator.comparingInt(b -> b.reviewRank != null ? b.reviewRank : Integer.MAX_VALUE));
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
            System.out.printf("|- ID: %s\n", book.id);
            System.out.printf("|- 저자: %s\n", book.author);
            System.out.printf("|- 가격: %,d원\n", book.getPrice());
            System.out.printf("|- 상태: %s\n", getConditionText(book.condition));
            System.out.printf("|- 출판일: %s\n", book.publicationDate);
            if(book.reviewRank != null) {
                System.out.printf("|- 리뷰 순위: %d위\n", book.reviewRank);
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

    private static void showBookDetail(Book book, Scanner scanner) {
        clearScreen();
        printHeader("[상세 정보] " + book.title);
        System.out.printf("|- ISBN: %s\n", book.id);
        System.out.printf("|- 저자: %s\n", book.author);
        System.out.printf("|- 정가: %,d원\n", book.basePrice);
        System.out.printf("|- 판매가: %,d원\n", book.getPrice());
        System.out.printf("|- 상태: %s\n", getConditionText(book.condition));
        System.out.printf("|- 출판일: %s\n", book.publicationDate);
        if(book.reviewRank != null) {
            System.out.printf("|- 리뷰 순위: %d위\n", book.reviewRank);
        }
        System.out.println(SUB_BORDER);

        printMenu(new ArrayList<>(Arrays.asList(
            "장바구니 추가", 
            "바로구매", 
            "돌아가기"
        )));
        
        System.out.print("\n>> 선택: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기
        
        switch(choice) {
            case 1:
                handleAddToCart(book, scanner);
                break;
            case 2:
                processPurchase(book, scanner);
                break;
            case 3:
                return; // 돌아가기
        }
    }

    private static void handleAddToCart(Book book, Scanner scanner) {
        System.out.print("\n>> 수량 입력: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기
        
        MockCartDB.addItem(book, quantity);
        System.out.printf("\n[완료] %s %d권 장바구니 추가 완료!\n", book.title, quantity);
        System.out.println("[독서 통계] " + getRandomMessage(PURCHASE_MESSAGES));
        pause(scanner);
    }

    private static void processPurchase(Book book, Scanner scanner) {
        System.out.print("\n>> 수량 입력: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기
        
        System.out.println("\n================ 결제 정보 ================");
        System.out.printf("도서명: %s\n", book.title);
        System.out.printf("수량: %d권\n", quantity);
        System.out.printf("결제금액: %,d원\n", book.getPrice() * quantity);
        System.out.println("-----------------------------------------");
        
        printMenu(new ArrayList<>(Arrays.asList(
            "신용카드 결제", 
            "계좌이체", 
            "취소"
        )));
        
        System.out.print("\n>> 결제 방법 선택: ");
        int paymentType = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기
        
        if(paymentType != 3) { // 취소가 아닌 경우
            System.out.println("[완료] 결제가 완료되었습니다!");
            MockDB.removeBook(book.id);
            System.out.println("[독서 통계] " + getRandomMessage(PURCHASE_MESSAGES));
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

            int totalAmount = 0;
            int index = 1;
            
            for(CartItem item : cart) {
                System.out.printf("\n%d. %s\n", index++, item.book.title);
                System.out.printf("|- 수량: %d개\n", item.quantity);
                System.out.printf("|- 단가: %,d원\n", item.book.getPrice());
                System.out.printf("|- 소계: %,d원\n", item.getTotalPrice());
                System.out.println(SUB_BORDER);
                totalAmount += item.getTotalPrice();
            }
            
            System.out.printf("\n총 금액: %,d원\n", totalAmount);

            // 랜덤 출판 트렌드 메시지 출력
            System.out.println("[출판 트렌드] " + getRandomMessage(TREND_MESSAGES));

            printMenu(new ArrayList<>(Arrays.asList(
                "전체 구매", 
                "장바구니 비우기",
                "뒤로가기"
            )));
            
            System.out.print("\n>> 선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기
            
            switch(choice) {
                case 1:
                    processBulkPurchase(scanner);
                    break;
                case 2:
                    MockCartDB.clearCart();
                    System.out.println("\n[완료] 장바구니를 비웠습니다");
                    pause(scanner);
                    break;
                case 3:
                    return; // 뒤로가기
            }
        }
    }
    
    private static void processBulkPurchase(Scanner scanner) {
        List<CartItem> cart = MockCartDB.getCart();
        int total = cart.stream().mapToInt(CartItem::getTotalPrice).sum();
        
        System.out.println("\n================ 결제 정보 ================");
        System.out.printf("총 결제금액: %,d원\n", total);
        System.out.println("-----------------------------------------");
        
        printMenu(new ArrayList<>(Arrays.asList(
            "신용카드 결제", 
            "계좌이체", 
            "취소"
        )));
        
        System.out.print("\n>> 결제 방법 선택: ");
        int paymentType = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기
        
        if(paymentType != 3) { // 취소가 아닌 경우
            System.out.println("[완료] 결제가 완료되었습니다!");
            
            // 구매한 모든 책 재고에서 제거
            cart.forEach(item -> MockDB.removeBook(item.book.id));
            MockCartDB.clearCart();
            
            System.out.println("[독서 통계] " + getRandomMessage(PURCHASE_MESSAGES));
        }
        pause(scanner);
    }
    
    // 회원 정보 관리
    private static void userFlow(Scanner scanner) {
        clearScreen();
        printHeader("회원 정보 관리");
        
        // 더미 데이터
        System.out.println("\n[회원 정보]");
        System.out.println("|- 이름: 홍길동");
        System.out.println("|- 이메일: user@example.com");
        System.out.println("|- 전화번호: 010-1234-5678");
        System.out.println("|- 회원등급: Gold");
        System.out.println("|- 적립금: 5,000 포인트");
        System.out.println(SUB_BORDER);
        
        printMenu(new ArrayList<>(Arrays.asList(
            "개인정보 수정", 
            "배송지 관리", 
            "결제수단 관리",
            "뒤로가기"
        )));
        
        System.out.print("\n>> 선택: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기
        
        if(choice == 4) return;
        
        System.out.println("\n[알림] 회원 정보 관리 기능은 아직 준비 중입니다.");
        pause(scanner);
    }
    
    // 주문 이력 관리
    private static void orderFlow(Scanner scanner) {
        clearScreen();
        printHeader("주문 이력 조회");
        
        System.out.println("\n[알림] 최근 주문 내역이 없습니다.");
        
        printMenu(new ArrayList<>(Arrays.asList(
            "과거 주문 조회", 
            "주문 취소 내역", 
            "뒤로가기"
        )));
        
        System.out.print("\n>> 선택: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기
        
        if(choice == 3) return;
        
        System.out.println("\n[알림] 주문 이력 관리 기능은 아직 준비 중입니다.");
        pause(scanner);
    }

    // 메뉴 출력 (List<String> 버전)
    private static void printMenu(List<String> items) {
        System.out.println("\n" + SUB_BORDER);
        for(int i=0; i<items.size(); i++) {
            System.out.printf("%d. %s\n", i+1, items.get(i));
        }
        System.out.println(SUB_BORDER);
    }
    
    // 시스템 종료
    private static void exit(Scanner scanner) {
        clearScreen();
        printHeader("시스템 종료");
        System.out.println("\n온라인 서점 서비스를 이용해 주셔서 감사합니다.");
        System.out.println("시스템을 종료합니다.");
        scanner.close();
        System.exit(0);
    }
    
    // 에러 메시지 출력
    private static void errorMsg(String message) {
        System.out.println("\n[오류] " + message);
    }
    
    // 예외 처리
    private static void errorHandler(Scanner scanner, Exception e) {
        System.out.println("\n[시스템 오류] 처리 중 오류가 발생했습니다: " + e.getMessage());
        e.printStackTrace();
        scanner.nextLine(); // 버퍼 비우기
    }
    
    // 화면 지우기
    private static void clearScreen() {
        // 콘솔 환경에서 화면을 지우는 방식
        for(int i=0; i<50; i++) {
            System.out.println();
        }
        // 또는 ANSI 이스케이프 코드 사용 (일부 터미널에서만 작동)
        // System.out.print("\033[H\033[2J");
        // System.out.flush();
    }
    
    // 제목 헤더 출력
    private static void printHeader(String title) {
        System.out.println(BORDER);
        System.out.println("     " + title);
        System.out.println(BORDER);
    }
    
    // 섹션 헤더 출력
    private static void printSection(String section) {
        System.out.println("\n" + SUB_BORDER);
        System.out.println(" " + section);
        System.out.println(SUB_BORDER);
    }
    
    // 사용자 입력 대기
    private static void pause(Scanner scanner) {
        System.out.println("\n계속하려면 엔터키를 누르세요...");
        scanner.nextLine();
    }
    
    // 랜덤 메시지 선택
    private static String getRandomMessage(String[] messages) {
        return messages[random.nextInt(messages.length)];
    }
}
