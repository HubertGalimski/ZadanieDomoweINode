import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MyStructure implements IMyStructure {


    private List<INode> nodes;

    public INode findByRenderer(String renderer) {
        if (renderer == null) {
            throw new IllegalArgumentException("Parameter is null");
        }
        return checkTheList(nodes, renderer, Type.RENDERER);
    }

    public INode findByCode(String code) {
        if (code == null) {
            throw new IllegalArgumentException("Parameter is null");
        }
        return checkTheList(nodes, code, Type.CODE);
    }

    public int count() {
        return countNodesFromTheList(nodes);
    }

    private int countNodesFromTheList(List<INode> nodes) {
        if (nodes == null) return 0;
        return nodes.size() + nodes.stream()
                .filter(t -> t instanceof ICompositeNode)
                .map(t -> ((ICompositeNode) t).getNodes())
                .mapToInt(this::countNodesFromTheList)
                .sum();
    }

    public void setNodes(List<INode> nodes) {
        this.nodes = nodes;
    }


    public List<INode> getNodes() {
        return nodes;
    }


    public INode checkTheList(List<INode> iNodeList, String s, Type t) {
        boolean isAdd = false;
        List<INode> list = new ArrayList<>();
        ListIterator<INode> listIterator = iNodeList.listIterator();
        while (listIterator.hasNext()) {
            INode temp = listIterator.next();
            if (t.equals(Type.CODE)) {
                if (temp.getCode().equals(s))
                    return temp;
            }
            if (t.equals(Type.RENDERER)) {
                if (temp.getRenderer().equals(s))
                    return temp;
            }
            if (temp instanceof ICompositeNode) {
                list.addAll(((ICompositeNode) temp).getNodes());
                isAdd = true;
            }
        }
        if (isAdd) {
            return checkTheList(list, s, t);
        }
        return null;
    }

    public enum Type {
        CODE, RENDERER
    }
}

