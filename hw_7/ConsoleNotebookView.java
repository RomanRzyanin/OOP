import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
/**
 * ConsoleNotebookView
 */
public class ConsoleNotebookView implements NotebookView {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void showNotes(List<Note> notes) {
        if (notes.isEmpty()) {
            System.out.println("Заметки не найдены");
        } else {
            for (Note note : notes) {
            System.out.println(note);
        }
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public LocalDateTime getDateTimeInput() {
        System.out.println("Введите дату и время в формате:(yyyy-MM-dd'T'HH:mm):");
        String input = scanner.nextLine();
        DateTimeFormatter formatter =
        DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        return LocalDateTime.parse(input, formatter);
    }
    @Override
    public String getDescriptionInput() {
        System.out.println("Введите описание заметки:");
        return scanner.nextLine();
    }
    @Override
    public String getFileNameInput() {
        System.out.println("Введите название файла:");
        return scanner.nextLine();
    }
}
