package note;

import java.io.IOException;
import java.util.Scanner;

public class NoteApp {

    public static void main(String[] args) throws IOException {
        NoteManager noteManager = new NoteManager();
        Scanner scanner = new Scanner(System.in);

        // 메인 메뉴와 사용자 입력 처리
        while (true) {
            System.out.println("1: 메모 작성 | 2: 메모 조회 | 3: 메모 삭제 | 0: 종료");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("메모를 작성해주세요.");
                    String createMemo = scanner.nextLine();
                    noteManager.createNote(createMemo);
                    break;
                case 2:
                    System.out.println("메모 리스트를 출력합니다.");
                    noteManager.viewAllNotes();
                    break;
                case 3:
                    System.out.println("삭제할 메모를 입력해주세요.");
                    String deleteMemo = scanner.nextLine();
                    noteManager.deleteNoteByName(deleteMemo);
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("다시 입력해주세요.");
                    break;
            }
        }

    }
}
