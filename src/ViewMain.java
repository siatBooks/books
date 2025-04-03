// import java.util.Scanner;

// public class ViewMain {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
        
//         System.out.println("===================온라인 서점 시스템============");
//         System.out.println(">> 로그인 >>");
//         System.out.print("성명:");
//         scanner.nextInt();
//         System.out.println();

//         System.out.print("비밀번호:");
//         scanner.nextInt();
//         System.out.println();

//         while (true) {
//             try {
//                 System.out.println("====================[홈페이지]====================");
//                 System.out.println("= 1. 도서 검색   ");
//                 System.out.println("= 2. 회원 정보 조회 ");
//                 System.out.println("= 3. 주문 이력 확인 ");
//                 System.out.println("= 4. 장바구니 보기  ");
//                 System.out.println("= 99. 종료     ");
//                 System.out.println("====================");
//                 // System.out.println("* 숫자 8을 입력하면 모든 화면에서 장바구니 보기 화면으로 넘어갑니다");
//                 int num = scanner.nextInt();

//                 switch (num) {
//                     case 1:
//                         search(); break;
//                     case 2:
//                         user(); break;
//                     case 3:
//                         System.out.println("주문 리스트");
//                         System.out.println("주문 리스트");
//                         System.out.println("주문 리스트");
//                         System.out.println("주문 리스트");
//                         break;
//                     case 4:
//                         System.out.println("주문 리스트");
//                         System.out.println("주문 리스트");
//                         System.out.println("주문 리스트");
//                         System.out.println("주문 리스트");
//                         break;
                
//                     case 99:
//                         exit();
                    
//                     // 그외 모두는 종료버튼으로 간주해보자.
//                     default:
//                         exit();
//                         break;
//                 }
//             } catch (Exception e) {
//                 e.printStackTrace();
//             }
//         }
//     }

//     private static void exit() {
//         System.out.println("시스템 종료? (y/n)");
//         Scanner scanner1 = new Scanner(System.in);
//         String str = scanner1.nextLine();

//         if (str.equals("y")) {
//             System.exit(0);
//         } else if (str.equals("n")) {
//             System.out.println("\n\n\n\n\n");
//             System.out.println("초기 화면으로 돌아갑니다.");
//         } else {
//             System.out.println("\n\n\n\n\n");
//             System.out.println("입력이 잘못 되었습니다. 초기 화면으로 돌아갑니다.");
//         }
//     }

//     private static void user() {
//         while (true) {
//             try {
//                 System.out.println("> 유저 정보 조회");
//                 System.out.println("> 유저 정보 리스트");
//                 System.out.println("> 유저 정보 리스트");
//                 System.out.println("> 유저 정보 리스트");
//                 System.out.println("> 유저 정보 리스트");
//                 System.out.println("원하시는 번호를 선택하세요 : ");
//                 System.out.println("1 회원 정보 수정  2 상위 메뉴 이동 99 종료");
//                 System.out.println("* 숫자 8을 입력하면 모든 화면에서 장바구니 보기 화면으로 넘어갑니다");
//                 Scanner scanner = new Scanner(System.in);
//                 int num = scanner.nextInt();

//                 switch (num) {
//                     case 1:
//                         System.out.println("검색");
//                         break;
//                     case 2:
//                         return;
//                     case 99:
//                         exit();
//                 }
//             } catch (Exception e) {
//                 e.printStackTrace();
//             }
//         }
//     }



//     private static void home() {
        
//     }
//     private static void search() {
//         while (true) {
//             try {
                
//                 System.out.println("[검색 유형[v]]");
//                 System.out.println("|-1 베스트셀러 검색");
//                 System.out.println("|-2 신간 검색");
//                 System.out.println("|-3 전체 검색");
//                 allPageOption(); // 나머지 옵션

                                    
//                 System.out.println("* 숫자 8을 입력하면 모든 화면에서 장바구니 보기 화면으로 넘어갑니다");

//                 Scanner scanner = new Scanner(System.in);
//                 System.out.println("> 서적 검색 ");
//                 System.out.print("검색어를 입력해주세요 : ");
//                 String searchContents = scanner.nextLine();
//                 System.out.println();

//                 System.out.println("검색유형을 선택해주세요 : ");
//                 int num = scanner.nextInt();

                
//                 switch (num) {
//                     case 1: // 베스트 셀러
//                         searchResult("bstseller", searchContents); // 매개변수로 줘야될듯하다...
//                         break;
//                     case 2: // 신간
//                         searchResult("newseller", searchContents); // 매개변수로 줘야될듯하다...
//                         break;
//                     case 3: // 전체
//                         searchResult("all", searchContents); // 매개변수로 줘야될듯하다...
//                         break;
//                     case 0:
//                         // detail();
//                         System.out.println("홈페이지로 이동합니다.");
//                         home();
//                         break;
//                     case 99:
//                         exit();
//                 }
//             } catch (Exception e) {
//                 e.printStackTrace();
//             }
//         }

//     }
//     // 정렬하는 기준을 각각 나눠야하나?
//     private static void searchResult(String searchType, String searchContents) { // 상수값을 토대로 넣는 것도 좋은 방법!

//         if (searchType.equals("bstseller")) {
//             System.out.println("베스트셀러 검색 결과입니다.");
//             // 데이터셋 받는다.
//         } else if (searchType.equals("newseller")) {
//             System.out.println("신간 검색 결과입니다.");
//             // 데이터셋 받는다.
//         } else if (searchType.equals("all")) {
//             System.out.println("전체 검색 결과입니다.");
//             // 데이터셋 받는다.
//         } else {
//             System.out.println("잘못된 검색어입니다.");
//             return;
//         }

//         // 받은 데이터셋으로 뿌려준다.
//         System.out.println("====================[검색결과페이지]====================");
//         System.out.println("= 검색어:    " + "{서적명}");
//         System.out.println("= 검색 유형:    " + "{전체 검색}"); // 해당 내용에 데이터가 들어가야한다.
//         System.out.println("= 정렬 유형:    " + "{기본은 문자 오름차순 정렬}"); // 해당 내용에 데이터가 들어가야한다.
//         System.out.println("====================");

//         System.out.println("검색어를 입력해주세요 : ");
//         System.out.println("서적 리스트1");
//         System.out.println("> {1번째 책 제목}");
//         System.out.println("> {1번째 책 저자}");
//         System.out.println("> {북타입: Ebook}");
//         System.out.println("> {판매가: 18000원} ");

//         System.out.println("서적 리스트2");
//         System.out.println("> {2번째 책 제목}");
//         System.out.println("> {2번째 책 저자}");
//         System.out.println("> {북타입: book}");
//         System.out.println("> {판매가: 26000원} ");
        
//         System.out.println("서적 리스트3");
//         System.out.println("> {3번째 책 제목}");
//         System.out.println("> {3번째 책 저자}");
//         System.out.println("> {북타입: book}");
//         System.out.println("> {판매가: 21000원} ");
        
//         System.out.println("서적 리스트4");
//         System.out.println("> {3번째 책 제목}");
//         System.out.println("> {북타입: book}");
//         System.out.println("> {판매가: 12000원} ");
        
//         // System.out.println("정렬을 선택해주세요 : ");
//         // System.out.println("1 베스트셀러 순위  2 리뷰 순위 3 구매 순위 4 선택 99 종료");
//         // System.out.println("* 숫자 8을 입력하면 모든 화면에서 장바구니 보기 화면으로 넘어갑니다");

//         // System.out.println("원하시는 번호를 선택하세요 : ");

//         Scanner scanner = new Scanner(System.in);
//         System.out.println("[액션을 선택해주세요[v]]");
//         System.out.println("|-1 원하는 도서 선택");
//         System.out.println("|-2 도서 재검색");
//         System.out.println("|-3 재정렬");
//         allPageOption(); // 나머지 옵션
//         int num = scanner.nextInt();
        
//         switch (num) {
//             case 1: // 원하는 도서 선택
//                 detail();
                
//                 break;
//             case 2: // search 인데 무한루프가 되지 않을까? 검토 필요.
//                 search();
//                 break;
//             case 3: // 재정렬
//                 sort();
//                 break;
//             case 0:
//                 home();
//                 break;
//             case 99:
//                 exit();
//                 break; 
//             default:
//                 exit();
//                 break;
//         }
//     }
//     private static void detail() { // 책정보가 내려오거나 무슨 방법이 필요..
//         while (true) {
//             try {

//                 System.out.println("> 책 상세 정보");
//                 System.out.println("=====================");
//                 System.out.println("- 서적명:");
//                 System.out.println("- 저자:");
//                 System.out.println("- 출판사:");
//                 System.out.println("- 출판일:");
//                 System.out.println("=====================");
//                 System.out.println();

//                 System.out.println("> 중고 서적 가격표");
//                 System.out.println("=====================");
//                 System.out.println("- 최상" + "{개수}" + " : " + "{가격}");
//                 System.out.println("- 상"   + "{개수}" + " : " + "{가격}");
//                 System.out.println("- 중"   + "{개수}" + " : " + "{가격}");
//                 System.out.println("- 하"   + "{개수}" + " : " + "{가격}");
//                 System.out.println("=====================");

//                 System.out.println("원하시는 번호를 선택하세요 : ");
//                 System.out.println("1 장바구니 담기  2 해당 서적 바로 구매");
//                 allPageOption(); // 나머지 옵션
//                 Scanner scanner = new Scanner(System.in);
//                 int num = scanner.nextInt();

//                 switch (num) {
//                     case 1:
//                         System.out.println("장바구니에 담기");
//                         System.out.println("장바구니 보기 페이지로 이동 ");

//                         System.out.println("서적 상태 선택: ");
//                         System.out.println("1 최상 2 상 3 중");
//                         int state = scanner.nextInt();
//                         System.out.println("수량 입력");
//                         int amounts = scanner.nextInt();
//                         cart(); // 카드에 담기 : 데이터도 당연히 필요할 것이다.
//                         break;
//                     case 2:
//                         System.out.println("서적 상태 선택: ");
//                         System.out.println("1 최상 2 상 3 중");
//                         int state1 = scanner.nextInt();
//                         System.out.println("수량 입력");
//                         int amounts1 = scanner.nextInt();

//                         order(); // ? 주문하기 페이지로 이동


//                         break;
//                     case 0:
//                         System.out.println("홈페이지로 이동합니다.");
//                         home();
//                         break;
//                     case 99:
//                         exit();
//                 }
//             } catch (Exception e) {
//                 e.printStackTrace();
//             }
//         }

//     }
//     private static void order() {
//         while (true) {
//             try {
//                 System.out.println("> 주문 페이지");
//                 System.out.println("캡슐 문장");
//                 System.out.println("1 주문 0. 홈페이지 이동 99 종료");
//                 System.out.println("원하시는 번호를 선택하세요 : ");

//                 Scanner scanner = new Scanner(System.in);
//                 int num = scanner.nextInt();

//                 switch (num) {
//                     case 0:
//                         home();
//                         break;
//                     case 1:
//                     // 실제로 받는 건 아직...
//                         System.out.println("주문 중입니다");
//                         System.out.println("주문이 완료되었습니다");
//                         // 내주문 정보 조회
//                         break;
//                     case 99:
//                         exit();
//                         break;
//                     default:
//                         break;
//                 }
//             } catch (Exception e) {
//                 e.printStackTrace();
//             }
//         }
//     }

//     private static void sort() {
//         System.out.println("정렬을 선택해주세요 : ");
//         System.out.println("1 베스트셀러 순위  2 리뷰 순위 3 구매 순위 4 선택 99 종료");
//         System.out.println("* 숫자 8을 입력하면 모든 화면에서 장바구니 보기 화면으로 넘어갑니다");

//         Scanner scanner = new Scanner(System.in);
//         int num = scanner.nextInt();
        
//         switch (num) {
//             case 1:
//                 System.out.println("베스트셀러 순위로 정렬합니다.");
//                 break;
//             case 2:
//                 System.out.println("리뷰 순위로 정렬합니다.");
//                 break;
//             case 3:
//                 System.out.println("구매 순위로 정렬합니다.");
//                 break;
//             case 4:
//                 System.out.println("선택한 서적을 구매합니다.");
//                 break;
//             case 99:
//                 exit();
//                 break;
//             default:
//                 exit();
//                 break;
//         }
//     }
//     private static void cart(){
//         System.out.println("원하시는 번호를 선택하세요 : ");
//         System.out.println("1. 구매 0.홈페이지  99.  종료");

//         Scanner scanner = new Scanner(System.in);
//         int num = scanner.nextInt();
        
//         switch (num) {
//             case 0:
//                 System.out.println("홈페이지로 이동합니다.");
//                 home();
//                 break;
//             case 1:
//                 System.out.println("구매");
//                 // 구매 함수 작성 필요
//                 break;
//             case 99:
//                 System.out.println("종료합니다.");
//                 exit();
//                 break;
//             default:
//                 System.out.println("잘못된 입력입니다.");
//                 exit();
//                 break;
//         }



//     }
//     private static void allPageOption() { // return 값을 주는게 좋아보이는데
//         System.out.println("====================[그외]====================");
//         System.out.println("> 0. 홈페이지");
//         System.out.println("= 99. 종료     ");
//         System.out.println("====================");        


//         Scanner scanner = new Scanner(System.in);
//         int num = scanner.nextInt();
        
//         switch (num) {
//             case 1:
//                 System.out.println("홈페이지로 이동합니다.");
//                 home();
//                 break;
//             case 2:
//                 System.out.println("종료합니다.");
//                 exit();
//                 break;
//             default:
//                 System.out.println("잘못된 입력입니다.");
//                 exit();
//                 break;
//         }

//     }
// }





// ----------------------------------------------------- // 

// 초안

// import java.util.Scanner;

// public class ViewMain {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
        
//         System.out.println("===================온라인 서점 시스템============");
//         System.out.println(">> 로그인 >>");
//         System.out.print("성명: ");
//         String name = scanner.nextLine();
//         System.out.println();

//         System.out.print("비밀번호: ");
//         String password = scanner.nextLine();
//         System.out.println();

//         home(scanner);
//     }

//     private static void home(Scanner scanner) {
//         while (true) {
//             try {
//                 System.out.println("====================[홈페이지]====================");
//                 System.out.println("= 1. 도서 검색   ");
//                 System.out.println("= 2. 회원 정보 조회 ");
//                 System.out.println("= 3. 주문 이력 확인 ");
//                 System.out.println("= 4. 장바구니 보기  ");
//                 System.out.println("= 99. 종료     ");
//                 System.out.println("====================");
//                 System.out.println();

//                 System.out.print("메뉴 선택: ");
//                 System.out.println();
                
//                 int num = scanner.nextInt();
//                 scanner.nextLine(); // 버퍼 비우기

//                 switch (num) {
//                     case 1:
//                         search(scanner); 
//                         break;
//                     case 2:
//                         user(scanner); 
//                         break;
//                     case 3:
//                         System.out.println("주문 리스트");
//                         System.out.println("주문 리스트");
//                         System.out.println("주문 리스트");
//                         System.out.println("주문 리스트");
//                         break;
//                     case 4:
//                         cart(scanner); 
//                         break;
//                     case 99:
//                         exit(scanner);
//                         break;
//                     default:
//                         System.out.println("잘못된 입력입니다. 초기 화면으로 돌아갑니다.");
//                         break;
//                 }
//             } catch (Exception e) {
//                 System.out.println("오류가 발생했습니다: " + e.getMessage());
//                 scanner.nextLine(); // 입력 버퍼 비우기
//             }
//         }
//     }

//     private static void exit(Scanner scanner) {
//         System.out.println("시스템 종료? (y/n)");
//         String str = scanner.nextLine();

//         if (str.equalsIgnoreCase("y")) {
//             System.out.println("시스템을 종료합니다. 감사합니다.");
//             System.exit(0);
//         } else {
//             System.out.println("\n\n\n");
//             System.out.println("초기 화면으로 돌아갑니다.");
//         }
//     }

//     private static void user(Scanner scanner) {
//         while (true) {
//             try {
//                 System.out.println("> 유저 정보 조회");
//                 System.out.println("> 유저 정보 리스트");
//                 System.out.println("> 유저 정보 리스트");
//                 System.out.println("> 유저 정보 리스트");
//                 System.out.println("> 유저 정보 리스트");
//                 System.out.println("원하시는 번호를 선택하세요 : ");
                
//                 System.out.println("\n");
//                 System.out.println("1 회원 정보 수정  2 이전으로 바로가기 0 홈페이지 돌아가기 99 종료");
//                 System.out.println("* 숫자 8을 입력하면 모든 화면에서 장바구니 보기 화면으로 넘어갑니다");
//                 System.out.println("\n\n\n");
                
//                 System.out.print("선택: ");
//                 int num = scanner.nextInt();
//                 scanner.nextLine(); // 버퍼 비우기

//                 switch (num) {
//                     case 0:
//                         home(scanner);
//                         return; // 홈페이지로 복귀
//                     case 1:
//                         System.out.println("회원 정보 수정");
//                         break;
//                     case 2:
//                         return; // 상위 메뉴로 이동
//                     case 8:
//                         cart(scanner);
//                         return;
//                     case 99:
//                         exit(scanner);
//                         break;
//                     default:
//                         System.out.println("잘못된 입력입니다.");
//                         break;
//                 }
//             } catch (Exception e) {
//                 System.out.println("오류가 발생했습니다: " + e.getMessage());
//                 scanner.nextLine(); // 버퍼 비우기
//             }
//         }
//     }

//     private static void search(Scanner scanner) {
//         while (true) {
//             try {
//                 System.out.println("\n\n");
//                 System.out.println("====================[도서 검색]====================");
//                 System.out.println("[검색 유형[v]]");
                
//                 System.out.println("|-1 베스트셀러 검색");
//                 System.out.println("|-2 신간 검색");
//                 System.out.println("|-3 전체 검색");

//                 System.out.println();
//                 System.out.println("|-0 홈페이지로 돌아가기");
//                 System.out.println("|-99 종료");
//                 System.out.println();
//                 System.out.println("* 숫자 8을 입력하면 모든 화면에서 장바구니 보기 화면으로 넘어갑니다");
//                 System.out.println("====================");

//                 System.out.println("> 서적 검색 ");
//                 System.out.print("검색어를 입력해주세요: ");
//                 String searchContents = scanner.nextLine();
//                 System.out.println();

//                 System.out.print("검색유형을 선택해주세요: ");

//                 int num = scanner.nextInt();
//                 scanner.nextLine(); // 버퍼 비우기
                
//                 switch (num) {
//                     case 0:
//                         home(scanner);
//                         return; // 홈페이지로 복귀
//                     case 1: // 베스트 셀러
//                         searchResult("bstseller", searchContents, scanner);
//                         break;
//                     case 2: // 신간
//                         searchResult("newseller", searchContents, scanner);
//                         break;
//                     case 3: // 전체
//                         searchResult("all", searchContents, scanner);
//                         break;
//                     case 8:
//                         cart(scanner);
//                         return;
//                     case 99:
//                         exit(scanner);
//                         break;
//                     default:
//                         System.out.println("잘못된 입력입니다.");
//                         break;
//                 }
//             } catch (Exception e) {
//                 System.out.println("오류가 발생했습니다: " + e.getMessage());
//                 scanner.nextLine(); // 버퍼 비우기
//             }
//         }
//     }

//     private static void searchResult(String searchType, String searchContents, Scanner scanner) {
//         if (searchType.equals("bstseller")) {
//             System.out.println("베스트셀러 검색 결과입니다.");
//         } else if (searchType.equals("newseller")) {
//             System.out.println("신간 검색 결과입니다.");
//         } else if (searchType.equals("all")) {
//             System.out.println("전체 검색 결과입니다.");
//         } else {
//             System.out.println("잘못된 검색어입니다.");
//             return;
//         }

//         // 검색 결과 표시
//         System.out.println("====================[검색결과페이지]====================");
//         System.out.println("= 검색어: " + searchContents);
//         System.out.println("= 검색 유형: " + searchType);
//         System.out.println("= 정렬 유형: 기본(문자 오름차순 정렬)");
//         System.out.println("====================");
//         System.out.println("\n\n");

//         // 검색 결과 예시 출력 -> 반복 구문이 있어야겠죠?
//         // 📖📓📚📑🔍🖋✏🖍📆📝🗓📌📌⌛⏰ 💰💵💶💸 💨💫💬 🗝📟📞🖥💻🛒
//         System.out.println("📗 [서적 리스트1] ");
//         System.out.println("📓 {1번째 책 제목} ");
//         System.out.println("📝 {1번째 책 저자}");
//         System.out.println("📌 {북타입: Ebook}");
//         System.out.println("💸 {판매가: 18000원} ");
//         System.out.println("====================");

//         System.out.println("[액션을 선택해주세요[v]]");
//         System.out.println("|-1 📚원하는 도서 선택 ");
//         System.out.println("|-2 🔍도서 재검색");
//         System.out.println("|-3 재정렬💨");
//         System.out.println("|-0 🏠 홈페이지로 돌아가기");
//         System.out.println("|-8 🛒 장바구니");
//         System.out.println("|-99 ⏹ 종료");
//         System.out.println("====================");

//         System.out.print("액션 선택: ");
//         int num = scanner.nextInt();
//         scanner.nextLine(); // 버퍼 비우기
        
//         switch (num) {
//             case 0:
//                 home(scanner);
//                 return; // 홈페이지로 복귀
//             case 1: // 원하는 도서 선택
//                 detail(scanner);
//                 break;
//             case 2: // 재검색 - 스택 오버플로우 방지를 위해 return
//                 search(scanner);
//                 break;
//             case 3: // 재정렬
//                 sort(scanner);
//                 break;
//             case 8:
//                 cart(scanner);
//                 break;
//             case 99:
//                 exit(scanner);
//                 break; 
//             default:
//                 System.out.println("잘못된 입력입니다.");
//                 break;
//         }
//     }

//     private static void detail(Scanner scanner) {
//         try {
//             System.out.println("> 책 상세 정보");
//             System.out.println("=====================");
//             System.out.println("- 서적명: 자바 프로그래밍");
//             System.out.println("- 저자: 홍길동");
//             System.out.println("- 출판사: 코딩출판사");
//             System.out.println("- 출판일: 2023-01-01");
//             System.out.println("=====================");
//             System.out.println();

//             System.out.println("> 중고 서적 가격표");
//             System.out.println("=====================");
//             System.out.println("- 최상 (5) : 25000원");
//             System.out.println("- 상 (3) : 20000원");
//             System.out.println("- 중 (7) : 15000원");
//             System.out.println("- 하 (2) : 10000원");
//             System.out.println("=====================");

//             System.out.println("원하시는 번호를 선택하세요 : ");
//             System.out.println("1 장바구니 담기  2 해당 서적 바로 구매  0 홈페이지  99 종료");
            
//             System.out.print("선택: ");
//             int num = scanner.nextInt();
//             scanner.nextLine(); // 버퍼 비우기

//             switch (num) {
//                 case 0:
//                     home(scanner);
//                     return; // 홈페이지로 복귀
//                 case 1:
//                     System.out.println("장바구니에 담기");
//                     System.out.print("서적 상태 선택(1:최상 2:상 3:중 4.하): ");
//                     int state = scanner.nextInt();
//                     scanner.nextLine(); // 버퍼 비우기
                    
//                     System.out.print("수량 입력: ");
//                     int amounts = scanner.nextInt();
//                     scanner.nextLine(); // 버퍼 비우기
                    
//                     System.out.println(amounts + "권이 장바구니에 담겼습니다.");
//                     cart(scanner);
//                     break;
//                 case 2:
//                     System.out.print("서적 상태 선택(1:최상 2:상 3:중 4.하): ");
//                     int state1 = scanner.nextInt();
//                     scanner.nextLine(); // 버퍼 비우기
                    
//                     System.out.print("수량 입력: ");
//                     int amounts1 = scanner.nextInt();
//                     scanner.nextLine(); // 버퍼 비우기
                    
//                     System.out.println(amounts1 + "권을 바로 구매합니다.");
//                     order(scanner);
//                     break;
//                 case 8:
//                     cart(scanner);
//                     return;
//                 case 99:
//                     exit(scanner);
//                     break;
//                 default:
//                     System.out.println("잘못된 입력입니다.");
//                     break;
//             }
//         } catch (Exception e) {
//             System.out.println("오류가 발생했습니다: " + e.getMessage());
//             scanner.nextLine(); // 버퍼 비우기
//         }
//     }

//     private static void order(Scanner scanner) {
//         try {
//             System.out.println("> 주문 페이지");
//             System.out.println("=====================");
//             System.out.println("- 주문 상품: 자바 프로그래밍");
//             System.out.println("- 상태: 최상");
//             System.out.println("- 수량: 1");
//             System.out.println("- 가격: 25000원");
//             System.out.println("- 배송비: 3000원");
//             System.out.println("- 총액: 28000원");
//             System.out.println("=====================");
//             System.out.println("1 주문 확정 0 홈페이지 이동 99 종료");
            
//             System.out.print("선택: ");
//             int num = scanner.nextInt();
//             scanner.nextLine(); // 버퍼 비우기

//             switch (num) {
//                 case 0:
//                     home(scanner);
//                     return; // 홈페이지로 복귀
//                 case 1:
//                     System.out.println("주문을 진행합니다...");
//                     System.out.println("주문이 완료되었습니다!");
//                     return; // 주문 완료 후 홈페이지로 복귀
//                 case 8:
//                     cart(scanner);
//                     return;
//                 case 99:
//                     exit(scanner);
//                     break;
//                 default:
//                     System.out.println("잘못된 입력입니다.");
//                     break;
//             }
//         } catch (Exception e) {
//             System.out.println("오류가 발생했습니다: " + e.getMessage());
//             scanner.nextLine(); // 버퍼 비우기
//         }
//     }

//     private static void sort(Scanner scanner) {
//         System.out.println("정렬을 선택해주세요 : ");
//         System.out.println("1 베스트셀러 순위  2 리뷰 순위 3 판매순 4 최신순 5  0 홈페이지 99 종료"); // 구매 순위 4 
        
//         System.out.print("선택: ");
//         int num = scanner.nextInt();
//         scanner.nextLine(); // 버퍼 비우기
        
//         switch (num) {
//             case 0:
//                 home(scanner);
//                 return; // 홈으로 돌아가기
//             case 1:
//                 System.out.println("베스트셀러 순위로 정렬합니다.");
//                 break;
//             case 2:
//                 System.out.println("리뷰 순위로 정렬합니다.");
//                 break;
//             case 3:
//                 System.out.println("가격순으로 정렬합니다.");
//                 break;
//             case 8:
//                 cart(scanner);
//                 break;
//             case 99:
//                 exit(scanner);
//                 break;
//             default:
//                 System.out.println("잘못된 입력입니다.");
//                 break;
//         }
//     }

//     private static void cart(Scanner scanner) {
//         System.out.println("> 장바구니 페이지");
//         System.out.println("=====================");
//         System.out.println("1. 자바 프로그래밍 (최상) - 1권 - 25000원"); // 해당 부분 수정이 필요! -> 업데이트된 책이름과 권수 및 가격이 나와야한다.(db 연동후)
//         System.out.println("2. 스프링 부트 가이드 (상) - 2권 - 40000원"); // 해당 부분 수정이 필요! -> (이하 동일)
//         System.out.println("=====================");
//         System.out.println("총액: 65000원");
//         System.out.println("1. 전체 구매 2. 선택 구매 3. 장바구니 비우기 0.홈페이지 99.종료");

//         System.out.print("선택: ");
//         int num = scanner.nextInt();
//         scanner.nextLine(); // 버퍼 비우기
        
//         switch (num) {
//             case 0:
//                 home(scanner);
//                 return; // 홈페이지로 복귀
//             case 1:
//                 System.out.println("전체 상품을 구매합니다.");
//                 order(scanner);
//                 break;
//             case 2:
//                 System.out.println("구매할 상품 번호를 입력하세요.");
//                 System.out.print("상품 번호: ");
//                 int itemNum = scanner.nextInt();
//                 scanner.nextLine(); // 버퍼 비우기
//                 System.out.println(itemNum + "번 상품을 구매합니다.");
//                 order(scanner);
//                 break;
//             case 3:
//                 System.out.println("장바구니를 비웠습니다.");
//                 return;
//             case 99:
//                 exit(scanner);
//                 break;
//             default:
//                 System.out.println("잘못된 입력입니다.");
//                 break;
//         }
//     }
// }
// import java.util.Scanner;
// import java.util.Random;

// public class ViewMain {
//     private static final Random random = new Random();

//     // 책 구매 및 장바구니 담기 시 출력할 메시지 배열
//     private static final String[] PURCHASE_MESSAGES = {
//         "지금까지 읽으신 책의 총 페이지를 쌓으면 에베레스트 높이의 3배에 달합니다.",
//         "당신이 읽은 책들을 쌓으면 남산타워 15개를 세운 높이입니다.",
//         "올해 독서에 투자한 시간은 서울에서 부산까지 KTX로 20번 왕복할 수 있는 시간입니다.",
//         "당신의 독서 시간은 넷플릭스 드라마 '오징어 게임' 시리즈를 35번 볼 수 있는 시간입니다.",
//         "각 페이지가 한 걸음이라면, 당신은 서울에서 부산까지 두 번 왕복한 거리를 걸었습니다!",
//         "당신이 읽은 책의 페이지를 일렬로 늘어놓으면 한강 길이의 5배에 해당합니다.",
//         "당신의 전자책 독서 습관은 소나무 15그루를 살렸습니다—여의도 공원의 1/10에 해당하는 면적입니다.",
//         "당신이 읽은 책들의 무게는 중형 승용차 한 대와 같습니다.",
//         "올해 읽은 책의 두께를 모두 합치면 냉장고 높이의 2배입니다."
//     };

//     // 장바구니 페이지에서 출력할 출판 트렌드 메시지 배열
//     private static final String[] TREND_MESSAGES = {
//         "당신이 선호하는 장르의 평균 가격은 2020년 이후 15% 하락했습니다.",
//         "A출판사는 시장 점유율 30%로 선두를 달리고, B출판사가 20%로 뒤를 잇고 있습니다.",
//         "높은 평점을 받은 책들은 대체로 가격이 낮고 2020년 이후 출간된 경향이 있습니다.",
//         "미스터리 장르는 다른 장르에 비해 일관되게 높은 평점을 받고 있습니다."
//     };

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         System.out.println("===================온라인 서점 시스템============");
//         System.out.println(">> 로그인 >>");
//         System.out.print("성명: ");
//         scanner.nextLine();
//         System.out.println();

//         System.out.print("비밀번호: ");
//         scanner.nextLine();
//         System.out.println();

//         home(scanner);
//     }

//     private static void home(Scanner scanner) {
//         while (true) {
//             try {
//                 System.out.println("====================[홈페이지]====================");
//                 System.out.println("= 1. 도서 검색   ");
//                 System.out.println("= 2. 회원 정보 조회 ");
//                 System.out.println("= 3. 주문 이력 확인 ");
//                 System.out.println("= 4. 장바구니 보기  ");
//                 System.out.println("= 99. 종료     ");
//                 System.out.println("====================");
//                 System.out.print("메뉴 선택: ");

//                 int num = scanner.nextInt();
//                 scanner.nextLine(); // 버퍼 비우기

//                 switch (num) {
//                     case 1:
//                         search(scanner);
//                         break;
//                     case 2:
//                         user(scanner);
//                         break;
//                     case 3:
//                         System.out.println("주문 이력을 확인합니다.");
//                         break;
//                     case 4:
//                         cart(scanner);
//                         break;
//                     case 99:
//                         exit(scanner);
//                         break;
//                     default:
//                         System.out.println("잘못된 입력입니다. 초기 화면으로 돌아갑니다.");
//                 }
//             } catch (Exception e) {
//                 System.out.println("오류가 발생했습니다: " + e.getMessage());
//                 scanner.nextLine(); // 버퍼 비우기
//             }
//         }
//     }

//     private static void search(Scanner scanner) {
//         while (true) {
//             try {
//                 System.out.println("====================[도서 검색]====================");
//                 System.out.println("|-1 베스트셀러 검색");
//                 System.out.println("|-2 신간 검색");
//                 System.out.println("|-3 전체 검색");
//                 System.out.println("|-0 홈페이지로 돌아가기");
//                 System.out.println("|-99 종료");
//                 System.out.println("====================");

                

//                 System.out.print("검색 유형 선택: ");
//                 int num = scanner.nextInt();
//                 scanner.nextLine(); // 버퍼 비우기

//                 System.out.print("검색어를 입력해주세요: ");
//                 String searchContents = scanner.nextLine();
//                 System.out.println();


//                 switch (num) {
//                     case 1:
//                         searchResult(scanner, "베스트셀러", searchContents);
//                         break;
//                     case 2:
//                         searchResult(scanner, "신간", searchContents);
//                         break;
//                     case 3:
//                         searchResult(scanner, "전체", searchContents);
//                         break;
//                     case 0:
//                         return; // 홈페이지로 복귀
//                     case 99:
//                         exit(scanner);
//                         break;
//                     default:
//                         System.out.println("잘못된 입력입니다.");
//                 }
//             } catch (Exception e) {
//                 System.out.println("오류가 발생했습니다: " + e.getMessage());
//                 scanner.nextLine(); // 버퍼 비우기
//             }
//         }
//     }

//     private static void searchResult(Scanner scanner, String type, String searchContents) {
//         System.out.println("====================[검색결과페이지]====================");
//         System.out.printf("[%s 검색 결과]%n", type);
        
//         System.out.println("= 검색어: " + searchContents);
//         System.out.println("= 검색 유형: " + type);
//         System.out.println("= 정렬 유형: 기본(문자 오름차순 정렬)");
//         System.out.println("====================");
//         System.out.println("\n\n");

//         if (type.equals("베스트셀러")) {
//             System.out.println("ㄴ----");
//             System.out.println("- 책 제목: " + searchContents + " 베스트셀러"); ;
//             System.out.println("- 저자: 홍길동");
//             System.out.println("- 가격: 15,000원");  
//             System.out.println("\n");

//             System.out.println("ㄴ----");
//             System.out.println("- 책 제목: " + searchContents + " 베스트셀러"); ;
//             System.out.println("- 저자: 홍길동");
//             System.out.println("- 가격: 15,000원");  
//             System.out.println("\n");

//             System.out.println("ㄴ----");
//             System.out.println("- 책 제목: " + searchContents + " 베스트셀러"); ;
//             System.out.println("- 저자: 홍길동");
//             System.out.println("- 가격: 15,000원"); 

//         } else if (type.equals("신간")) {
//             System.out.println("ㄴ----");
//             System.out.println("- 책 제목: 사랑하는 법" + searchContents + " 신간 ");
//             System.out.println("- 저자: 이순신");
//             System.out.println("- 가격: 20,000원");
//             System.out.println("\n");

//             System.out.println("ㄴ----");

//             System.out.println("- 책 제목: 사랑하는 법" + searchContents + " 신간 ");
//             System.out.println("- 저자: 이순신");
//             System.out.println("- 가격: 20,000원");
//             System.out.println("\n");

//             System.out.println("ㄴ----");

//             System.out.println("- 책 제목: 사랑하는 법" + searchContents + " 신간 ");
//             System.out.println("- 저자: 이순신");
//             System.out.println("- 가격: 20,000원");            

//         } else if (type.equals("전체")) {
//             System.out.println("ㄴ----");
//             System.out.println("- 책 제목: 2030년 우리의 미래" + searchContents + " 전체 ");
//             System.out.println("- 저자: 김유신");
//             System.out.println("- 가격: 25,000원");
//             System.out.println("\n");

//             System.out.println("ㄴ----");

//             System.out.println("- 책 제목: 2030년 우리의 미래" + searchContents + " 전체 ");
//             System.out.println("- 저자: 김유신");
//             System.out.println("- 가격: 25,000원");

//             System.out.println("\n");

//             System.out.println("ㄴ----");
//             System.out.println("- 책 제목: 2030년 우리의 미래" + searchContents + " 전체 ");
//             System.out.println("- 저자: 김유신");
//             System.out.println("- 가격: 25,000원");

            
//         } else {
//             System.out.println("잘못된 검색어입니다.");
//             return;
//         }
        

//         System.out.print("1. 상세보기 | 0. 재검색 : ===>>  "); // 이 부분은 수정 필요: 검색어를 입력받아야 함 그리고 정렬하기도 없고! 0, 99가 없다 
//         int num = scanner.nextInt();
//         scanner.nextLine(); // 버퍼 비우기

//         if (num == 1) detail(scanner);
//     }

//     private static void detail(Scanner scanner) {
//         try {
//             System.out.println("================[도서 상세 정보]================");
//             System.out.println("- 제목: 자바 프로그래밍 예제");
//             System.out.println("- 저자: 홍길동");
//             System.out.println("- 가격: 15,000원");

//             System.out.print("1. 장바구니 담기 | 2. 바로 구매 | 0. 뒤로가기 : ");
//             int num = scanner.nextInt();
//             scanner.nextLine(); // 버퍼 비우기

//             switch (num) {
//                 case 1:
//                     addToCart(scanner);
//                     break;
//                 case 2:
//                     purchaseBook(scanner);
//                     break;
//                 case 0:
//                     return; // 뒤로가기
//             }
//         } catch (Exception e) {
//             System.out.println("오류가 발생했습니다: " + e.getMessage());
//             scanner.nextLine(); // 버퍼 비우기
//         }
//     }

//     private static void addToCart(Scanner scanner) {
//         System.out.print("수량 입력: ");
//         int quantity = scanner.nextInt();
//         scanner.nextLine(); // 버퍼 비우기

//         // 랜덤 메시지 출력
//         String message = getRandomPurchaseMessage();
//         System.out.printf("%d권이 장바구니에 담겼습니다.%n", quantity);
//         System.out.printf("[독서 통계] %s%n", message);
//     }

//     private static void purchaseBook(Scanner scanner) {
//         System.out.print("수량 입력: ");
//         int quantity = scanner.nextInt();
//         scanner.nextLine(); // 버퍼 비우기

//         // 랜덤 메시지 출력
//         String message = getRandomPurchaseMessage();
//         System.out.printf("%d권을 구매하셨습니다.%n", quantity);
//         System.out.printf("[독서 통계] %s%n", message);
//     }

//     private static void cart(Scanner scanner) {
//         while (true) {
//             try {
//                 // 랜덤 출판 트렌드 메시지 출력
//                 String trendMessage = getRandomTrendMessage();
//                 System.out.printf("[출판 트렌드] %s%n", trendMessage);

//                 System.out.print("1. 전체 구매 | 0. 뒤로가기 : ");
//                 int num = scanner.nextInt();
//                 scanner.nextLine(); // 버퍼 비우기

//                 if (num == 1) purchaseBook(scanner);
//                 else if (num == 0) return; // 뒤로가기
//             } catch (Exception e) {
//                 System.out.println("오류가 발생했습니다: " + e.getMessage());
//                 scanner.nextLine(); // 버퍼 비우기
//             }
//         }
//     }

//     private static void user(Scanner scanner) {
//         while (true) {
//             try {
//                 System.out.print("1. 회원 정보 수정 | 0. 뒤로가기 : ");
//                 int num = scanner.nextInt();
//                 if (num == 0) return; // 뒤로가기
//             } catch (Exception e) {
//                 scanner.nextLine(); // 버퍼 비우기
//             }
//         }
//     }

//     private static void exit(Scanner scanner) {
//         System.exit(0); // 프로그램 종료
//     }

//     private static String getRandomPurchaseMessage() {
//         return PURCHASE_MESSAGES[random.nextInt(PURCHASE_MESSAGES.length)];
//     }

//     private static String getRandomTrendMessage() {
//         return TREND_MESSAGES[random.nextInt(TREND_MESSAGES.length)];
//     }
// }



// 완성본(다만, 홈페이지랑 종료가 안되는 버전)


import java.util.*;
import java.util.stream.Collectors;

public class ViewMain {
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
            printMenu(new String[]{
                "도서 검색", 
                "회원 정보", 
                "주문 이력", 
                "장바구니",
                "종료"
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
            printHeader("도서 검색 시스템");
            printMenu(new String[]{
                "베스트셀러 검색",
                "신간 도서 검색", 
                "전체 검색",
                "홈으로 돌아가기",
                "시스템 종료"
            });

            System.out.print("\n>> 검색 유형: ");
            int choice = getValidNumber(scanner, 0, 99);
            
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
            scanner.nextLine(); // 버퍼 비우기
            
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
        
        printMenu(sortOptions.toArray(new String[0]));

        System.out.print("\n>> 정렬 선택: ");
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

    private static void handleBookSelection(List<Book> books, Scanner scanner) {
        System.out.print("\n>> 상세보기 할 도서 번호 (0: 뒤로가기): ");
        int choice = getValidNumber(scanner, 0, books.size());
        
        if(choice != 0) {
            Book selected = books.get(choice-1);
            showBookDetail(selected, scanner);
        }
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

        printMenu(new String[]{
            "장바구니 추가", 
            "바로구매", 
            "돌아가기"
        });
        
        handlePurchaseChoice(book, scanner);
    }

    private static void handlePurchaseChoice(Book book, Scanner scanner) {
        System.out.print("\n>> 선택: ");
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
        System.out.print("\n>> 수량 입력: ");
        int quantity = getValidNumber(scanner, 1, 10);
        MockCartDB.addItem(book, quantity);
        System.out.printf("\n[완료] %s %d권 장바구니 추가 완료!\n", book.title, quantity);
        System.out.println("[독서 통계] " + getRandomMessage(PURCHASE_MESSAGES));
        pause(scanner);
    }
    private static void processPurchase(Book book, Scanner scanner) {
        System.out.print("\n>> 수량 입력: ");
        int quantity = getValidNumber(scanner, 1, 10);
        
        System.out.println("\n================ 결제 정보 ================");
        System.out.printf("도서명: %s\n", book.title);
        System.out.printf("수량: %d권\n", quantity);
        System.out.printf("결제금액: %,d원\n", book.getPrice() * quantity);
        System.out.println("-----------------------------------------");
        System.out.println("1. 신용카드 결제 | 2. 계좌이체 | 0. 취소");
        
        System.out.print("\n>> 결제 방법 선택: ");
        int paymentType = getValidNumber(scanner, 0, 2);
        if(paymentType != 0) {
            System.out.println("[완료] 결제가 완료되었습니다!");
            MockDB.removeBook(book.id);
            System.out.println("[독서 통계] " + getRandomMessage(PURCHASE_MESSAGES));
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
                System.out.printf("\n[도서] %s\n", item.book.title);
                System.out.printf("|- 수량: %d개\n", item.quantity);
                System.out.printf("|- 단가: %,d원\n", item.book.getPrice());
                System.out.printf("|- 소계: %,d원\n", item.getTotalPrice());
                System.out.println(SUB_BORDER);
            });

            // 랜덤 출판 트렌드 메시지 출력
            System.out.println("[출판 트렌드] " + getRandomMessage(TREND_MESSAGES));

            printMenu(new String[]{
                "전체 구매", 
                "장바구니 비우기",
                "뒤로가기"
            });
            
            handleCartAction(scanner);
        }
    }

    private static void handleCartAction(Scanner scanner) {
        System.out.print("\n>> 선택: ");
        int choice = getValidNumber(scanner, 0, 2);
        switch(choice) {
            case 1:
                processBulkPurchase(scanner);
                break;
            case 2:
                MockCartDB.clearCart();
                System.out.println("\n[완료] 장바구니를 비웠습니다");
                pause(scanner);
                break;
            case 0:
                return;
        }
    }

    // 일괄 구매 처리
    private static void processBulkPurchase(Scanner scanner) {
        List<CartItem> cart = MockCartDB.getCart();
        int total = cart.stream().mapToInt(CartItem::getTotalPrice).sum();
        
        System.out.println("\n================ 결제 정보 ================");
        System.out.printf("총 결제금액: %,d원\n", total);
        System.out.println("-----------------------------------------");
        System.out.println("1. 신용카드 결제 | 2. 계좌이체 | 0. 취소");
        
        System.out.print("\n>> 결제 방법 선택: ");
        int paymentType = getValidNumber(scanner, 0, 2);
        if(paymentType != 0) {
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
        System.out.println("회원 정보 관리 기능은 아직 준비 중입니다.");
        pause(scanner);
    }
    
    // 주문 이력 관리
    private static void orderFlow(Scanner scanner) {
        System.out.println("주문 이력 관리 기능은 아직 준비 중입니다.");
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
        for(int i=0; i<items.length; i++) {
            System.out.printf("%d. %s\n", i+1, items[i]);
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
                if(input >= min && input <= max || input == 99) {
                    return input;
                }
                System.out.printf("[경고] %d~%d 사이 숫자를 입력해주세요\n", min, max);
            } catch(InputMismatchException e) {
                System.out.println("[경고] 숫자만 입력 가능합니다");
                scanner.nextLine(); // 버퍼 비우기
            }
        }
    }
    private static void exit(Scanner scanner) {
        System.out.println("\n[종료] 프로그램을 종료합니다.");
        System.out.println("감사합니다!");
        System.exit(0);
    }

    // 랜덤 메시지 생성
    private static String getRandomMessage(String[] messages) {
        return messages[random.nextInt(messages.length)];
    }

    // 예외 처리 핸들러
    private static void errorHandler(Scanner scanner, Exception e) {
        System.out.println("\n[시스템 오류] " + e.getMessage());
        scanner.nextLine(); // 버퍼 비우기
    }
}
