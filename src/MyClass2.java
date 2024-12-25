@Default(value = String.class) // Аннотируем класс
class MyClass2 {
    @Default(value = Integer.class) // Аннотируем поле
    private int myField;

    public int getMyField() {
        return myField;
    }
}