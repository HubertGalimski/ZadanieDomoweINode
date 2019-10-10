import org.w3c.dom.Node;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyStructure implements IMyStructure {


    private List<INode> nodes;

    public static boolean isIComposite(Object o) {
        return o instanceof ICompositeNode;
    }

    public INode findByCode(String code) {
        return findBy(code, t -> t.getCode().equals(code));

    }

    public INode findByRenderer(String renderer) {
        return findBy(renderer, t -> t.getRenderer().equals(renderer));
    }

    private INode findBy(String stringToFind, Predicate<INode> codeForFilter) {
        if (stringToFind == null) {
            throw new IllegalArgumentException("Parameter is null");
        }
        return toStream().filter(codeForFilter).findFirst().orElse(null);
    }

    private Stream<INode> toStream() {
        return nodes.stream();
    }

    public void setNodes(List<INode> nodes) {
        this.nodes = nodes;
    }

    public int count() {
        return countNode(nodes);
    }

    public ICompositeNode toICompositeNode(INode iNode) {
        return ((ICompositeNode) iNode);
    }

    public int countNode(List<INode> nodes) {
        if (nodes == null) return 0;
        int childrenNodes = nodes.stream()
                .filter(MyStructure::isIComposite)
                .map(this::toICompositeNode)
                .map(ICompositeNode::getNodes)
                .mapToInt(this::countNode)
                .sum();
        return nodes.size() + childrenNodes;
    }
}

