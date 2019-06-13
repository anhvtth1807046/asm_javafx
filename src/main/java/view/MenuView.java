package view;

import app.MyApplication;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class MenuView {
    private MyApplication application;
    private VBox vBoxChild;
    private AnchorPane rootPane;
    private Button btnDeposit, btnWithDraw, btnTransfer;
    private Label lblUser, lblBalance;

    public MenuView(MyApplication application) {
        this.application = application;
        this.rootPane = application.getRootPane();
        initComponent();
    }

    public void initComponent(){
        this.vBoxChild = new VBox();
        this.btnDeposit = new Button("Gửi tiền");
        this.btnTransfer = new Button("Chuyển khoản");
        this.btnWithDraw = new Button("Rút tiền");
//        System.out.println(MyApplication.currentLogin.toString());
        this.btnDeposit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                application.depositView = new DepositView(application);
                rootPane.getChildren().clear();
                rootPane.getChildren().add(application.getDepositView().getvBoxChild());
            }
        });

        this.btnWithDraw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                application.withDrawView = new WithDrawView(application);
                rootPane.getChildren().clear();
                rootPane.getChildren().add(application.getWithDrawView().getvBoxChild());
            }
        });

        if (MyApplication.currentLogin != null){
            System.out.println(MyApplication.currentLogin.toString());
            this.lblUser = new Label("Khách hàng: " + MyApplication.currentLogin.getFullName());
            this.lblBalance = new Label("Số dư: " + MyApplication.currentLogin.getBalance());
            vBoxChild.getChildren().addAll(lblUser, lblBalance);
        }
        this.vBoxChild.getChildren().addAll(btnDeposit, btnWithDraw, btnTransfer);
        this.vBoxChild.setAlignment(Pos.CENTER);
        this.vBoxChild.setSpacing(10);
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

    public Button getBtnDeposit() {
        return btnDeposit;
    }

    public void setBtnDeposit(Button btnDeposit) {
        this.btnDeposit = btnDeposit;
    }

    public Button getBtnWithDraw() {
        return btnWithDraw;
    }

    public void setBtnWithDraw(Button btnWithDraw) {
        this.btnWithDraw = btnWithDraw;
    }

    public Button getBtnTransfer() {
        return btnTransfer;
    }

    public void setBtnTransfer(Button btnTransfer) {
        this.btnTransfer = btnTransfer;
    }

    public AnchorPane getRootPane() {
        return rootPane;
    }

    public void setRootPane(AnchorPane rootPane) {
        this.rootPane = rootPane;
    }

    public Label getLblBalance() {
        return lblBalance;
    }

    public void setLblBalance(Label lblBalance) {
        this.lblBalance = lblBalance;
    }

    public Label getLblUser() {
        return lblUser;
    }

    public void setLblUser(Label lblUser) {
        this.lblUser = lblUser;
    }
}
