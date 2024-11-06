package service;

import model.F_Tree;
import java.io.*;

public class FileOperationsImpl<T> implements FileOperations<T> {
@Override
public void saveToFile(F_Tree<T> familyTree, String fileName) throws IOException {
    try (ObjectOutputStream oos = new ObjectOutputStream(new
    FileOutputStream(fileName))) {
    oos.writeObject(familyTree);
}
}
@Override
public F_Tree<T> loadFromFile(String fileName) throws IOException, ClassNotFoundException {
    try (ObjectInputStream ois = new ObjectInputStream(new
        FileInputStream(fileName))) {
    return (F_Tree<T>) ois.readObject();
}
}
}