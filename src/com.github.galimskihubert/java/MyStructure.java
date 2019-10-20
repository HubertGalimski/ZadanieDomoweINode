import java.util.*;
import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MyStructure implements IMyStructure {


    private List<INode> nodes;

    public INode findByRenderer(String renderer) {
        if (renderer == null) {
            throw new IllegalArgumentException("Parameter is null");
        }
        return findFromTheListByPredicate(getNodes(), t -> t.getRenderer().equals(renderer));
    }

    public INode findByCode(String code) {
        if (code == null) {
            throw new IllegalArgumentException("Parameter is null");
        }
        return getList(nodes, code, Type.CODE);
    }

    public int count() {
        return countNodesFromTheList(nodes);
    }

    private INode findFromTheListByPredicate(List<INode> nodes, Predicate<INode> predicate) {
        return flattenTheList(nodes)
                .filter(predicate)
                .findFirst()
                .orElse(null);
    }

    private Stream<INode> flattenTheList(List<INode> nodes) {
        return nodes
                .stream()
                .flatMap(t -> t instanceof ICompositeNode ? Stream.concat(flattenTheList(((ICompositeNode) t).getNodes()), Stream.of(t)) : Stream.of(t));
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


    public INode getList(List<INode> iNodeList, String s, Type t) {
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
            System.out.println("1!!");
            return getList(list, s, t);
        }
        return null;
    }

    public enum Type {
        CODE, RENDERER
    }
}

