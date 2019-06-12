package view;

import app.MyApplication;

public class DepositView {
    private MyApplication application;
    public DepositView(MyApplication application) {
        this.application = application;
    }

    public void initComponent(){

    }

    public MyApplication getApplication() {
        return application;
    }

    public void setApplication(MyApplication application) {
        this.application = application;
    }
}
