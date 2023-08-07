package study;

public class Product3 {
    private int id;

    private String name;

    /*
    * 필드가 두개 이상 있어도, 기본 생성자가 필요함. 이는 기본 생성자가 있어야지 역직렬화가 가능하기 떄문.
    * */
    protected Product3 () {}
    public Product3(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
