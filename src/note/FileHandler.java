package note;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FileHandler {

    public static final String FILE_DIRECTORY = "temp/";
    public static final String FILE_EXTENSION = ".txt";

    public void saveNote(String note) throws IOException {
        /* 파일 저장 로직 */
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        // 현재 날짜 시간 이름으로 파일 저장
        FileWriter out = new FileWriter(FILE_DIRECTORY + now.format(formatter) + FILE_EXTENSION);
        out.write(note);
        out.close();
    }

    public List<String> readAllNotes() {
        /* 파일 목록 조회 로직 */
        return null;
    }

    public void deleteNote(String fileName) {
        /* 파일 삭제 로직 */
    }
}
