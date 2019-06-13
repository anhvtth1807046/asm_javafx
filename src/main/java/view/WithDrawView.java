package view;

import app.MyApplication;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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
