package week11.saviero.id.ac.umn;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<User> listOfUser = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void initialize() {
        listOfUser.add(new User(
                "John",
                "Doe",
                "L",
                "Jl. Merpati No. 1 RT 1 RW 1, Banten",
                "admin",
                "admin"
        ));
    }

    public static void handleLogin() {
        int attempts = 0;

        while (attempts < 3) {
            System.out.print("Username : ");
            String user = input.next();
            System.out.print("Password : ");
            String pass = input.next();

            for (User u : listOfUser) {
                try {
                    if (u.login(user, pass)) {
                        System.out.println("Selamat Datang!" + u.getNamaLengkap());
                        return;
                    }
                } catch (AuthenticationException e) {
                    System.out.println(e.getMessage());
                }
            }

            attempts++;
        }

        try {
            throw new ExcessiveFailedLoginException("Anda telah mencapai jumlah batas login");
        } catch (ExcessiveFailedLoginException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void handleSignUp() {
        System.out.print("Nama Depan : ");
        String fn = input.next();

        System.out.print("Nama Belakang : ");
        String ln = input.next();

        System.out.print("Jenis Kelamin (L/P) : ");
        String gender = input.next();

        System.out.print("Alamat : ");
        input.nextLine();
        String address = input.nextLine();

        String username;
        while (true) {
            System.out.print("Username : ");
            username = input.next();
            if (username.length() < 8) {
                System.out.println("Username harus lebih dari 8 karakter");
            } else break;
        }

        String password;
        while (true) {
            System.out.print("Password : ");
            password = input.next();

            if (password.length() < 6 || password.length() > 16) {
                System.out.println("Password harus minimum 6 karakter dan maksimum 16 karakter");
            } else if (!password.matches(".*[A-Z].*") || !password.matches(".*[0-9].*")) {
                System.out.println("Password harus mengandung huruf besar dan angka");
            } else {
                break;
            }
        }

        listOfUser.add(new User(fn, ln, gender, address, username, password));
        System.out.println("User telah berhasil didaftarkan");
    }

    public static void main(String[] args) {
        initialize();

        while (true) {
            System.out.println("\nMenu Utama");
            System.out.println("1. Login");
            System.out.println("2. Sign Up");
            System.out.print("Pilihan : ");

            int pilih = input.nextInt();

            if (pilih == 1) {
                System.out.println("\nMenu Login");
                handleLogin();
            } else if (pilih == 2) {
                System.out.println("\nMenu Sign Up");
                handleSignUp();
            } else {
                System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
