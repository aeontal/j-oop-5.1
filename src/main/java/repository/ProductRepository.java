package repository;


import domain.Book;
import domain.Product;
import domain.Smartphone;

public class ProductRepository {

    private Product[] items = {

            new Book(1, "Мертвые души", 100, "Н.В.Гоголь"),
            new Book(2, "Евгений Онегин", 200, "А.С.Пушкин"),
            new Book(3, "Война и мир", 200, "А.Н.Толстой"),
            new Book(4, "Севастопольские рассказы", 200, "А.Н.Толстой"),
            new Smartphone(5, "Iphone 11", 100, "Apple"),
            new Smartphone(6, "6530i", 100, "Nokia"),
            new Smartphone(7, "3310", 200, "Nokia"),
            new Smartphone(8, "Galaxy A7", 300, "Samsung")

    };

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] findAll() {
        return items;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

}