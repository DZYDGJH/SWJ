package two;
//2205900101宋玮杰

public class Person {
    @Hello(value = "SWJ", name = "宋玮杰", age = 18)
    private String name;

    @Hello(value = "名字", name = "王健豪", age = 1000)
    private int age;

    @Hello(value = "四川", name = "锦江学院", age = 18)
    public String getAddress() {
        return "四川, 眉山";
    }

    @Hello(value = "666", name = "777", age = 888)
    public void show() {
        System.out.println("Hello, World!");
    }
}
