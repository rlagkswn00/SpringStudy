package hello.core.singleton;

public class SingleToneService {

    private static final SingleToneService instance = new SingleToneService();

    public static SingleToneService getInstance() {
        return instance;
    }

    private SingleToneService(){

    }

}
