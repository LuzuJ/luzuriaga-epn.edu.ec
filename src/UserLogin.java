import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class UserLogin implements Login {
    private String user;
    private String encryptedPassword;

    public UserLogin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        this.user = sc.nextLine();
        System.out.print("Enter password: ");
        String plainPassword = sc.nextLine();
        this.encryptedPassword = encryptPassword(plainPassword);
        sc.close();
    }

    private String encryptPassword(String plainPassword) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        md.update(plainPassword.getBytes());
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    @Override
    public String getUser() {
        return this.user;
    }

    @Override
    public String getEncryptedPassword() {
        return this.encryptedPassword;
    }
}
