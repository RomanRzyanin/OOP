package main;

import java.io.IOException;
import model.F_Tree;
import model.Person;
import service.FileOperations;
import service.FileOperationsImpl;
/**
 * Задание 1.
Продолжаем работать с проектом с семейным деревом. Реализовать интерфейс
Iterable для дерева. Создать методы сортировки списка людей перед выводом,
например по имени или по дате рождения (не менее 2). Создать пакетную
структуру для проекта.
 */
public class main {
    public static void main(String[] args) {
        F_Tree familyTree = new F_Tree();
        // Add people
        Person anton = new Person("Антон", 1982);
        Person mary = new Person("Мария", 1983);
        Person anna = new Person("Анна", 2005);
        Person igor = new Person("Игорь", 1987);
        Person katya = new Person("Катерина", 1990);
        Person nastya = new Person("Анастасия", 2011);
        Person roman = new Person("Роман", 2011);
        // Set 
        anna.setMother(mary);
        anna.setFather(anton);
        anton.addChild(anna);
        mary.addChild(anna);
        nastya.setFather(igor);
        nastya.setMother(katya);
        igor.addChild(nastya);
        katya.addChild(nastya);
        roman.setFather(igor);
        roman.setMother(katya);
        igor.addChild(roman);
        katya.addChild(roman);

        // Add people in tree
        familyTree.addPerson(anton);
        familyTree.addPerson(mary);
        familyTree.addPerson(anna);
        familyTree.addPerson(igor);
        familyTree.addPerson(nastya);
        familyTree.addPerson(katya);
        familyTree.addPerson(roman);

        // Создаем объект для работы с файлами
    FileOperations fileOps = new FileOperationsImpl();

    // Сохраняем генеалогическое древо в файл
    try {
        fileOps.saveToFile(familyTree, "familyTree.dat");
        System.out.println("Family tree saved to file.");
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Загружаем генеалогическое древо из файла
    F_Tree loadedFamilyTree = null;
    try {
        loadedFamilyTree =
        fileOps.loadFromFile("familyTree.dat");
        System.out.println("Family tree loaded from file.");
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }

    // Проверяем, что древо загрузилось правильно
    if (loadedFamilyTree != null) {
        for (Person person : loadedFamilyTree.getPeople()) {
            System.out.println("Loaded person: " +
            person.getName() + ", born in " + person.getBirthYear());
    }
    }
}
}
