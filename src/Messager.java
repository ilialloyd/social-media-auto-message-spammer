import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: ${USER}
 * Date: ${DATE}
 * Leave your comment below if you have
 * --------------------------------------------------------
 */
public class Messager {
    public static void main(String[] args) throws AWTException, InterruptedException {

        //message start Count
        int messageRepeatedStart = 0;

        //spam start count
        int spamStartingSecond = 5;


        Robot robot = new Robot();

        //this defines how many times do you want to send message
        Scanner sc = new Scanner(System.in);
        System.out.println("How many times do you want to send the text:");
        int messageRepeatingTime=sc.nextInt();

        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        System.out.println("Enter the text:");
        String text = scanner.nextLine();
        scanner.close();

        //it transfers simple js in a plain text, so
        // we can easily copy it to our clipboard
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection,null);

        System.out.println("Spamming will start in a 5 seconds");

        System.out.println("Put your cursor in a window, place, social media page you want to write");

        while(spamStartingSecond>=1){

            System.out.print(spamStartingSecond);
            Thread.sleep(1000);
            spamStartingSecond--;
        }

        System.out.println("...");
        while(messageRepeatedStart<messageRepeatingTime) {

            Thread.sleep(1000);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            messageRepeatedStart++;
        }

        System.out.println("Process finished. If you want to repeat, start again!");
    }
}