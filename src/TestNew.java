
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestNew extends Application {
    
	private static String newLine = System.lineSeparator();
	
	public static Stage mainWindow;
	public static Parent idWindow, afterLogWindow, mainWin;
	public static Scene idScene, afterLogScene, mainScene;
	public static String userName;
	
	public static Stage addTS;
	public static Parent infoWindow, qaWindow, testWindow, logWindow;
	public static Scene infoScene, qaScene, testScene, logScene;
	public static boolean tsOpen = false;
	
	public static Stage remindFX, showTS;
	public static Parent remindWindow, tsWindow;
	public static Scene remindScene, tsScene;
	
	public static String TS = "";
	public static String log = "";
	
    public static void main(String[] args) {
        Application.launch();
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
    	mainWindow = primaryStage;
    	
    	idWindow = FXMLLoader.load(getClass().getResource("TestFX.fxml"));
    	afterLogWindow = FXMLLoader.load(getClass().getResource("AfterLogin.fxml"));
    	mainWin = FXMLLoader.load(getClass().getResource("mainWinSetup.fxml"));
    	
        idScene = new Scene(idWindow, 600, 400);
        afterLogScene = new Scene(afterLogWindow, 450, 150);
        mainScene = new Scene(mainWin, 400, 400);
        
        infoWindow = FXMLLoader.load(getClass().getResource("infoTS.fxml"));
    	qaWindow = FXMLLoader.load(getClass().getResource("qaTS.fxml"));
    	testWindow = FXMLLoader.load(getClass().getResource("testTS.fxml"));
    	logWindow = FXMLLoader.load(getClass().getResource("logTS.fxml"));
    	remindWindow = FXMLLoader.load(getClass().getResource("RemindFX.fxml"));
    	tsWindow = FXMLLoader.load(getClass().getResource("showTS.fxml"));
        
        infoScene = new Scene(infoWindow, 400, 100);
        qaScene = new Scene(qaWindow, 400, 100);
        testScene = new Scene(testWindow, 400, 100);
        logScene = new Scene(logWindow, 400, 100);
        remindScene = new Scene(remindWindow, 200, 400);
        tsScene = new Scene(tsWindow, 400, 350);
        
        addTS  = new Stage();
        addTS.setResizable(false);
        
        mainWindow.setTitle("Created by Sahar Hayun");
        mainWindow.setResizable(false);
        mainWindow.setScene(idScene);
        mainWindow.show();
        
    }
    
    public static void sucLog() {
    	mainWindow.hide();
    	mainWindow.setScene(afterLogScene);
    	mainWindow.show();
    	try {
    		//mainWindow.wait(5);
    		mainWindow.hide();
    		mainWindow.setScene(mainScene);
    		mainWindow.show();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public static void addInfo() {
    	if(tsOpen)
    		return;
    	tsOpen = true;
    	addTS.setTitle("INFO");
    	addTS.setScene(infoScene);
    	addTS.show();
    }
    
    public static void addQA() {
    	if(tsOpen)
    		return;
    	tsOpen = true;
    	addTS.setTitle("QA");
    	addTS.setScene(qaScene);
    	addTS.show();
    }
    
    public static void addTest() {
    	if(tsOpen)
    		return;
    	tsOpen = true;
    	addTS.setTitle("TEST");
    	addTS.setScene(testScene);
    	addTS.show();
    }
    
    public static void addLog() {
    	if(tsOpen)
    		return;
    	tsOpen = true;
    	addTS.setTitle("LOG");
    	addTS.setScene(logScene);
    	addTS.show();
    }
    
    public static void addRemind() {
    	if(tsOpen)
    		return;
    	tsOpen = true;
    	addTS.setTitle("Remind");
    	addTS.setScene(remindScene);
    	addTS.show();
    }
    
    public static void editTS() {
    	if(tsOpen)
    		return;
    	tsOpen = true;
    	addTS.setTitle("TS");
    	addTS.setScene(tsScene);
    	addTS.show();
    }
    
    public static void finish(String ServiceTag, String Name, String last, String Phone, String Email, String Issue, String Started, String City, String Address) {
    	
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd");
    	LocalDate localDate = LocalDate.now();
    	
    	if(ServiceTag.isEmpty())
    		ServiceTag = "N/A";
    	if(Name.isEmpty())
    		Name = "N/A";
    	if(last.isEmpty())
    		last = "N/A";
    	if(Phone.isEmpty())
    		Phone = "N/A";
    	else if(Phone.charAt(0) == '0' && Phone.charAt(1) == '5') {
			Phone.replaceFirst("05", "+972");
		}
    		
    	if(Email.isEmpty())
    		Email = "N/A";
    	if(Issue.isEmpty())
    		Issue = "N/A";
    	if(Started.isEmpty())
    		Started = "N/A";
    	if(log.isEmpty())
    		log = "";
    	if(TS.isEmpty())
    		TS = "";
    	if(!new File("C:\\Users\\sahar.hayun\\Desktop\\SRs\\" + dtf.format(localDate)).mkdirs()) {
        	try {
            	Files.createDirectories(Paths.get("C:\\Users\\sahar.hayun\\Desktop\\SRs\\" + dtf.format(localDate)));
            	}catch(Exception e) {
            		System.out.println("ERROR");
            	}
    	}
    	File file = new File("C:\\Users\\sahar.hayun\\Desktop\\SRs\\" + dtf.format(localDate) + "\\" + Name + " " + ServiceTag + ".txt");
    	String toFile = "ServiceTag: " + ServiceTag + newLine + "Name: " + Name + " " + last + newLine + "Phone: " + Phone + newLine + "Email: " + Email + newLine + newLine + "Issue: " + Issue + newLine + newLine + "Issue Started: " + Started + newLine + newLine + "TS" + newLine + TS + newLine + newLine + "LOG" + newLine + log + newLine + newLine + City + ", " + Address;
    	try {
    		file.createNewFile();
    		BufferedWriter write = new BufferedWriter(new FileWriter(file));
    		write.write(toFile);
    		write.close();
    	}catch(Exception e) {
    		System.out.println("ERROR");
    		e.printStackTrace();
    	}
    }
    
    public static void findReminders(String Name, String ServiceTag, String last, String Phone, String Email, String Issue, String Started) {
    	
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd");
    	LocalDate localDate = LocalDate.now();
    	
    	File file = new File("C:\\Users\\sahar.hayun\\Desktop\\Reminders\\" + Name + " " + ServiceTag + " " + dtf.format(localDate) + ".txt");
    	if(ServiceTag.isEmpty())
    		ServiceTag = "N/A";
    	if(Name.isEmpty())
    		Name = "N/A";
    	if(last.isEmpty())
    		last = "N/A";
    	if(Phone.isEmpty())
    		Phone = "N/A";
    	else if(Phone.charAt(0) == '0' && Phone.charAt(1) == '5') {
			Phone.replaceFirst("05", "+972");
		}
    		
    	if(Email.isEmpty())
    		Email = "N/A";
    	if(Issue.isEmpty())
    		Issue = "N/A";
    	if(Started.isEmpty())
    		Started = "N/A";
    	String toFile = "ServiceTag: " + ServiceTag + newLine + "Name: " + Name + " " + last + newLine + "Phone: " + Phone + newLine + "Email: " + Email + newLine + newLine + "Issue: " + Issue + newLine + newLine + "Issue Started: " + Started;
    	try {
    		file.createNewFile();
    		BufferedWriter write = new BufferedWriter(new FileWriter(file));
    		write.write(toFile);
    		write.close();
    	}catch(Exception e) {
    		System.out.println("ERROR");
    		e.printStackTrace();
    	}
    }
    
    public static void remind(String day, String month, String year, String text, String name, String st) {
    	
    	File file = new File("C:\\Users\\sahar.hayun\\Desktop\\Reminders\\" + name + " " + st + " " + day + "/" + month + "/" + year + ".txt");
    	
    	String toFile = "ServiceTag: " + st + newLine + "Name: " + name + newLine + "Text: " + text;
    	try {
    		file.createNewFile();
    		BufferedWriter write = new BufferedWriter(new FileWriter(file));
    		write.write(toFile);
    		write.close();
    	}catch(Exception e) {
    		System.out.println("ERROR");
    		e.printStackTrace();
    	}
    	
    }
    

    
}
