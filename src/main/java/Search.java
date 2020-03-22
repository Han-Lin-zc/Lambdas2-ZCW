import java.util.List;

public class Search {

    public static void printPersonOlderThan(List<Person> people, int age) {
        for (Person p : people) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    public static void printPersonWithinRange(List<Person> people, int low, int high) {
        for (Person p: people) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    public static void printPersons(List<Person> people, CheckPerson tester) {
        for(Person p : people) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }
}
