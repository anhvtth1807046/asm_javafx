package view;

import app.MyApplication;

public class TransferView {
    private MyApplication application;
    public TransferView(MyApplication application) {
        this.application = application;
    }

    public MyApplication getApplication() {
        return application;
    }

    public void setApplication(MyApplication application) {
        this.application = application;
    }
}
