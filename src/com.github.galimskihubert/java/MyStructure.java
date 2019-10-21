import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MyStructure implements IMyStructure {

    private List<INode> nodes;

    public INode findByRenderer(String renderer) {
        if (renderer == null) {
            throw new IllegalArgumentException("Parameter is null");
        }
        return checkTheList(renderer, Type.RENDERER);
    }

    public INode findByCode(String code) {
        if (code == null) {
            throw new IllegalArgumentException("Parameter is null");
        }
        return checkTheList(code, Type.CODE);
    }

    public int count() {
        boolean changed = true;
        List<INode> list = new ArrayList<>(nodes);
        List<INode> temporaryList;
        int startFrom = 0;
        while (changed) {
            temporaryList = new ArrayList<>();
            ListIterator<INode> listIterator = list.listIterator(startFrom);
            while (listIterator.hasNext()) {
                INode temporaryINode = listIterator.next();
                if (temporaryINode instanceof ICompositeNode) {
                    temporaryList.addAll(((ICompositeNode) temporaryINode).getNodes());
                }
            }
            if (temporaryList.isEmpty()) {
                changed = false;
            } else {
                startFrom = list.size();
                list.addAll(temporaryList);
            }
        }
        return list.size();
    }


    private INode checkTheList(String string, Type type) {
        boolean changed = true;
        List<INode> list = new ArrayList<>(nodes);
        List<INode> temporaryList;
        while (changed) {
            temporaryList = new ArrayList<>();
            ListIterator<INode> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                INode temporaryINode = listIterator.next();
                if (matchesSearchCriteria(string, type, temporaryINode)) {
                    return temporaryINode;
                }
                if (temporaryINode instanceof ICompositeNode) {
                    temporaryList.addAll(((ICompositeNode) temporaryINode).getNodes());
                }
            }
            if (temporaryList.isEmpty()) {
                changed = false;
            } else list = temporaryList;
        }
        return null;
    }

    private boolean matchesSearchCriteria(String string, Type type, INode temporaryINode) {
        if (type.equals(Type.CODE)) {
            return temporaryINode.getCode().equals(string);
        } else if (type.equals(Type.RENDERER)) {
            return temporaryINode.getRenderer().equals(string);
        }
        return false;
    }


    public void setNodes(List<INode> nodes) {
        this.nodes = nodes;
    }


    private enum Type {
        CODE, RENDERER
    }
}

