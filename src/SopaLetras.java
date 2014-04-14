
import java.util.Random;
import java.io.*;

public class SopaLetras {

    public int numPalabra = 0;

    public static void main(String[] args) {

        char arrChar[][] = new char[30][30];
        Random r = new Random();
        int v;
        SopaLetras sopa = new SopaLetras();

        int i, j;

// Llena e imprime la tabla arrChar
        for (i = 0; i < 30; i++) {
            for (j = 0; j < 30; j++) {
                v = 65 + (int) (r.nextDouble() * 26);
                arrChar[i][j] = (char) v;
                arrChar[i][j] = '*'; //asigna un * a todas las posiciones expcepto las palabras que agregamos desde el archivo diccionario.txt
                System.out.print(" ");
                System.out.print(" " + arrChar[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");

        String palabras[];
        palabras = sopa.leerPalabras();

        for (i = 0; i < sopa.numPalabra; i++) {

            sopa.insertarPalabra(palabras[i], arrChar, 30);
            System.out.println("");

        }
        System.out.println("");

        for (i = 0; i < 30; i++) {
            for (j = 0; j < 30; j++) {
                System.out.print(" " + arrChar[i][j]);
            }
            System.out.println("");

        }

    } // Fin del main

    public String[] leerPalabras() {
        String fileName = "/Users/reyz/Desktop/diccionario.txt"; // AQUI ESPECIFICO EL 
        String palabras[] = new String[1000];
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader in = new BufferedReader(fr);

            String cadena;
            cadena = in.readLine();

            while (cadena != null) {
                System.out.printf(" " + cadena);
                palabras[numPalabra] = cadena;
                numPalabra++;
                cadena = in.readLine();
            }
            fr.close();
            in.close();
            return palabras;

        } catch (IOException e) {
            System.out.println("ha ocurrido un error al utilizar " + fileName);

        }
        return null;
    }

    public void insertarPalabra(String pal, char sopa[][], int len) {
        int x = 0, y = 0;
        Random r = new Random(); //Crear instancia para generar valores aleatorios

        x = (int) (r.nextDouble() * (29 - pal.length()));
        System.out.print("[ " + x + ",");
        y = (int) (r.nextDouble() * (29 - pal.length()));
        System.out.print(" " + y + "] ");

        int dir;
        dir = (int) (r.nextDouble() * 4);
        System.out.print(" Dir= " + dir + " ");
// aqui se especifica la forma en que se van a a colocar las palabras ya sea en diagonal horizontal o vertical...se colocan en forma aleatoria por toda la sopa 
        for (int i = 0; i < pal.length(); i++) {
            if (dir == 0) {
                sopa[x][y + i] = pal.charAt(i);
            } else if (dir == 1) {
                sopa[x + i][y] = pal.charAt(i);
            } else if (dir == 2) {
                sopa[x][y + i] = pal.charAt(pal.length() - i - 1);
            } else {
                sopa[x + i][y] = pal.charAt(pal.length() - i - 1);
            }

        } //fin de for

    } //Fin del insertarPalabra
} // fin de la clase
