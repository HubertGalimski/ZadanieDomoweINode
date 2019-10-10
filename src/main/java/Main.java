import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        INode iNode1 = new ICompositeImp("1", "15");
        INode iNode2 = new InodeImp("2", "16");
        INode iNode3 = new InodeImp("3", "17");
        INode iNode4 = new ICompositeImp("4", "18");
        INode iNode5 = new InodeImp("5", "19");
        INode iNode6 = new ICompositeImp("6", "20");
        INode iNode7 = new InodeImp("7", "21");
        INode iNode8 = new InodeImp("8", "22");
        INode iNode9 = new InodeImp("9", "23");
        INode iNode10 = new ICompositeImp("10", "24");
        INode iNode11 = new ICompositeImp("11", "25");
        INode iNode12 = new ICompositeImp("12", "26");
        INode iNode13 = new InodeImp("13", "27");
        INode iNode14 = new ICompositeImp("14", "28");


        List<INode> list1 = new ArrayList<>();
        List<INode> list2 = new ArrayList<>();
        List<INode> list3 = new ArrayList<>();
        List<INode> list4 = new ArrayList<>();
        List<INode> list5 = new ArrayList<>();
        List<INode> list6 = new ArrayList<>();
        List<INode> list7 = new ArrayList<>();
        List<INode> list8 = new ArrayList<>();

        list1.add(iNode1);
        list1.add(iNode2);
        list1.add(iNode10);

        list2.add(iNode3);
        list2.add(iNode4);

        list3.add(iNode5);
        list3.add(iNode6);

        list4.add(iNode7);
        list4.add(iNode8);
        list4.add(iNode9);

        list5.add(iNode11);
        list5.add(iNode12);

        list6.add(iNode13);
        list6.add(iNode14);


        MyStructure myStructure = new MyStructure();
        myStructure.setNodes(list1);

        ((ICompositeImp)iNode1).setiNodes((list2));
        ((ICompositeImp)iNode4).setiNodes((list3));
        ((ICompositeImp)iNode6).setiNodes((list4));
        ((ICompositeImp)iNode10).setiNodes((list5));
        ((ICompositeImp)iNode11).setiNodes((list6));
        ((ICompositeImp)iNode14).setiNodes((list7));
        ((ICompositeImp)iNode12).setiNodes((list8));

        System.out.println(myStructure.count());

        System.out.println(myStructure.findByCode("1").getRenderer());
        System.out.println(myStructure.findByCode("2").getRenderer());
        System.out.println(myStructure.findByCode("3").getRenderer());
        System.out.println(myStructure.findByCode("4").getRenderer());
        System.out.println(myStructure.findByCode("5").getRenderer());
        System.out.println(myStructure.findByCode("6").getRenderer());
        System.out.println(myStructure.findByCode("7").getRenderer());
        System.out.println(myStructure.findByCode("8").getRenderer());
        System.out.println(myStructure.findByCode("9").getRenderer());
        System.out.println(myStructure.findByCode("10").getRenderer());
        System.out.println(myStructure.findByCode("11").getRenderer());
        System.out.println(myStructure.findByCode("12").getRenderer());
        System.out.println(myStructure.findByCode("13").getRenderer());
        System.out.println(myStructure.findByCode("14").getRenderer());
        System.out.println(myStructure.findByRenderer("20").getCode());

    }
}
