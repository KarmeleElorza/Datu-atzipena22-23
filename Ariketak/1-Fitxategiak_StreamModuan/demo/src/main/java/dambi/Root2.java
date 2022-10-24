/** Programa honek i aldagaian gordeta dagoen zenbakiaren (Kasu honetan 2 zenbakia) erro karratua kalkulatu eta erakusten du formatu berezian.
*/
package dambi;

public class Root2 {
    public static void main(String[] args) {
        int i = 2;
        double r = Math.sqrt(i);
        
        System.out.format("The square root of %d is %f.%n", i, r);
    }
}
