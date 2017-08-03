package Practice;


public class TechnicalSpecification {

}

class RandomAccessMemory {

    int RAM_volume;
    String RAM_type;

}

class Processor {

    int processor_coresNumber;
    int processor_coreClockFrequency;


}
class VideoCard {

    int videoCard_coresNumber;
    int videoCard_coreClockFrequency;


}

class VideoMemory extends RandomAccessMemory {
    int videoMemoryVolume;
    int videoMemoryType;
}
