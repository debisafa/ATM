import java.util.Scanner;

public class ATM {
    private static double saldo = 0; // Saldo awal
    private static String nomorRekening = "123456"; // Nomor rekening default
    private static String password = "1234"; // Password default

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Meminta input nomor rekening
        System.out.print("Masukkan nomor rekening: ");
        String inputNomorRekening = scanner.nextLine();

        // Meminta input password
        System.out.print("Masukkan password: ");
        String inputPassword = scanner.nextLine();

        // Memeriksa kecocokan nomor rekening dan password
        if (!inputNomorRekening.equals(nomorRekening) || !inputPassword.equals(password)) {
            System.out.println("Nomor rekening atau password salah. Program berhenti.");
            return;
        }

        int pilihan;

        do {
            // Menampilkan menu
            System.out.println("Menu ATM:");
            System.out.println("1. Check Saldo");
            System.out.println("2. Deposit");
            System.out.println("3. Jumlah Penarikan");
            System.out.println("4. Exit");
            System.out.print("Pilih menu (1-4): ");

            // Membaca pilihan dari pengguna
            pilihan = scanner.nextInt();

            // Memproses pilihan
            switch (pilihan) {
                case 1:
                    checkSaldo();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    tarikTunai();
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan ATM. Sampai jumpa!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        } while (pilihan != 4);

        scanner.close();
    }

    private static void checkSaldo() {
        System.out.println("Saldo Anda saat ini: " + saldo);
    }

    private static void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jumlah deposit: ");
        double jumlahDeposit = scanner.nextDouble();
        saldo += jumlahDeposit;
        System.out.println("Deposit berhasil. Saldo Anda saat ini: " + saldo);
    }

    private static void tarikTunai() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jumlah penarikan: ");
        double jumlahPenarikan = scanner.nextDouble();

        if (jumlahPenarikan > saldo) {
            System.out.println("Maaf, saldo tidak mencukupi.");
        } else {
            saldo -= jumlahPenarikan;
            System.out.println("Penarikan berhasil. Saldo Anda saat ini: " + saldo);
        }
    }
}