package view;

import app.MyApplication;
import entity.Account;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class DepositView {
    private MyApplication application;

    private VBox vBoxChild;
    private Label lblBalance, lblUsername, lblError, lblSuccess;
    private TextField txtAmount;
    private Button btnSubmit, btnBack;
    private AnchorPane rootPane;

    public DepositView(MyApplication application) {
        this.application = application;
        this.rootPane = application.getRootPane();
        initComponent();
    }

    public void initComponent(){
        this.vBoxChild = new VBox();
        if (MyApplication.currentLogin != null){
            this.lblUsername = new Label("Khách hàng: " + MyApplication.currentLogin.getFullName());
            this.lblBalance = new Label( "Số dư: " + MyApplication.currentLogin.getBalance());
            this.txtAmount = new TextField();

            this.btnSubmit = new Button("Rút tiền");
            this.btnBack = new Button("Quay lại");
            this.btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Account a = MyApplication.currentLogin;
                    if(a.deposit(Double.parseDouble(txtAmount.getText())) > MyApplication.currentLogin.getBalance()){
                        lblSuccess = new Label("Gửi tiền thành công!");
                        vBoxChild.getChildren().add(lblSuccess);
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        rootPane.getChildren().clear();
                        rootPane.getChildren().add(application.getMenuView().getvBoxChild());
                        return;
                    }
                    lblError = new Label("Co loi xay ra vui long thu lai!");
                    vBoxChild.getChildren().add(lblError);
                }
            });

            this.btnBack.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    rootPane.getChildren().clear();
                    rootPane.getChildren().add(application.getMenuView().getvBoxChild());
                }
            });
            vBoxChild.getChildren().addAll(this.lblUsername, this.lblBalance, this.btnSubmit, this.btnBack);
        }
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

    public Label getLblBalance() {
        return lblBalance;
    }

    public void setLblBalance(Label lblBalance) {
        this.lblBalance = lblBalance;
    }

    public Label getLblUsername() {
        return lblUsername;
    }

    public void setLblUsername(Label lblUsername) {
        this.lblUsername = lblUsername;
    }

    public TextField getTxtAmount() {
        return txtAmount;
    }

    public void setTxtAmount(TextField txtAmount) {
        this.txtAmount = txtAmount;
    }

    public Button getBtnSubmit() {
        return btnSubmit;
    }

    public void setBtnSubmit(Button btnSubmit) {
        this.btnSubmit = btnSubmit;
    }

    public Button getBtnBack() {
        return btnBack;
    }

    public void setBtnBack(Button btnBack) {
        this.btnBack = btnBack;
    }

    public Label getLblError() {
        return lblError;
    }

    public void setLblError(Label lblError) {
        this.lblError = lblError;
    }

    public Label getLblSuccess() {
        return lblSuccess;
    }

    public void setLblSuccess(Label lblSuccess) {
        this.lblSuccess = lblSuccess;
    }

    public AnchorPane getRootPane() {
        return rootPane;
    }

    public void setRootPane(AnchorPane rootPane) {
        this.rootPane = rootPane;
    }
}
