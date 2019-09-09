package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {



    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject root = new JSONObject(json);

            JSONObject name = root.getJSONObject("name");
            String mainName = name.getString("mainName");

            JSONArray JSONArrayAlsoKnownAs = name.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAs = convertArray(JSONArrayAlsoKnownAs);

            String placeOfOrigin = root.getString("placeOfOrigin");

            String description = root.getString("description");

            String image = root.getString("image");

            JSONArray JSONArrayIngredients = root.getJSONArray("ingredients");
            List<String> ingredients = convertArray(JSONArrayIngredients);

            return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);

        } catch (JSONException e) {

            e.printStackTrace();
            return null;
        }
    }

    private static List<String> convertArray(JSONArray jsonArray) throws JSONException {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            list.add(jsonArray.getString(i));
        }

        return list;
    }
}
