package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Iterator;
/**
 * Класс для работы с генеалогическим древом
 */

public class F_Tree<T> implements Serializable, Iterable<T> {
    private static final long serialVersionUID = 1L;
    private List<T> members;

    public F_Tree() {
        this.members = new ArrayList<>();
    }

    public void addMember(T member) {
        this.members.add(member);
    }

    public List<T> getMembers() {
        return members;
    }

    // public List<Person> getParents(Person children) {
    //     return children.getParents();
    // }

    // public Person findPersonByName(String name) {
    //     for (Person person : people) {
    //         if (person.getName().equals(name)) {
    //             return person;
    //         }
    //     }
    //     return null;
    // }

    // public List<Person> getPeople() {
    //     return people;
    //     }
    
    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }

    public void sortByName() {
        Collections.sort(members, (m1, m2) ->
        m1.toString().compareTo(m2.toString()));
    }
    public void sortByBirthYear() {
        if (members.get(0) instanceof Person) {
            Collections.sort(members, (m1, m2) ->
            Integer.compare(((Person) m1).getBirthYear(), ((Person) m2).getBirthYear()));
        }
        
    }
}