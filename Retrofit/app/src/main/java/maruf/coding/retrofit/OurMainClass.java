package maruf.coding.retrofit;

import java.util.List;

public class OurMainClass {
    private List<ObjectDataClass> data;

    public OurMainClass(List<ObjectDataClass> data) {
        this.data = data;
    }

    public OurMainClass() {
    }

    public List<ObjectDataClass> getData() {
        return data;
    }

    public void setData(List<ObjectDataClass> data) {
        this.data = data;
    }
}
