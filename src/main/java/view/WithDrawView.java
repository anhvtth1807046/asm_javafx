package view;

import app.MyApplication;
import entity.Account;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class WithDrawView {
    private MyApplication application;
    private VBox vBoxChild;
    private Label lblBalance, lblUsername, lblError, lblSuccess, lblContent, lblAmount;
    private TextField txtAmount;
    private TextArea txtContent;
    private Button btnSubmit, btnBack;
    private AnchorPane rootPane;
    private HBox hBoxAmount, hBoxContent;

    public WithDrawView(MyApplication application) {
        this.application = application;
        this.rootPane = application.getRootPane();
        initComponent();
    }

    private void initComponent(){
        this.vBoxChild = new VBox();
        this.hBoxAmount = new HBox();
        this.hBoxContent = new HBox();
        this.lblUsername = new Label("Khách hàng: " + MyApplication.currentLogin.getFullName());
        this.lblBalance = new Label( "Số dư: " + MyApplication.currentLogin.getBalance());
        this.lblAmount = new Label("So dinh ban muon rut: ");
        this.lblContent = new Label("Noi dung");
        this.txtAmount = new TextField();
        this.txtContent = new TextArea();

        this.hBoxAmount.getChildren().addAll(lblAmount, txtAmount);
        this.hBoxContent.getChildren().addAll(lblContent, txtContent);

        this.btnSubmit = new Button("Rut tiền");
        this.btnBack = new Button("Quay lại");
        lblSuccess = new Label("Rut tiền thành công!");
        lblSuccess.setVisible(false);

        this.btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Account a = MyApplication.currentLogin;
                double newBalance = a.withdraw(Double.parseDouble(txtAmount.getText()), txtContent.getText());
                if(newBalance >= 50000){
                    setcurrentLoginNewBalance(lblSuccess, rootPane, application);
                    return;
                }
                lblError = new Label("Co loi xay ra vui long thu lai!");
                lblError.setTextFill(Color.RED);
                lblError.setFont(Font.font(20));
                vBoxChild.getChildren().add(lblError);
            }
        });

        setPosVboxAndSpacing(vBoxChild, this.lblUsername, this.lblBalance, this.lblSuccess, this.hBoxAmount, this.hBoxContent, this.btnSubmit, this.btnBack);
    }

    static void setPosVboxAndSpacing(VBox vBoxChild, Label lblUsername, Label lblBalance, Label lblSuccess, HBox hBoxAmount, HBox hBoxContent, Button btnSubmit, Button btnBack) {
        vBoxChild.getChildren().addAll(lblUsername, lblBalance, lblSuccess, hBoxAmount, hBoxContent, btnSubmit, btnBack);
        vBoxChild.setAlignment(Pos.CENTER);
        vBoxChild.setSpacing(10);
    }

    static void setcurrentLoginNewBalance(Label lblSuccess, AnchorPane rootPane, MyApplication application) {
        lblSuccess.setFont(Font.font(20));
        lblSuccess.setTextFill(Color.GREEN);
        lblSuccess.setVisible(true);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        rootPane.getChildren().clear();
        application.getMenuView().getLblBalance().setText("So du: " + MyApplication.currentLogin.getBalance());
        rootPane.getChildren().add(application.getMenuView().getvBoxChild());
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

    public Label getLblContent() {
        return lblContent;
    }

    public void setLblContent(Label lblContent) {
        this.lblContent = lblContent;
    }

    public Label getLblAmount() {
        return lblAmount;
    }

    public void setLblAmount(Label lblAmount) {
        this.lblAmount = lblAmount;
    }

    public TextField getTxtAmount() {
        return txtAmount;
    }

    public void setTxtAmount(TextField txtAmount) {
        this.txtAmount = txtAmount;
    }

    public TextArea getTxtContent() {
        return txtContent;
    }

    public void setTxtContent(TextArea txtContent) {
        this.txtContent = txtContent;
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

    public AnchorPane getRootPane() {
        return rootPane;
    }

    public void setRootPane(AnchorPane rootPane) {
        this.rootPane = rootPane;
    }

    public HBox gethBoxAmount() {
        return hBoxAmount;
    }

    public void sethBoxAmount(HBox hBoxAmount) {
        this.hBoxAmount = hBoxAmount;
    }

    public HBox gethBoxContent() {
        return hBoxContent;
    }

    public void sethBoxContent(HBox hBoxContent) {
        this.hBoxContent = hBoxContent;
    }
}
