CLASSPATH = "${CATALINA_HOME}/lib/servlet-api.jar"

all:
	echo $(CLASSPATH)
	(cd WEB-INF/classes; javac -cp $(CLASSPATH) HelloWorldServlet.java)
	zip -r coucou.war WEB-INF
