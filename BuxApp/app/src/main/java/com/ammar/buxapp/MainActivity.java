package com.ammar.buxapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView teamsView = findViewById(R.id.recycler_view);

        List<TicketModel> tickets = new ArrayList<>();

        tickets.add(new TicketModel("Ammar Ridwan Darma", "081211557242", 2, "7,8", "Sinar Jaya", "230719-0001", "P 1921 NM", "17:35", "22:30", "Magelang", "Medan Utara", "05/20/2022",
                "05/25/2022", "Terminal Kampung DR", "Terminal Bocil Kematian", 350000));
        tickets.add(new TicketModel("Ridwan Ganteng", "082211557242", 1, "9", "Surajana", "230719-0511", "B 1122 CC", "12:35", "22:30", "Padang", "Aceh", "05/23/2022",
                "05/25/2022", "Terminal Basudara", "Terminal Bocil Kematian", 350000));
        tickets.add(new TicketModel("Darma GG GEMING", "083311557242", 3, "1,10,11", "Wawa san ", "235519-0101", "R 3122 TQ", "10:00", "15:30", "Jakarta", "Bandung", "05/22/2022",
                "05/22/2022", "Terminal Melayu", "Terminal Bocil Kematian",  350000));

        TicketAdapter adapter = new TicketAdapter(this, tickets);
        teamsView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        teamsView.setLayoutManager(layoutManager);
    }
}