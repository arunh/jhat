package uk.co.arunhorne.jhat;

import java.util.concurrent.TimeUnit;

public class SessionCacheReloadSimulator {

    public static void main (String... args) throws InterruptedException {

        Container c = new Container();
        int id = c.newUserSessionAndQuery();
        c.newUserSessionAndQuery();
        c.triggerReload();
        c.newUserSessionAndQuery();
        c.removeSession(id);

        System.out.println("Going to sleep so you can dump the heap!");
        Thread.sleep(TimeUnit.HOURS.toMillis(1));

    }

}
