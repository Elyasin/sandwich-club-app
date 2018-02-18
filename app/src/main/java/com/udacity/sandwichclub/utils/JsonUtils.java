package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String jsonString) {
        try {

            JSONObject jsonData = new JSONObject(jsonString);
            JSONObject name = jsonData.getJSONObject("name");
            String mainName = name.getString("mainName");
            JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAsList = new ArrayList<String>();
            for (int i = 0; i < alsoKnownAs.length(); i++) {
                alsoKnownAsList.add(alsoKnownAs.getString(i));
            }
            String placeOfOrigin = jsonData.getString("placeOfOrigin");
            String description = jsonData.getString("description");
            String image = jsonData.getString("image");
            JSONArray ingredients = jsonData.getJSONArray("ingredients");
            List<String> ingredientsList = new ArrayList<String>();
            for (int i = 0; i < ingredients.length(); i++) {
                ingredientsList.add(ingredients.getString(i));
            }

            return new Sandwich(mainName, alsoKnownAsList, placeOfOrigin, description, image, ingredientsList);

        } catch (JSONException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
