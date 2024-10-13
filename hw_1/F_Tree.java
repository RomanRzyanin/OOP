import java.util.ArrayList;
import java.util.List;
/**
 * Класс для работы с генеалогическим древом
 */

class F_Tree {
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
}