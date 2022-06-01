package responsi;

public class mvc {
    public void mvc1(){
        ViewTrans viewTrans = new ViewTrans();
        ModelTrans modelTrans = new ModelTrans();
        ControllerTrans controllerTrans = new ControllerTrans(modelTrans, viewTrans);
    }
}
