package note;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private static final String FILE_DIRECTORY = "temp/";
    private static final String FILE_EXTENSION = ".txt";
    private List<String> fileList = new ArrayList<String>();

    public void saveNote(String note) throws IOException {
        /* 파일 저장 로직 */
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String fileName = now.format(formatter);
        // 현재 날짜 시간 이름으로 파일 저장
        FileWriter out = new FileWriter(FILE_DIRECTORY + fileName + FILE_EXTENSION);
        out.write(note);
        fileList.add(fileName);
        out.close();
    }

    public List<String> readAllNotes() {
        /* 파일 목록 조회 로직 */
        return fileList;
    }

    public void deleteNote(String fileName) {
        /* 파일 삭제 로직 */
    }
}
