package study;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Food {
    private final String name;
    private final String imageUrl;

    /*
    * 필드가 2개이상 존재하고, 생성자가 있으면 JSONCreator 붙이지 않아도 된다.
    * */
    public Food(final String name, final String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
