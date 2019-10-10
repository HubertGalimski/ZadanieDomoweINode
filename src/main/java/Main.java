import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        INode iNode1 = new ICompositeImp("1", "210");
        INode iNode2 = new InodeImp("1", "2");
        INode iNode3 = new InodeImp("1", "2");
        INode iNode4 = new ICompositeImp("1", "2");
        INode iNode5 = new InodeImp("1", "2");
        INode iNode6 = new ICompositeImp("1", "2");
        INode iNode7 = new InodeImp("1", "2");
        INode iNode8 = new InodeImp("1", "2");
        INode iNode9 = new InodeImp("1", "2");
        INode iNode10 = new ICompositeImp("1", "2");
        INode iNode11 = new ICompositeImp("1", "2");
        INode iNode12 = new ICompositeImp("1", "2");
        INode iNode13 = new InodeImp("1", "2");
        INode iNode14 = new ICompositeImp("8", "3");


        List<INode> list1 = new ArrayList<>();
        List<INode> list2 = new ArrayList<>();
        List<INode> list3 = new ArrayList<>();
        List<INode> list4 = new ArrayList<>();
        List<INode> list5 = new ArrayList<>();
        List<INode> list6 = new ArrayList<>();

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

        System.out.println(myStructure.count());

        System.out.println(myStructure.findByCode("1").getRenderer());
    }
}
