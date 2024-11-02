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
        F_Tree<Person> familyTree = new F_Tree<>();
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
        familyTree.addMember(anton);
        familyTree.addMember(mary);
        familyTree.addMember(anna);
        familyTree.addMember(igor);
        familyTree.addMember(nastya);
        familyTree.addMember(katya);
        familyTree.addMember(roman);

        // Сортируем по имени
        System.out.println("Сортировка по имени:");
            familyTree.sortByName();
            for (Person person : familyTree) {
                System.out.println(person.getName() + " - " +
                person.getBirthYear());

        // Создаем объект для работы с файлами
    FileOperations<Person> fileOps = new FileOperationsImpl<>();

    // Сохраняем генеалогическое древо в файл
    try {
        fileOps.saveToFile(familyTree, "familyTree.dat");
        System.out.println("Гинеалогическое дерево загружено в файл.");
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Загружаем генеалогическое древо из файла
    F_Tree<Person> loadedFamilyTree = null;
    try {
        loadedFamilyTree = fileOps.loadFromFile("familyTree.dat");
        System.out.println("Гинеалогическое дерево загружено из файла.");
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }

    //Проверяем, что древо загрузилось правильно
    if (loadedFamilyTree != null) {
        System.out.println("\nДерево загружено:");
        for (Person person : loadedFamilyTree) {
            System.out.println(person.getName() + ", рожден в " + person.getBirthYear());
        }
    }
    }
    }
}

