public class InodeImp implements INode {
    String code;
    String render;

    public InodeImp(String code, String render) {
        this.code = code;
        this.render = render;
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
