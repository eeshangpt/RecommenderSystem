
public class NormalizedUser {

    String name;
    float age;
    int id, sex;
    float[] rating = new float[25];

    public static NormalizedUser getNormalizedUser(User user) {

        NormalizedUser nUser = new NormalizedUser();
        nUser.name = user.name;
        nUser.id = user.id;
        nUser.age = user.age / Users.getMaxAge();
        for (int i = 0; i < 25; i++) {
            nUser.rating[i] = (float) (user.rating[i] / 5);
        }
        return nUser;
    }

    public NormalizedUser() {
    }
}
