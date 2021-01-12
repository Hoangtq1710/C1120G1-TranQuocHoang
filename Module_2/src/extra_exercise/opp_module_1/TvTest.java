package extra_exercise.opp_module_1;

public class TvTest {
    public static void main(String[] args) {
        System.out.println("Television - Remote");
        Television television = new Television(15,21, false);
        Remote remote = new Remote(television);

        television.turnOnOff();
        System.out.println(television);

        System.out.println("\nPre-channel : "+television.getChannel());
        television.switchChannel(7);
        remote.switchChannel(3);
        System.out.println("After-channel : "+television.getChannel());

        System.out.println("\nPre-volume : "+television.getVolume());
        television.switchVolume(10);
        remote.switchVolume(-7);
        System.out.println("After-volume : "+television.getVolume());

        remote.turnOnOff();
        System.out.println(television);
    }
}
