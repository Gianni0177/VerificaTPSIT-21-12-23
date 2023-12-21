import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("prova.txt"));
            bw.write("");
            bw.close();

        
            Thread t = Thread.currentThread();
            t.setName("Thread Principale");

            System.out.println("\n"+Thread.currentThread().getName() + " ha iniziato\n");

            Thread t1 = new Thread(new ThreadFiglio(), "Pari");
            t1.start();

            Thread t2 = new Thread(new ThreadFiglio(), "Dispari");
            t2.start();

            BufferedWriter bw1 = new BufferedWriter(new FileWriter("prova.txt", true));
            
            for (int i = 21; i <= 48; i++) {
                bw1.write("Numero " + i + "\n");
                bw1.flush();

                Thread.sleep(100);
            }

            bw1.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n" + Thread.currentThread().getName() + " ha finito\n");
 
    }
}
