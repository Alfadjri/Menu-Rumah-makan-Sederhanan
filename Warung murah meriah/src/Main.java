import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input,inputan_Salah = "Kode yang anda masukkan tidak ada!!";
        int no_paket,harga;
        boolean kondisi;
        Scanner scan = new Scanner(System.in);
        Head();
        do{
            System.out.print("Pilih Paket yang ada inginkan : ");
            input = scan.next();
            input = cekinputPesanan(input);
            if(!input.isEmpty()){
                kondisi = true;
                no_paket = Integer.parseInt(input);
                switch (no_paket){
                    case 1:
                        System.out.println("AYAM GEPREK DAN TEH ES");
                        harga = 27000;
                        total(harga);
                        break;
                    case 2:
                        System.out.println("NASI GORENG DAN TEH ES");
                        harga =45000;
                        total(harga);
                        break;
                    case 3:
                        System.out.println("MIE PANGSIT DAN JUS");
                        harga = 35000;
                        total(harga);
                        break;
                    case 4:
                        System.out.println("NASI TIMBEL KOMPLIT DAN TEH HANGAT");
                        harga = 50000;
                        total(harga);
                        break;
                    case 5:
                        System.out.println("SEBLAK CAMPUR DAN JUS");
                        harga = 18000;
                        total(harga);
                        break;
                    case 6:
                        System.out.println("BASO TAHU DAN TEH ES");
                        harga = 25000;
                        total(harga);
                        break;
                    default:
                        System.out.println(inputan_Salah);
                        kondisi = false;
                        break;
                };
            }else{
                kondisi = false;
                System.out.println(inputan_Salah);
            }
        }while (!kondisi);


    }

    public static void Head(){

        System.out.println("=================================================================");
        System.out.println("|                   WARUNG MURAH MERIAH         \t\t\t\t|");
        System.out.println("================================================================");
        System.out.println("| NO | Menu Makanan\t\t\t\t\t\t\t\t\tHarga\t\t|");
        Menu();
        System.out.println("================================================================");
    }
    public static void Menu(){
        System.out.println("| 1.\t AYAM GEPREK DAN TEH ES                  RP.\t 27.000 |");
        System.out.println("| 2.\t NASI GORENG DAN TEH ES                  RP.\t 45.000 |");
        System.out.println("| 3.\t MIE PANGSIT DAN JUS                     RP.\t 35.000 |");
        System.out.println("| 4.\t NASI TIMBEL KOMPLIT DAN TEH HANGAT      RP.\t 50.000 |");
        System.out.println("| 5.\t SEBLAK CAMPUR DAN JUS                   RP.\t 18.000 |");
        System.out.println("| 6.\t BASO TAHU DAN TEH ES                    RP.\t 25.000 |");
    }
    private static void clearConsole(){
        try{
            String operatingSystem = System.getProperty("os.name");
            if(operatingSystem.contains("Windows")){
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    private static String cekinputPesanan(String input) {
        int ascii_start=48,ascii_end=57;
        boolean kondisi = true;
        while (kondisi){
            if((int) input.charAt(0) == ascii_start ){
                return String.valueOf(input.charAt(0));
            }else{
                if(ascii_start == ascii_end)
                    kondisi= false;
                ascii_start++;
            }
        }
        ascii_start= 48;
        kondisi=true;
        return "";
    }
    private static String cekInputan(String input) {
        int ascii_start = 48, ascii_end = 57;
        String kata = input;
        boolean kondisi = true;
        for (int i = 0; i < input.length(); i++) {
            while (kondisi) {
                if ((int) input.charAt(i) == ascii_start && (int) input.charAt(i) != 47) {
                    if (i != input.length() - 1) {
                        kondisi = false;
                    } else {
                        return kata;
                    }
                } else {
                    if (ascii_start == ascii_end)
                        kondisi = false;
                    ascii_start++;
                }
            }
            ascii_start = 46;
            kondisi = true;
        }
        return "";
    }
    private  static void total(int harga){
        Scanner scan = new Scanner(System.in);
        String input;
        int jumlahPesanan;
        boolean kondisi;
        do{
            System.out.print("Masukan JUMLAH :");
            input = scan.next();
            input = cekInputan(input);
            if (!input.isEmpty()){
                kondisi = true;
                jumlahPesanan = Integer.parseInt(input);
                int totalHaraga = hitungHarga(harga,jumlahPesanan);
                if(totalHaraga > 100000){
                    int diskon = totalHaraga * 10/100;
                    totalHaraga = totalHaraga - diskon;
                }
                pembayaran(totalHaraga);
            }else{
                kondisi = false;
                System.out.println("Masukan jumlah makanan yang anda pesan ");
            }
        }while (!kondisi);
    }

    private static int hitungHarga(int harga, int jumlahPesanan) {
        int totalHarga = harga * jumlahPesanan;
        return  totalHarga;
    }
    private static void pembayaran(int totalHaraga) {
        Scanner scan = new Scanner(System.in);
        boolean kondisi = true;
        do {
            System.out.println("Total Haraga : " + totalHaraga);
            System.out.print("Dibayar : ");
            String pembayaran = scan.next();
            pembayaran = cekInputan(pembayaran);
            if (!pembayaran.isEmpty()) {
                int totalPembayaran = Integer.parseInt(pembayaran);
                int kembalian = totalPembayaran - totalHaraga;
                if (kembalian < 0) {
                    System.out.println("uang anda kurang !!!");
                    kondisi = false;
                } else {
                    System.out.println("KEMBALIAN : " + kembalian);
                    kondisi = true;
                }
            } else {
                System.out.println("Masukan nominal yang akan di bayar!!!");
                kondisi = false;
            }
        } while (!kondisi);

    }
}
