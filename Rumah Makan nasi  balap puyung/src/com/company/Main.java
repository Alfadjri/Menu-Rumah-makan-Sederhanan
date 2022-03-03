package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String input;
        int tombol,harga;
        boolean kondisi;
        Scanner scan = new Scanner(System.in);
        do{
            Head();
            System.out.print("MASUKAN PILIHAN ANDA : ");
            input = scan.next();
            input =  cekInputanPesanan(input);
            if(!input.isEmpty()){
                kondisi = true;
                tombol = Integer.parseInt(input);
                switch (tombol){
                    case 1:
                        System.out.println("\n AYAM GORENG");
                        harga = 10000;
                        Selection(harga);
                        break;
                    case 2:
                        System.out.println("NASI GORENG");
                        harga = 8000;
                        Selection(harga);
                        break;
                    case 3:
                        System.out.println("MIE PANGSIT");
                        harga = 10000;
                        Selection(harga);
                        break;
                    case 4:
                        System.out.println("NASI BALAP PUYUNG");
                        harga = 12000;
                        Selection(harga);
                        break;
                    case 5:
                        System.out.println("NASI CAMPUR");
                        harga = 8000;
                        Selection(harga);
                        break;
                    case 6:
                        System.out.println("JUS JERUK");
                        harga = 6000;
                        Selection(harga);
                        break;
                    case 7:
                        System.out.println("AIR GELAS");
                        harga = 500;
                        Selection(harga);
                        break;
                    default:
                        System.out.println("Tidak ada dalam menu silahkan masukan angak yang telah ada !!");
                        break;
                };
                boolean pilihan = TambahanPesanan();
                if(pilihan == false){
                    kondisi = false;
                    clearConsole();
                }else{
                    kondisi = true;
                }
            }else{
                System.out.println("Tidak ada dalam menu silahkan masukan angak yang telah ada !!!");
                kondisi = false;
            }

        }while (!kondisi);
        System.out.println("Trimakasih Atas Kunjungan Anda Di Warung Nasi Balap Puyung");
        System.out.println("==========================================================");
    }
    private  static void Selection(int harga){
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
                pembayaran(totalHaraga);
            }else{
                System.out.println("Jumlah yang ada masukan salah silhkan masukan total pesanan !");
                kondisi = false;
            }

        }while(!kondisi);
    }
    private static boolean TambahanPesanan() {
        Scanner scan = new Scanner(System.in);
        String input;
        System.out.print("Masih ada  Y / T : ");
        input = scan.next();
        if(input.toLowerCase(Locale.ROOT).equals("y")){
            return false;
        }else{
            return true;
        }
    }
    private static void pembayaran(int totalHaraga) {
        Scanner scan = new Scanner(System.in);
        boolean kondisi = true;
        do{
            System.out.println("Total Haraga : " + totalHaraga);
            System.out.print("Dibayar : ");
            String pembayaran = scan.next();
            pembayaran = cekInputan(pembayaran);
            if(!pembayaran.isEmpty()){
                int totalPembayaran = Integer.parseInt(pembayaran);
                int kembalian =totalPembayaran - totalHaraga;
                if (kembalian <0){
                    System.out.println("uang anda kurang !!!");
                    kondisi = false;
                }else{
                    System.out.println("KEMBALIAN : " + kembalian);
                    kondisi = true;
                }
            }else{
                System.out.println("Masukan nominal yang akan di bayar!!!");
                kondisi = false;
            }
        }while (!kondisi);
    }
    private static int hitungHarga(int harga, int jumlahPesanan) {
        int totalHarga = harga * jumlahPesanan;
        return  totalHarga;
    }
    private static String cekInputanPesanan(String input) {
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
    public static void Head(){

        System.out.println("=====================================================");
        System.out.println("|                   RUMAH MAKAN                 \t|");
        System.out.println("|                NASI BALAP PUYUNG              \t|");
        System.out.println("|             Aplikasi kasir rumah makan        \t|");
        System.out.println("=====================================================");
        System.out.println("| Menu Makanan\t\t\t\t\t\t\tHarga\t\t|");
        Menu();
//        for(Map.Entry map : content.entrySet()){
//            String namaMasakan = (String) map.getKey();
//            int harga = (int) map.getValue();
//            System.out.printf("| %d.\t%s\t\t\t\tRp.\t%7d\t |\n",no,namaMasakan.toUpperCase(Locale.ROOT),harga);
//            no++;
//        }
        System.out.println("=====================================================");
    }
    public static void Menu(){
        System.out.println("| 1.\t AYAM GORENG                  RP.\t 10.000 |");
        System.out.println("| 2.\t NASI GORENG                  RP.\t  8.000 |");
        System.out.println("| 3.\t MIE PANGSIT                  RP.\t 10.000 |");
        System.out.println("| 4.\t NASI BALAP PUTUNG            RP.\t 12.000 |");
        System.out.println("| 5.\t NASI CAMPUR                  RP.\t  8.000 |");
        System.out.println("| 6.\t JUS JERUK                    RP.\t  6.000 |");
        System.out.println("| 7.\t AIR GELAS                    RP.\t    500 |");
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
}
