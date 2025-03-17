package task2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE}) // Цель - тип или аннотация
@Retention(RetentionPolicy.RUNTIME) // Доступна во время выполнения
public @interface Validate2 {
    Class<?>[] value(); // Обязательное свойство типа Class[]
}
