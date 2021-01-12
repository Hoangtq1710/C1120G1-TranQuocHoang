package extra_exercise.opp_module_1;

public class Remote implements Switch{
    int code;
    private Television tv = null;

    public Remote(Television tv) {
        this.tv = tv;
    }

    public Television getTv() {
        return tv;
    }

    public void setTv(Television tv) {
        this.tv = tv;
    }

    public Remote(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public void switchChannel(int channel) {
        this.tv.switchChannel(channel);
    }

    @Override
    public void switchVolume(int code) {
        this.tv.switchVolume(code);
    }

    @Override
    public void turnOnOff() {
        this.tv.setStatus(!this.tv.isStatus());
    }
}
