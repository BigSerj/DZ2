package CompanyHierarchy;


import java.util.List;

public class MainC {

    public static void main(String[] args) {

        StaffCollection<String> staf = new StaffCollection<>();

        // заполняем новый объект
        String director = staf.getDirector();

        staf.addDirector("Директор");
        staf.addDep("Отдел 1","отд1-1");
        staf.addDep("Отдел 1","отд1-2");
        staf.addDep("Отдел 1","отд1-3");
        staf.addDep("Отдел 1","отд1-4");

        staf.addDep("Отдел 2","отд2-1");
        staf.addDep("Отдел 2","отд2-2");

        staf.addDep("Отдел 3","отд3-1");
        staf.addDep("Отдел 3","отд3-2");
        staf.addDep("Отдел 3","отд3-3");



        // выводим элементы указанного департамента на экран
        System.out.println("Выводим перед удалением:");
        showList(staf.getDep("Отдел 1"));
        showList(staf.getDep("Отдел 3"));

        // удаляем указанный элемент департамента
        staf.delDep("Отдел 1","отд1-3");
        staf.delDep("Отдел 3","отд3-2");

        // выводим элементы указанного департамента на экран после удаления
        System.out.println("Выводим после удалениея:");
        showList(staf.getDep("Отдел 1"));
        showList(staf.getDep("Отдел 3"));
    }


    public static void showList(List<String> list){
        System.out.println("////////////////////////////////////////////");
        for (String aList : list) System.out.println(aList);
        System.out.println("////////////////////////////////////////////");
    }


}