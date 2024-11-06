package service;

import model.F_Tree;
import java.io.IOException;

public interface FileOperations<T> {
    void saveToFile(F_Tree<T> familyTree, String fileName)
throws IOException;
    F_Tree<T> loadFromFile(String fileName) throws IOException,
    ClassNotFoundException;
}