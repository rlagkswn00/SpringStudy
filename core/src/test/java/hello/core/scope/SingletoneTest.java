package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.*;

public class SingletoneTest {

    @Test
    void singletoneBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);
        SingletonBean bean = ac.getBean(SingletonBean.class);
        SingletonBean bean2 = ac.getBean(SingletonBean.class);
        System.out.println("bean = " + bean);
        System.out.println("bean2 = " + bean2);

        assertThat(bean).isSameAs(bean2);

        ac.close();
    }

    @Scope("singleton")
    static class SingletonBean {
        @PostConstruct
        public void init(){
            System.out.println("SingletoneBean.init");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("SingletoneBean.destroy");
        }
    }
}
