import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SearchTest {

    List<Person> test;
    Person p1 = new Person("BM", LocalDate.of(1992, Month.OCTOBER, 20), Person.Sex.MALE, "BM@gmail.com");
    Person p2 = new Person("J.Seph", LocalDate.of(1990, Month.JUNE, 21), Person.Sex.MALE, "j.seph@gmail.com");
    Person p3 = new Person("Somin", LocalDate.of(1996, Month.AUGUST, 22), Person.Sex.FEMALE, "somin@gmail.com");
    Person p4 = new Person("Jiwoo", LocalDate.of(1996, Month.OCTOBER, 4), Person.Sex.FEMALE, "jiwoo@gmail.com");

    @Before
    public void setUp() {
        test = new ArrayList<>();
        test.add(p1);
        test.add(p2);
        test.add(p3);
        test.add(p4);
    }

    @Test
    public void printPersonOlderThanTest() {
        Search.printPersonOlderThan(test, 28);
        String expected = "Person: J.Seph";
    }

    @Test
    public void printPersonWithinRangeTest() {
        Search.printPersonWithinRange(test, 26, 27);
        String expected = "Person: BM";
    }

    @Test
    public void printPersonsTest() {
        Person person = new Person();
        Search.printPersons(test, person);
    }

    @Test
    public void anonymousClassTest() {
        Person person = new Person() {
            @Override
            public boolean test(Person p) {
                return p.getAge() <= 25;
            }
        };
        Search.printPersons(test, person);
    }

    @Test
    public void lambdaTest() {
        CheckPerson person = p -> p.getAge() < 20;
        Search.printPersons(test, person);
    }

}