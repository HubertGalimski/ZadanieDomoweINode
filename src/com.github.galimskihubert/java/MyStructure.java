import java.util.*;

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
        int i = 0;
        boolean changed = true;
        List<INode> list = new ArrayList<>(nodes);
        List<INode> temporaryList;
        while (changed) {
            temporaryList = new ArrayList<>();
            ListIterator<INode> listIterator = list.listIterator(i);
            while (listIterator.hasNext()) {
                INode temporaryINode = listIterator.next();
                if (temporaryINode instanceof ICompositeNode) {
                    temporaryList.addAll(((ICompositeNode) temporaryINode).getNodes());
                }
            }
            if (temporaryList.isEmpty()) {
                changed = false;
            } else {
                i= list.size();
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
            if (temporaryINode.getCode().equals(string))
                return true;
        } else if (type.equals(Type.RENDERER)) {
            if (temporaryINode.getRenderer().equals(string))
                return true;
        }
        return false;
    }


    public void setNodes(List<INode> nodes) {
        this.nodes = nodes;
    }


    private enum Type {
        CODE, RENDERER;
    }
}

