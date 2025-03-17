package task2;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // Цель - метод
@Retention(RetentionPolicy.RUNTIME) // Доступна во время исполнения
public @interface Invoke2 {
}
