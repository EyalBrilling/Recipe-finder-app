package AppAndParsers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javax.swing.JButton;

import org.json.JSONException;
import org.json.JSONObject;

import UI.Welcome;
import network.Client;

public class AppManager implements ActionListener{
	 static Welcome  welcome;
	 static JSONParser jsonParser=new JSONParser();
	 static VarsParser varsParser=new VarsParser();
	 static Client client=new Client();
	 
	public static void main(String[] args) {
		client.startConnection(null, 0);
		welcome=new Welcome(new AppManager());
		welcome.setVisible(true);
	}
	
	
	public AppManager() {
		
	}
		
	public void actionPerformed(ActionEvent e) {
		JButton button= (JButton) e.getSource();
		if (button.getName()=="sign_in_menu_button") {
			List<String> ListSign_in_Vars=welcome.ReturnSignInVars();
			JSONObject dJsonObject=new JSONObject();
			JSONObject var_list_JsonObject = null;
			try {
				var_list_JsonObject = varsParser.UserAddParse(ListSign_in_Vars);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String response = null;
			try {
				response = client.SendNewUser(var_list_JsonObject).toString();
			} catch (URISyntaxException | IOException | InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (response =="0") {
				//could save user error
			}
			
		}
		

		else if (button.getName()=="log_in_button") {
			String[] ListLog_in_Vars=welcome.ReturnLogInVars();
			JSONObject user_var_list = null;
			try {
				user_var_list = varsParser.UserRequestParse(ListLog_in_Vars);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String response = null;
			try {
				response = client.GetUser(user_var_list).toString();
			} catch (URISyntaxException | IOException | InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (response =="") {
				//could not find user
			}
			
		}
		
		else if (button.getName()=="recipes_get_button") {
			String[] recipe_Vars=welcome.getRecipeVars();
			JSONObject var_list_JsonObject = null;
			try {
				var_list_JsonObject = varsParser.RecipeSearchParse(recipe_Vars);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String response = null;
			try {
				response = client.SendNewUser(var_list_JsonObject).toString();
			} catch (URISyntaxException | IOException | InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (response =="0") {
				//could save user error
			}
			
		}
		
		else if (button.getName()=="recipe_update_button") {
			String[] recipe_update_Vars=welcome.getRecipeVars();
			JSONObject var_list_JsonObject = null;
			try {
				var_list_JsonObject = varsParser.RecipePrepTimeUpdateParse(recipe_update_Vars);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String response = null;
			try {
				response = client.SendNewUser(var_list_JsonObject).toString();
			} catch (URISyntaxException | IOException | InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (response =="0") {
				//could save user error
			}
			
		}
		
		
		//System.out.print("hello");
		String[] parsed= new String[] {"hey","2"};
	}

	

}
