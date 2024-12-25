import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

// Создаем аннотацию @Validate
@Retention(RetentionPolicy.RUNTIME) // Доступна во время исполнения
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE}) // Цели применения: тип и аннотация
@interface Validate {
    Class<?>[] value(); // Обязательное свойство
}

// Создаем класс, который будет аннотирован
@Validate(value = {String.class, Integer.class}) // Используем аннотацию
class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}