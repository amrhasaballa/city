import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class City {
    private int cityNum;
    private String cityName;
    private int cityPobulation;
    private String cityCode;

    private static List<City> cities = new ArrayList<>();

    public City (int cityNum, String cityName, int cityPobulation, String cityCode){
        this.cityNum = cityNum;
        this.cityName = cityName;
        this.cityPobulation = cityPobulation;
        this.cityCode = cityCode;
    }

    public static List<City> getAll()
    {
        return cities;
    }

    public int getNum() {
       return cityNum;
    }

    public void setNum(int cityNum) {
       this.cityNum = cityNum;
    }
    
    public String getcityname() {
       return cityName;
    }

    public void setcityname(String cityname) {
       this.cityName = cityName;
    }
    public int getpopulation() {
       return cityPobulation;
    }

    public void setpopulation(int population) {
       this.cityPobulation = cityPobulation;
    }
    public String getcode() {
       return cityCode;
    }

    public void setcode(String code) {
       this.cityCode = cityCode;
    }

    public static void loadFile(String filename)
    {
        try {
            FileReader f = new FileReader(filename);
            BufferedReader bf = new BufferedReader(f);
            String line;
            String[] parts;
            City st;
            do {
                line = bf.readLine();
                if (line != null) {
                    // System.out.println(line);
                    parts = line.split(",");
                    // System.out.println(parts[1]);
                    st = new City(Integer.parseInt(parts[0]),parts[1], Integer.parseInt(parts[2]) ,parts[3].trim());
                    cities.add(st);
                    }
                } while (line != null);
            bf.close();
            f.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public String toString() {
        return "City{" + "num=" + cityNum + ", cityname=" + cityName + ", population=" + cityPobulation + ", code=" + cityCode + '}';
    }

    public static void getCitesOfCountry (String Code)
    {
        cities.stream().filter(c -> c.getcode().equals(Code)).forEach(System.out::println);
    }

    public static String getHighestPopulation (String Code)
    {
        return cities.stream()
        .filter(c -> c.getcode().equals(Code))
        .map(c -> c.cityPobulation)
        .sorted(Comparator.reverseOrder())
        .findFirst()
        .toString();
    }

    public static void getAllCitiesPopulation (String Code)
    {
        cities.stream()
        .filter(c -> c.getcode().equals(Code))
        .map(c -> c.cityPobulation)
        .sorted(Comparator.reverseOrder())
        .forEach(System.out::println);
    }
    
}