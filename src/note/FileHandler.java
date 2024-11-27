package note;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

public class FileHandler {

    private static final String FILE_DIRECTORY = "temp/";
    private static final String FILE_EXTENSION = ".txt";

    public void saveNote(String note) throws IOException {
        /* 파일 저장 로직 */
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String fileName = now.format(formatter);

        Path path = Path.of(FILE_DIRECTORY + fileName + FILE_EXTENSION);
        // 현재 날짜 시간 이름으로 파일 저장
        Files.writeString(path, note);
    }

    public List<Path> readAllNotes() {
        /* 파일 목록 조회 로직 */
        Path path = Path.of(FILE_DIRECTORY);

        try (Stream<Path> pathStream = Files.list(path)) {
            return pathStream.toList();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAllNotes() {
        Path path = Path.of(FILE_DIRECTORY);

        try (Stream<Path> files = Files.list(path)) {
            List<Path> lists = files.toList();
            for (Path list : lists) {
                Files.delete(list);
            }
            System.out.println("모든 메모가 삭제되었습니다");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteNote(String fileName) {
        /* 파일 삭제 로직 */
        Path path = Path.of(FILE_DIRECTORY + fileName + FILE_EXTENSION);

        try {
            Files.delete(path);
            System.out.println(fileName + " 메모가 삭제되었습니다");
        } catch (NoSuchFileException e) {
            System.out.println("해당하는 이름의 메모가 존재하지 않습니다.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
