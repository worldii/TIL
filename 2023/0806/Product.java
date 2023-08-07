package study;

public class Product {
    private int id;
    /*
    * 기본생성자가 없으므로 역직렬화에 실패한다.
    * */

    public Product(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
