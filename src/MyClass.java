class MyClass implements Cacheable {
    private int value;
    //поле
    //метода getValue(), который возвращает значение поля value
    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int value) {
        this.value = value; // Изменение состояния объекта
    }

    @Invoke // Аннотируем метод
    public void myAnnotatedMethod() {
        System.out.println("Метод myAnnotatedMethod был вызван.");
    }
}
//@Override, что означает, что он переопределяет метод, определенный в интерфейсе Cacheable.