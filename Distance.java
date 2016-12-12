
public class Distance {

    NormalizedUser user0, user1;
    int movieId;
    Movie movie;

    public void getDistance(NormalizedUser user0, NormalizedUser user1, int movieId) {

        this.user0 = user0;
        this.user1 = user1;
        this.movieId = movieId;
        movie = (new Movie()).getMovieData();
        float distance = getAgeDistance(getWeight(0, 1)) + getSexDistance(getWeight(1, 2))
                + getRemain(getWeight(2, 9));
    }

    public float getAgeDistance(int[] weight) {

        float f = Math.abs(user0.age - user1.age);
        f *= weight[0];
        return f;
    }

    public float getSexDistance(int[] weigth) {

        float i = Math.abs(user0.sex - user1.sex);
        i *= weigth[0];
        return i;
    }

    public float getRemain(int[] weight) {

        float sumRemain = 0, rating, genre[];
        genre = new float[7];
        if (user0.rating[movieId] != 0 && user1.rating[movieId] != 0) {
            rating = Math.abs(user0.rating[movieId] - user1.rating[movieId])
                    * weight[0];
            sumRemain += rating;
            for (int i = 0; i < 7; i++) {
                genre[i] = movie.genre[movieId][i] * weight[i + 1];
                sumRemain += genre[i];
            }
        } else {
            sumRemain = 0;
        }
        return sumRemain;
    }

    public int[] getWeight(int number1, int number2) {

        Weights w = new Weights();
        w.applyGA();
        int num = number2 - number1;
        int x[] = new int[num];
        for (int i = 0; i < num; i++) {
            x[i] = 1;
        }
        return x;
    }
}
