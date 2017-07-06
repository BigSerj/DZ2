package GarbageCollector;

import java.lang.ref.SoftReference;

public class SoftReferenceClass {

    private String b = "ffferf";

    public void test(){

        // этот класс удалит то что в него вложили первым делом когда не будет хватать памяти.
        SoftReference<String> ref = new SoftReference<>(b);

        String a = ref.get();
        if(a!=null){
            // использовать
        }


    }

}
