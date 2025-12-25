package Stream;
import java.util.*;
import java.util.stream.Collectors;

public class ProductMain {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product(1, "Laptop", "Electronics", 50000, 10),
                new Product(2, "Phone", "Electronics", 20000, 20),
                new Product(3, "Notebook", "Stationery", 50, 100),
                new Product(4, "Pen", "Stationery", 10, 200),
                new Product(5, "Book", "Books", 300, 50),
                new Product(6, "Smart Watch", "Electronics", 7000, 15),
                new Product(7, "Textbook", "Books", 1200, 25)
        );
        products.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------------------------");
//        Get a list of products whose price > 1000.

        products
                .stream()
                .filter(prod->prod.getPrice()>1000)
                .forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------------------------");

//        Get a list of product names in the "Electronics" category.
        products
                .stream()
                .filter(prod->prod.getCategory().equals("Electronics"))
                .forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------------------------------");
//        Count total quantity of products category-wise.
        products
                .stream()
                .collect(Collectors.groupingBy(Product::getCategory,Collectors.counting()))
                .forEach((cat,prod)-> System.out.println(cat+"="+prod));
        System.out.println("-----------------------------------------------------------------------------------------");
//        Get the product with the maximum price.

        Product product = products
                .stream()
                .collect(Collectors.maxBy(Comparator.comparing(Product::getPrice)))
                .orElse(null);
        System.out.println(product);
        System.out.println("-----------------------------------------------------------------------------------------");
//        Group products by category.
        products
                .stream()
                .collect(Collectors.groupingBy(Product::getCategory))
                .forEach((cat,prod)-> System.out.println(cat+"="+prod));
        System.out.println("-----------------------------------------------------------------------------------------");

//        Increase price by 10% for products in "Books" category.
//        products
//                .stream()
//                .filter(cat -> cat.getCategory().equals("Books"))
//                .map(price->price.getPrice()*(1.1))
//                .toList()
//                .forEach(System.out::println);

        System.out.println("-----------------------------------------------------------------------------------------");

        products
                .stream()
                .filter(prod->prod.getCategory().equalsIgnoreCase("books"))
                .forEach(prod->prod.setPrice(prod.getPrice()*1.1));
        products.forEach(System.out::println);

        System.out.println("-----------------------------------------------------------------------------------------");
    }
}
