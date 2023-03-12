public class Main {
    public static void main(String[] args) {
        Login login = new UserLogin();
        System.out.println("Username: " + login.getUser());
        System.out.println("Encrypted password: " + login.getEncryptedPassword());
    }
}
