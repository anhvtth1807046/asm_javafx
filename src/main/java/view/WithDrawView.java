package view;

import app.MyApplication;

public class WithDrawView {
    private MyApplication application;
    public WithDrawView(MyApplication application) {
        this.application = application;
    }

    public MyApplication getApplication() {
        return application;
    }

    public void setApplication(MyApplication application) {
        this.application = application;
    }
}
