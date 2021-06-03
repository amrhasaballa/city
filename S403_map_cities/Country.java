import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class Country {
    private String code;
    private String countryname;
    private String continent;
    int population;
    private double surfaceArea;
    private double gnp;
    private int capitalId;

    private static List<Country> countries = new ArrayList<Country>();

    public Country(String code, String countryname, String continent,
                    int population,double surfaceArea, double gnp, 
                    int capitalId) 
    {
        this.code = code;
        this.countryname = countryname;
        this.continent = continent;
        this.surfaceArea = surfaceArea;
        this.population = population;
        this.gnp = gnp;
        this.capitalId = capitalId;
    }
    
    public static List<Country> All()
    {
        return countries;
    }
    
    
    public String getCode() {
        return code;
    }

    public String getcountryname() {
        return countryname;
    }

    public String getContinent() {
        return continent;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public int getPopulation() {
        return  population;
    }

    public double getGnp() {
        return gnp;
    }

    public int getCapitalId() {
        return capitalId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setcountryname(String countryname) {
        this.countryname = countryname;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setGnp(double gnp) {
        this.gnp = gnp;
    }

    public void setCapitalId(int capitalId) {
        this.capitalId = capitalId;}
    
    public String toString() {
        return countryname + "(" + code + ")";
    }
    
    public static void loadFile(String filename){
        try {
            FileReader f = new FileReader(filename);
            BufferedReader bf = new BufferedReader(f);
            String line;
            String[] parts;
            Country st;
            do {
                line = bf.readLine();
                if (line != null) {
                    // System.out.println(line);
                    parts = line.split(",");
                    st = new Country(parts[0], parts[1].trim(), parts[2], Integer.parseInt(parts[3]),
                                Double.parseDouble(parts[4]), Double.parseDouble(parts[5]), 
                                Integer.parseInt(parts[6]));
                    countries.add(st);
                }
            } while (line != null);
            bf.close();
            f.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void getAllCountriesPopulation ()
    {
        countries.stream().forEach(c -> System.out.println(c.countryname + " : "+c.getPopulation()));
    }

    public static double getAveragePopulation ()
    {
        return countries.stream().mapToInt(c -> c.getPopulation()).average().getAsDouble();
    }

    public static Integer getMaxCountryPopulation () 
    {
        return countries.stream().map(c -> c.getPopulation()).max(Integer::compare).get();
    }

    /*
    public static Optional<Country> getMaxPopulationCountry(){
        return countries.stream().max(PopulationComparator);
    }
    public static Comparator<Country> PopulationComparator = new Comparator<Country>() {
        public int compare(Country c1, Country c2) {
            if (c1.population < c2.population)
                return -1;
            else if (c1.population == c2.population)
                return 0;
            else
                return 1;
        }
    };
    */
    
}
