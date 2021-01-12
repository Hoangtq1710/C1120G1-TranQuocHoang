package extra_exercise.opp_module_1;

public class Television implements Switch{
    private int channel;
    private int volume;
    private boolean status;

    public Television(int channel, int volume) {
        this.channel = channel;
        this.volume = volume;
    }

    public Television(int channel, int volume, boolean status) {
        this.channel = channel;
        this.volume = volume;
        this.status = status;
    }

    public int getChannel() {
        return this.channel;
    }

    public int getVolume() {
        return this.volume;
    }

    public String displayStatus() {
        if (isStatus()) {
            return "Television is on" ;
        } else {
            return "Television is off";
        }
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void switchChannel(int channel) {
        if (channel < 0 || channel > 20) {
            this.channel = this.getChannel();
            System.out.println("Invalid TV Channel");
        } else {
            this.channel = channel;
        }
    }

    @Override
    public void switchVolume(int code) {
        int plus = this.getVolume() + code;
        if (plus < 0) {
            this.volume = 0;
            System.out.println("Min Volume");
        } else if (plus > 50){
            this.volume = 50;
            System.out.println("Max Volume = "+this.volume);
        } else {
            this.volume += code;
        }
    }

    @Override
    public void turnOnOff() {
        this.setStatus(!this.isStatus());
    }

    @Override
    public String toString() {
        if (isStatus()) {
            return displayStatus()+
                    ", Channel : "+this.getChannel()+
                    ", Volume : "+this.getVolume();
        } else {
            return displayStatus();
        }
    }
}
