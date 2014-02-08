package org.komlev;

import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.Server;
import org.hsqldb.server.ServerAcl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Alex on 08.02.14.
 */
public class LogicRunner {

    private Server server;

    public LogicRunner() {
    }

    public static void main(String[] args) {
        LogicRunner runner = new LogicRunner();
        runner.execute();
    }

    private void execute() {
        if(!initDb()){
            System.err.println("Can't initialize database");
            System.exit(-1);
        }
        ApplicationContext context = new ClassPathXmlApplicationContext("appConfig.xml");
        TaskProcessor taskProcessor = (TaskProcessor) context.getBean("taskProcessor");
        taskProcessor.initScheme();
        taskProcessor.execute();
        releaseDb();
    }

    private void releaseDb() {
        server.stop();
    }

    private boolean initDb() {
        server = new Server();
        Properties properties = new Properties();
        properties.setProperty("server.database.0", "mem:mymemdb");
        properties.setProperty("server.dbname.0", "mymemdb");

        try {
            server.setProperties(new HsqlProperties(properties));
        } catch (Exception e) {
            return false;
        }
        server.start();
        return true;
    }

}
