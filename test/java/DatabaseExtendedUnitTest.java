import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import p02_ExtendedDatabase.Database;
import p02_ExtendedDatabase.Person;

import javax.naming.OperationNotSupportedException;

public class DatabaseExtendedUnitTest {

    @Test
    public void whenTryToAddNullValue_thenExceptionIsThrown() throws OperationNotSupportedException {

        Person ivan = new Person(1, "Ivan");
        Person gosho = new Person(2, "Gosho");
        Person[] people = {ivan, gosho};

        Database database = new Database(people);

        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            database.add(null);
        });
    }

 
    @Test
    public void whenAddNonNullPerson_thenPersonIsAddedAtTheLastIndexAndCountIsIncrementedByOne() throws OperationNotSupportedException {

        Person ivan = new Person(1, "Ivan");
        Person gosho = new Person(2, "Gosho");
        Person[] people = {ivan, gosho};

        Database database = new Database(people);
        int initialPeopleCount = database.getElements().length; // 2

        Person peter = new Person(3, "Peter");
        database.add(peter);

        int newPeopleCount = database.getElements().length;
        Person lastPerson = database.getElements()[newPeopleCount - 1];

        Assertions.assertEquals(lastPerson, peter);
        Assertions.assertEquals(newPeopleCount, initialPeopleCount + 1);
    }


    @Test
    public void whenTryToRemoveFromEmptyDatabase_thenExceptionIsThrown() throws OperationNotSupportedException {

        Person ivan = new Person(1, "Ivan");
        Person gosho = new Person(2, "Gosho");
        Person[] people = {ivan, gosho};

        Database database = new Database(people);

        database.remove();
        database.remove();

        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            database.remove();
        });
    }


    @Test
    public void whenTryToRemoveFromNonEmptyDataBase_thenPeopleCountDecrementByOne() throws OperationNotSupportedException {

        Person ivan = new Person(1, "Ivan");
        Person gosho = new Person(2, "Gosho");
        Person[] people = {ivan, gosho};

        Database database = new Database(people);
        int initialPeopleCount = database.getElements().length;
        database.remove();

        int newPeopleCount = database.getElements().length;
        Assertions.assertEquals(newPeopleCount, initialPeopleCount - 1);
    }

}
