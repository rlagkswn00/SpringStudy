package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetwrokClient{
    private String url;

    public NetwrokClient() {
        System.out.println("생성자 호출, url = " + url);

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


    public void init(){
        //의존관계 주입이 끝나면 호출되는 함수
        System.out.println("NetwrokClient.init");
        connect();
        call("초기화 연결 메시지");
    }


    public void close(){
        System.out.println("NetwrokClient.close");
        disconnect();
    }
}
