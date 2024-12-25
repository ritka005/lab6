public class Main {
    public static void main(String[] args) {

        //1 Задание
        System.out.println("Задание 1.3.");

        Cacheable myObject = new MyClass();
        myObject.setValue(42);
        Cacheable cachedObject = CacheUtils.cache(myObject);
        System.out.println(cachedObject.getValue()); // Выведет 42
        cachedObject.setValue(24);
        System.out.println(cachedObject.getValue()); // Выведет 24
        cachedObject.setValue(24); // Значение не изменилось
        System.out.println(cachedObject.getValue()); // Выведет 24 (из кеша)

        //2 Задание
        System.out.println("Задание 2.1.");

        MyClass myClass = new MyClass();
        myClass.myAnnotatedMethod(); // Вызов аннотированного метода

        // Проверка наличия аннотации
        try {
            if (myClass.getClass().getMethod("myAnnotatedMethod").isAnnotationPresent(Invoke.class)) {
                System.out.println("Аннотация @Invoke присутствует на myAnnotatedMethod.");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //3 Задание
        System.out.println("Задание 2.2.");
        Default classAnnotation = MyClass2.class.getAnnotation(Default.class);
        if (classAnnotation != null) {
            System.out.println("Аннотация @Default найдена на классе MyClass с value: " + classAnnotation.value().getName());
        }
        // Получаем аннотацию на поле
        try {
            Default fieldAnnotation = MyClass2.class.getDeclaredField("myField").getAnnotation(Default.class);
            if (fieldAnnotation != null) {
                System.out.println("Аннотация @Default найдена на поле myField с value: " + fieldAnnotation.value().getName());
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        //4 Задание
        System.out.println("Задание 2.3.");
        Person person = new Person("Rita", 19);
        person.printInfo(); // Вывод информации о объекте

        //5 Задание
        System.out.println("Задание 2.4.");
        User user = new User("Rita", 19);
        user.printInfo();

        //6 Задание
        System.out.println("Задание 2.5.");
        MyClass3 myClass3 = new MyClass3();
        myClass3.display();

        // Используем рефлексию для получения значений аннотации
        Two annotation = myClass3.getClass().getAnnotation(Two.class);
        if (annotation != null) {
            System.out.println("Первый: " + annotation.first());
            System.out.println("Второй: " + annotation.second());
        }

        //7 Задание
        System.out.println("Задание 2.6.");
        // Создаем экземпляр аннотированного класса
        MyCachedClass myCachedClass = new MyCachedClass();
        myCachedClass.display();

        // Получаем аннотацию @Cache с помощью рефлексии
        Cache cacheAnnotation = MyCachedClass.class.getAnnotation(Cache.class);
        if (cacheAnnotation != null) {
            // 4. Проверяем и выводим значение свойства value
            String[] cacheValues = cacheAnnotation.value();
            System.out.println("Значения кэша: " + String.join(", ", cacheValues));
        }

        //8 Задание
        System.out.println("Задание 3.1.");
        MyClass4 myClass4 = new MyClass4();
        CacheUtil.cache(myClass4);
    }
}