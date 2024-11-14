package note;

import java.io.IOException;

public class NoteManager {
    private FileHandler fileHandler = new FileHandler();

    public void createNote(String content) throws IOException {
        /* 사용자 입력 받아 메모 저장 */
        fileHandler.saveNote(content);
    }

    public void viewAllNotes() { /* 모든 메모 출력 */ }

    public void deleteNoteByName(String name) { /* 특정 메모 삭제 */ }
}
