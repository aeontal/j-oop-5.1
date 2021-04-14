package manager;

import domain.Book;
import domain.Product;
import domain.Smartphone;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;


class ProductManagerTest {

    ProductRepository repository = new ProductRepository();

    ProductManager manager = new ProductManager(repository);

    @Test
    void shouldSearchByBookName() {
        Product[] expected = {new Book(1, "Мертвые души", 100, "Н.В.Гоголь")};
        Product[] actual = manager.searchBy("Мертвые души");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBookNameIgnoreUpperCases() {
        Product[] expected = {new Book(1, "Мертвые души", 100, "Н.В.Гоголь")};
        Product[] actual = manager.searchBy("мертвые души");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBookAuthor() {
        Product[] expected = {new Book(2, "Евгений Онегин", 200, "А.С.Пушкин"),};
        Product[] actual = manager.searchBy("А.С.Пушкин");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBookAuthorIgnoreUpperCases() {
        Product[] expected = {new Book(2, "Евгений Онегин", 200, "А.С.Пушкин"),};
        Product[] actual = manager.searchBy("а.с.пушкин");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySeveralBooksResults() {
        Product[] expected = {
                new Book(3, "Война и мир", 200, "А.Н.Толстой"),
                new Book(4, "Севастопольские рассказы", 200, "А.Н.Толстой"),};
        Product[] actual = manager.searchBy("А.Н.Толстой");
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldSearchBySmartPhoneNameIgnoreUpperCases() {
        Product[] expected = {new Smartphone(5, "Iphone 11", 100, "Apple")};
        Product[] actual = manager.searchBy("iphone 11");
        assertArrayEquals(expected, actual);
    }

    void shouldSearchBySmartPhoneName() {
        Product[] expected = {new Smartphone(5, "Iphone 11", 100, "Apple")};
        Product[] actual = manager.searchBy("Iphone 11");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartPhoneProducer() {
        Product[] expected = {new Smartphone(8, "Galaxy A7", 300, "Samsung")};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }

    void shouldSearchBySmartPhoneProducerIgnoreUpperCases() {
        Product[] expected = {new Smartphone(8, "Galaxy A7", 300, "Samsung")};
        Product[] actual = manager.searchBy("samsung");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySeveralPhonesResults() {
        Product[] expected = {
                new Smartphone(6, "6530i", 100, "Nokia"),
                new Smartphone(7, "3310", 200, "Nokia")};
        Product[] actual = manager.searchBy("Nokia");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNull() {
        Product[] actual = manager.searchBy("Motorola");
        Product[] expect = {};

        assertArrayEquals(expect, actual);
    }


}