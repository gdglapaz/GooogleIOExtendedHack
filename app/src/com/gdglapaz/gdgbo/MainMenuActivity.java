package com.gdglapaz.gdgbo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainMenuActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
	}
	
	public void showLoginGoogle(View v) {
		startActivity(new Intent(MainMenuActivity.this, MainActivity.class));
	}
	
	public void showDirectorio(View v) {
		startActivity(new Intent(MainMenuActivity.this, DirectoryListActivity.class));
	}
}
