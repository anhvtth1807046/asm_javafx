package app;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.DbHelper;
import view.*;

import java.util.HashMap;

public class MyApplication extends Application {
    private static final int APP_WIDTH = 600;
    private static final int APP_HEIGHT = 800;
    private MyApplication application;
    private Stage main_stage;
    private Scene main_scene;
    private DepositView depositView;
    private WithDrawView withDrawView;
    private TransferView transferView;

    private MenuView menuView;
    private RegisterView registerView;
    private LoginView loginView;
    private AnchorPane rootPane;

    public void start(Stage stage) throws Exception {
        DbHelper.initDb();
        this.application = this;
        this.main_stage = stage;
        this.rootPane = new AnchorPane();
        this.rootPane.setPadding(new Insets(20));
        this.depositView = new DepositView(this.application);
        this.loginView = new LoginView(this.application);
        this.withDrawView = new WithDrawView(this.application);
        this.transferView = new TransferView(this.application);
        this.menuView = new MenuView(this.application);
        this.registerView = new RegisterView(this.application);

        // Màn hình sẽ bắt đầu từ thằng login.
        rootPane.getChildren().add(loginView.getvBoxChild());
        this.main_scene = new Scene(rootPane, APP_HEIGHT, APP_WIDTH);

        this.main_stage.setScene(this.main_scene);
        this.main_stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public Stage getMain_stage() {
        return main_stage;
    }

    public void setMain_stage(Stage main_stage) {
        this.main_stage = main_stage;
    }

    public Scene getMain_scene() {
        return main_scene;
    }

    public void setMain_scene(Scene main_scene) {
        this.main_scene = main_scene;
    }

    public DepositView getDepositView() {
        return depositView;
    }

    public void setDepositView(DepositView depositView) {
        this.depositView = depositView;
    }

    public WithDrawView getWithDrawView() {
        return withDrawView;
    }

    public void setWithDrawView(WithDrawView withDrawView) {
        this.withDrawView = withDrawView;
    }

    public TransferView getTransferView() {
        return transferView;
    }

    public void setTransferView(TransferView transferView) {
        this.transferView = transferView;
    }

    public MenuView getMenuView() {
        return menuView;
    }

    public void setMenuView(MenuView menuView) {
        this.menuView = menuView;
    }

    public RegisterView getRegisterView() {
        return registerView;
    }

    public void setRegisterView(RegisterView registerView) {
        this.registerView = registerView;
    }

    public LoginView getLoginView() {
        return loginView;
    }

    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }


    public MyApplication getApplication() {
        return application;
    }

    public void setApplication(MyApplication application) {
        this.application = application;
    }


    public AnchorPane getRootPane() {
        return rootPane;
    }

    public void setRootPane(AnchorPane rootPane) {
        this.rootPane = rootPane;
    }
}
