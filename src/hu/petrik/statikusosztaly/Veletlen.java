package hu.petrik.statikusosztaly;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public final class Veletlen {

        private Veletlen() {}

        private static final Random rnd=new Random();
        private static List<String > vezNevek=feltolt(("files/veznev.txt"));
        private static List<String > ferfiKerNevek=feltolt(("files/ferfikernev.txt"));
        private static List<String > noiKerNevek= feltolt(("files/noikernev.txt"));


        private static List<String > feltolt(String fajlnev) {
            List<String>lista=new ArrayList<>();
            try {
                Scanner file=new Scanner(new File(fajlnev));
                while (file.hasNext()){
                    String sor = file.nextLine();
                    lista.add(sor);
                }
                file.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return lista;
        }

        public static int velEgesz(int min, int max){
            return rnd.nextInt(max -min+1)+min;
        }

        public static char velKarakter(char min,char max){
            return (char) velEgesz(min,max);
        }

        public static String velVezetekNev(){
            return vezNevek.get(rnd.nextInt(vezNevek.size()));
        }

        /**
         * Véletlen Magyar keresztnév generálása
         * @param nem A generált név neme. Férfi esetén true, nő esetén false.
         * @return A generált keresztnév
         */
        public  static  String velKeresztNev(boolean nem){
            String keresztnev;
            if (nem){
                keresztnev=velFerfiKeresztNev();
            }else {
                keresztnev=velNoiKeresztNev();
            }
            return keresztnev;
        }

        private static String velFerfiKeresztNev(){
            return ferfiKerNevek.get(rnd.nextInt(ferfiKerNevek.size()));
        }
        private static String velNoiKeresztNev(){
            return noiKerNevek.get(rnd.nextInt(noiKerNevek.size()));
        }

        /**
         * Véletlen Magyar név generálása
         * @param nem A generált név neme. Férfi esetén true, nő esetén false.
         * @return A generált név
         */
        public static String velTeljesNev(boolean nem){
            return velVezetekNev()+" "+velKeresztNev(nem);
        }
        public static Date velDatum(int ev1, int ev2) {
            int year = velEgesz(ev1, ev2);
            int month = velEgesz(1, 12);
            int dayMax = 0;
            if (month == 2) {
                dayMax = 28;
            }
            if (month == 1 || month == 3 || month == 7 || month == 8 || month == 10 || month == 12) {
                dayMax = 31;
            } else {
                dayMax = 30;
            }
            return new Date(year, month, velEgesz(1, dayMax));
        }

        public static String velEmail(String name) {
            int id = velEgesz(0, 1000);
            String gmail = String.format("%s%d@gmail.com", name, id);
        /*while (){

        }*/
            return gmail;
        }

        public static String velMobil() {
            return String.format("+36 (30)%d%d%d-%d%d-%d%d", velEgesz(0, 9), velEgesz(0, 9), velEgesz(0, 9), velEgesz(0, 9),
                    velEgesz(0, 9), velEgesz(0, 9), velEgesz(0, 9));
        }

        public static String velSportag() {
            List<String> sportList = new ArrayList<>();
            Scanner sc = new Scanner("sportag.txt");
            while (sc.hasNext()) {

                sportList.add(sc.nextLine());

            }

            return sportList.get(velEgesz(0, sportList.size() - 1));
        }

        public static String velSportegyesulet() {
            List<String> egyesuletList = new ArrayList<>();
            Scanner sc = new Scanner("egyesulet.txt");
            while (sc.hasNext()) {
                egyesuletList.add(sc.nextLine());
            }
            return egyesuletList.get(velEgesz(0, egyesuletList.size() - 1));
        }
}
