import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class StringCalculatorCLI {

    private final InputStream inputStream;
    private final OutputStream outputStream;

    public StringCalculatorCLI(){
        inputStream = System.in;
        outputStream = System.out;
    }

    public StringCalculatorCLI(InputStream inputStream, OutputStream outputStream){
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }


    public void run() {
        Scanner scanner = new Scanner(inputStream);
        PrintStream out = new PrintStream(outputStream);

        out.println("Welcome");

        StringCalculator calculator = new StringCalculator();
        // Loop until the user inputs "exit"
        while (true) {
            String input = scanner.nextLine(); // Read the next line of input

            // Check if the user wants to exit
            if ("exit".equalsIgnoreCase(input)) {
                break; // Exit the loop
            }

            // Process the input
            if(input.contains("scalc '")){
                if(input.contains("//")){
                    input += scanner.nextLine();
                }
               input = input.substring(7);
               input = input.substring(0,input.length()-1);
            }
            var result = calculator.add(input);

            out.println("The result is "+result);
        }

        scanner.close();
        out.println("Exiting...");

    }
}
