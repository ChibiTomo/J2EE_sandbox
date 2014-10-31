import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.jlg.tutorial.ejb.interfaces.StatelessSessionWildFlyBeanRemote;

public class EJBSessionStatelessWildFlyClient {
	public static BufferedReader reader = new BufferedReader(
			new InputStreamReader(System.in));

	public static void main(String[] args) {
		try {
			int delay = 7000;
			if (args.length >= 1) {
				delay = new Integer(args[0]) * 1000;
			}
			System.out.println("delay=" + delay);
			Context ctx = new InitialContext();

			String name;
			// name = "java:global/EJBSessionStateless/StatelessSessionBean";
			// JBoss WildFly: la référence JNDI de l'EJB est différente
			name = "ejb:/EJBSessionStatelessWildFly//StatelessSessionWildFlyBean!com.jlg.tutorial.ejb.interfaces.StatelessSessionWildFlyBeanRemote";

			final StatelessSessionWildFlyBeanRemote bean = (StatelessSessionWildFlyBeanRemote) ctx
					.lookup(name);

			class MyRunnable implements Runnable {
				public int tid;

				public MyRunnable(int i) {
					tid = i;
				}

				@Override
				public void run() {
					System.out.println("tid[" + tid + "]: Calling bean.");
					System.out
							.println("tid[" + tid + "]: " + bean.getMessage());
				}
			}

			ExecutorService es = Executors.newCachedThreadPool();

			es.execute(new MyRunnable(1));
			Thread.sleep(delay);
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
