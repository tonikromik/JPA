package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "ім'я таблиці з бази даних")
// по аналогії з анотацією @Column
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //    @Column(name = "ім'я колонки, яке є в базі даних")
    //  Якщо в нас в базі даних є назва колонки, яка відрізняється від тієї, яку хочемо ми,
    // за допомого анотації @Column ми можемо перевизначити ім’я, тим самим зробивши ці імена синонімами
    // Це робиться для того щоб код був більш-зрозумілим для себе і щоб не плутатися

    private int id;
    private String name;
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "user"
    )
    private List<Car> cars = new ArrayList<Car>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<Book>();


    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, List<Car> cars) {
        this.name = name;
        this.cars = cars;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
