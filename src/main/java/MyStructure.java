import org.w3c.dom.ls.LSOutput;

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

    private INode findFromTheListByPredicate(List<INode> nodes, Predicate<INode> predicate) {
        return flattenTheList(nodes)
                .filter(predicate)
                .findFirst()
                .orElse(null);
    }

    private Stream<INode> flattenTheList(List<INode> nodes) {
        return nodes
                .stream()
                .flatMap(t-> isIComposite(t)?Stream.concat(flattenTheList(castNodeToICompositeAndReturnGetNodes(t)), Stream.of(t)):Stream.of(t));
    }


    private int countNodesFromTheList(List<INode> nodes) {
        if (nodes == null) return 0;
        return nodes.size() + nodes.stream()
                .filter(MyStructure::isIComposite)
                .map(this::castNodeToICompositeAndReturnGetNodes)
                .mapToInt(this::countNodesFromTheList)
                .sum();
    }

    private static boolean isIComposite(Object o) {
        return o instanceof ICompositeNode;
    }

    private List<INode> castNodeToICompositeAndReturnGetNodes(INode iNode) {
        return ((ICompositeNode) iNode).getNodes();
    }

    public void setNodes(List<INode> nodes) {
        this.nodes = nodes;
    }

    public List<INode> getNodes() {
        return nodes;
    }
}

