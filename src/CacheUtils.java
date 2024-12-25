import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

class CacheUtils {
    //метод cache принимает объект любого типа T и возвращает прокси-объект
    public static <T> T cache(T obj) {
        Class<?> clazz = obj.getClass();
        //cache и lastValues - будут хранить соответственно кэшированные результаты вызовов методов и последние значения
        Map<Method, Object> cache = new HashMap<>();
        Map<Method, Object> lastValues = new HashMap<>();

        // Хендлер для вызова методов
        InvocationHandler handler = (proxy, method, args) -> {
            //Этот блок кода будет выполняться, если вызываемый метод не имеет параметров.
            if (args == null || args.length == 0) {
                // Если метод уже был вызван ранее, то мы сравниваем последнее возвращенное значение с текущим.
                if (cache.containsKey(method)) {
                    Object lastValue = lastValues.get(method);
                    Object currentValue = method.invoke(obj);

                    // Если они совпадают, мы возвращаем кэшированный результат.
                    if (currentValue.equals(lastValue)) {
                        return cache.get(method);
                    }
                }
                // Вызываем метод и кэшируем результат
                Object result = method.invoke(obj);
                cache.put(method, result);
                lastValues.put(method, result);
                return result;
            } else {
                // Если метод с параметрами, вызываем его напрямую
                return method.invoke(obj, args);
            }
        };

        // Создаем прокси-объект
        return (T) Proxy.newProxyInstance(
                clazz.getClassLoader(),
                clazz.getInterfaces(),
                handler
        );
    }
}
//Этот код создает прокси-объект для кеширования результатов
// вызова методов, что позволяет избежать повторного