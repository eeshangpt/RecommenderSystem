
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.print("Enter Active User Id : \t");
        int id = s.nextInt();
        id -= 1;
        User[] users = new User[25];
        users = User.getUsers();
        NormalizedUser[] nu = new NormalizedUser[25];
        for (int i = 0; i < 25; i++) {
            nu[i] = new NormalizedUser();
            nu[i] = NormalizedUser.getNormalizedUser(users[i]);
        }//normalization ended.
        Movie m = Movie.mainMovie;
        User u = Users.findById(id);
        Neighbour neighbour = new Neighbour(u);
        ArrayList<Integer> a = neighbour.findNeightbour();
        System.out.println("For Active User : " + u.name);
        System.out.println("suggested Movie is : ");
        printMovieName(neighbour, a);
    }

    public static NormalizedUser[] normalize(User[] user) {

        NormalizedUser[] normalizedUser = (new NormalizedUsers())
                .getNormalizedUsers();
        for (int i = 0; i < 50; i++) {
            normalizedUser[i] = NormalizedUser.getNormalizedUser(user[i]);
        }
        return normalizedUser;
    }

    public static void printMovieName(Neighbour n, ArrayList<Integer> al) {

        Movie.printMovie(n.gotoMovie(al));
    }
}
