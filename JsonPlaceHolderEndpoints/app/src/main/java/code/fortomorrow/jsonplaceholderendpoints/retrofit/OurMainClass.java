package code.fortomorrow.jsonplaceholderendpoints.retrofit;

import java.util.List;

public class OurMainClass {
    private List<POJOClass> posts;

    public OurMainClass() {
    }

    public OurMainClass(List<POJOClass> posts) {
        this.posts = posts;
    }

    public List<POJOClass> getPosts() {
        return posts;
    }

    public void setPosts(List<POJOClass> posts) {
        this.posts = posts;
    }
}
