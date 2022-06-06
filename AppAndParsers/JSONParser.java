package AppAndParsers;
import java.util.ArrayList;
import java.util.List;

import org.json.*;

public class JSONParser {
	
	public List<String> RecipeToJsonParse(JSONObject recipejsonObject) {
		JSONArray recipeJsonArray = recipejsonObject.getJSONArray("recipes");
		List<String> recipeArray= new ArrayList<String>();
		for(int i=0;i<recipeArray.size();i++) {
			recipeArray.add(recipeArray.get(i));
		}
		return recipeArray;
	}
	
}
