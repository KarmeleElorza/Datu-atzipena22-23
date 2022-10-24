/** Programa honek Math.PI(konstantea pi zenbakia gordetzen duena) dagoen zenbakia erakusten du formatu berezian.
*/
package dambi;

public class Format {
    public static void main(String[] args) {
        System.out.format("%f, %1$+020.10f %n", Math.PI);
    }
}
