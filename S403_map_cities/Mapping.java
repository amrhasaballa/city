import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.max;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Mapping {
    private static HashMap<String, List<City>> countryMap = new HashMap<>();
    private static HashMap<Integer, List<City>> cityMap = new HashMap<>();

    public static void mappingCountry (List<City> cities, List<Country> countries) {
        // List<Integer> kk = countries.stream().map(c -> c.getCapitalId()).collect(Collectors.toList());

        for (Country c : countries) {

            List<City> x = cities.stream()
            .filter((n) -> n
            .getNum() == ( c.getCapitalId()) )
            .collect( Collectors.toList() );
            
            countryMap.put(c.getcountryname().trim(), x);
        }
    }
    

    public static void mappingCity (List<City> citiess) {
        for (City c : citiess) {

            // List<City> x = cities.stream()
            // // .filter((n) -> n
            // // .getNum() == (c) )
            // .collect( Collectors.toList() );
            
            cityMap.put(c.getNum(), (List<City>) c);
        }
    }

    @Override
    public String toString() {
        return "mapping{" + "countryMap=" + countryMap + '}';
    }

    public static void getCountryMap ()
    {
        System.out.println( countryMap );
    }

    public static List<City> GetCountryCapital(String country_name)
   {
       return countryMap.get(country_name);
   }
   
   //
   public static void getCityMap ()
    {
        System.out.println( cityMap );
    }

//     public static List<City> GetCity(Integer c)
//    {
//        return cityMap.get(c);
//    }
   //



   public static List<Integer> getMaxCapitalPopulation (List<City> cities, List<Country> countries)
   {
    //    List<Integer> temp = new List();
       List<Integer> kk = countries.stream().map(c -> c.getCapitalId()).collect(Collectors.toList());
       for (Integer k:kk) {

           
       }
       return kk;

   }

//    public static void printMap () 
//    {

//        List<Integer> kk = new ArrayList<>();
//        for (List<City> val : countryMap.values()){
//             // kk.add(((int) val).getpopulation());
//             System.out.println(val.);
//        }
//     //    System.out.println(kk);
//    }

}
