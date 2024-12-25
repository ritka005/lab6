import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

// 1. Создаем аннотацию @Cache
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@interface Cache {
    String[] value() default {}; // необязательное свойство
}

// 2. Создаем класс, аннотированный @Cache
@Cache(value = {"кэш1", "кэш2"}) // аннотируем класс
class MyCachedClass {
    public void display() {
        System.out.println("Выполнен метод MyCachedClass.");
    }
}