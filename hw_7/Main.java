//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
import java.util.Scanner;
/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        Notebook model = new Notebook();
        NotebookView view = new ConsoleNotebookView();
        NotebookPresenter presenter = new NotebookPresenter(model, view);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Добавить заметку");
            System.out.println("2. Сохранить заметки");
            System.out.println("3. Выгрузить заметки");
            System.out.println("4. Показать заметки за день");
            System.out.println("5. Показать заметки за неделю");
            System.out.println("6. Выход");
            System.out.print("--> ");
            int select = scanner.nextInt();
            scanner.nextLine(); 
            switch (select) {
            case 1:
                presenter.addNote();
                break;
            case 2:
                presenter.saveNotes();    
                break;
            case 3:
                presenter.loadNotes();
                break;
            case 4:
                presenter.showNotesForDay();
                break;
            case 5:
                presenter.showNotesForWeek();
                break;
            case 6:
                System.out.println("Будем ждать Вас снова!");
                return;
            default:
            System.out.println("Вы ошиблись с выбором. Попробуйте сначала.");
            System.out.println();
            }
        }
    }
}
