import controller.FrontController;
import domain.dto.book.BookInfoDetailResponseDto;
import domain.dto.book.BookListItemDto;
import oracle.net.aso.e;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.stream.Collectors;

public class ViewMain {
    private static FrontController frontController = new FrontController();
    private static List<BookListItemDto> list = new ArrayList<>();

    private static final Random random = new Random();
    private static final String BORDER = "==================================================";
    private static final String SUB_BORDER = "---------------------------------------------------";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // 도서 정보 클래스
    static class Book {
        String id;
        String title;
        String author;
        int basePrice;
        String types;
        String condition;
        String publicationDate;
        Integer reviewRank;
        int pageCount; // 페이지 수 추가

        public Book(String id, String title, String author, int basePrice,
                    String types, String condition, String publicationDate, Integer reviewRank, int pageCount) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.basePrice = basePrice;
            this.types = types;
            this.condition = condition;
            this.publicationDate = publicationDate;
            this.reviewRank = reviewRank;
            this.pageCount = pageCount;
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

    // 주문 클래스 추가
    static class Order {
        String orderId;
        String customerName;
        LocalDate orderDate;
        List<OrderItem> items;
        String status;
        String shippingAddress;
        String paymentMethod;
        int totalAmount;

        public Order(String orderId, String customerName, LocalDate orderDate,
                     List<OrderItem> items, String status, String shippingAddress, String paymentMethod) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.orderDate = orderDate;
            this.items = items;
            this.status = status;
            this.shippingAddress = shippingAddress;
            this.paymentMethod = paymentMethod;
            this.totalAmount = items.stream().mapToInt(OrderItem::getTotalPrice).sum();
        }
    }

    // 주문 상품 클래스 추가
    static class OrderItem {
        BookListItemDto book;
        int quantity;
        int priceAtPurchase;

        public OrderItem(BookListItemDto book2, int quantity) {
            this.book = book2;
            this.quantity = quantity;
            this.priceAtPurchase = book2.getPriceStandard();
        }

        public int getTotalPrice() {
            return priceAtPurchase * quantity;
        }
    }

    // Mock 데이터베이스
    static class MockDB {
        
        private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        private static Date parseDate(String date) {
            try {
                return dateFormat.parse(date);
            } catch (ParseException e) {
                throw new RuntimeException("Invalid date format: " + date);
            }
        }

    // private static final List<BookListItemDto> masterBooks1 = Arrays.asList(
    //         // 베스트셀러
    //         BookListItemDto.builder()
    //                 .bookId(1L)
    //                 .title("Java Master")
    //                 .author("홍길동")
    //                 .perdate(parseDate("2025-01-15"))
    //                 .priceStandard(35000)
    //                 .priceSales((int) (35000 * 0.7)) // condition "상" 기준
    //                 .isbn("B001")
    //                 .customerReviewRank(1)
    //                 .description("Java Master 소개")
    //                 .link("http://example.com/java-master")
    //                 .bookType("베스트셀러")
    //                 .displayType("new")
    //                 .coverImg("http://example.com/images/java-master.jpg")
    //                 .salesPoint(1000)
    //                 .categoryId(101L)
    //                 .build(),

    //         BookListItemDto.builder()
    //                 .bookId(2L)
    //                 .title("Effective Java")
    //                 .author("Joshua Bloch")
    //                 .perdate(parseDate("2024-12-01"))
    //                 .priceStandard(45000)
    //                 .priceSales((int) (45000 * 0.7)) // condition "상" 기준
    //                 .isbn("B002")
    //                 .customerReviewRank(2)
    //                 .description("Effective Java 소개")
    //                 .link("http://example.com/effective-java")
    //                 .bookType("베스트셀러")
    //                 .displayType("상")
    //                 .coverImg("http://example.com/images/effective-java.jpg")
    //                 .salesPoint(2000)
    //                 .categoryId(102L)
    //                 .build(),

    //         BookListItemDto.builder()
    //                 .bookId(3L)
    //                 .title("Clean Code")
    //                 .author("Robert C. Martin")
    //                 .perdate(parseDate("2023-10-05"))
    //                 .priceStandard(40000)
    //                 .priceSales((int) (40000 * 0.5)) // condition "중" 기준
    //                 .isbn("B003")
    //                 .customerReviewRank(3)
    //                 .description("Clean Code 소개")
    //                 .link("http://example.com/clean-code")
    //                 .bookType("베스트셀러")
    //                 .displayType("중")
    //                 .coverImg("http://example.com/images/clean-code.jpg")
    //                 .salesPoint(1500)
    //                 .categoryId(103L)
    //                 .build(),

    //         // 신간
    //         BookListItemDto.builder()
    //                 .bookId(101L)
    //                 .title("Spring Boot Guide")
    //                 .author("이순신")
    //                 .perdate(parseDate("2025-03-20"))
    //                 .priceStandard(30000)
    //                 .priceSales(30000) // 신간은 할인 없음
    //                 .isbn("B101")
    //                 .customerReviewRank(null)
    //                 .description("Spring Boot Guide 소개")
    //                 .link("http://example.com/spring-boot-guide")
    //                 .bookType("신간")
    //                 .displayType("new")
    //                 .coverImg("http://example.com/images/spring-boot-guide.jpg")
    //                 .salesPoint(500)
    //                 .categoryId(201L)
    //                 .build()
    // );
        private static final List<BookListItemDto> masterBooks = Arrays.asList(
                        // 베스트셀러
                        BookListItemDto.builder()
                            .bookId(1L)
                            .title("Java Master")
                            .author("홍길동")
                            .perdate(parseDate("2025-01-15"))
                            .priceStandard(35000)
                            .priceSales((int) (35000 * 0.7)) // condition "상" 기준
                            .isbn("B001")
                            .customerReviewRank(1)
                            .description("Java Master 소개")
                            .link("http://example.com/java-master")
                            .bookType("베스트셀러")
                            .displayType("new")
                            .coverImg("http://example.com/images/java-master.jpg")
                            .salesPoint(1000)
                            .categoryId(101L)
                            .build(),
                            
                        BookListItemDto.builder()
                            .bookId(2L)
                            .title("Effective Java")
                            .author("Joshua Bloch")
                            .perdate(parseDate("2024-12-01"))
                            .priceStandard(45000)
                            .priceSales((int) (45000 * 0.7)) // condition "상" 기준
                            .isbn("B002")
                            .customerReviewRank(2)
                            .description("Effective Java 소개")
                            .link("http://example.com/effective-java")
                            .bookType("베스트셀러")
                            .displayType("상")
                            .coverImg("http://example.com/images/effective-java.jpg")
                            .salesPoint(2000)
                            .categoryId(102L)
                            .build(),

                        BookListItemDto.builder()
                            .bookId(3L)
                            .title("Clean Code")
                            .author("Robert C. Martin")
                            .perdate(parseDate("2023-10-05"))
                            .priceStandard(40000)
                            .priceSales((int) (40000 * 0.5)) // condition "중" 기준
                            .isbn("B003")
                            .customerReviewRank(3)
                            .description("Clean Code 소개")
                            .link("http://example.com/clean-code")
                            .bookType("베스트셀러")
                            .displayType("중")
                            .coverImg("http://example.com/images/clean-code.jpg")
                            .salesPoint(1500)
                            .categoryId(103L)
                            .build()
        );
        

                // new Book("B006", "Java Master", "홍길동", 35000, "베스트셀러", "상", "2025-01-15", 1, 450),
                // new Book("B007", "Java Master", "홍길동", 35000, "베스트셀러", "중", "2025-01-15", 1, 450),
                // new Book("B008", "Effective Java", "Joshua Bloch", 45000, "베스트셀러", "상", "2024-12-01", 2, 380),
                // new Book("B009", "Effective Java", "Joshua Bloch", 45000, "베스트셀러", "하", "2024-12-01", 2, 380),
                // new Book("B010", "Clean Code", "Robert C. Martin", 40000, "베스트셀러", "중", "2023-10-05", 3, 420),
                // new Book("B011", "Clean Code", "Robert C. Martin", 40000, "베스트셀러", "하", "2023-10-05", 3, 420),
                // new Book("B012", "객체지향의 사실과 오해", "조영호", 22000, "베스트셀러", "하", "2022-08-12", 4, 250),
                // new Book("B013", "객체지향의 사실과 오해", "조영호", 22000, "베스트셀러", "하", "2022-08-12", 4, 250),
                // new Book("B014", "모던 자바스크립트 Deep Dive", "이웅모", 38000, "베스트셀러", "중", "2024-11-20", 5, 800),
                // new Book("B015", "모던 자바스크립트 Deep Dive", "이웅모", 38000, "베스트셀러", "중", "2024-11-20", 5, 800),



                // // 신간
                // new Book("B101", "Spring Boot Guide", "이순신", 30000, "신간", "new", "2025-03-20", null, 320),
                // new Book("B102", "Kotlin Programming", "김민준", 28000, "신간", "new", "2025-03-15", null, 280),
                // new Book("B103", "Cloud Native Architecture", "박지성", 42000, "신간", "new", "2025-03-10", null, 350),
                // new Book("B104", "인공지능과 머신러닝 기초", "최영희", 35000, "신간", "new", "2025-03-05", null, 420),
                // new Book("B105", "블록체인 개발 실전 가이드", "정승호", 37000, "신간", "new", "2025-02-28", null, 380)

                // // 웹개발
                // new Book("B201", "React for Beginners", "Dan Abramov", 35000, "웹개발", "하", "2023-05-11", null, 300),
                // new Book("B202", "Vue.js 완벽 가이드", "장영실", 28000, "웹개발", "new", "2025-02-28", null, 280),
                // new Book("B203", "HTML/CSS 마스터", "구종만", 33000, "웹개발", "상", "2024-07-15", null, 350),
                // new Book("B204", "Angular 실전 프로젝트", "이동욱", 45000, "웹개발", "new", "2024-09-30", null, 400),

                // // 데이터베이스/백엔드
                // new Book("B301", "SQL 레벨업", "미즈노 미츠히", 32000, "데이터베이스", "중", "2023-12-05", null, 320),
                // new Book("B302", "MongoDB 완벽 가이드", "유진우", 37000, "데이터베이스", "new", "2024-01-20", null, 360),
                // new Book("B303", "스프링 데이터 JPA", "김영한", 35000, "백엔드", "상", "2024-06-10", null, 380),
                // new Book("B304", "Node.js 백엔드 개발", "이태호", 28000, "백엔드", "하", "2022-05-15", null, 290)
        // );

        private static List<BookListItemDto> availableBooks = new ArrayList<>(masterBooks);

        static List<BookListItemDto> getBooks(String searchType) {
            return availableBooks.stream()
                    .filter(book -> searchType.equals("전체") || book.getDisplayType().equals(searchType))
                    .collect(Collectors.toList());
        }

        static BookListItemDto getBookById(String bookId) {
            return masterBooks.stream()
                    .filter(book -> book.getBookId().equals(bookId))
                    .findFirst()
                    .orElse(null);
        }

        static void removeBook(String bookId) {
            availableBooks.removeIf(book -> book.getBookId().equals(bookId));
        }
    }

    // 장바구니 아이템 클래스
    static class CartItem {
        BookListItemDto book;
        int quantity;

        public CartItem(BookListItemDto book2, int quantity) {
            this.book = book2;
            this.quantity = quantity;
        }

        public int getTotalPrice() {
            return book.getPriceStandard() * quantity;
        }
    }

    // 장바구니 DB
    static class MockCartDB {
        private static List<CartItem> cart = new ArrayList<>();

        static void addItem(BookListItemDto book, int quantity) {
            cart.add(new CartItem(book, quantity));
        }

        static List<CartItem> getCart() {
            return new ArrayList<>(cart);
        }

        static void clearCart() {
            cart.clear();
        }
    }

    // 주문 이력 DB 추가
    static class MockOrderDB {
        private static List<Order> orders = new ArrayList<>();
        private static int nextOrderId = 1001;

        static String addOrder(String customerName, List<CartItem> cartItems, String address, String paymentMethod) {
            String orderId = "ORD-" + nextOrderId++;
            List<OrderItem> orderItems = cartItems.stream()
                    .map(cartItem -> new OrderItem(cartItem.book, cartItem.quantity))
                    .collect(Collectors.toList());

            Order order = new Order(orderId, customerName, LocalDate.now(),
                    orderItems, "배송 준비중", address, paymentMethod);
            orders.add(order);

            // 샘플 데이터 자동 생성
            if (orders.size() <= 1) {
                generateSampleOrders();
            }

            return orderId;
        }

        // 샘플 주문 이력 생성
        private static void generateSampleOrders() {
            // 과거 주문 1
            List<OrderItem> items1 = new ArrayList<>();
            items1.add(new OrderItem(MockDB.getBookById("B001"), 2));
            items1.add(new OrderItem(MockDB.getBookById("B003"), 1));
            orders.add(new Order("ORD-" + nextOrderId++, "홍길동", LocalDate.now().minusDays(7),
                    items1, "배송 완료", "서울시 강남구", "신용카드"));

            // 과거 주문 2
            List<OrderItem> items2 = new ArrayList<>();
            items2.add(new OrderItem(MockDB.getBookById("B102"), 1));
            items2.add(new OrderItem(MockDB.getBookById("B301"), 3));
            orders.add(new Order("ORD-" + nextOrderId++, "김영희", LocalDate.now().minusDays(14),
                    items2, "배송 중", "부산시 해운대구", "계좌이체"));

            // 과거 주문 3
            List<OrderItem> items3 = new ArrayList<>();
            items3.add(new OrderItem(MockDB.getBookById("B203"), 2));
            orders.add(new Order("ORD-" + nextOrderId++, "이철수", LocalDate.now().minusMonths(1),
                    items3, "취소됨", "대구시 중구", "신용카드"));

            // 과거 주문 4
            List<OrderItem> items4 = new ArrayList<>();
            items4.add(new OrderItem(MockDB.getBookById("B004"), 1));
            items4.add(new OrderItem(MockDB.getBookById("B005"), 1));
            items4.add(new OrderItem(MockDB.getBookById("B201"), 1));
            orders.add(new Order("ORD-" + nextOrderId++, "박민지", LocalDate.now().minusMonths(2),
                    items4, "배송 완료", "인천시 서구", "계좌이체"));
        }

        static List<Order> getOrders() {
            return new ArrayList<>(orders);
        }

        static Order getOrderById(String orderId) {
            return orders.stream()
                    .filter(order -> order.orderId.equals(orderId))
                    .findFirst()
                    .orElse(null);
        }

        static List<Order> getOrdersByDateRange(LocalDate startDate, LocalDate endDate) {
            return orders.stream()
                    .filter(order -> !order.orderDate.isBefore(startDate) && !order.orderDate.isAfter(endDate))
                    .collect(Collectors.toList());
        }

        static List<Order> getOrdersByStatus(String status) {
            if (status == null) {
                return new ArrayList<>(orders);
            }
            return orders.stream()
                    .filter(order -> order.status.equals(status))
                    .collect(Collectors.toList());
        }

        static void updateOrderStatus(String orderId, String newStatus) {
            orders.stream()
                    .filter(order -> order.orderId.equals(orderId))
                    .findFirst()
                    .ifPresent(order -> order.status = newStatus);
        }

        static Map<String, Integer> getMonthlyOrderStats() {
            Map<String, Integer> monthlyCounts = new HashMap<>();

            for (Order order : orders) {
                String monthYear = order.orderDate.format(DateTimeFormatter.ofPattern("yyyy-MM"));
                monthlyCounts.put(monthYear, monthlyCounts.getOrDefault(monthYear, 0) + 1);
            }

            return monthlyCounts;
        }
    }

    // 통계 메시지 클래스 추가
    static class StatisticMessage {
        String messageTemplate;
        double factor;
        String unitName;

        public StatisticMessage(String messageTemplate, double factor, String unitName) {
            this.messageTemplate = messageTemplate;
            this.factor = factor;
            this.unitName = unitName;
        }

        public String getFormattedMessage(int quantity) {
            double value = quantity * factor;
            return String.format(messageTemplate, value, unitName);
        }
    }

    // 동적 계산되는 독서 통계 메시지
    private static final StatisticMessage[] PURCHASE_STATISTICS = {
            new StatisticMessage("지금까지 읽으신 책의 총 페이지를 쌓으면 에베레스트 높이의 %.1f%s에 달합니다.", 0.03, "배"),
            new StatisticMessage("당신이 읽은 책들을 쌓으면 남산타워 %.1f%s를 세운 높이입니다.", 0.15, "개"),
            new StatisticMessage("올해 독서에 투자한 시간은 서울에서 부산까지 KTX로 %.1f%s 왕복할 수 있는 시간입니다.", 0.2, "번"),
            new StatisticMessage("당신의 독서 시간은 넷플릭스 드라마 '오징어 게임' 시리즈를 %.1f%s 볼 수 있는 시간입니다.", 0.35, "번"),
            new StatisticMessage("각 페이지가 한 걸음이라면, 당신은 서울에서 부산까지 %.1f%s 왕복한 거리를 걸었습니다!", 0.02, "번"),
            new StatisticMessage("당신이 읽은 책의 페이지를 일렬로 늘어놓으면 한강 길이의 %.1f%s에 해당합니다.", 0.05, "배"),
            new StatisticMessage("당신의 전자책 독서 습관은 소나무 %.1f%s를 살렸습니다—여의도 공원의 1/10에 해당하는 면적입니다.", 0.15, "그루"),
            new StatisticMessage("당신이 읽은 책들의 무게는 중형 승용차 %.1f%s와 같습니다.", 0.01, "대"),
            new StatisticMessage("올해 읽은 책의 두께를 모두 합치면 냉장고 높이의 %.1f%s입니다.", 0.02, "배")
    };

    // 출판 트렌드 메시지
    private static final String[] TREND_MESSAGES = {
            "당신이 선호하는 장르의 평균 가격은 2020년 이후 15% 하락했습니다.",
            "A출판사는 시장 점유율 30%로 선두를 달리고, B출판사가 20%로 뒤를 잇고 있습니다.",
            "높은 평점을 받은 책들은 대체로 가격이 낮고 2020년 이후 출간된 경향이 있습니다.",
            "미스터리 장르는 다른 장르에 비해 일관되게 높은 평점을 받고 있습니다.",
            "전자책 시장은 지난 5년간 연평균 22%의 성장률을 보이고 있습니다.",
            "기술 서적은 평균 3년 주기로 개정판이 출간되는 추세를 보입니다.",
            "코딩 교육 도서는 지난 1년간 판매량이 35% 증가했습니다."
    };

    // 메인 함수
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        clearScreen();

        printHeader("온라인 서점 시스템");
        // ! 유저 - 로그인 서비스
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
                scanner.nextLine(); // 버퍼 비우기

                switch(choice) {
                    case 1: searchFlow(scanner); break;
                    case 2: userFlow(scanner); break;
                    case 3: orderFlow(scanner); break;
                    case 4: cartFlow(scanner); break;
                    // case 0: return; // 홈으로
                    case 99: exit(scanner); break;
                    default: errorMsg("잘못된 입력입니다.");
                }
            } catch (Exception e) {
                errorHandler(scanner, e);
            }
        }
    }

    // 도서 검색 흐름
    private static void searchFlow(Scanner scanner) {
        while(true) {
            clearScreen();
            printHeader("도서 검색 시스템");
            printMenu(new String[]{
                    "1. 베스트셀러 검색",
                    "2. 신간 도서 검색",
                    "3. 전체 검색",
                    "0. 홈으로 돌아가기",
                    "99. 종료"
            });

            System.out.print("\n>> 검색 유형: ");
            int choice = getValidNumber(scanner, 0, 99);

            if(choice == 0) return;
            if(choice == 99) exit(scanner);

            // 북 - 검색 유형 선택 필요
            String searchType = switch(choice) {
                case 1 -> "베스트셀러";
                case 2 -> "신간";
                case 3 -> "전체";
                default -> "";
            };

            System.out.print("\n>> 검색어 입력: ");
            String keyword = scanner.next();
            scanner.nextLine(); // 버퍼 비우기

            List<BookListItemDto> results = MockDB.getBooks(searchType).stream()
                    .filter(book -> book.getTitle().contains(keyword) || book.getAuthor().contains(keyword))
                    .collect(Collectors.toList());

            handleSearchResults(searchType, keyword, scanner); // results, 
        }
    }

    private static void handleSearchResults(String types, String keyword, Scanner scanner) {
        clearScreen();
        printHeader("'" + keyword + "' 검색 결과 (" + types + ")");

        

        List<BookListItemDto> books = new ArrayList<>(); // MockDB.getBooks(types).stream()
        // if 조건문 주기 &&
        if (types.equals("베스트셀러")) {
            books = frontController.selectBookListInBest(keyword);
        } else if (types.equals("신간")) {
            books = frontController.selectBookListInNew(keyword);
        } else if (types.equals("전체")) {
            books = frontController.selectBookList(keyword);
        } 
        
        
        // 추가 서비스 연결된 리스트
        // 검색 리스트 서비스 추가 필요
        if(books.isEmpty()) {
            System.out.println("\n[알림] 검색 결과가 없습니다");
            pause(scanner);
            return;
        }

        displayBooks(books);

        System.out.println("\n[정렬 옵션]");
        System.out.println();
        List<String> sortOptions = new ArrayList<>(Arrays.asList(
                "1. 가격 낮은 순",
                "2. 가격 높은 순",
                "3. 출판일 최신순"
        ));

        if(types.equals("베스트셀러")) {
            sortOptions.add("4. 리뷰 순위 순");
        }
        sortOptions.add("0. 홈으로 돌아가기");
        sortOptions.add("99. 종료");

        printMenu(sortOptions.toArray(new String[0]));

        System.out.print("\n>> 정렬 선택: ");
        int sortChoice = getValidNumber(scanner, 0, 99);

        if(sortChoice == 0) return;
        if(sortChoice == 99) exit(scanner);

        // 북 - 정렬 서비스 추가 필요
        sortBooks(books, sortChoice, types);
        displayBooks(books);

        System.out.println("\n[액션 메뉴]");
        printMenu(new String[]{
                "1. 상세보기",
                "2. 재검색",
                "0. 홈으로 돌아가기",
                "99. 종료"
        });

        System.out.print("\n>> 선택: ");
        int actionChoice = getValidNumber(scanner, 0, 99);

        switch(actionChoice) {
            case 0: return;
            case 1:
                System.out.print(">> 도서 번호 입력: ");
                int bookNum = getValidNumber(scanner, 1, books.size());
                showBookDetail(bookNum, books.get(bookNum-1), scanner);
                break;
            case 2: return; // 재검색
            case 99: exit(scanner); break;
        }
    }

    private static void sortBooks(List<BookListItemDto> books, int sortChoice, String types) {
        // 소트 서비스 추가
        System.out.println("수정 후");
        System.out.println("출판일");
        frontController.sortList("perdateAsc", list);
        System.out.println("가격순");
        frontController.sortList("priceStandardAsc", list);

        // 기존 소트 뷰
        System.out.println("수정 전");
        switch(sortChoice) {
            case 1:
                books.sort(Comparator.nullsFirst(Comparator.comparingInt(b -> b.getPriceStandard() != null ? b.getPriceStandard() : 0)));
                break;
            case 2:
                books.sort(Comparator.nullsFirst(Comparator.comparingInt(b -> ((BookInfoDetailResponseDto) b).getPriceStandard() != null ? ((BookInfoDetailResponseDto) b).getPriceStandard() : 0)).reversed());
                break;
            case 3:
                books.sort(Comparator.nullsFirst(Comparator.comparing(b -> ((BookInfoDetailResponseDto) b).getPerdate(), Comparator.nullsLast(Comparator.naturalOrder()))).reversed());
                break;
            case 4:
                if(types.equals("베스트셀러")) {
                    books.sort(Comparator.nullsFirst(Comparator.comparingInt(b -> b.getCustomerReviewRank() != null ? b.getCustomerReviewRank() : Integer.MAX_VALUE)));
                }
                break;
            default:
                books.sort(Comparator.nullsFirst(Comparator.comparing(b -> b.getTitle(), Comparator.nullsLast(Comparator.naturalOrder()))));
        }
    }

    private static void displayBooks(List<BookListItemDto> books) {
        int index = 1;
        // 기존 뷰 더미데이터
        for(BookListItemDto book : books) {
            System.out.printf("\n%d. %s\n", index++, book.getTitle());
            System.out.printf("|- ID: %s\n", book.getBookId());
            System.out.printf("|- 저자: %s\n", book.getAuthor());
            System.out.printf("|- 가격: %,d원\n", book.getPriceStandard());
            System.out.printf("|- 상태: %s\n", getConditionText(book.getDisplayType()));
            System.out.printf("|- 출판일: %s\n", book.getPerdate());
            System.out.printf("|- 페이지: %d페이지\n", new Random().nextInt(901)+ 100); // book.pageCount
            if(book.getCustomerReviewRank() != null) {
                System.out.printf("|- 리뷰 순위: %d위\n", book.getCustomerReviewRank());
            }
            System.out.println(SUB_BORDER);
        }
        // 추가 서비스 연결된 리스트
        // System.out.println("베스트");
        // frontController.selectBookListInBest("");
        // System.out.println("신간");
        // frontController.selectBookListInNew("");
        // frontController.selectBookList("");
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

    private static void showBookDetail(int bookId, BookListItemDto book, Scanner scanner) {
        clearScreen();
        // 상세보기 수정 후
        frontController.selectBookDetail(bookId);

        // 수정 전
        printHeader("[상세 정보] " + book.getTitle());
        System.out.printf("\n%d. %s\n", book.getTitle());
        System.out.printf("|- ID: %s\n", book.getBookId());
        System.out.printf("|- 저자: %s\n", book.getAuthor());
        System.out.printf("|- 가격: %,d원\n", book.getPriceStandard());
        System.out.printf("|- 상태: %s\n", getConditionText(book.getDisplayType()));
        System.out.printf("|- 출판일: %s\n", book.getPerdate());
        System.out.printf("|- 페이지: %d페이지\n", new Random().nextInt(901)+ 100); // book.pageCount
        if(book.getCustomerReviewRank() != null) {
            System.out.printf("|- 리뷰 순위: %d위\n", book.getCustomerReviewRank());
        }

        printMenu(new String[]{
                "1. 장바구니 추가",
                "2. 바로구매",
                "0. 돌아가기",
                "99. 종료"
        });

        System.out.print("\n>> 선택: ");
        int choice = getValidNumber(scanner, 0, 99);

        switch(choice) {
            case 0: return;
            case 1: handleAddToCart(book, scanner); break;
            case 2: processPurchase(book, scanner); break;
            case 99: exit(scanner); break;
        }
    }

    private static void handleAddToCart(BookListItemDto book, Scanner scanner) {
        System.out.print("\n>> 수량 입력: ");
        // 수량도 일단 해당 erd에서 만들수 있도록한다.
        int quantity = getValidNumber(scanner, 1, 10);
        // 카트 담는 로직

         //frontController.
        System.out.printf("\n[완료] %s %d권 장바구니 추가 완료!\n", book.getTitle(), quantity);
        System.out.println("[독서 통계] " + getRandomStatistic(quantity));
        pause(scanner);
    }

    private static void processPurchase(BookListItemDto book, Scanner scanner) {
        System.out.print("\n>> 수량 입력: ");
        int quantity = getValidNumber(scanner, 1, 10);

        System.out.println("\n================ 결제 정보 ================");
        System.out.printf("도서명: %s\n", book.getTitle());
        System.out.printf("수량: %d권\n", quantity);
        System.out.printf("결제금액: %,d원\n", book.getPriceStandard() * quantity);
        System.out.println("-----------------------------------------");

        System.out.print("배송지 주소: ");
        String address = scanner.nextLine();

        printMenu(new String[]{
                "1. 신용카드 결제",
                "2. 계좌이체",
                "0. 취소"
        });

        System.out.print("\n>> 결제 방법 선택: ");
        int paymentType = getValidNumber(scanner, 0, 2);

        if(paymentType != 0) {
            String paymentMethod = (paymentType == 1) ? "신용카드" : "계좌이체";
            System.out.println("[완료] 결제가 완료되었습니다!");

            // 장바구니에 추가
            List<CartItem> orderItems = new ArrayList<>();
            orderItems.add(new CartItem(book, quantity));

            // 주문 생성
            String orderId = MockOrderDB.addOrder("홍길동", orderItems, address, paymentMethod);
            System.out.printf("[주문번호] %s\n", orderId);

            // 재고 감소
            MockDB.removeBook(String.valueOf(book.getBookId()));

            // 동적 통계 메시지 출력
            System.out.println("[독서 통계] " + getRandomStatistic(quantity));
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
                System.out.println("\n[알림] 장바구니가 비어 있습니다");
                pause(scanner);
                return;
            }

            cart.forEach(item -> {
                System.out.printf("\n[도서] %s\n", item.book.getTitle());
                System.out.printf("|- 수량: %d개\n", item.quantity);
                System.out.printf("|- 단가: %,d원\n", item.book.getPriceStandard());
                System.out.printf("|- 소계: %,d원\n", item.getTotalPrice());
                System.out.println(SUB_BORDER);
            });

            // 랜덤 출판 트렌드 메시지 출력
            System.out.println("[출판 트렌드] " + getRandomMessage(TREND_MESSAGES));

            printMenu(new String[]{
                    "1. 전체 구매",
                    "2. 장바구니 비우기",
                    "0. 뒤로가기",
                    "99. 종료"
            });

            System.out.print("\n>> 선택: ");
            int choice = getValidNumber(scanner, 0, 99);

            switch(choice) {
                case 0: return;
                case 1: processBulkPurchase(scanner); break;
                case 2:
                    MockCartDB.clearCart();
                    System.out.println("\n[완료] 장바구니를 비웠습니다");
                    pause(scanner);
                    break;
                case 99: exit(scanner); break;
            }
        }
    }

    // 일괄 구매 처리
    private static void processBulkPurchase(Scanner scanner) {
        List<CartItem> cart = MockCartDB.getCart();
        int total = cart.stream().mapToInt(CartItem::getTotalPrice).sum();
        int totalQuantity = cart.stream().mapToInt(item -> item.quantity).sum();

        System.out.println("\n================ 결제 정보 ================");
        System.out.printf("총 결제금액: %,d원\n", total);
        System.out.printf("총 도서 수량: %d권\n", totalQuantity);
        System.out.println("-----------------------------------------");

        System.out.print("배송지 주소: ");
        String address = scanner.nextLine();

        printMenu(new String[]{
                "1. 신용카드 결제",
                "2. 계좌이체",
                "0. 취소"
        });

        System.out.print("\n>> 결제 방법 선택: ");
        int paymentType = getValidNumber(scanner, 0, 2);

        if(paymentType != 0) {
            String paymentMethod = (paymentType == 1) ? "신용카드" : "계좌이체";
            System.out.println("[완료] 결제가 완료되었습니다!");

            // 주문 생성
            String orderId = MockOrderDB.addOrder("홍길동", cart, address, paymentMethod);
            System.out.printf("[주문번호] %s\n", orderId);

            // 구매한 모든 책 재고에서 제거
            cart.forEach(item -> MockDB.removeBook(String.valueOf(item.book.getBookId())));
            MockCartDB.clearCart();

            // 동적 통계 메시지 출력
            System.out.println("[독서 통계] " + getRandomStatistic(totalQuantity));
        }
        pause(scanner);
    }

    // 주문 이력 관리 - 신규 구현
    private static void orderFlow(Scanner scanner) {
        while(true) {
            clearScreen();
            printHeader("주문 이력 관리");
            printSection("구매 내역 및 주문 상태 확인");

            List<Order> orders = MockOrderDB.getOrders();

            if(orders.isEmpty()) {
                System.out.println("\n[알림] 주문 내역이 없습니다");
                pause(scanner);
                return;
            }

            System.out.println("\n[주문 목록]");
            for(int i=0; i<orders.size(); i++) {
                Order order = orders.get(i);
                System.out.printf("%d. 주문번호: %s | 고객명: %s | 주문일: %s | 상태: %s | 총액: %,d원\n",
                        i+1, order.orderId, order.customerName, order.orderDate,
                        order.status, order.totalAmount);
            }

            printMenu(new String[]{
                    "1. 주문 상세 조회",
                    "2. 날짜별 검색",
                    "3. 상태별 검색",
                    "4. 월별 주문 통계",
                    "0. 홈으로 돌아가기",
                    "99. 종료"
            });

            System.out.print("\n>> 선택: ");
            int choice = getValidNumber(scanner, 0, 99);

            switch(choice) {
                case 0: return;
                case 1: viewOrderDetails(scanner, orders); break;
                case 2: searchOrdersByDate(scanner); break;
                case 3: searchOrdersByStatus(scanner); break;
                case 4: showMonthlyOrderStats(scanner); break;
                case 99: exit(scanner); break;
            }
        }
    }

    private static void viewOrderDetails(Scanner scanner, List<Order> orders) {
        System.out.print("\n>> 조회할 주문 번호 선택: ");
        int orderNum = getValidNumber(scanner, 1, orders.size());

        Order order = orders.get(orderNum-1);

        clearScreen();
        printHeader("[주문 상세 정보] " + order.orderId);
        System.out.printf("|- 주문자: %s\n", order.customerName);
        System.out.printf("|- 주문일: %s\n", order.orderDate);
        System.out.printf("|- 상태: %s\n", order.status);
        System.out.printf("|- 배송지: %s\n", order.shippingAddress);
        System.out.printf("|- 결제방법: %s\n", order.paymentMethod);
        System.out.println("\n[주문 상품 목록]");

        int totalPages = 0;

        for(int i=0; i<order.items.size(); i++) {
            OrderItem item = order.items.get(i);
            System.out.printf("%d. %s | 저자: %s | 수량: %d개 | 가격: %,d원 | 소계: %,d원\n",
                    i+1, item.book.getTitle(), item.book.getAuthor(), item.quantity,
                    item.priceAtPurchase, item.getTotalPrice());
            // totalPages += item.book.pageCount * item.quantity;
            totalPages += (new Random().nextInt(851) + 150) * item.quantity;

        }

        System.out.printf("\n|- 총 페이지 수: %d페이지\n", totalPages);
        System.out.printf("|- 총 결제금액: %,d원\n", order.totalAmount);

        printMenu(new String[]{
                "1. 주문 상태 변경",
                "2. 배송 추적",
                "3. 영수증 출력",
                "0. 돌아가기",
                "99. 종료"
        });

        System.out.print("\n>> 선택: ");
        int choice = getValidNumber(scanner, 0, 99);

        switch(choice) {
            case 0: return;
            case 1: changeOrderStatus(scanner, order); break;
            case 2:
                System.out.println("\n[배송 추적 정보]");
                System.out.println("배송 상태: " + order.status);
                if(order.status.equals("배송 중")) {
                    System.out.println("현재 위치: 물류센터 -> 대구 허브 -> 지역 배송점 이동 중");
                    System.out.println("예상 도착일: " + LocalDate.now().plusDays(2));
                } else if(order.status.equals("배송 완료")) {
                    System.out.println("배송 완료일: " + order.orderDate.plusDays(3));
                    System.out.println("수령인: " + order.customerName);
                } else {
                    System.out.println("아직 배송이 시작되지 않았습니다.");
                }
                pause(scanner);
                break;
            case 3:
                System.out.println("\n[영수증 출력]");
                System.out.println(BORDER);
                System.out.println("               온라인 서점 영수증");
                System.out.println("주문번호: " + order.orderId);
                System.out.println("주문일시: " + order.orderDate);
                System.out.println("고객명: " + order.customerName);
                System.out.println(SUB_BORDER);

                for(OrderItem item : order.items) {
                    System.out.printf("%s x %d권 = %,d원\n",
                            item.book.getTitle(), item.quantity, item.getTotalPrice());
                }

                System.out.println(SUB_BORDER);
                System.out.printf("결제 금액: %,d원\n", order.totalAmount);
                System.out.printf("결제 방법: %s\n", order.paymentMethod);
                System.out.println(BORDER);
                System.out.println("영수증이 프린터로 전송되었습니다.");
                pause(scanner);
                break;
            case 99: exit(scanner); break;
        }
    }

    private static void changeOrderStatus(Scanner scanner, Order order) {
        System.out.println("\n[주문 상태 변경]");
        printMenu(new String[]{
                "1. 배송 준비중",
                "2. 배송 중",
                "3. 배송 완료",
                "4. 취소됨",
                "0. 돌아가기"
        });

        System.out.print("\n>> 새 상태 선택: ");
        int choice = getValidNumber(scanner, 0, 4);

        if(choice == 0) return;

        String newStatus = switch(choice) {
            case 1 -> "배송 준비중";
            case 2 -> "배송 중";
            case 3 -> "배송 완료";
            case 4 -> "취소됨";
            default -> order.status;
        };

        MockOrderDB.updateOrderStatus(order.orderId, newStatus);
        System.out.printf("\n[완료] 주문 %s의 상태가 '%s'로 변경되었습니다.\n",
                order.orderId, newStatus);
        pause(scanner);
    }

    private static void searchOrdersByDate(Scanner scanner) {
        System.out.println("\n[날짜별 검색]");
        System.out.print("검색 시작일 입력 (YYYY-MM-DD): ");
        String startDateStr = scanner.nextLine();
        System.out.print("검색 종료일 입력 (YYYY-MM-DD): ");
        String endDateStr = scanner.nextLine();

        try {
            LocalDate startDate = LocalDate.parse(startDateStr, DATE_FORMATTER);
            LocalDate endDate = LocalDate.parse(endDateStr, DATE_FORMATTER);

            List<Order> filteredOrders = MockOrderDB.getOrdersByDateRange(startDate, endDate);

            if(filteredOrders.isEmpty()) {
                System.out.println("\n[알림] 해당 기간에 주문 내역이 없습니다");
            } else {
                System.out.printf("\n[%s ~ %s 주문 목록]\n", startDateStr, endDateStr);
                for(int i=0; i<filteredOrders.size(); i++) {
                    Order order = filteredOrders.get(i);
                    System.out.printf("%d. 주문번호: %s | 고객명: %s | 주문일: %s | 상태: %s | 총액: %,d원\n",
                            i+1, order.orderId, order.customerName, order.orderDate,
                            order.status, order.totalAmount);
                }
            }
        } catch (DateTimeParseException e) {
            System.out.println("\n[오류] 날짜 형식이 올바르지 않습니다 (YYYY-MM-DD)");
        }

        pause(scanner);
    }

    private static void searchOrdersByStatus(Scanner scanner) {
        System.out.println("\n[상태별 검색]");
        printMenu(new String[]{
                "1. 배송 준비중",
                "2. 배송 중",
                "3. 배송 완료",
                "4. 취소됨",
                "5. 전체 상태",
                "0. 돌아가기"
        });

        System.out.print("\n>> 검색할 상태: ");
        int choice = getValidNumber(scanner, 0, 5);

        if(choice == 0) return;

        String statusToSearch = switch(choice) {
            case 1 -> "배송 준비중";
            case 2 -> "배송 중";
            case 3 -> "배송 완료";
            case 4 -> "취소됨";
            case 5 -> null; // 전체 상태
            default -> null;
        };

        List<Order> filteredOrders = MockOrderDB.getOrdersByStatus(statusToSearch);

        if(filteredOrders.isEmpty()) {
            System.out.println("\n[알림] 해당 상태의 주문 내역이 없습니다");
        } else {
            System.out.printf("\n[%s 상태 주문 목록]\n",
                    statusToSearch != null ? statusToSearch : "전체");
            for(int i=0; i<filteredOrders.size(); i++) {
                Order order = filteredOrders.get(i);
                System.out.printf("%d. 주문번호: %s | 고객명: %s | 주문일: %s | 총액: %,d원\n",
                        i+1, order.orderId, order.customerName, order.orderDate,
                        order.totalAmount);
            }
        }

        pause(scanner);
    }

    private static void showMonthlyOrderStats(Scanner scanner) {
        clearScreen();
        printHeader("월별 주문 통계");

        Map<String, Integer> monthlyStats = MockOrderDB.getMonthlyOrderStats();

        if(monthlyStats.isEmpty()) {
            System.out.println("\n[알림] 주문 통계 데이터가 없습니다");
        } else {
            System.out.println("\n[월별 주문 건수]");

            // 날짜순으로 정렬
            List<String> sortedMonths = new ArrayList<>(monthlyStats.keySet());
            Collections.sort(sortedMonths);

            System.out.println(SUB_BORDER);
            System.out.printf("%-10s | %-10s | %-10s\n", "년-월", "주문 건수", "그래프");
            System.out.println(SUB_BORDER);

            for(String month : sortedMonths) {
                int count = monthlyStats.get(month);
                System.out.printf("%-10s | %-10d | %s\n",
                        month, count, "*".repeat(count * 2));
            }

            System.out.println(SUB_BORDER);

            // 총계 계산
            int total = monthlyStats.values().stream().mapToInt(Integer::intValue).sum();
            System.out.printf("총 주문 건수: %d건\n", total);
        }

        printMenu(new String[]{"0. 돌아가기"});
        System.out.print("\n>> 선택: ");
        getValidNumber(scanner, 0, 0);
    }

    // 회원 정보 관리
    private static void userFlow(Scanner scanner) {
        System.out.println("회원 정보 관리 기능은 아직 준비 중입니다.");
        pause(scanner);
    }

    // 섹션 출력
    private static void printSection(String title) {
        System.out.println("\n" + SUB_BORDER);
        System.out.println("| " + title);
        System.out.println(SUB_BORDER);
    }

    // 헤더 출력
    private static void printHeader(String title) {
        System.out.println(BORDER);
        System.out.println("| " + title + " |");
        System.out.println(BORDER);
    }

    // 메뉴 출력
    private static void printMenu(String[] items) {
        System.out.println("\n" + SUB_BORDER);
        for(String item : items) {
            System.out.println(item);
        }
        System.out.println(SUB_BORDER);
    }

    // 화면 클리어
    private static void clearScreen() {
        for(int i=0; i<50; i++) {
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
        System.out.println("\n[경고] " + message);
    }

    // 입력 검증
    private static int getValidNumber(Scanner scanner, int min, int max) {
        while(true) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine(); // 버퍼 비우기
                if(input == 0 || input == 99 || (input >= min && input <= max)) {
                    return input;
                }
                System.out.printf("[경고] %d~%d 사이 숫자를 입력해주세요 (0:뒤로가기, 99:종료)\n", min, max);
            } catch(InputMismatchException e) {
                System.out.println("[경고] 숫자만 입력 가능합니다");
                scanner.nextLine(); // 버퍼 비우기
            }
        }
    }

    // 랜덤 메시지 생성
    private static String getRandomMessage(String[] messages) {
        return messages[random.nextInt(messages.length)];
    }

    // 랜덤 통계 메시지 생성 (수량 기반 동적 계산)
    private static String getRandomStatistic(int quantity) {
        StatisticMessage statistic = PURCHASE_STATISTICS[random.nextInt(PURCHASE_STATISTICS.length)];
        return statistic.getFormattedMessage(quantity);
    }

    // 예외 처리 핸들러
    private static void errorHandler(Scanner scanner, Exception e) {
        System.out.println("\n[시스템 오류] " + e.getMessage());
        scanner.nextLine(); // 버퍼 비우기
    }

    // 종료
    private static void exit(Scanner scanner) {
        System.out.println("\n[종료] 프로그램을 종료합니다.");
        System.out.println("이용해주셔서 감사합니다!");
        scanner.close();
        System.exit(0);
    }
}
