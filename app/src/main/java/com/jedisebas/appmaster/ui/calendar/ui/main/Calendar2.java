package com.jedisebas.appmaster.ui.calendar.ui.main;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.jedisebas.appmaster.MainActivity;
import com.jedisebas.appmaster.R;
import com.jedisebas.appmaster.ui.calendar.CalendarActivity;

import java.util.Calendar;

public class Calendar2 extends Fragment {

    TextView hourTv;
    EditText notiftitle, notifsubtitle;
    TimePickerDialog.OnTimeSetListener onTimeSetListener;
    String hour="0", minuta="0";
    Button saveBtn;
    public static String title, subtitle;

    public static void setTitleANDSubtitle(String t, String st) {
        title = t;
        subtitle = st;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_calendar2, container, false);
        hourTv = root.findViewById(R.id.hourTv);
        notiftitle = root.findViewById(R.id.notifytitleEt);
        notifsubtitle = root.findViewById(R.id.notifysubtitleEt);
        saveBtn = root.findViewById(R.id.calendarBtn);

        notiftitle.setText(title);
        notifsubtitle.setText(subtitle);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = notiftitle.getText().toString().trim();
                subtitle = notifsubtitle.getText().toString().trim();
                CharSequence empty = "Nie podano wszystkiego";
                Context context = getContext();
                if (title.isEmpty() || subtitle.isEmpty()) {
                    Toast toast = Toast.makeText(context, empty, Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    MyIntentService.setBuilderTitle(title);
                    MyIntentService.setBuilderText(subtitle);
                    CalendarActivity.changeTitleANDSubtitle(title, subtitle);


                    int h = Integer.parseInt(hour);
                    int m = Integer.parseInt(minuta);

                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.HOUR_OF_DAY, h);
                    calendar.set(Calendar.MINUTE, m);
                    calendar.set(Calendar.SECOND, 1);


                    Intent notifyIntent = new Intent(getContext(),MyReceiver.class);
                    PendingIntent pendingIntent = PendingIntent.getBroadcast
                            (context, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                    AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                            AlarmManager.INTERVAL_DAY , pendingIntent);

                }
            }
        });

        hourTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int hour = cal.get(Calendar.HOUR_OF_DAY);
                int minute = cal.get(Calendar.MINUTE);

                Context context = getContext();

                TimePickerDialog dialog = new TimePickerDialog(context, onTimeSetListener, hour, minute, true);
                String currentmode = MainActivity.choicetheme.getString("mode", "dark");
                if (currentmode.equals("dark")) {
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(20,20,20)));
                } else {
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(255,255,255)));
                }
                dialog.show();
            }
        });

        onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String hourofdays = "";
                String minutes = "";
                if (hourOfDay < 10) {
                    hourofdays = "0" + hourOfDay;
                } else {
                    hourofdays = "" + hourOfDay;
                }
                if (minute < 10) {
                    minutes = "0" + minute;
                } else {
                    minutes = "" + minute;
                }
                String t = hourofdays + ":" + minutes;
                hour = hourofdays;
                minuta = minutes;

                hourTv.setText(t);
            }
        };

        return root;
    }
}
