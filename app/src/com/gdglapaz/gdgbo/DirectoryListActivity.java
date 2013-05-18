package com.gdglapaz.gdgbo;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.androidhive.jsonparsing.R;
import com.androidhive.jsonparsing.SingleMenuItemActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class DirectoryListActivity extends Activity {
	private static String url = "http://gdglapaz.codigobase.com/";
	
	private static final String TAG_CLIENTS = "clients";
	private static final String TAG_ID = "id";
	private static final String TAG_NAME = "name";
	private static final String TAG_CUENTA = "cuenta";
	
	// contacts JSONArray
	JSONArray contacts = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_directory_list);	
		
		// Hashmap for ListView
		ArrayList<HashMap<String, String>> contactList = new ArrayList<HashMap<String, String>>();

		// Creating JSON Parser instance
		JSONParser jParser = new JSONParser();

		// getting JSON string from URL
		JSONObject json = jParser.getJSONFromUrl(url);
		
		try {
			// Getting Array of Contacts
			contacts = json.getJSONArray(TAG_CLIENTS);
			
			// looping through All Contacts
			for(int i = 0; i < contacts.length(); i++){
				JSONObject c = contacts.getJSONObject(i);
				
				// Storing each json item in variable
				String id = c.getString(TAG_ID);
				String name = c.getString(TAG_NAME);
				String email = c.getString(TAG_CUENTA);
				
				// Phone number is agin JSON Object
				
				// creating new HashMap
				HashMap<String, String> map = new HashMap<String, String>();
				
				// adding each child node to HashMap key => value
				map.put(TAG_ID, id);
				map.put(TAG_NAME, name);
				map.put(TAG_CUENTA, email);

				// adding HashList to ArrayList
				contactList.add(map);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		/*
		ListAdapter adapter = new SimpleAdapter(this, contactList,
				R.layout.list_item,
				new String[] { TAG_NAME, TAG_SUCURSAL }, new int[] {
						R.id.name, R.id.mobile });

		setListAdapter(adapter);

		// selecting single ListView item
		ListView lv = getListView();*/

		// Launching new screen on Selecting Single ListItem
		/*lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// getting values from selected ListItem
				String name = ((TextView) view.findViewById(R.id.name)).getText().toString();
				String description = ((TextView) view.findViewById(R.id.mobile)).getText().toString();
				
				// Starting new intent
				Intent in = new Intent(getApplicationContext(), SingleMenuItemActivity.class);
				in.putExtra(TAG_NAME, name);
				startActivity(in);

			}
		});*/
	}
}
