import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

// Создаем аннотацию @Two
@Retention(RetentionPolicy.RUNTIME) // Доступна во время исполнения
@Target(ElementType.TYPE) // Цель применения - только тип (класс)
@interface Two {
    String first(); // Обязательное свойство типа String
    int second();   // Обязательное свойство типа int
}