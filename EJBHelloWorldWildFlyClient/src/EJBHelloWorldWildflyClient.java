import javax.naming.Context;
import javax.naming.InitialContext;

import com.jlg.tutorial.ejb.interfaces.HelloWorldWildFlyBeanRemote;


public class EJBHelloWorldWildflyClient {
    public static void main(String[] args) {
        try {
            Context ctx = new InitialContext();

            String name;
            //name = "java:global/EJBHelloWorld/HelloWorldBean";
            // JBoss WildFly: la référence JNDI de l'EJB est différente
            name = "ejb:/EJBHelloWorld//HelloWorldBean!com.jlg.tutorial.ejb.interfaces.HelloWorldBeanRemote";

            HelloWorldWildFlyBeanRemote bean = (HelloWorldWildFlyBeanRemote) ctx.lookup(name);

            System.out.println(bean.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}