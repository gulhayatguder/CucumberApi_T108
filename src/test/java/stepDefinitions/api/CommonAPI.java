package stepDefinitions.api;

import hooks.api.HooksAPI;
import io.cucumber.java.en.Given;

public class CommonAPI {

    public static String fullPath;

    @Given("Api kullanicisi {string} path parametreleri set eder")
    public void api_kullanicisi_path_parametreleri_set_eder(String rawPaths) {

        // https://trendlifebuy.com/api/register

       // HooksAPI.spec.pathParams("pp1","api","pp2","register");

        //    api/register

        String [] paths = rawPaths.split("/"); // ["api","register"]

        StringBuilder tempPath = new StringBuilder("/{");

        for (int i = 0; i < paths.length ; i++) {

            String key = "pp" + i; // pp0 pp1 pp2
            String value = paths[i].trim();

            HooksAPI.spec.pathParam(key,value);

            tempPath.append(key + "}/{");
        }
        // System.out.println("tempPath = " + tempPath);

        tempPath.deleteCharAt(tempPath.lastIndexOf("{"));
        tempPath.deleteCharAt(tempPath.lastIndexOf("/"));

        // System.out.println("tempPath = " + tempPath);

        fullPath = tempPath.toString();

    }











}
