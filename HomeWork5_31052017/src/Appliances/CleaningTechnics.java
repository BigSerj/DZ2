package Appliances;


public class CleaningTechnics extends AppliancesTechniks {

    private String noiseLevel;
    private String typeOfCleaning; //паровая/сухая и т.д.
    private int powerLevel;



    public int getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    public String getNoiseLevel() {
        return noiseLevel;
    }

    public void setNoiseLevel(String noiseLevel) {
        this.noiseLevel = noiseLevel;
    }

    public String getTypeOfCleaning() {
        return typeOfCleaning;
    }

    public void setTypeOfCleaning(String typeOfCleaning) {
        this.typeOfCleaning = typeOfCleaning;
    }
}
