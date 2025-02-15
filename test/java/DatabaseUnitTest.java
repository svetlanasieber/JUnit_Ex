import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;

public class DatabaseUnitTest {

    @Test
    public void whenCreateDatabaseWithZeroElements_thenExceptionIsThrown() {

        Integer[] elements = new Integer[0];

        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            Database database = new Database(elements);
        });
    }

    @Test
    public void whenCreatDatabaseWithMoreThanSixteenElements_thenExceptionIsThrown() {


        Integer[] elements = new Integer[17];

        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            Database database = new Database(elements);
        });
    }

    @Test
    public void whenCreateDatabaseWithAllowedNumberOfElements_thenDatabaseShouldBeSuccessfullyCreated() throws OperationNotSupportedException {

        Integer[] elements = new Integer[]{7, 18, 9};
        Database database = new Database(elements);

        Assertions.assertEquals(database.getElements()[0], elements[0]);
        Assertions.assertEquals(database.getElements()[1], elements[1]);
        Assertions.assertEquals(database.getElements()[2], elements[2]);
        Assertions.assertEquals(database.getElements().length, elements.length);
    }

    @Test
    public void whenAddNullElementToDatabase_thenExceptionIsThrown() throws OperationNotSupportedException {

        Integer element = null;

        Integer[] elements = new Integer[]{7, 18, 9};
        Database database = new Database(elements);

        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            database.add(element);
        });
    }

    @Test
    public void whenAddNumberElementToDatabase_thenElementSuccessfullyAddedAndCountIncrementedByOne() throws OperationNotSupportedException {

        Integer number = 5;

        Integer[] elements = new Integer[]{7, 18, 9};
        Database database = new Database(elements);
        int oldElementsCount = database.getElements().length;

        database.add(5);

        Integer lastElement = database.getElements()[database.getElements().length - 1];
        Assertions.assertEquals(number, lastElement);


        int newElementsCount = database.getElements().length;
        Assertions.assertEquals(newElementsCount, oldElementsCount + 1);
    }

    @Test
    public void whenRemoveElementFromDatabaseWithManyElements_thenElementSuccessfullyRemovedAndCountDecrementedByOne() throws OperationNotSupportedException {

        Integer[] elements = new Integer[]{7, 18, 9};
        Database database = new Database(elements);
        int oldElementsCount = database.getElements().length;

        database.remove();

        int actualElementsCount = database.getElements().length;
        Assertions.assertEquals(actualElementsCount, oldElementsCount - 1);
    }

    @Test
    public void whenRemoveElementFromEmptyDatabase_thenExceptionIsThrown() throws OperationNotSupportedException {

        Integer[] elements = new Integer[]{7};
        Database database = new Database(elements);

        database.remove();

        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            database.remove();
        });
    }
}
