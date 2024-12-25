import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Определяем аннотацию @Default
@Target({ElementType.TYPE, ElementType.FIELD}) // Может применяться к типу или полю
@Retention(RetentionPolicy.RUNTIME) // Доступна во время выполнения
public @interface Default {
    Class<?> value(); // Обязательное свойство value типа Class
}