import java.util.List;

public class Main {
    public static void main(String[] args) {

        MyStructure myStructure = new MyStructure();
        INode iNode1 = new ICompositeImp("1", "6");
        INode iNode2 = new InodeImp("2", "7");
        INode iNode3 = new ICompositeImp("3", "8");
        INode iNode4 = new InodeImp("4", "9");
        INode iNode5 = new InodeImp("5", "10");

        myStructure.setNodes(List.of(iNode1));
        ((ICompositeImp) iNode1).setiNodes(List.of(iNode2, iNode3));
        ((ICompositeImp) iNode3).setiNodes(List.of(iNode4, iNode5));


        System.out.println(myStructure.findByCode("2").getRenderer());


    }

}
