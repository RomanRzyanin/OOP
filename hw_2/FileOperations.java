import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import service.FileOperations;


// Интерфейс для операций с файлами
public interface FileOperations {
    void saveToFile(F_Tree familyTree, String fileName) throws IOException;
        F_Tree loadFromFile(String fileName) throws IOException,
            ClassNotFoundException;
    }

// Реализация интерфейса для операций с файлами
class FileOperationsImpl implements FileOperations {
    @Override
    public void saveToFile(F_Tree familyTree, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new
        FileOutputStream(fileName))) {
        oos.writeObject(familyTree);
        }
    }
    @Override
    public F_Tree loadFromFile(String fileName) throws IOException, ClassNotFoundException {
    try (ObjectInputStream ois = new ObjectInputStream(new
    FileInputStream(fileName))) {
    return (F_Tree) ois.readObject();
    }
    }
}

