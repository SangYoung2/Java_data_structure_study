package Chapter3.section1;

public class Computer {
    public String manufacturer;
    public String processor;
    public int ramSize;
    public int diskSize;
    public double processorSpeed;

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
        return "Computer{" +
                "manufacturer='" + manufacturer + '\'' +
                ", processor='" + processor + '\'' +
                ", ramSize=" + ramSize + "megaBite" +
                ", diskSize=" + diskSize +
                ", processorSpeed=" + processorSpeed +
                '}';
    }
}
