import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// import java.util.HashMap;

// import org.graalvm.compiler.nodes.java.ArrayLengthNode;

public class App {
    public static void main(String[] args) throws Exception {
        City.loadFile("/media/disk3/ITI_AI_materials/03_Java_UML_course/Java_UML_ITI_course/S403_map_cities/Cities.csv");
    
        City.getCitesOfCountry("AFG");
        
        System.out.println(City.getHighestPopulation("AFG"));

        City.getAllCitiesPopulation("AFG");

        Country.loadFile("/media/disk3/ITI_AI_materials/03_Java_UML_course/Java_UML_ITI_course/S403_map_cities/Countries.csv");
        
        // Country.getAllCountriesPopulation();

        System.out.println("Average population = " + Country.getAveragePopulation());
        System.out.println("Maximum population = " + Country.getMaxCountryPopulation() ) ;

        Mapping.mappingCountry(City.getAll(), Country.All());;
        Mapping.getCountryMap();
        System.out.println(Mapping.GetCountryCapital("Egypt") ) ;

        System.out.println(Mapping.getMaxCapitalPopulation(City.getAll(), Country.All()));

        System.out.println('\n'+'\n');
        Mapping.getCityMap();



    }

}
// 