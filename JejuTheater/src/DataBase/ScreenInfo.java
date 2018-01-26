package DataBase;

public class ScreenInfo{
    public final String screenId;
    public final String screen;
    public final String startTime;
    public final String leftSeat;
    public final String totalSeat;

    public ScreenInfo(String screenId, String screen, String startTime, String leftSeat, String totalSeat) {
        this.screenId = screenId;
        this.screen = screen;
        this.startTime = startTime;
        this.leftSeat = leftSeat;
        this.totalSeat = totalSeat;
    }
}
