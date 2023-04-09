//nos permitirá realizar la ejecución en parapelo de todos los feature del package country
//además nos permitirá mostrar los resultados con cucumber

package country;

import com.intuit.karate.Results; //para generar informes de resultados en Karate
import com.intuit.karate.Runner; //para automatizar la ejecución de pruebas en Karate
import net.masterthought.cucumber.Configuration; //para configurar la generación de informes en Cucumber
import net.masterthought.cucumber.ReportBuilder; //para generar informes de resultados en Cucumber
import org.apache.commons.io.FileUtils; //para el manejo de arcivhos y directorios en Java
import org.junit.jupiter.api.Test; //para escribir las pruebas en Java a través de JUnit5

import java.io.File; //para manipular archivos y directorios en Java
import java.util.Collection; //para manipular archivos y directorios en Java
import java.util.ArrayList; //para manipular archivos y directorios en Java
import java.util.List; //para manipular archivos y directorios en Java

public class TestRunner {

    @Test
    void testParallel(){
        Results results =  Runner.path("classpath:country").outputCucumberJson(true).tags("~@ignore").parallel(4);
        generateReport(results.getReportDir());
    }

    public static void generateReport(String karateOutputPath){
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[]{"json"}, true);
        List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration config = new Configuration(new File("build"), "country");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }
}
