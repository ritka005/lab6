import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

//Создаем перечисление для значений
enum ToStringValue {
    YES, NO
}

//Создаем аннотацию @ToString
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD}) // Цель применения аннотации
@interface ToString {
    ToStringValue value() default ToStringValue.YES; // Значение по умолчанию
}

//Создаем класс, который будет аннотирован
@ToString(value = ToStringValue.YES)
class Person {
    @ToString(value = ToStringValue.NO)
    private String name;

    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void printInfo() {
        // Шаг 4: Извлекаем аннотацию и выводим информацию
        if (getClass().isAnnotationPresent(ToString.class)) {
            ToString toString = getClass().getAnnotation(ToString.class);
            if (toString.value() == ToStringValue.YES) {
                System.out.println("Class: " + getClass().getSimpleName());
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
            }
        }
    }
}