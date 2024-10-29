package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Iterator;
/**
 * Класс для работы с генеалогическим древом
 */

public class F_Tree implements Serializable, Iterable<Person> {
    private static final long serialVersionUID = 1L;
    private List<Person> people;

    public F_Tree() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        this.people.add(person);
    }

    public List<Person> getChildren(Person parent) {
        return parent.getChildren();
    }

    // public List<Person> getParents(Person children) {
    //     return children.getParents();
    // }

    public Person findPersonByName(String name) {
        for (Person person : people) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public List<Person> getPeople() {
        return people;
        }
    
    @Override
    public Iterator<Person> iterator() {
        return people.iterator();
    }

    public void sortByName() {
        Collections.sort(people, (p1, p2) ->
        p1.getName().compareTo(p2.getName()));
    }
    public void sortByBirthYear() {
        Collections.sort(people, (p1, p2) ->
        Integer.compare(p1.getBirthYear(), p2.getBirthYear()));
    }
        
}