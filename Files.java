import java.io.*;
import java.util.ArrayList;

public class Files {
  public static FileReader fileReader;
  public static FileWriter fileWriter;
  public static BufferedReader reader;
  public static PrintWriter printWriter;

  public void createFile(File file) {
    try {
      file.createNewFile();
    } catch (IOException e) {}
  }

  public void writeToFile(File file, String string) {
    try {
      fileWriter = new FileWriter(file, false);
      printWriter = new PrintWriter(fileWriter);
      printWriter.println(string);
      printWriter.flush();
      printWriter.close();
    } catch (IOException e) {}
      
  }

  public void appendToFile(File file, String string) {
    try {
      fileWriter = new FileWriter(file, true);
      printWriter = new PrintWriter(fileWriter);
      printWriter.println(string);
      printWriter.flush();
      printWriter.close();
    } catch (IOException e) {}
  }

  public void readLineFromFile(File file, ArrayList<String> list) {
    try {
      fileReader = new FileReader(file);
      reader = new BufferedReader(fileReader);
      String line;
      try {
        while ((line = reader.readLine()) != null) {
          list.add(line);
        }
        fileReader.close();
      } catch (IOException e) {}
    } catch (FileNotFoundException e) {
      createFile(file);
    }   
  }
}