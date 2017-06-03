package Appliances;


public class CookingTechniks extends AppliancesTechniks {

    private int Clearance;//мелко/средне/крупногабаритная
    private String typeOfEnergy;



    public String getTypeOfEnergy() {
        return typeOfEnergy;
    }

    public void setTypeOfEnergy(String typeOfEnergy) {
        this.typeOfEnergy = typeOfEnergy;
    }

    public int getClearance() {
        return Clearance;
    }

    public void setClearance(int clearance) {
        Clearance = clearance;
    }
}
