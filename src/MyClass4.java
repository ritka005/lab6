// Класс для тестирования
class MyClass4 {
    @Cache
    public String method1() {
        return "Результат method1";
    }

    @Cache({"method2"})
    public String method2() {
        return "Результат method2";
    }

    public String method3() {
        return "Результат method3";
    }
}