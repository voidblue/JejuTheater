package Utils;

import Interface.SchedulRunner;

//메인에 이거 하나 돌린다고 생각하면 될듯!
public class Scheduler {
    public static Scheduler getInstance(){
        return new Scheduler();
    }
    private Scheduler(){
    }
    public void run(SchedulRunner schedulRunner, int time){
        while(true) {
            schedulRunner.run();
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
