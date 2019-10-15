import java.util.List;

public class ICompositeImp implements ICompositeNode {

    String code;
    String render;

    public ICompositeImp(String code, String render) {
        this.code = code;
        this.render = render;
    }

    List<INode>iNodes;

    @Override
    public List<INode> getNodes() {
        return iNodes;
    }

    public void setiNodes(List<INode> iNodes) {
        this.iNodes = iNodes;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getRenderer() {
        return render;
    }


}
