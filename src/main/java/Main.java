import entity.Book;
import entity.Car;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Створюэмо фабрику
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("xxx");

        //Створюэмо менеджера
        EntityManager manager = factory.createEntityManager();

        // Починаємо транзакцію
        manager.getTransaction().begin();

        //Вносимо нового юзера в базу даних
//        manager.persist(new User("vasya"));
//        manager.persist(new User("petya"));

        //Знаходимо юзера в базі даних по id
//        User user = manager.find(User.class, 1);
//        System.out.println(user);

        // select * from User
        //Якщо хочемо уникнути вказання параметра в запиті, можемо його винести в окрему змінну за допомогою наступного синтаксису (:zxc)
        //Потім сетаємо цей параметр (маємо ніби змінну)
        // Цей синтаксис є гібридним між скюл і джава-синтаксисом

//        TypedQuery<User> usersQuery = manager.createQuery("select u from User u where u.id >= :zxc", User.class);
//        usersQuery.setParameter("zxc", 2);
//        List<User> resultList = usersQuery.getResultList();
//
//        System.out.println(resultList);

//        Car car = new Car("subaru", new User("serj"));
//        manager.persist(car);

//        User user = new User("Anton");
//        List<Car> cars = new ArrayList<Car>();
//        cars.add(new Car("bmw", user));
//        cars.add(new Car("mb", user));
//        user.setCars(cars);
//        manager.persist(user);


        User user = new User("Alex");
        manager.persist(user);
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Bible"));
        books.add(new Book("Mine kampf"));
        user.setBooks(books);

        manager.getTransaction().commit();

        //Фабрика і менеджер обов'язково мають закриватися
        manager.close();
        factory.close();

    }
}
