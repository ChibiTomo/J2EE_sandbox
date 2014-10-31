import javax.naming.Context;
import javax.naming.InitialContext;

import com.jlg.tutorial.ejb.interfaces.HelloWorldBeanRemote;


public class EJBHelloWorldClient {
    public static void main(String[] args) {
        try {
            Context ctx = new InitialContext();

            String name;
            name = "java:global/EJBHelloWorld/HelloWorldBean";
            // JBoss WildFly: la référence JNDI de l'EJB est différente
            // name = "ejb:/EJBHelloWorld//HelloWorldBean!com.jlg.tutorial.ejb.interfaces.HelloWorldBeanRemote";

            HelloWorldBeanRemote bean = (HelloWorldBeanRemote) ctx.lookup(name);

            System.out.println(bean.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}