package it.jacopogaggiotti.intentcalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        View btn1 = findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar calendar = Calendar.getInstance();
                calendar.set(2023,Calendar.MAY,15,00,00);
                long beginTime = calendar.getTimeInMillis();

                Calendar calendar2 = Calendar.getInstance();
                calendar2.set(2023,Calendar.MAY,15,23,59);
                long endTime = calendar2.getTimeInMillis();

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE,"Festa dei CERI");
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION,"Gubbio");
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,beginTime);
                intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime);

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }
            }
        });
    }
}