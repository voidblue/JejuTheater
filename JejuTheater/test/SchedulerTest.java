import Utils.Scheduler;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class SchedulerTest {
    private Scheduler scheduler;

    @Before
    public void getInstacneTest(){
        scheduler = Scheduler.getInstance();
    }

    @Test
    public void runTest(){
        //Assert 테스트가 불가능
        scheduler.run(()->{System.out.println(new Date().getSeconds());}, 5000);
    }

}