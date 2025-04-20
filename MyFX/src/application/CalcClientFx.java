package application;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.Stage;

public class CalcClientFx extends Application {

	@Override
	public void start(Stage mystage) throws Exception {
		TextField numTf01 = new TextField();
		TextField numTf02 = new TextField();
		ComboBox<String> opbox = new ComboBox<>();

		opbox.getItems().addAll("+", "-", "*", "/");
		opbox.setValue("+");

		Button sendButton = new Button("계산  결과 ");
		Label result = new Label(" 결과  : - ");

		sendButton.setOnAction(e -> {
			try {
				double a = Double.parseDouble(numTf01.getText());
				double b = Double.parseDouble(numTf02.getText());
				String op = opbox.getValue();

				SendData response = sendDataServer(new SendData(a,b,op)); 
				
				result.setText("결과 : "+response.getResult());
			}catch(Exception ei) {
				ei.printStackTrace();
				
			}
		});

		GridPane grid = new GridPane();
		grid.setVgap(10);
		grid.setHgap(10);
		grid.add(new Label("숫 자 1:"), 0, 0);
		grid.add(numTf01, 1, 0);
		grid.add(new Label("숫 자 2:"), 0, 1);
		grid.add(numTf02, 1, 2);
		grid.add(sendButton, 0, 3, 2, 1);
		grid.add(result, 0, 4, 2, 1);
		
		
		Scene scene = new Scene(grid, 300, 200);
		mystage.setScene(scene);
		mystage.setTitle("계산기 클라이언트");
		mystage.show();

	}
	private SendData sendDataServer(SendData data) throws UnknownHostException, IOException, ClassNotFoundException {
		try(
				Socket sc = new Socket("localhost",7777);
				ObjectOutputStream oos = new ObjectOutputStream(sc.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(sc.getInputStream());
				Scanner input = new Scanner(System.in);
			){
				//객체에 값을 담고 서버로 전송 
				oos.writeObject(data);
				oos.flush();
				
				// 서버로부터 리턴받은 결과값 출력 
				return (SendData) ois.readObject();				
			}
	}
	public static void main(String[] args) {
		launch(args);
	}

}
