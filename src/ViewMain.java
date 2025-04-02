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




import java.util.Scanner;

public class ViewMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===================온라인 서점 시스템============");
        System.out.println(">> 로그인 >>");
        System.out.print("성명: ");
        String name = scanner.nextLine();
        System.out.println();

        System.out.print("비밀번호: ");
        String password = scanner.nextLine();
        System.out.println();

        home(scanner);
    }

    private static void home(Scanner scanner) {
        while (true) {
            try {
                System.out.println("====================[홈페이지]====================");
                System.out.println("= 1. 도서 검색   ");
                System.out.println("= 2. 회원 정보 조회 ");
                System.out.println("= 3. 주문 이력 확인 ");
                System.out.println("= 4. 장바구니 보기  ");
                System.out.println("= 99. 종료     ");
                System.out.println("====================");
                System.out.println();

                System.out.print("메뉴 선택: ");
                System.out.println();
                
                int num = scanner.nextInt();
                scanner.nextLine(); // 버퍼 비우기

                switch (num) {
                    case 1:
                        search(scanner); 
                        break;
                    case 2:
                        user(scanner); 
                        break;
                    case 3:
                        System.out.println("주문 리스트");
                        System.out.println("주문 리스트");
                        System.out.println("주문 리스트");
                        System.out.println("주문 리스트");
                        break;
                    case 4:
                        cart(scanner); 
                        break;
                    case 99:
                        exit(scanner);
                        break;
                    default:
                        System.out.println("잘못된 입력입니다. 초기 화면으로 돌아갑니다.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("오류가 발생했습니다: " + e.getMessage());
                scanner.nextLine(); // 입력 버퍼 비우기
            }
        }
    }

    private static void exit(Scanner scanner) {
        System.out.println("시스템 종료? (y/n)");
        String str = scanner.nextLine();

        if (str.equalsIgnoreCase("y")) {
            System.out.println("시스템을 종료합니다. 감사합니다.");
            System.exit(0);
        } else {
            System.out.println("\n\n\n");
            System.out.println("초기 화면으로 돌아갑니다.");
        }
    }

    private static void user(Scanner scanner) {
        while (true) {
            try {
                System.out.println("> 유저 정보 조회");
                System.out.println("> 유저 정보 리스트");
                System.out.println("> 유저 정보 리스트");
                System.out.println("> 유저 정보 리스트");
                System.out.println("> 유저 정보 리스트");
                System.out.println("원하시는 번호를 선택하세요 : ");
                
                System.out.println("\n");
                System.out.println("1 회원 정보 수정  2 상위 메뉴 이동 0 홈페이지 돌아가기 99 종료");
                System.out.println("* 숫자 8을 입력하면 모든 화면에서 장바구니 보기 화면으로 넘어갑니다");
                System.out.println("\n\n\n");
                
                System.out.print("선택: ");
                int num = scanner.nextInt();
                scanner.nextLine(); // 버퍼 비우기

                switch (num) {
                    case 0:
                        return; // 홈페이지로 복귀
                    case 1:
                        System.out.println("회원 정보 수정");
                        break;
                    case 2:
                        return; // 상위 메뉴로 이동
                    case 8:
                        cart(scanner);
                        return;
                    case 99:
                        exit(scanner);
                        break;
                    default:
                        System.out.println("잘못된 입력입니다.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("오류가 발생했습니다: " + e.getMessage());
                scanner.nextLine(); // 버퍼 비우기
            }
        }
    }

    private static void search(Scanner scanner) {
        while (true) {
            try {
                System.out.println("\n\n");
                System.out.println("====================[도서 검색]====================");
                System.out.println("[검색 유형[v]]");
                
                System.out.println("|-1 베스트셀러 검색");
                System.out.println("|-2 신간 검색");
                System.out.println("|-3 전체 검색");

                System.out.println();
                System.out.println("|-0 홈페이지로 돌아가기");
                System.out.println("|-99 종료");
                System.out.println();
                System.out.println("* 숫자 8을 입력하면 모든 화면에서 장바구니 보기 화면으로 넘어갑니다");
                System.out.println("====================");

                System.out.println("> 서적 검색 ");
                System.out.print("검색어를 입력해주세요: ");
                String searchContents = scanner.nextLine();
                System.out.println();

                System.out.print("검색유형을 선택해주세요: ");

                int num = scanner.nextInt();
                scanner.nextLine(); // 버퍼 비우기
                
                switch (num) {
                    case 0:
                        return; // 홈페이지로 복귀
                    case 1: // 베스트 셀러
                        searchResult("bstseller", searchContents, scanner);
                        break;
                    case 2: // 신간
                        searchResult("newseller", searchContents, scanner);
                        break;
                    case 3: // 전체
                        searchResult("all", searchContents, scanner);
                        break;
                    case 8:
                        cart(scanner);
                        return;
                    case 99:
                        exit(scanner);
                        break;
                    default:
                        System.out.println("잘못된 입력입니다.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("오류가 발생했습니다: " + e.getMessage());
                scanner.nextLine(); // 버퍼 비우기
            }
        }
    }

    private static void searchResult(String searchType, String searchContents, Scanner scanner) {
        if (searchType.equals("bstseller")) {
            System.out.println("베스트셀러 검색 결과입니다.");
        } else if (searchType.equals("newseller")) {
            System.out.println("신간 검색 결과입니다.");
        } else if (searchType.equals("all")) {
            System.out.println("전체 검색 결과입니다.");
        } else {
            System.out.println("잘못된 검색어입니다.");
            return;
        }

        // 검색 결과 표시
        System.out.println("====================[검색결과페이지]====================");
        System.out.println("= 검색어: " + searchContents);
        System.out.println("= 검색 유형: " + searchType);
        System.out.println("= 정렬 유형: 기본(문자 오름차순 정렬)");
        System.out.println("====================");
        System.out.println("\n\n");

        // 검색 결과 예시 출력 -> 반복 구문이 있어야겠죠?
        // 📖📓📚📑🔍🖋✏🖍📆📝🗓📌📌⌛⏰ 💰💵💶💸 💨💫💬 🗝📟📞🖥💻🛒
        System.out.println("📗 [서적 리스트1] ");
        System.out.println("📓 {1번째 책 제목} ");
        System.out.println("📝 {1번째 책 저자}");
        System.out.println("📌 {북타입: Ebook}");
        System.out.println("💸 {판매가: 18000원} ");
        System.out.println("====================");

        System.out.println("[액션을 선택해주세요[v]]");
        System.out.println("|-1 📚원하는 도서 선택 ");
        System.out.println("|-2 🔍도서 재검색");
        System.out.println("|-3 재정렬💨");
        System.out.println("|-0 🏠 홈페이지로 돌아가기");
        System.out.println("|-8 🛒 장바구니");
        System.out.println("|-99 ⏹ 종료");
        System.out.println("====================");

        System.out.print("액션 선택: ");
        int num = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기
        
        switch (num) {
            case 0:
                return; // 홈페이지로 복귀
            case 1: // 원하는 도서 선택
                detail(scanner);
                break;
            case 2: // 재검색 - 스택 오버플로우 방지를 위해 return
                search(scanner);
                break;
            case 3: // 재정렬
                sort(scanner);
                break;
            case 8:
                cart(scanner);
                break;
            case 99:
                exit(scanner);
                break; 
            default:
                System.out.println("잘못된 입력입니다.");
                break;
        }
    }

    private static void detail(Scanner scanner) {
        try {
            System.out.println("> 책 상세 정보");
            System.out.println("=====================");
            System.out.println("- 서적명: 자바 프로그래밍");
            System.out.println("- 저자: 홍길동");
            System.out.println("- 출판사: 코딩출판사");
            System.out.println("- 출판일: 2023-01-01");
            System.out.println("=====================");
            System.out.println();

            System.out.println("> 중고 서적 가격표");
            System.out.println("=====================");
            System.out.println("- 최상 (5) : 25000원");
            System.out.println("- 상 (3) : 20000원");
            System.out.println("- 중 (7) : 15000원");
            System.out.println("- 하 (2) : 10000원");
            System.out.println("=====================");

            System.out.println("원하시는 번호를 선택하세요 : ");
            System.out.println("1 장바구니 담기  2 해당 서적 바로 구매  0 홈페이지  99 종료");
            
            System.out.print("선택: ");
            int num = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            switch (num) {
                case 0:
                    return; // 홈페이지로 복귀
                case 1:
                    System.out.println("장바구니에 담기");
                    System.out.print("서적 상태 선택(1:최상 2:상 3:중): ");
                    int state = scanner.nextInt();
                    scanner.nextLine(); // 버퍼 비우기
                    
                    System.out.print("수량 입력: ");
                    int amounts = scanner.nextInt();
                    scanner.nextLine(); // 버퍼 비우기
                    
                    System.out.println(amounts + "권이 장바구니에 담겼습니다.");
                    cart(scanner);
                    break;
                case 2:
                    System.out.print("서적 상태 선택(1:최상 2:상 3:중): ");
                    int state1 = scanner.nextInt();
                    scanner.nextLine(); // 버퍼 비우기
                    
                    System.out.print("수량 입력: ");
                    int amounts1 = scanner.nextInt();
                    scanner.nextLine(); // 버퍼 비우기
                    
                    System.out.println(amounts1 + "권을 바로 구매합니다.");
                    order(scanner);
                    break;
                case 8:
                    cart(scanner);
                    return;
                case 99:
                    exit(scanner);
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다: " + e.getMessage());
            scanner.nextLine(); // 버퍼 비우기
        }
    }

    private static void order(Scanner scanner) {
        try {
            System.out.println("> 주문 페이지");
            System.out.println("=====================");
            System.out.println("- 주문 상품: 자바 프로그래밍");
            System.out.println("- 상태: 최상");
            System.out.println("- 수량: 1");
            System.out.println("- 가격: 25000원");
            System.out.println("- 배송비: 3000원");
            System.out.println("- 총액: 28000원");
            System.out.println("=====================");
            System.out.println("1 주문 확정 0 홈페이지 이동 99 종료");
            
            System.out.print("선택: ");
            int num = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            switch (num) {
                case 0:
                    return; // 홈페이지로 복귀
                case 1:
                    System.out.println("주문을 진행합니다...");
                    System.out.println("주문이 완료되었습니다!");
                    return; // 주문 완료 후 홈페이지로 복귀
                case 8:
                    cart(scanner);
                    return;
                case 99:
                    exit(scanner);
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다: " + e.getMessage());
            scanner.nextLine(); // 버퍼 비우기
        }
    }

    private static void sort(Scanner scanner) {
        System.out.println("정렬을 선택해주세요 : ");
        System.out.println("1 베스트셀러 순위  2 리뷰 순위 3 구매 순위 4 가격순 0 홈페이지 99 종료");
        
        System.out.print("선택: ");
        int num = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기
        
        switch (num) {
            case 0:
                return; // 홈으로 돌아가기
            case 1:
                System.out.println("베스트셀러 순위로 정렬합니다.");
                break;
            case 2:
                System.out.println("리뷰 순위로 정렬합니다.");
                break;
            case 3:
                System.out.println("구매 순위로 정렬합니다.");
                break;
            case 4:
                System.out.println("가격순으로 정렬합니다.");
                break;
            case 8:
                cart(scanner);
                break;
            case 99:
                exit(scanner);
                break;
            default:
                System.out.println("잘못된 입력입니다.");
                break;
        }
    }

    private static void cart(Scanner scanner) {
        System.out.println("> 장바구니 페이지");
        System.out.println("=====================");
        System.out.println("1. 자바 프로그래밍 (최상) - 1권 - 25000원");
        System.out.println("2. 스프링 부트 가이드 (상) - 2권 - 40000원");
        System.out.println("=====================");
        System.out.println("총액: 65000원");
        System.out.println("1. 전체 구매 2. 선택 구매 3. 장바구니 비우기 0.홈페이지 99.종료");

        System.out.print("선택: ");
        int num = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기
        
        switch (num) {
            case 0:
                return; // 홈페이지로 복귀
            case 1:
                System.out.println("전체 상품을 구매합니다.");
                order(scanner);
                break;
            case 2:
                System.out.println("구매할 상품 번호를 입력하세요.");
                System.out.print("상품 번호: ");
                int itemNum = scanner.nextInt();
                scanner.nextLine(); // 버퍼 비우기
                System.out.println(itemNum + "번 상품을 구매합니다.");
                order(scanner);
                break;
            case 3:
                System.out.println("장바구니를 비웠습니다.");
                return;
            case 99:
                exit(scanner);
                break;
            default:
                System.out.println("잘못된 입력입니다.");
                break;
        }
    }
}
