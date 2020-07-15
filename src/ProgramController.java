import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ProgramController {
	
	private static String newLine = System.lineSeparator();
	public static Runtime rt = Runtime.getRuntime();
	
    @FXML
    private TextField getUsername;

    @FXML
    private PasswordField getPassword;

    @FXML
    void setPasswordAction(ActionEvent event) {
    	authEnter();
    }

    @FXML
    void setUsernameAction(ActionEvent event) {
    	authEnter();
    }
    
    public void authEnter() {
    	if(getUsername.getText().equals("Sahar") && getPassword.getText().equals("rahaS")) {
    		TestNew.userName = "Sahar Hayun";
    		TestNew.sucLog();
    	}
    }
    
    @FXML
    void infoAction(ActionEvent event) {
    	TestNew.addInfo();
    }

    @FXML
    void qaAction(ActionEvent event) {
    	TestNew.addQA();
    }

    @FXML
    void testAction(ActionEvent event) {
    	TestNew.addTest();
    }
    
    @FXML
    private TextArea questionID;
    
    @FXML
    private TextArea answerID;

    @FXML
    void QAcancelButton(ActionEvent event) {
    	TestNew.addTS.hide();
    	TestNew.tsOpen = false;
    }

    @FXML
    void QAfinishButton(ActionEvent event) {
    	TestNew.TS += newLine + "Question: " + questionID.getText() + newLine + "Answer: " + answerID.getText();
    	TestNew.tsOpen = false;
    	questionID.setText("");
    	answerID.setText("");
    	TestNew.addTS.hide();
    }
    
    @FXML
    void TSreset(ActionEvent event) {
    	TestNew.TS = "";
    	TestNew.log = "";
    }
    
    @FXML
    private TextArea testID;

    @FXML
    private TextArea resultID;

    @FXML
    void TESTcancelButton(ActionEvent event) {
    	TestNew.addTS.hide();
    	TestNew.tsOpen = false;
    }

    @FXML
    void TESTfinishButton(ActionEvent event) {
    	TestNew.TS += newLine + "Test: " + testID.getText() + newLine + "Result: " + resultID.getText();
    	TestNew.tsOpen = false;
    	testID.setText("");
    	resultID.setText("");
    	TestNew.addTS.hide();
    }
    
    @FXML
    private TextArea infoID;

    @FXML
    void INFOcancelButton(ActionEvent event) {
    	TestNew.addTS.hide();
    	TestNew.tsOpen = false;
    }

    @FXML
    void INFOfinishButton(ActionEvent event) {
    	TestNew.TS += newLine + "Info: " + infoID.getText();
    	TestNew.tsOpen = false;
    	infoID.setText("");
    	TestNew.addTS.hide();
    }
    
    @FXML
    private TextField nameID;

    @FXML
    private TextField lastID;

    @FXML
    private TextField phoneID;

    @FXML
    private TextField emailID;

    @FXML
    private TextField issueID;

    @FXML
    private TextField startedID;
    
    @FXML
    private TextField cityID;

    @FXML
    private TextField addressID;
    
    @FXML
    void finishAction(ActionEvent event) {
    	TestNew.finish(stID.getText(),nameID.getText() , lastID.getText(), phoneID.getText(), emailID.getText(), issueID.getText(), startedID.getText(), cityID.getText(), addressID.getText());
    }
    
    @FXML
    private TextField stID;
    
    @FXML
    void gotoButton(ActionEvent event) {
		String url = "http://www.dell.com/support/home/us/en/04/product-support/servicetag/" + stID.getText() + "/diagnose";
		try {
		rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
		}catch(Exception e) {
			e.printStackTrace();
		}
    }
    

    @FXML
    void resetButton(ActionEvent event) {
    	nameID.setText("");
    	lastID.setText("");
    	phoneID.setText("");
    	emailID.setText("");
    	issueID.setText("");
    	startedID.setText("");
    	stID.setText("");
    	cityID.setText("");
    	addressID.setText("");
    	TestNew.log = "";
    	TestNew.TS = "";
    }
    

    @FXML
    void logAction(ActionEvent event) {
    	TestNew.addLog();
    }
    
    @FXML
    private TextArea logID;

    @FXML
    void LOGcancelButton(ActionEvent event) {
    	TestNew.addTS.hide();
    	logID.setText(TestNew.log);
    	TestNew.tsOpen = false;
    }

    @FXML
    void LOGfinishAction(ActionEvent event) {
    	TestNew.log = logID.getText();
    	logID.setText("");
    	TestNew.tsOpen = false;
    	TestNew.addTS.hide();
    }
    
    @FXML
    void remindAction(ActionEvent event) {
    	TestNew.addRemind();
    }
    
    @FXML
    private MenuButton dayID;

    @FXML
    private MenuButton monthID;

    @FXML
    private TextField yearID;

    @FXML
    private TextArea remindID;

    @FXML
    private TextField remindNameID;

    @FXML
    private TextField remindStID;

    @FXML
    void REMINDcancelButton(ActionEvent event) {
    	TestNew.tsOpen = false;
    	TestNew.addTS.hide();
    }

    @FXML
    void REMINDfinishButton(ActionEvent event) {
    	TestNew.remind(dayID.getId(), monthID.getId(), yearID.getText(), remindID.getText(), remindNameID.getText(), remindStID.getText());
    	TestNew.tsOpen = false;
    	TestNew.addTS.hide();
    }
    
    @FXML
    private TextArea TStextID;
    
    @FXML
    void TScancelButton(ActionEvent event) {
    	TestNew.tsOpen = false;
    	TestNew.addTS.hide();
    }

    @FXML
    void TSfinishButton(ActionEvent event) {
    	TestNew.TS = TStextID.getText();
    	TStextID.setText("");
    	TestNew.tsOpen = false;
    	TestNew.addTS.hide();
    }
    
    @FXML
    void TSedit(ActionEvent event) {
    	TestNew.editTS();
    }
    
    @FXML
    void TSshowButton(ActionEvent event) {
    	TStextID.setText(TestNew.TS);
    }

}
