package System;
import java.io.IOException;

import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.io.File;

public class Notification{

  String title, message;
  Date fecha;

  public static void main(String[] args){
    try{
      Notification n = new Notification("Titulo", "Mensaje", new Date(System.currentTimeMillis() + 60000));
      n.SendNotification();
      System.out.println("Notificación preparada para dentro de 1 minutos");
    }
    catch(IOException e){System.out.println(e);}
  }

  public Notification(String title, String message, Date fecha){
    this.title = title;
    this.message = message;
    this.fecha = fecha;
  }

  public void SendNotification() throws IOException{

    String os = System.getProperty("os.name");
    if (os.contains("Linux") || os.contains("Mac")){
      DateFormat dateFormat = new SimpleDateFormat("HH:mm M/dd/yyyy");  
      String strDate = dateFormat.format(fecha);  
      ProcessBuilder builder = new ProcessBuilder(
          "bash", "-c", 
          "echo notify-send " + title + " " + message + " | at " + strDate);
      builder.inheritIO().start();
    }
    else{
        displayTray(title, message);
      }
    }

  private void displayTray(String title, String message) throws IOException {

    DateFormat dateFormat = new SimpleDateFormat("HH:mm");  
    String time = dateFormat.format(fecha);  

    dateFormat = new SimpleDateFormat("dd/M/yyyy");  
    String date = dateFormat.format(fecha);  

    String powershellCommand = "[void] [System.Reflection.Assembly]::LoadWithPartialName('System.Windows.Forms');" +
    "$objNotifyIcon = New-Object System.Windows.Forms.NotifyIcon;" +
    "$objNotifyIcon.BalloonTipIcon = 'Info';" +
    "$objNotifyIcon.BalloonTipText = \'"+title+"\';" +
    "$objNotifyIcon.BalloonTipTitle = \'"+message+"\';" +
    "$objNotifyIcon.Visible = $True;" + 
    "$objNotifyIcon.ShowBalloonTip(500)";

    String filename = getUniqueName();
    
    java.nio.file.Path scriptPath = java.nio.file.Paths.get(filename);
    java.nio.file.Files.write(scriptPath, powershellCommand.getBytes());

    String currentDirectory = System.getProperty("user.dir");

    ProcessBuilder builder = new ProcessBuilder("cmd","/c", "schtasks", "/create", "/tn", "PowerShellTask",
    "/tr", "powershell -File " + currentDirectory + "\\Notificaciones\\" + filename,"/sc","once", "/st", time,"/sd", date, "/f" );

    builder.inheritIO().start();
 }

 private String getUniqueName(){
    DateFormat dateFormat = new SimpleDateFormat("HH_mm");  
    String time = dateFormat.format(fecha);  
    String name = "PW_" + title +time ;
    String currentDirectory = System.getProperty("user.dir");
    File checker = new File(currentDirectory+"\\Notificaciones", name);
    while(checker.exists() && name.length() <236){name +="(1)"; }
    if(name.length() > 236){name = "PW__" + title + time;}
    return name;
 }
}