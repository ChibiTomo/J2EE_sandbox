import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.jlg.tutorial.ejb.interfaces.SingletonSessionWildFlyBeanRemote;

public class EJBSessionSingletonWildFlyClient {
	public static void main(String[] args) {
		try {
			final Context ctx = new InitialContext();

			final String name;
			// name = "java:global/EJBSessionStateful/StatefulSessionBean";
			// JBoss WildFly: la référence JNDI de l'EJB est différente
			name = "ejb:/EJBSessionSingletonWildFly//SingletonSessionWildFlyBean!com.jlg.tutorial.ejb.interfaces.SingletonSessionWildFlyBeanRemote";

			class MyRunnable implements Runnable {
				public int tid;

				public MyRunnable(int i) {
					tid = i;
				}

				@Override
				public void run() {
					try {
						SingletonSessionWildFlyBeanRemote bean = (SingletonSessionWildFlyBeanRemote) ctx
								.lookup(name);

						for (int i = 0; i < 5; i++) {
							System.out.println("tid[" + tid + "]: "
									+ bean.getMessage());
							Thread.sleep(1000);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

			ExecutorService es = Executors.newCachedThreadPool();

			es.execute(new MyRunnable(1));
			es.execute(new MyRunnable(2));

			es.shutdown();
			if (es.awaitTermination(1, TimeUnit.MINUTES)) {
				System.out.println("Finished");
			} else {
				System.out.println("Finished with timeout.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
