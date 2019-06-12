package view;

import app.MyApplication;
import javafx.scene.layout.VBox;

public class MenuView {
    private MyApplication application;
    private VBox vBoxChild;

    public MenuView(MyApplication application) {
        this.application = application;
    }

    public MyApplication getApplication() {
        return application;
    }

    public void setApplication(MyApplication application) {
        this.application = application;
    }

    public VBox getvBoxChild() {
        return vBoxChild;
    }

    public void setvBoxChild(VBox vBoxChild) {
        this.vBoxChild = vBoxChild;
    }
}
