
public class NormalizedUsers {

    static NormalizedUser[] nu = new NormalizedUser[25];

    static {
        for (int i = 0; i < 25; i++) {
            nu[i] = new NormalizedUser();
        }
    }

    public NormalizedUsers(NormalizedUser[] n) {
        System.arraycopy(n, 0, nu, 0, 50);
    }

    public NormalizedUsers() {
    }

    public NormalizedUser[] getNormalizedUsers() {
        return nu.clone();
    }

}
