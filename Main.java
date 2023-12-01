class Main {
  public static void main(String[] args) {
    System.out.println("Cifriamo il nostro testo e trasformiamolo in un testo segreto!");
    Matrice m = new Matrice("PrOVa");
    Vigenere v = new Vigenere(0, 12, 0, 12, m);
    Vigenere v1 = new Vigenere(13, 25, 13, 25, m);
    Thread t = new Thread(v);
    Thread t1 = new Thread(v1);
    t.start();
    t1.start();
    try {
      t.join();
      t1.join();
    } catch (InterruptedException e) {
      System.err.println("Errore nel metodo join");
    }

    m.stampa();
  }
}