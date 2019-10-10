import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MyStructure implements IMyStructure {

    private List<INode> nodes;

    public INode findByRenderer(String renderer) {
        return findFromTheListByPredicate(getNodes(), t -> t.getRenderer().equals(renderer));
    }

    public INode findByCode(String code) {
        return findFromTheListByPredicate(getNodes(), t -> t.getCode().equals(code));
    }

    public int count() {
        return countNodesFromTheList(nodes);
    }

    private INode findFromTheListByPredicate(List<INode>nodes, Predicate<INode> predicate) throws IllegalArgumentException {
        return flattenTheList(nodes)
                .filter(predicate)
                .findFirst()
                .orElse(null);
    }

    private Stream<INode> flattenTheList(List<INode> nodes) {
        return nodes
                .stream()
                .flatMap(node -> {
                    if (isIComposite(node)) {
                        if (((ICompositeNode) node).getNodes() == null) {
                            return Stream.ofNullable(node);
                        } else return
                                Stream.concat(flattenTheList(((ICompositeNode) node).getNodes()), Stream.of(node));
                    }
                    return Stream.of(node);
                });
    }

    private int countNodesFromTheList(List<INode> nodes) {
        if (nodes == null) return 0;
        return nodes.size() + nodes.stream()
                .filter(MyStructure::isIComposite)
                .map(this::castNodeToIComposite)
                .map(ICompositeNode::getNodes)
                .mapToInt(this::countNodesFromTheList)
                .sum();
    }

    private static boolean isIComposite(Object o) {
        return o instanceof ICompositeNode;
    }

    private ICompositeNode castNodeToIComposite(INode iNode) {
        return ((ICompositeNode) iNode);
    }

    public void setNodes(List<INode> nodes) {
        this.nodes = nodes;
    }

    public List<INode>getNodes() {
        return nodes;
    }
}

