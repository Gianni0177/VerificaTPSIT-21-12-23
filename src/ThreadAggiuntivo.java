import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ThreadAggiuntivo implements Runnable{

    @Override
    public void run() {
        
        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
            bw.write("");

            BufferedReader br = new BufferedReader(new FileReader("nomi.txt"));

            String r = br.readLine();

            if (Thread.currentThread().getName().equals("Thread aggiuntivo creato da Pari")) {
                
                Thread.currentThread().setName(r);
            }

            r = br.readLine();

            if (Thread.currentThread().getName().equals("Thread aggiuntivo creato da Dispari")) {

                Thread.currentThread().setName(r);
            }

            System.out.println("\t\t\t" + Thread.currentThread().getName() + " ha iniziato la sua esecuzione\n");

            BufferedWriter bw1 = new BufferedWriter(new FileWriter("output.txt"));
            
            for (int i = 110; i <= 150; i++) {
                    
                if (i != 150) {

                    bw1.write(i + " - ");
                }else{

                    bw1.write(i + "\n");
                }   
                bw1.flush();
                Thread.sleep(100);
            }

            System.out.println("\t\t\t" + Thread.currentThread().getName() + " ha terminato la sua esecuzione\n");

            bw.close();
            br.close();
            bw1.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    
}
