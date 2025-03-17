package task2;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.TYPE) // Цель - тип
@Retention(RetentionPolicy.RUNTIME) // Доступна во время выполнения
public @interface Cache2 {
    String[] value() default {}; // Необязательное свойство типа String[], по умолчанию - пустой массив
}