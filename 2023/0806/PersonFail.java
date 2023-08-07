package study;

public class PersonFail {
    private final String name;

    /*
    * 필드가 하나 있으면 반드시 JsonCreator 붙여줘야 한다.
    * */
    public PersonFail(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
