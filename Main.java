import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    // ciao, questa è una prova
    System.out.println("Cifriamo il nostro testo e trasformiamolo in un testo segreto! \n");
    Matrice m = new Matrice("PROVA");
    Vigenere v = new Vigenere(0, 12, 0, 12, m);
    Vigenere v1 = new Vigenere(12, 26, 0, 12, m);
    Vigenere v2 = new Vigenere(0, 12, 12, 26, m);
    Vigenere v3 = new Vigenere(12, 26, 12, 26, m);
    Thread t = new Thread(v);
    Thread t1 = new Thread(v1);
    Thread t2 = new Thread(v2);
    Thread t3 = new Thread(v3);
    t.start();
    t1.start();
    t2.start();
    t3.start();
    try {
      t.join();
      t1.join();
      t2.join();
      t3.join();
    } catch (InterruptedException e) {
      System.err.println("Errore nel metodo join");
    }

    m.stampa();
    
    Scanner input = new Scanner(System.in);
    System.out.println("\n Inserisci il testo in chiaro: ");
    String testo_chiaro = input.nextLine();
    String testo_cifrato = m.cifra(testo_chiaro);
    System.out.println("\n");
    System.out.println(testo_cifrato);
  }
}