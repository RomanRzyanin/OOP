package service;


import java.io.IOException;
import model.F_Tree;


// Интерфейс для операций с файлами
public interface FileOperations<T> {
    void saveToFile(F_Tree<T> familyTree, String fileName) throws IOException;
        F_Tree<T> loadFromFile(String fileName) throws IOException,
            ClassNotFoundException;
    }


