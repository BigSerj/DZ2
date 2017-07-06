package CompanyHierarchy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StaffCollection<T> {

    private HashMap<String, List<T>> data = new HashMap<>();
    private T director;

    public void addDirector(T value){
        director = value;
    }

    public T getDirector() {
        return director;
    }



    // метод добавления
    public void addDep(String department,T value){
        if (data.containsKey(department)){
            data.get(department).add(value);
        }
        else{
            List<T> list = data.get(department);
            if(list==null){     // проверка на всякий случай
                list = new ArrayList<>();
            }
            list.add(value);
            data.put(department,list);
        }
    }


    // и гет
    public List<T> getDep(String department) {
        if (data.containsKey(department))
            return data.get(department);
        return null;
    }

    // удаления
    public void delDep(String department, T value) {
        if (data.containsKey(department)){
            for(int i=0;i<data.get(department).size();i++)
                if (data.get(department).get(i).equals(value)) {
                    data.get(department).remove(i);
                    return;
                }
        }
        System.out.println("Указанный элемент для удаления не найден");
    }
}