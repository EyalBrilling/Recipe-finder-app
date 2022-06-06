package AppAndParsers;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
public class VarsParser {
	
	
	public JSONObject RecipePrepTimeUpdateParse(String[] prepVars) throws JSONException{
		JSONObject prepJsonObject = new JSONObject();
		prepJsonObject.put("recipe_id",prepVars[0].toString());
		prepJsonObject.put("prep_time",prepVars[1].toString());
		prepJsonObject.put("cook_time",prepVars[2].toString());
		return prepJsonObject;
	}
	
	public JSONObject RecipeSearchParse(String[] recipepVars) throws JSONException {
		JSONObject recipeSearchJsonObject = new JSONObject();
		recipeSearchJsonObject.put("Category",recipepVars[0].toString());
		recipeSearchJsonObject.put("ingridient",recipepVars[1].toString());
		recipeSearchJsonObject.put("nutrition",recipepVars[2].toString());
		recipeSearchJsonObject.put("nutrition_quantity",recipepVars[3].toString());
		return recipeSearchJsonObject;
		
	}
	
	public JSONObject UserAddParse(List<String> userVars) throws JSONException {
		JSONObject UserAddJsonObject = new JSONObject();
		UserAddJsonObject.put("username", userVars.get(0).toString());
		UserAddJsonObject.put("password", userVars.get(1).toString());
		UserAddJsonObject.put("age", userVars.get(2));
		UserAddJsonObject.put("sex", userVars.get(3).toString());
		UserAddJsonObject.put("height", userVars.get(4));
		UserAddJsonObject.put("weight", userVars.get(5));
		return UserAddJsonObject;
	}
	
	public JSONObject UserRequestParse(String[] userRequestVars) throws JSONException {
		JSONObject userRequestJsonObject = new JSONObject();
		userRequestJsonObject.put("username", userRequestVars[0].toString());
		userRequestJsonObject.put("password", userRequestVars[1].toString());
		return userRequestJsonObject;
	}
	
	
	
}
