package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


// 이름 주소 전번 받아서 버튼 클릭하면 입력 내용 출력

public class HelloFX02 extends Application {
    
	
	private Button createButton() {
		
		Button bt = new Button("Hello JAVA FX 내꺼 ");
		return bt;
	}
	
	@Override
    public void start(Stage stage) {
		
		
		
		Label lb_name = new Label("이름 : ");
		TextField tx_name = new TextField();
		
		Label lb_addr = new Label("주소 : ");
		TextField tx_addr = new TextField();
		
		Label lb_phone = new Label("전화번호 : ");
		TextField tx_phone = new TextField();
		
		Button bt = new Button("확인");
		
		
		Button bt_cancel = new Button("입력 초기화");
		
		Label res_message = new Label();
		
		bt_cancel.setOnAction(e->{
			
			tx_name.setText("");
			tx_addr.setText("");
			tx_phone.setText("");
			
			res_message.setText("");
		});
		
		bt.setOnAction(e->{
			
			String res_name = tx_name.getText();
			String res_addr = tx_addr.getText();
			String res_phone = tx_phone.getText();
			
			String format_res = String.format("입력한 내용\n 이름 : %10s 주소 : %10s 번호 : %10s", 
										res_name, res_addr, res_phone);
			
			res_message.setText(format_res);
			
		});
		
		VBox root = new VBox();
		root.getChildren().addAll(
				lb_name, tx_name, lb_addr, tx_addr, lb_phone, tx_phone,
				bt, bt_cancel, res_message
				
				);
		
		root.setSpacing(10.0d);
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(40));
		

        stage.setScene(new Scene(root, 500, 500));
        stage.setTitle("JavaFX 테스트");
        stage.show();
    }
	
	
    public static void main(String[] args) {
        launch(args);
    }
}
