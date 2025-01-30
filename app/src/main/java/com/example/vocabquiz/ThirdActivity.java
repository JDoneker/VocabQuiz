package com.example.vocabquiz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ThirdActivity extends AppCompatActivity {
    private HashMap<String, String> vocabularyMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        vocabularyMap = setVocab();
        Button button = findViewById(R.id.reveal);
        final TextView textView = findViewById(R.id.definition);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> keysAsArray = new ArrayList<String>(vocabularyMap.keySet());
                Random r = new Random();
                String randomKey = keysAsArray.get(r.nextInt(keysAsArray.size()));
                textView.setText(vocabularyMap.get(randomKey));
            }
        });
    }

    private HashMap<String, String> setVocab() {
        HashMap<String, String> temp = new HashMap<>();
        temp.put("Amargado", "Bitter or resentful person");
        temp.put("Con la pata en alto", "With the leg raised (referring to being in a relaxed or idle state)");
        temp.put("Escayola", "Plaster cast (used for broken bones)");
        temp.put("Estado de alarma", "State of alarm (a legal state in which emergency measures are taken)");
        temp.put("Confinamiento", "Lockdown (the restriction of movement during a crisis)");
        temp.put("Recapacitar", "To rethink or reconsider");
        temp.put("Aplaudir", "To applaud");
        temp.put("Estar de mala leche", "To be in a bad mood");
        temp.put("Estar de cachondeo", "To be joking or messing around");
        temp.put("Estar muy mono/mona", "To look very cute or attractive");

        temp.put("Voluntariado", "Volunteering");
        temp.put("Comprometerse", "To commit oneself");
        temp.put("Reivindicar", "To claim or advocate for something");
        temp.put("Agravarse", "To worsen or intensify");
        temp.put("Pobreza", "Poverty");
        temp.put("Tomar conciencia", "To become aware");
        temp.put("Solidaridad", "Solidarity");
        temp.put("Desigualdad", "Inequality");
        temp.put("Compromiso", "Commitment");
        temp.put("Aportar un granito de arena", "To contribute a small part");

        temp.put("Auge", "Rise or boom");
        temp.put("A menudo", "Frequently");
        temp.put("Trascender", "To transcend or go beyond");
        temp.put("Entablar", "To establish or start (a relationship or conversation)");
        temp.put("Vagar", "To wander or roam");
        temp.put("Entorno", "Environment or surroundings");
        temp.put("Llevarse (con alguien)", "To get along with someone");
        temp.put("Tolerar", "To tolerate or endure");
        temp.put("Arraigo", "Rootedness or strong connection");
        temp.put("Merodear", "To roam or lurk around");
        temp.put("Expatriado", "Expatriate (someone living outside their home country)");

        temp.put("Vínculo", "Link or bond");
        temp.put("Aislado", "Isolated");
        temp.put("Llevarse con alguien", "To get along with someone");
        temp.put("Fuente", "Source");
        temp.put("Afín", "Similar or kindred");
        temp.put("Acompañamiento", "Support or accompaniment");
        temp.put("Darle mil vueltas", "To overthink something");
        temp.put("Compromiso", "Commitment");
        temp.put("Afectivo", "Affective or emotional");
        temp.put("Forjarse", "To forge or form (a relationship or identity)");
        return temp;
    }

}