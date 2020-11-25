package dev.ky3he4ik.pr.pr2;

public class AuthorTest {
    public static void main(String[] args) {
        var author1 = new Author("Unknown Author", "mail@example.com", 'f');
        var author2 = new Author("Well-known Author", "name@famouswriter.org", 'm');
        System.out.println(author1);
        System.out.println(author2);
        author1.setEmail("newmail@google.com");
        System.out.println(author1);

        System.out.println("Author tested successfully!");
    }
}
