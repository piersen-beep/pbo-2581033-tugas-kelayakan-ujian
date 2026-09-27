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

        // Satu syarat yang sama, ditulis dalam tiga versi kurung
        boolean a = kehadiran >= 75 && nilaiTugas >= 60 || dispensasi;
        boolean b = (kehadiran >= 75 && nilaiTugas >= 60) || dispensasi;
        boolean c = kehadiran >= 75 && (nilaiTugas >= 60 || dispensasi);

        boolean tidakDispensasi = !dispensasi;

        System.out.println();
        System.out.println("===== KELAYAKAN UJIAN =====");
        System.out.println("Kehadiran   : " + kehadiran + "%");
        System.out.println("Nilai tugas : " + nilaiTugas);
        System.out.println("Dispensasi  : " + dispensasi);
        System.out.println("a (tanpa kurung)      : " + a);
        System.out.println("b (kurung precedence) : " + b);
        System.out.println("c (kurung digeser)    : " + c);
        System.out.println("!dispensasi           : " + tidakDispensasi);

        // Kesimpulan: a sama dengan b. Java secara default mengerjakan &&
        // lebih dulu daripada ||, jadi menulis a tanpa kurung sama persis
        // dengan menulis b yang kurungnya sengaja mengikuti precedence itu.
        // c berbeda karena kurungnya digeser: (nilaiTugas >= 60 || dispensasi)
        // dipaksa dievaluasi lebih dulu sebagai satu kesatuan, sehingga
        // urutan pengerjaan operatornya berubah dan hasilnya bisa berbeda
        // dari a maupun b. Kesimpulannya: && mengikat lebih kuat daripada ||,
        // jadi Java membaca a persis seperti b.

        // Pembuktian short-circuit evaluation
        int cek = 0;
        boolean x = (kehadiran >= 75) && (cek++ >= 0);
        boolean y = (nilaiTugas >= 60) || (cek++ >= 0);
        System.out.println("cek dipanggil: " + cek);

        // Penjelasan (dengan contoh kehadiran 60, nilai tugas 80):
        // Pada x, (kehadiran >= 75) bernilai false karena kehadiran cuma 60.
        // Untuk operator &&, begitu operand kiri sudah false, jawabannya
        // sudah pasti false, jadi operand kanan (cek++ >= 0) dilewati -
        // cek tidak jadi bertambah.
        // Pada y, (nilaiTugas >= 60) bernilai true karena nilai tugas 80.
        // Untuk operator ||, begitu operand kiri sudah true, jawabannya
        // sudah pasti true, jadi operand kanan (cek++ >= 0) juga dilewati -
        // cek lagi-lagi tidak jadi bertambah.
        // Karena kedua post-increment sama-sama dilewati (short-circuit),
        // cek tetap di nilai awalnya, yaitu 0.
    }
}