package BookMyShow;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class MovieManager {

    static ArrayList<Movie> movies = new ArrayList<>();

    public static void addMovie(String name,int cost,double rating) {
        Movie m = new Movie(name,cost,rating);
        movies.add(m);
        System.out.println("Movie added successfully!");
    }
    public static void printMovies(){
        System.out.println("       Movie   "+"          Cost  "+"Ratings");
        System.out.println("    ---------- "+"          ----  "+"-------");
        int index = 1;
        for(Movie movie:MovieManager.movies){
            String movieName=Utils.formatedName(movie.getName());
            System.out.println(index++ +" : "+movieName+"  ->  "+movie.getCost()+"     "+ movie.getRatings());
        }
    }
    public static ArrayList<Movie> readMovies() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("movies.txt"));

        ArrayList<Movie> list = new ArrayList<>();
        String line;

        while ((line = br.readLine()) != null) {
            String[] p = line.split(",");

            String name = p[0];
            int cost = Integer.parseInt(p[1]);
            double rating = Double.parseDouble(p[2]);

            list.add(new Movie(name, cost, rating));
        }

        br.close();
        return list;
    }
    public static void writeMovies(ArrayList<Movie> list) throws Exception {
                       BufferedWriter bw = new BufferedWriter(new FileWriter("movies.txt",true));

                       for (Movie m : list) {
                        bw.write(m.getName() + "," + m.getCost() + "," + m.getRatings());
                        bw.newLine();
                       }

                      bw.close();
    }
    public static void deleteMovie(String movieName) throws Exception {

    //  Read all movies
    ArrayList<Movie> list = readMovies();

    //  Remove matching movie
    Iterator<Movie> it = list.iterator();

    while (it.hasNext()) {
        Movie m = it.next();

        if (m.getName().equalsIgnoreCase(movieName)) {
            it.remove();
        }
    }

    // Rewrite file
    writeMovies(list);
}
}
