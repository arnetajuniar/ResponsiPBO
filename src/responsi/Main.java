package responsi;

public class Main {
    
    public void main(){
        ViewTrans viewTrans = new ViewTrans();
        ModelTrans modelTrans = new ModelTrans();
        ControllerTrans controllerTrans = new ControllerTrans(modelTrans, viewTrans);
    }
    public static void main(String[] args) {
        ViewTrans viewTrans = new ViewTrans();
        ModelTrans modelTrans = new ModelTrans();
        ControllerTrans controllerTrans = new ControllerTrans(modelTrans, viewTrans);
    }
}
