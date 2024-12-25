import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// Утилитный класс кэширования
public class CacheUtil {
    //создается статическое финальное поле cache
    private static final Map<String, Object> cache = new HashMap<>();
    //метод является точкой входа в класс CacheUtil
    //Он принимает любое количество объектов (используя синтаксис Object...)
    public static void cache(Object... objects) {
        // итерация по всем переданным объектам
        for (Object obj : objects) {
            Class<?> clazz = obj.getClass();
            Method[] methods = clazz.getDeclaredMethods();
            //итерация по всем методам, проверяется, есть ли на нем аннотация @Cache
            for (Method method : methods) {
                if (method.isAnnotationPresent(Cache.class)) {
                    Cache cacheAnnotation = method.getAnnotation(Cache.class);
                    //Из аннотации @Cache извлекается массив строк, указывающих, какие именно методы нужно кэшировать.
                    //Если массив пуст или содержит имя текущего метода, то будет произведено кэширование.
                    String[] cacheMethods = cacheAnnotation.value();
                    if (cacheMethods.length == 0 || contains(cacheMethods, method.getName())) {
                        // Здесь нужно кэшировать метод
                        try {
                            method.setAccessible(true);
                            Object result = method.invoke(obj);
                            cache.put(method.getName(), result);
                            System.out.println("Метод " + method.getName() + " кэширован с результатом: " + result);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    //Этот вспомогательный метод проверяет, содержится ли заданное значение value в массиве строк array.
    //Если значение найдено, возвращается true, иначе - false.
    private static boolean contains(String[] array, String value) {
        for (String str : array) {
            if (str.equals(value)) {
                return true;
            }
        }
        return false;
    }
}