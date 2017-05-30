package Clinic;



class Patient {

    private String name;
    private int age;


    //сеттеры:
    //Ввод имени
    void setNamePatient(int sequence,int i){
        System.out.print(returnBuilderString(sequence,i));
        name = MainClinic.scannerInString();
    }
    //Ввод возраста
    void setAge(int sequence,int i){
        System.out.print(returnBuilderString(sequence,i));
        age = MainClinic.scannerInInt();
    }
    //Ввод группы здоровья
    void setHealthGroup(int sequence,int i){
        System.out.print(returnBuilderString(sequence,i));
        int healthGroup = MainClinic.scannerInInt();
    }
    //Ввод состояния пациента
    void setIsNowSick(int sequence,int i){
        System.out.print(returnBuilderString(sequence,i));
        boolean isNowSick = MainClinic.scannerInBoolean();
    }
    //Ввод лечащего врача
    void setDistrictDoctorName(int sequence,int i){
        System.out.print(returnBuilderString(sequence,i));
        String districtDoctorName = MainClinic.scannerInString();
    }

    private String returnBuilderString(int x, int i){
        StringBuilder builder = new StringBuilder();
        builder.append(i+1).append(".").append(x).append(". Введите ");
        switch (x){
            case 1: return builder.append("имя нового пациента: ").toString();
            case 2: return builder.append("возраст пациента ").append(name).append(": ").toString();
            case 3: return builder.append("группу здоровья, в которую входит пациент ").append(name).append(" (1..5): ").toString();
            case 4: return builder.append("\"true\", если  пациент ").append(name).append(" на сегодняшний день болен, либо, \"false\", если здоров: ").toString();
            case 5: return builder.append("имя лечащего врача пациента ").append(name).append(": ").toString();
        }
        return " //Непредвиденная ошибка//";
    }



    // герреты:
    String getName(){
        return name;
    }
    int getAge(){
        return age;
    }


}
