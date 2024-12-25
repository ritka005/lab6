import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Определяем аннотацию @Invoke
@Target(ElementType.METHOD) // Можем использовать только для методов
@Retention(RetentionPolicy.RUNTIME) // Доступна во время выполнения
public @interface Invoke { }