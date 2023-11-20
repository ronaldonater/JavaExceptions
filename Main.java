import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        String url;

        try {
            File myFile = new File("WebpageData.txt");
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            }
        } catch (IOException e) {
            System.out.println("Error occurred while creating the file.");
            e.printStackTrace();
            return;
        }

        try {
            Scanner linkScanner = new Scanner(System.in);
            System.out.println("Please enter the link of the Web Page you'd like to gather the data from: ");
            url = linkScanner.nextLine();
            if (url == null || url.isEmpty()) {
                throw new InputMismatchException("Invalid input.");
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            return;
        }

        URL pageLocation;
        try {
            pageLocation = new URL(url);
        } catch (Exception e) {
            System.out.println("This URL is invalid: " + url);
            return;
        }

        System.out.println("Saving data to WebpageData.txt");
        System.out.println("Protocol: " + pageLocation.getProtocol());
        System.out.println("Host Name: " + pageLocation.getHost());
        System.out.println("File Name: " + pageLocation.getFile());

        try (FileWriter myWriter = new FileWriter("WebpageData.txt")) {
            myWriter.write("Protocol: " + pageLocation.getProtocol() + "\n");
            myWriter.write("Host: " + pageLocation.getHost() + "\n");
            myWriter.write("File name: " + pageLocation.getFile() + "\n");
            System.out.println("Data successfully saved to WebpageData.txt");
        } catch (IOException e) {
            System.out.println("An error has occurred while writing to the file WebpageData.txt");
            e.printStackTrace();
        }
    }
}