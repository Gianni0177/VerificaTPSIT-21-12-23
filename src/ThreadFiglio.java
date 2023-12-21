import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ThreadFiglio implements Runnable{

    @Override
    public void run() {
        
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("contatore.txt"));
            bw.write("");
            bw.close();

        
            if(Thread.currentThread().getName().equals("Pari")){

                Thread tf1 = new Thread(new ThreadAggiuntivo());
                tf1.setName("Thread aggiuntivo creato da " + Thread.currentThread().getName());
                tf1.start();

            
                BufferedReader br = new BufferedReader(new FileReader("numeri.txt"));

                String r = br.readLine();

                int t1c = 0;

                while (r != null) {
                    
                    if (Integer.parseInt(r) %2 == 0) {
                        
                        System.out.println("\tThread " + Thread.currentThread().getName() + " : " + r);
                        t1c++;
                    }

                    r = br.readLine();
                }

                BufferedWriter bw1 = new BufferedWriter(new FileWriter("contatore.txt", true));
                bw1.write(Thread.currentThread().getName() + "[" + t1c + "]\n");
                
                br.close();
                bw1.close();
            }

            if (Thread.currentThread().getName().equals("Dispari")) {

                Thread tf2 = new Thread(new ThreadAggiuntivo());
                tf2.setName("Thread aggiuntivo creato da " + Thread.currentThread().getName());
                tf2.start();

                BufferedReader br1 = new BufferedReader(new FileReader("numeri.txt"));

                String r1 = br1.readLine();

                int t2c = 0;

                while (r1 != null) {
                    
                    if (Integer.parseInt(r1) %2 != 0) {
                        
                        System.out.println("\t\tThread " + Thread.currentThread().getName() + " : " + r1);
                        t2c++;
                    }

                    r1 = br1.readLine();
                }

                BufferedWriter bw1 = new BufferedWriter(new FileWriter("contatore.txt", true));
                bw1.write(Thread.currentThread().getName() + "[" + t2c + "]\n");
                
                br1.close();
                bw1.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
