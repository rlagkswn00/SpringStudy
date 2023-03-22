package hello.core.lifecycle;

public class NetwrokClient {
    private String url;

    public NetwrokClient() {
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메시지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect(){
        System.out.println("url = " + url);
    }

    public void call(String message){
        System.out.println("url= "+url+"message = " + message);
    }

    public void disconnect(){
        System.out.println("close "+ url);
    }
}
