//import java.util.ArrayList;
import java.util.List;
/**
 * Задание 1.
Реализовать, с учетом ооп подхода, приложение. Для проведения исследований с
генеалогическим древом.
Идея: описать некоторое количество компонент, например - модель человека и
дерева. Под “проведением исследования” можно понимать например получение
всех детей выбранного человека.
 */
public class t_Main {
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
        // Пример получения всех детей ....
        List<Person> antonChildren = familyTree.getChildren(anton);
        for (Person child : antonChildren) {
            System.out.println(child.getFather() + ", ребенок: " + child.getName());
        }
        List<Person> maryChildren = familyTree.getChildren(mary);
        for (Person child : maryChildren) {
            System.out.println(child.getMother() + ", ребенок: " + child.getName());
        }
        List<Person> igorChildren = familyTree.getChildren(igor);
        for (Person child : igorChildren) {
            System.out.println(child.getFather() + ", ребенок: " + child.getName());
        }
        List<Person> katyaChildren = familyTree.getChildren(katya);
        for (Person child : katyaChildren) {
            System.out.println(child.getMother() + ", ребенок: " + child.getName());
        }
        System.out.println("-----------------------------------");
        System.out.println(anna);  
        System.out.println(anton); 
        System.out.println(mary); 
        System.out.println(katya); 
        System.out.println(igor); 
        System.out.println(nastya); 
        System.out.println("-----------------------------------");
        System.out.println(anna + ", мать: " + anna.getMother()); 
        System.out.println(anna + ", отец: " + anna.getFather()); 
        }
    }

