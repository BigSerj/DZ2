package GarbageCollector;


import java.lang.ref.WeakReference;

public class WeakReferenceClass {

    private String b = "ffferf";

    // когда сборзик мусора проходится по приложению, то если на объект кроме WeakReference никто не ссылается,
    // то он его удалит (или не удалит если не захочет???)
    WeakReference<String> ref = new WeakReference<String>(b);




}
