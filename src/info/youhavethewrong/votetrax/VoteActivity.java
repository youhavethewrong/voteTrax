package info.youhavethewrong.votetrax;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class VoteActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_vote);

		final Button decButton = (Button) findViewById(R.id.decrement_button);
		decButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				changePoints(-1);
			}
		});
		
		final Button incButton = (Button) findViewById(R.id.increment_button);	
		incButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				changePoints(1);
			}
		});
	}

	private void changePoints(int i) {
		TextView tv = (TextView)findViewById(R.id.fullscreen_content);
		CharSequence text = tv.getText();
		char currentVal = text.charAt(0);
		currentVal += i;
		char[] rebuild = new char[1];
		rebuild[0] = (char) currentVal;
		if(rebuild[0] > '9')
			rebuild[0] = '9';
		else if (rebuild[0] < '0')
			rebuild[0] = '0';
		tv.setText(rebuild, 0, 1);
	}
}
