package mappings;


import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.*;

public class mapper {

    public static String key_data(String element){
        String use_selector = null;
        if (element == null || element.isEmpty() == true){
            throw new RuntimeException("element is required ..!");
        }
        else{
            use_selector = "src/test/java/resources/"+element.split(":")[0]+".yml"+":"+element.split(":")[1];
        }
        return use_selector;
    }


    public static Map LoadYaml(String selector, String element) {
        Map conf = new HashMap();
        Yaml yaml = new Yaml();
        Map config   = conf;

        try {
            InputStream stream = new FileInputStream(selector);

            conf = (Map) yaml.load(stream);
            config = (LinkedHashMap) conf.get(element);

            if (conf == null || conf.isEmpty() == true) {
                throw new RuntimeException("Failed to read config file");
            }

        } catch (FileNotFoundException e) {
            System.out.println("No such file " + selector);
            throw new RuntimeException("No config file");
        } catch (Exception e1) {
            e1.printStackTrace();
            throw new RuntimeException("Failed to read config file");
        }

        return config;
    }

    public static Map yamlData(String data){
        String parsePath = mapper.key_data(data);
        Map value = mapper.LoadYaml(parsePath.split("\\:")[0],parsePath.split("\\:")[1]);

        return value;
    }

//    public static Map writeYml(Map data) throws FileNotFoundException {
//
//        PrintWriter writer = new PrintWriter(new File(".src/test/java/resources/output.yml"));
//        Yaml yaml = new Yaml();
//
//         return yaml.dump(data, writer);
//    }
}
