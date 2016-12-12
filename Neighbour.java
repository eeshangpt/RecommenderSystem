
import java.util.ArrayList;
import java.util.Random;

public class Neighbour {

    User u = new User();

    public Neighbour(User u) {
        this.u = u;
    }

    public ArrayList<Integer> findNeightbour() {

        ArrayList<Integer> mov = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            if (u.rating[i] == 0) {
                mov.add(i);
            }
        }
        return mov;
    }

    public int gotoMovie(ArrayList<Integer> al) {

        Random random = new Random();
        int alBound = al.size() , i = 0;
        if (alBound == 0) {
            System.out.println("USER IS A MOVIE BUFF. NO MOVIES "
                    + "LEFT UNWATCHED. DAMN IT!!!!!");
            System.exit(0);
        } else if(alBound == 1){
            i = i = random.nextInt(alBound);
        }else {
             i = random.nextInt(alBound - 1);
        }
        return al.get(i);
    }
}
