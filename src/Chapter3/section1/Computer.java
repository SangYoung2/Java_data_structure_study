package Chapter3.section1;

public class Computer {
    // protected - private는 동일한 패키지내 자식클래스여도 사용을 하지 못하게 하지만 protected는 동일한 패키지 또는 자식클래스에서 사용 할 수 있게해준다.
    private String manufacturer;
    private String processor;
    private int ramSize;
    private int diskSize;
    private double processorSpeed;

    public Computer(String manufacturer, String processor, int ramSize, int diskSize, double processorSpeed) {
        this.manufacturer = manufacturer;
        this.processor = processor;
        this.ramSize = ramSize;
        this.diskSize = diskSize;
        this.processorSpeed = processorSpeed;
    }

    public Computer() {
    }

    public double computerPower() {
        return ramSize * processorSpeed;
    }

    public int getRamSize() {
        return ramSize;
    }

    public int getDiskSize() {
        return diskSize;
    }

    public double getProcessorSpeed() {
        return processorSpeed;
    }

    @Override
    public String toString() {
        return  "manufacturer='" + manufacturer + '\'' +
                ", processor='" + processor + '\'' +
                ", ramSize=" + ramSize + "megaBite" +
                ", diskSize=" + diskSize +
                ", processorSpeed=" + processorSpeed ;
    }
}
