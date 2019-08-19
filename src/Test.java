import com.DataStructure.LinkedList.SingleLinkedList;
import com.DataStructure.LinkedList.TwoWayLinkedList;

public class Test {
    public static void main(String[] args) {

        TwoWayLinkedList dl = new TwoWayLinkedList();
        dl.addHead("abc");
        dl.addHead("askdljfs");
        dl.addHead("93203");
        dl.addTail("oinioadn");
        dl.addTail("cba");

//        dl.set(2, "hhhhhhh");
        System.out.println(dl.get(2));
        for (Object x : dl.toArray()) {
            System.out.print(x+" ");
        }


//        SingleLinkedList sl = new SingleLinkedList();
//        sl.add("dlkg");
//        sl.add("sd");
//        sl.add("345");
//        sl.add("hjg");
//        sl.add("sgkjnk");
//
////        System.out.println(sl.delete());
////        System.out.println(sl.contains("sgkjnk"));
////        System.out.println(sl.size());
////        System.out.println(sl.isEmpty());
////        System.out.println(sl.set(1,"abcdefg"));
//////        System.out.println(sl.contains("abcdefg"));
//        System.out.println(sl.get(4));
//        for (Object x : sl.toArray()) {
//            System.out.print(x+" ");
//        }
    }
}
