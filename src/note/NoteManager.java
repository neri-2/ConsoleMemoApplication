package note;

import java.io.IOException;
import java.util.List;

public class NoteManager {
    private FileHandler fileHandler = new FileHandler();

    public void createNote(String content) throws IOException {
        /* 사용자 입력 받아 메모 저장 */
        fileHandler.saveNote(content);
    }

    public void viewAllNotes() {
        /* 모든 메모 출력 -> 파일 이름을 출력할지 내용을 출력할지 */
        List<String> notes = fileHandler.readAllNotes();
        for (String note : notes) {
            System.out.println(note);
        }
    }

    public void deleteNoteByName(String name) {
        /* 특정 메모 삭제 */
        fileHandler.deleteNote(name);
    }
}
