import java.util.Scanner;

public class KelayakanUjian {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Kehadiran (%): ");
        int kehadiran = input.nextInt();

        System.out.print("Nilai tugas: ");
        int nilaiTugas = input.nextInt();

        System.out.print("Dispensasi (true/false): ");
        boolean dispensasi = input.nextBoolean();
