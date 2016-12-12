
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class Movie {

    String[] movie;
    int[] movieId;
    Integer[][] genre;

    static JSONParser parser = new JSONParser();
    static Movie mainMovie = new Movie();

    public Movie() {
        movie = new String[25];
        movieId = new int[25];
        genre = new Integer[25][7];
    }

    static {

        try {
            JSONObject jObject = (JSONObject) parser.parse(
                    new FileReader("movie_data_gaa.json"));
            JSONArray movieList = (JSONArray) jObject.get("movies");
            Iterator<JSONObject> iterator = movieList.iterator();

            int i = 0;

            while (iterator.hasNext() && i < 25) {
                JSONObject jObject1 = iterator.next();
                mainMovie.movie[i] = (String) jObject1.get("movie");
                mainMovie.movieId[i] = i;
                mainMovie.genre[i][0] = ((Long) jObject1.get("g0")).intValue();
                mainMovie.genre[i][1] = ((Long) jObject1.get("g1")).intValue();
                mainMovie.genre[i][2] = ((Long) jObject1.get("g2")).intValue();
                mainMovie.genre[i][3] = ((Long) jObject1.get("g3")).intValue();
                mainMovie.genre[i][4] = ((Long) jObject1.get("g4")).intValue();
                mainMovie.genre[i][5] = ((Long) jObject1.get("g5")).intValue();
                mainMovie.genre[i][6] = ((Long) jObject1.get("g6")).intValue();
                i++;
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public Movie getMovieData() {

        Movie retMovie = null;
        try {
            retMovie = (Movie) mainMovie.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return retMovie;
    }
    
    public static void printMovie(int i){
        int temp = 0;
        for (int j = 0; j < 25; j++) {
            if (i == mainMovie.movieId[j])  {
                temp = j;
                break;
            }
        }
        System.out.println(mainMovie.movie[temp]);
    }
}
