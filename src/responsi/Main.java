package responsi;

public class Main {
    public void mvc(){
        ViewTrans viewTrans = new ViewTrans();
        ModelTrans modelTrans = new ModelTrans();
        ControllerTrans controllerTrans = new ControllerTrans(modelTrans, viewTrans);
    }
    public static void main(String[] args) {
        Main v = new Main();
        v.mvc();
    }
}
