package com.example.vocabquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    private ArrayList<String> receivedStringArrayList;
    private char status;
    String randomKey;
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

        vocabularyMap = new HashMap<>();
        Intent intent = getIntent();
        receivedStringArrayList = intent.getStringArrayListExtra("key");
        if (receivedStringArrayList != null) {
            for (String str : receivedStringArrayList) {
                Toast.makeText(ThirdActivity.this, str, Toast.LENGTH_SHORT).show();
                addVocab(str);
            }
        }


        


        Button reveal = findViewById(R.id.buttonReveal);
        TextView definition = findViewById(R.id.textDefintion);
        TextView word = findViewById(R.id.textWord);
        status = 'n';

        reveal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!vocabularyMap.isEmpty()) {
                    if (status == 'n') {
                        List<String> keysAsArray = new ArrayList<String>(vocabularyMap.keySet());
                        Random r = new Random();
                        randomKey = keysAsArray.get(r.nextInt(keysAsArray.size()));
                        word.setText(randomKey);
                        reveal.setText("Reveal Definition");

                        definition.setText("Definition will appear here.");
                        status = 'y';
                    } else if (status == 'y') {
                        definition.setText(vocabularyMap.remove(randomKey));
                        reveal.setText("Get New Word");

                        status = 'n';
                    }
                }else{
                    Toast.makeText(ThirdActivity.this, "No more words left. Please Restart", Toast.LENGTH_LONG).show();
                }


            }
        });
    }

    private void addVocab(String str) {
        switch (str){
            case "checkBox1.1":
                vocabularyMap.put("Hábitos saludables", "Healthy habits (actions that promote physical and mental well-being)");
                vocabularyMap.put("Lidiar con el estrés", "To deal with stress (handling the pressures and challenges of life)");
                vocabularyMap.put("Tener compasión", "To have compassion (to feel sympathy and concern for others' suffering)");
                vocabularyMap.put("Gestionar (estrés/tiempo)", "To manage (stress/time) (to effectively control or organize stress or time)");
                vocabularyMap.put("No procrastinar", "Not to procrastinate (to avoid delaying tasks or decisions)");
                vocabularyMap.put("Relajar(se)", "To relax (to become less tense or anxious)");
                vocabularyMap.put("(Hacer) vida social", "To have a social life (to engage in activities with friends and acquaintances)");
                vocabularyMap.put("Distraer(se)", "To distract oneself (to divert attention from stress or negative thoughts)");
                vocabularyMap.put("Asertividad", "Assertiveness (the quality of being self-assured and confident without being aggressive)");
                vocabularyMap.put("Mimar(se)", "To pamper oneself (to indulge or treat oneself with care and attention)");

                vocabularyMap.put("Salud física y mental", "Physical and mental health (overall well-being, both in body and mind)");

                vocabularyMap.put("(Signos de) alerta", "Signs of alert (indications of warning or potential danger)");
                vocabularyMap.put("(Comportamiento) errático", "Erratic behavior (inconsistent or unpredictable actions)");
                vocabularyMap.put("Padecer", "To suffer from (to experience discomfort or illness)");
                vocabularyMap.put("Duro", "Tough or hard (difficult or challenging, often used to describe experiences)");
                vocabularyMap.put("Pasarlo mal", "To have a hard time (to endure difficult or uncomfortable situations)");
                vocabularyMap.put("Dar importancia", "To give importance (to consider something as significant or meaningful)");
                vocabularyMap.put("Dañino", "Harmful (having the potential to cause damage or injury)");
                vocabularyMap.put("Sedentarismo", "Sedentarism (lack of physical activity or sitting for long periods)");
                vocabularyMap.put("Ejercicio físico moderado", "Moderate physical exercise (physical activity done at a moderate intensity level)");
                vocabularyMap.put("Enfermedades crónicas", "Chronic diseases (long-lasting health conditions that are typically difficult to cure)");
                vocabularyMap.put("Tensión (presión arterial)", "Tension (blood pressure) (the force exerted by circulating blood on the walls of blood vessels)");
                vocabularyMap.put("Estar irritado", "To be irritated (to feel frustrated or angry due to stress or discomfort)");
                vocabularyMap.put("Cansancio", "Fatigue (extreme tiredness or exhaustion)");
                vocabularyMap.put("Anorexia", "Anorexia (an eating disorder characterized by an intense fear of gaining weight and a restriction of food intake)");
                vocabularyMap.put("Bulimia", "Bulimia (an eating disorder characterized by binge eating followed by purging to prevent weight gain)");
                vocabularyMap.put("Dieta", "Diet (the types and amounts of food consumed regularly)");

                vocabularyMap.put("Granos", "Pimples (small raised spots on the skin, often caused by acne)");
                vocabularyMap.put("Endulzar", "To sweeten (to add sweetness to something, typically food or drink)");
                vocabularyMap.put("Aceite", "Oil (a liquid substance used in cooking or as a lubricant)");
                vocabularyMap.put("Porciones", "Portions (the amount of food served or consumed at one time)");
                vocabularyMap.put("Bebidas gaseosas", "Soda (carbonated drinks, often sweetened and flavored)");
                vocabularyMap.put("Comida basura", "Junk food (unhealthy food, typically high in fats, sugars, and salts)");

                vocabularyMap.put("Tecnología y salud", "Technology and health (the impact of technology on physical and mental well-being)");

                vocabularyMap.put("(Uso) prolongado", "Prolonged use (using something for an extended period, often leading to negative effects)");
                vocabularyMap.put("(Alertas) vibratorias", "Vibratory alerts (signals or notifications that use vibration to grab attention)");
                vocabularyMap.put("Estar pendiente", "To be attentive (to stay focused or concerned about something)");
                vocabularyMap.put("Insomnio", "Insomnia (the inability to sleep or difficulty staying asleep)");
                vocabularyMap.put("Sistema immune", "Immune system (the body’s defense system against harmful organisms and diseases)");

                vocabularyMap.put("Ejercicio físico", "Physical exercise (activities involving physical exertion to maintain or improve health)");

                vocabularyMap.put("Abdominales", "Abdominal exercises (workouts targeting the muscles in the stomach area)");
                vocabularyMap.put("Footing", "Jogging (a form of running at a steady, moderate pace)");
                vocabularyMap.put("Calambres", "Cramps (painful muscle contractions often caused by overuse or dehydration)");
                vocabularyMap.put("Flexibilidad", "Flexibility (the ability to move joints and muscles through their full range of motion)");
                vocabularyMap.put("Hidratación", "Hydration (the process of maintaining adequate fluid levels in the body)");
                vocabularyMap.put("Peso", "Weight (the measure of how heavy a person or object is)");
                vocabularyMap.put("Fortalecer", "To strengthen (to make something more powerful or resilient)");
                vocabularyMap.put("Entrenamiento", "Training (the process of learning and developing skills or fitness)");
                vocabularyMap.put("Frecuencia", "Frequency (the rate at which something occurs or repeats)");

                vocabularyMap.put("Frases hechas relacionadas con la salud", "Common health-related expressions");

                vocabularyMap.put("Lograr un equilibrio", "To achieve balance (to maintain a healthy and manageable equilibrium in life)");
                vocabularyMap.put("Estar/ponerse en forma", "To get in shape (to become physically fit through exercise and diet)");
                vocabularyMap.put("Ponerse en pie", "To stand up (to rise to an upright position)");
                vocabularyMap.put("Entrarle a uno/a alguien el pánico", "To be overcome with panic (to feel sudden, intense fear)");
                vocabularyMap.put("Quemar las velas (por ambos extremos)", "To burn the candle at both ends (to work excessively and exhaust oneself)");
                vocabularyMap.put("Acabar con", "To put an end to (to stop or finish something, often with finality)");
                vocabularyMap.put("Tener una salud de hierro", "To have iron health (to be in excellent physical condition)");
                vocabularyMap.put("Pasar por el bisturí", "To go under the knife (to undergo surgery or a medical procedure)");
                vocabularyMap.put("Tener frentes abiertos", "To have many open fronts (to be dealing with multiple issues simultaneously)");
                vocabularyMap.put("Pasar la noche en vela", "To stay up all night (to remain awake without sleep)");
                vocabularyMap.put("Ser lo que uno come", "You are what you eat (suggesting that diet influences health and well-being)");
                vocabularyMap.put("Estar como un roble", "To be as strong as an oak (to be very healthy or physically strong)");

                vocabularyMap.put("No levantar cabeza", "To not be able to recover (to be overwhelmed or unable to bounce back from challenges)");
                vocabularyMap.put("Dormir como un lirón", "To sleep like a dormouse (to sleep very deeply and peacefully)");
                vocabularyMap.put("Estar como una rosa", "To be in perfect health (to be feeling great or looking well)");
                vocabularyMap.put("Estar pachucho", "To feel a bit off (to be feeling unwell or slightly sick)");
                vocabularyMap.put("Estar hecho polvo", "To be exhausted (to be extremely tired or worn out)");
                vocabularyMap.put("No pegar ojo", "To not sleep a wink (to be unable to sleep at all)");

                break;
            case "checkBox1.2":
                vocabularyMap.put("Resiliencia", "Resilience, the ability to recover from adversity");
                vocabularyMap.put("Empatía", "Empathy, the ability to understand and share the feelings of others");
                vocabularyMap.put("Sinceridad", "Sincerity, the quality of being honest and genuine");
                vocabularyMap.put("Responsabilidad", "Responsibility, the duty to take care of something or someone");
                vocabularyMap.put("Compañerismo", "Companionship, a sense of fellowship and teamwork");
                vocabularyMap.put("Gratitud", "Gratitude, a feeling of thankfulness");
                vocabularyMap.put("Piedad", "Piety, devotion and reverence, often religious");
                vocabularyMap.put("Modestia", "Modesty, the quality of being humble and not boastful");
                vocabularyMap.put("Honradez", "Honesty, the quality of being truthful and fair");
                vocabularyMap.put("Solidaridad", "Solidarity, unity and mutual support");
                vocabularyMap.put("Bondad", "Kindness, the quality of being good and caring");
                vocabularyMap.put("Esperanza", "Hope, the expectation of positive outcomes");
                vocabularyMap.put("Paciencia", "Patience, the ability to endure difficulties calmly");
                vocabularyMap.put("Fortaleza", "Strength, both physical and emotional resilience");
                vocabularyMap.put("Confianza", "Trust, reliance on the integrity of someone or something");

                // Defectos, faltas o ejemplos de mal comportamiento
                vocabularyMap.put("Maldad", "Evil, wickedness or cruelty");
                vocabularyMap.put("Deshonestidad", "Dishonesty, lack of truthfulness");
                vocabularyMap.put("Insolidaridad", "Lack of solidarity, unwillingness to support others");
                vocabularyMap.put("Rebeldía", "Rebellion, resistance to authority");
                vocabularyMap.put("Desconsideración", "Disrespect, lack of consideration for others");
                vocabularyMap.put("Aversión", "Aversion, a strong dislike or opposition");
                vocabularyMap.put("Debilidad", "Weakness, lack of strength or resolve");
                vocabularyMap.put("Insubordinación", "Insubordination, defiance of authority");

                // Conceptos relacionados con las creencias y los valores
                vocabularyMap.put("Igualdad", "Equality, the state of being equal");
                vocabularyMap.put("Entorno", "Environment, surroundings or setting");
                vocabularyMap.put("Libertad de expresión", "Freedom of speech, the right to express one's opinions");
                vocabularyMap.put("Mente abierta", "Open-mindedness, willingness to consider new ideas");
                vocabularyMap.put("Valores universales", "Universal values, moral principles applicable to all societies");
                vocabularyMap.put("Comportamiento", "Behavior, the way a person acts");
                vocabularyMap.put("Amistad", "Friendship, a close and mutual bond between people");
                vocabularyMap.put("Equidad", "Equity, fairness and impartiality");
                vocabularyMap.put("Capacidades", "Capabilities, skills or competencies");
                vocabularyMap.put("Prejuicio", "Prejudice, a preconceived opinion not based on reason");
                vocabularyMap.put("Convivencia", "Coexistence, living together peacefully");

                // Religiones
                vocabularyMap.put("Adoración", "Worship, reverence and devotion to a deity");
                vocabularyMap.put("Bautizar", "To baptize, to perform a religious rite of initiation");
                vocabularyMap.put("Alma", "Soul, the spiritual essence of a person");
                vocabularyMap.put("Cielo", "Heaven, the place of divine presence");
                vocabularyMap.put("Paraíso", "Paradise, a place of perfect happiness");
                vocabularyMap.put("Fe", "Faith, strong belief or trust, often religious");
                vocabularyMap.put("Santuario", "Sanctuary, a sacred place of refuge");
                vocabularyMap.put("Sistema de creencias", "Belief system, a structured set of faiths or ideologies");

                // Etnias y ritos
                vocabularyMap.put("Mestizaje", "Miscegenation, the mixing of different ethnic groups");
                vocabularyMap.put("Criollo", "Creole, a person of mixed European and native descent");
                vocabularyMap.put("Mozo", "Young man, often used to describe a servant or worker");
                vocabularyMap.put("Payo", "Non-Romani person, commonly used in Spain");
                vocabularyMap.put("Rito", "Rite, a ceremonial act");

                break;
            case "checkBox1.3":
                vocabularyMap.put("Identidad", "Identity, the sense of self");
                vocabularyMap.put("Grupo cohesionado", "Cohesive group, a closely bonded community");
                vocabularyMap.put("Memoria colectiva", "Collective memory, shared historical experiences");
                vocabularyMap.put("Condición social", "Social condition, one's position in society");
                vocabularyMap.put("Puntos en común", "Commonalities, shared characteristics");
                vocabularyMap.put("Organización", "Organization, a structured group or system");
                vocabularyMap.put("Búsqueda", "Search, the act of looking for something");
                vocabularyMap.put("Convivencia", "Coexistence, living together in harmony");
                vocabularyMap.put("Evolución", "Evolution, gradual change and development");
                vocabularyMap.put("Ideas", "Ideas, thoughts or concepts");
                vocabularyMap.put("Juntar(se)", "To gather, to come together");
                vocabularyMap.put("Estilo de vida", "Lifestyle, the way a person or group lives");
                vocabularyMap.put("En desuso", "Obsolete, no longer in use");
                vocabularyMap.put("Hostigar", "To harass, to bother persistently");
                vocabularyMap.put("Reconocimiento", "Recognition, acknowledgment of something");
                vocabularyMap.put("Esperanza", "Hope, expectation of a positive outcome");
                vocabularyMap.put("Redes", "Networks, interconnected systems or groups");
                vocabularyMap.put("Marginal", "Marginal, on the outskirts of society");
                vocabularyMap.put("Independizarse", "To become independent, to gain autonomy");
                vocabularyMap.put("Seguidor", "Follower, someone who supports a group or idea");
                vocabularyMap.put("Fusión", "Fusion, blending of different elements");

                // Skaters
                vocabularyMap.put("Monopatín", "Skateboard");
                vocabularyMap.put("Voltear", "To flip, to turn over");
                vocabularyMap.put("Rampas", "Ramps, inclined surfaces for skating");

                // Atuendos y símbolos
                vocabularyMap.put("Marca", "Brand, a label identifying a product");
                vocabularyMap.put("Atuendo", "Outfit, clothing ensemble");
                vocabularyMap.put("Pitillo", "Skinny jeans");
                vocabularyMap.put("Flequillo", "Bangs, hair cut across the forehead");
                vocabularyMap.put("Pulsera", "Bracelet, wrist accessory");
                vocabularyMap.put("Ropa holgada", "Loose clothing");
                vocabularyMap.put("Colores chillones", "Bright colors, flashy hues");
                vocabularyMap.put("Estética", "Aesthetics, visual style");

                break;
            case "checkBox1.4":
                vocabularyMap.put("Lengua", "Language");
                vocabularyMap.put("Entendimiento", "Understanding");
                vocabularyMap.put("Construir puentes", "To build bridges");
                vocabularyMap.put("Renuevan", "They renew");
                vocabularyMap.put("Embajador", "Ambassador");
                vocabularyMap.put("Pluralidad", "Plurality");
                vocabularyMap.put("Riqueza", "Wealth or richness");
                vocabularyMap.put("Curiosidad", "Curiosity");
                vocabularyMap.put("Disfrute", "Enjoyment");
                vocabularyMap.put("Palabra", "Word");

                // El multilingüismo
                vocabularyMap.put("Atrasado", "Delayed or behind");
                vocabularyMap.put("Inversión", "Investment");
                vocabularyMap.put("Tardíamente", "Late");
                vocabularyMap.put("A la vez", "At the same time");
                vocabularyMap.put("Altera", "It alters");
                vocabularyMap.put("Se pierden", "They are lost");
                vocabularyMap.put("Canguro", "Babysitter");
                vocabularyMap.put("Sensorial", "Sensory");
                vocabularyMap.put("Asiduidad", "Frequency or regularity");
                vocabularyMap.put("Vejez", "Old age");

                // Los idiomas indígenas
                vocabularyMap.put("Lenguas ancestrales", "Ancestral languages");
                vocabularyMap.put("En auge", "On the rise");
                vocabularyMap.put("Foráneas", "Foreign");
                vocabularyMap.put("Siglo de Oro", "Golden Age");
                vocabularyMap.put("Siglo XVIII", "18th century");
                vocabularyMap.put("Región andina", "Andean region");
                vocabularyMap.put("Siglo XXI", "21st century");
                vocabularyMap.put("Excepción", "Exception");
                vocabularyMap.put("Se enorgullezcan", "They take pride");
                vocabularyMap.put("Plurilingüismo", "Multilingualism");

                break;
            case "checkBox2.1":
                vocabularyMap.put("Tocar la guitarra", "To play the guitar");
                vocabularyMap.put("Practicar yoga", "To practice yoga");
                vocabularyMap.put("Los momentos de ocio", "Leisure moments");
                vocabularyMap.put("Salir a divertirse", "To go out to have fun");
                vocabularyMap.put("Ha salido de gira", "Has gone on tour");
                vocabularyMap.put("Practicar deportes", "To practice sports");
                vocabularyMap.put("Formar parte de un equipo", "To be part of a team");
                vocabularyMap.put("Teléfonos inteligentes", "Smartphones");

                // Frases hechas relacionadas con las actividades de ocio
                vocabularyMap.put("Rojo/a como un tomate", "Red as a tomato");
                vocabularyMap.put("Como un roble", "Strong as an oak");
                vocabularyMap.put("Un ojo de la cara", "Costs an arm and a leg");
                vocabularyMap.put("En su tiempo libre", "In one's free time");
                vocabularyMap.put("Meter la pata", "To put one's foot in it");
                vocabularyMap.put("Fresca como una lechuga", "Fresh as a lettuce");
                vocabularyMap.put("Pan comido", "Piece of cake");

                // El mundo deportivo
                vocabularyMap.put("Sudaron la camiseta", "They gave it their all");
                vocabularyMap.put("Me he tirado a la piscina", "I took the plunge");
                vocabularyMap.put("Contra reloj", "Against the clock");
                vocabularyMap.put("Tirar la toalla", "To throw in the towel");
                vocabularyMap.put("Da en el blanco", "Hits the target");
                vocabularyMap.put("Una maratón", "A marathon");
                vocabularyMap.put("Una vida equilibrada", "A balanced life");


                break;
            case "checkBox2.2":
                vocabularyMap.put("Estacional", "Seasonal");
                vocabularyMap.put("Destinos", "Destinations");
                vocabularyMap.put("Naturales", "Natural");
                vocabularyMap.put("Sol", "Sun");
                vocabularyMap.put("Reclamo", "Attraction or appeal");
                vocabularyMap.put("Declarada", "Declared");
                vocabularyMap.put("Media", "Average");
                vocabularyMap.put("Riqueza", "Wealth");
                vocabularyMap.put("Verde", "Green");
                vocabularyMap.put("Viñedos", "Vineyards");

                // El turismo de masas
                vocabularyMap.put("Se ha matado la gallina de los huevos de oro", "They have killed the goose that laid the golden eggs");
                vocabularyMap.put("Pinares", "Pine forests");
                vocabularyMap.put("Tienen los días contados", "Their days are numbered");
                vocabularyMap.put("Desocupadas", "Unoccupied");
                vocabularyMap.put("Urbanizables", "Developable");
                vocabularyMap.put("Puestos", "Jobs");
                vocabularyMap.put("Proyectos", "Projects");

                break;
            case "checkBox2.3":
                vocabularyMap.put("Niñez", "Childhood");
                vocabularyMap.put("Pubertad/adolescencia", "Puberty/Adolescence");
                vocabularyMap.put("Vejez", "Old age");

                vocabularyMap.put("Apego", "Attachment");
                vocabularyMap.put("Apoyo", "Support");
                vocabularyMap.put("Alejarse (de las normas)", "To deviate (from the norms)");
                vocabularyMap.put("Realización", "Fulfillment");
                vocabularyMap.put("Momentos duros", "Tough moments");
                vocabularyMap.put("Momentos formidables", "Great moments");

                vocabularyMap.put("Despertar físico", "Physical awakening");
                vocabularyMap.put("Fuerza", "Strength");
                vocabularyMap.put("Capacidad", "Capacity");

                vocabularyMap.put("Echar de menos", "To miss");
                vocabularyMap.put("Avanzar", "To advance");
                vocabularyMap.put("Dejar huella", "To leave a mark");
                vocabularyMap.put("Conseguir", "To achieve");
                vocabularyMap.put("Complicado", "Complicated");
                vocabularyMap.put("Diferente", "Different");
                vocabularyMap.put("Volver", "To return");
                vocabularyMap.put("Sentir", "To feel");
                vocabularyMap.put("Formar parte", "To be part of");
                vocabularyMap.put("Agradecer", "To thank");
                vocabularyMap.put("Estrés", "Stress");
                vocabularyMap.put("Aprender", "To learn");
                vocabularyMap.put("Mirar a través de", "To look through");
                vocabularyMap.put("Fomentar", "To encourage");
                vocabularyMap.put("Aleccionar", "To teach (a lesson)");
                vocabularyMap.put("Valores", "Values");
                vocabularyMap.put("Sueños", "Dreams");
                vocabularyMap.put("Esfuerzo", "Effort");
                vocabularyMap.put("Luchar", "To fight");
                vocabularyMap.put("Éxito", "Success");
                vocabularyMap.put("Emprender", "To undertake");
                vocabularyMap.put("Grabar", "To record");
                vocabularyMap.put("Recuerdos", "Memories");
                vocabularyMap.put("Nostalgia", "Nostalgia");

                vocabularyMap.put("Resultado", "Result");
                vocabularyMap.put("Ambición", "Ambition");
                vocabularyMap.put("Remunerado", "Remunerated");
                vocabularyMap.put("Eficiencia", "Efficiency");
                vocabularyMap.put("Puesto", "Position");
                vocabularyMap.put("Involucrar", "To involve");
                vocabularyMap.put("Remoto", "Remote");
                vocabularyMap.put("Prioridad", "Priority");
                vocabularyMap.put("Desigualdad", "Inequality");
                vocabularyMap.put("Batir", "To beat");

                break;
            case "checkBox2.4":
                vocabularyMap.put("Nacer", "To be born");
                vocabularyMap.put("Crecer", "To grow");
                vocabularyMap.put("Graduarse", "To graduate");
                vocabularyMap.put("Mudarse", "To move");
                vocabularyMap.put("Enamorarse", "To fall in love");
                vocabularyMap.put("Casarse", "To get married");
                vocabularyMap.put("Divorciarse", "To get divorced");
                vocabularyMap.put("Jubilarse", "To retire");
                vocabularyMap.put("Morirse", "To die");

                vocabularyMap.put("Anonimato", "Anonymity");
                vocabularyMap.put("Deshilachados", "Frayed");
                vocabularyMap.put("Comparsa", "Parade group");
                vocabularyMap.put("Pervivir", "To endure");
                vocabularyMap.put("Paliar", "To alleviate");
                vocabularyMap.put("Atribulados", "Troubled");
                vocabularyMap.put("Recinto", "Enclosure");
                vocabularyMap.put("Jalear", "To cheer");
                vocabularyMap.put("Apenas", "Barely");
                vocabularyMap.put("Sagrado", "Sacred");

                vocabularyMap.put("Escalada", "Climbing");
                vocabularyMap.put("Salto base", "Base jumping");
                vocabularyMap.put("Paracaidismo", "Skydiving");
                vocabularyMap.put("Parapente", "Paragliding");
                vocabularyMap.put("Descenso de ríos", "River rafting");
                vocabularyMap.put("Puenting", "Bungee jumping");
                vocabularyMap.put("Surf", "Surfing");
                vocabularyMap.put("Esquí alpino", "Alpine skiing");
                vocabularyMap.put("Rapel", "Rappelling");
                vocabularyMap.put("Submarinismo", "Scuba diving");

                vocabularyMap.put("Corona", "Crown");
                vocabularyMap.put("Misa", "Mass");
                vocabularyMap.put("Invitaciones", "Invitations");
                vocabularyMap.put("Chambelanes", "Chamberlains");
                vocabularyMap.put("Vals", "Waltz");
                vocabularyMap.put("Tarta", "Cake");
                vocabularyMap.put("Maestro de ceremonias", "Master of ceremonies");
                vocabularyMap.put("Zapatos de tacón", "High heels");

                vocabularyMap.put("Se pone", "It becomes");
                vocabularyMap.put("Se ha vuelto", "It has become");
                vocabularyMap.put("Ha llegado a ser", "It has become");
                vocabularyMap.put("Se hizo", "It was done");
                vocabularyMap.put("Se quedó", "It stayed");
                vocabularyMap.put("Se ha convertido en", "It has turned into");
                vocabularyMap.put("Ponerse el mundo por montera", "To go headfirst into everything");
                vocabularyMap.put("Tener el corazón en un puño", "To have a tight heart");
                vocabularyMap.put("Entrar en pánico", "To panic");
                vocabularyMap.put("Estar como unas castañuelas", "To be extremely happy");
                vocabularyMap.put("Hacer codos", "To study hard");
                vocabularyMap.put("Tirar la casa por la ventana", "To spare no expense");

                break;
            case "checkBox2.5":
                vocabularyMap.put("Altar", "Altar");
                vocabularyMap.put("Calavera", "Skull");
                vocabularyMap.put("Máscara", "Mask");
                vocabularyMap.put("Tumbas", "Graves");
                vocabularyMap.put("Velas", "Candles");
                vocabularyMap.put("Esqueleto", "Skeleton");
                vocabularyMap.put("Ofrendas", "Offerings");
                vocabularyMap.put("Ataúd", "Coffin");
                vocabularyMap.put("Ceremonial", "Ceremonial");
                vocabularyMap.put("Dulces", "Sweets or candies");

                // De Navidad
                vocabularyMap.put("Campanada", "Chime or bell toll");
                vocabularyMap.put("Turrón", "Nougat");
                vocabularyMap.put("Brindar", "To toast (celebration)");
                vocabularyMap.put("Nochevieja", "New Year's Eve");
                vocabularyMap.put("Nochebuena", "Christmas Eve");
                vocabularyMap.put("Guirnalda", "Garland");
                vocabularyMap.put("Pesebre", "Nativity scene");
                vocabularyMap.put("Reyes Magos", "Three Wise Men");
                vocabularyMap.put("Villancicos", "Christmas carols");
                vocabularyMap.put("Bromas", "Jokes or pranks");

                // Bailes y danza
                vocabularyMap.put("Danza", "Dance");
                vocabularyMap.put("Flamenco", "Flamenco (Spanish dance)");
                vocabularyMap.put("Sevillanas", "Sevillanas (Spanish folk dance)");
                vocabularyMap.put("Coreógrafo", "Choreographer");
                vocabularyMap.put("Bailaor", "Flamenco dancer");
                vocabularyMap.put("Mezcolanza", "Mixture or medley");
                vocabularyMap.put("Folclore", "Folklore");
                vocabularyMap.put("Andalucía", "Andalusia");
                vocabularyMap.put("Divertimento", "Entertainment or amusement");
                vocabularyMap.put("Piruetas", "Pirouettes or spins");
                vocabularyMap.put("Tablado", "Stage for flamenco dancing");

                // Fiesta
                vocabularyMap.put("Disfrazarse", "To dress up in a costume");
                vocabularyMap.put("Coro", "Choir");
                vocabularyMap.put("Banda sonora", "Soundtrack");
                vocabularyMap.put("Festejos", "Festivities or celebrations");
                vocabularyMap.put("Agrupación (de personas)", "Group or gathering (of people)");
                vocabularyMap.put("Ganador", "Winner");
                vocabularyMap.put("Ayuntamiento", "City hall or town hall");
                vocabularyMap.put("Satirizar", "To satirize or mock");
                vocabularyMap.put("Nocturno", "Nocturnal or nighttime");

                // Adjetivos
                vocabularyMap.put("Tedioso", "Tedious or boring");
                vocabularyMap.put("Precioso", "Beautiful or precious");
                vocabularyMap.put("Agotada", "Exhausted");
                vocabularyMap.put("Diminuto", "Tiny or diminutive");
                vocabularyMap.put("Prohibitivo", "Prohibitive");
                vocabularyMap.put("Gélido", "Freezing or icy");
                vocabularyMap.put("Desolador", "Desolate or devastating");
                vocabularyMap.put("Horroroso", "Horrifying or dreadful");
                vocabularyMap.put("Árido", "Arid or dry");
                vocabularyMap.put("Ameno", "Pleasant or enjoyable");
                vocabularyMap.put("Arrebatadora", "Stunning or captivating");
                vocabularyMap.put("Destacable", "Remarkable or noteworthy");

                // Lenguaje informal
                vocabularyMap.put("Picar entre horas", "To snack between meals");
                vocabularyMap.put("Fijar (los ojos/la vista)", "To fix one’s gaze");
                vocabularyMap.put("Romper esquemas", "To break the mold");
                vocabularyMap.put("Hablar (hasta) por los codos", "To talk a lot");

                // Otros
                vocabularyMap.put("Escudo", "Shield or emblem");
                vocabularyMap.put("Solsticio", "Solstice");
                vocabularyMap.put("Farolillo", "Paper lantern");
                vocabularyMap.put("Parientes", "Relatives");
                vocabularyMap.put("Triunfar", "To triumph or succeed");
                vocabularyMap.put("Caramelo", "Candy or caramel");

                break;
            case "checkBox2.6":
                vocabularyMap.put("Digno", "Dignified");
                vocabularyMap.put("Construir", "To build");
                vocabularyMap.put("Nostalgia", "Nostalgia");
                vocabularyMap.put("Barrera legal", "Legal barrier");
                vocabularyMap.put("Aportar", "To contribute");
                vocabularyMap.put("Calor humano", "Human warmth");
                vocabularyMap.put("Empatía", "Empathy");
                vocabularyMap.put("Población", "Population");
                vocabularyMap.put("Habilidades sociales", "Social skills");

                // Consecuencias negativas de los movimientos migratorios
                vocabularyMap.put("Desconfianza", "Distrust or suspicion");
                vocabularyMap.put("Discriminación", "Discrimination");
                vocabularyMap.put("Insidioso", "Insidious or harmful");
                vocabularyMap.put("Enfrentamiento", "Confrontation or clash");
                vocabularyMap.put("Fuga de cerebros", "Brain drain");
                vocabularyMap.put("Obligado", "Forced or obligated");
                vocabularyMap.put("Temer", "To fear");
                vocabularyMap.put("Obstáculos", "Obstacles");
                vocabularyMap.put("Abandonar", "To abandon or leave behind");
                vocabularyMap.put("Complicaciones", "Complications");
                vocabularyMap.put("Rechazar", "To reject or refuse");
                vocabularyMap.put("Peligroso", "Dangerous");

                // Consecuencias o aspectos positivos de los movimientos migratorios
                vocabularyMap.put("Esperanza", "Hope");
                vocabularyMap.put("Solidaridad", "Solidarity");
                vocabularyMap.put("Valorar", "To value or appreciate");
                vocabularyMap.put("Compartir", "To share");
                vocabularyMap.put("Adaptarse", "To adapt");
                vocabularyMap.put("Respetar", "To respect");
                vocabularyMap.put("Facilitar", "To facilitate or ease");
                vocabularyMap.put("Apoyo", "Support");
                vocabularyMap.put("Avanzar", "To move forward");

                // Aspectos sociales y laborales de la inmigración
                vocabularyMap.put("Prestaciones sociales", "Social benefits");
                vocabularyMap.put("Población activa", "Active population or workforce");
                vocabularyMap.put("Envejecimiento (población)", "Aging (population)");
                vocabularyMap.put("Enriquecimiento", "Enrichment");
                vocabularyMap.put("Impuestos", "Taxes");

                // Frases hechas / Expresiones relacionadas con las migraciones
                vocabularyMap.put("Recorrer un largo camino", "To travel a long road");
                vocabularyMap.put("Hacer sacrificios", "To make sacrifices");
                vocabularyMap.put("Alcanzar un sueño", "To achieve a dream");
                vocabularyMap.put("Brindar (una/la oportunidad)", "To offer an opportunity");
                vocabularyMap.put("Tejer vínculos", "To weave connections");
                vocabularyMap.put("Ofrecer alternativas", "To offer alternatives");
                vocabularyMap.put("Dar lo mejor de uno (sí) mismo", "To give one's best");
                vocabularyMap.put("Poner (su/nuestro/…) granito de arena", "To contribute a small part");
                vocabularyMap.put("Agarrar el ritmo", "To catch the rhythm");
                vocabularyMap.put("Combatir prejuicios", "To fight prejudice");
                vocabularyMap.put("Salir adelante", "To move forward");

                break;
            case "checkBox3.1":
                vocabularyMap.put("Entretenimiento y tiempo libre", "Entertainment and free time");
                vocabularyMap.put("Amistad", "Friendship");
                vocabularyMap.put("Salir con", "To go out with");
                vocabularyMap.put("Pasar tiempo con", "To spend time with");
                vocabularyMap.put("Tiempo libre", "Free time");
                vocabularyMap.put("Navegar por Internet", "To browse the Internet");
                vocabularyMap.put("Tocar un instrumento", "To play an instrument");
                vocabularyMap.put("Ocio", "Leisure");
                vocabularyMap.put("Aficiones", "Hobbies");
                vocabularyMap.put("Literatura juvenil", "Young adult literature");
                vocabularyMap.put("Recomendaciones", "Recommendations");
                vocabularyMap.put("Pasión", "Passion");
                vocabularyMap.put("Suscribir(se)", "To subscribe");
                vocabularyMap.put("Sedentarismo", "Sedentary lifestyle");
                vocabularyMap.put("Media naranja", "Soulmate");
                vocabularyMap.put("Ejercitar los músculos", "To exercise the muscles");
                vocabularyMap.put("Agilidad", "Agility");
                vocabularyMap.put("Influencia del ocio en nuestra vida", "Influence of leisure in our life");

                vocabularyMap.put("Divertir(se)", "To have fun");
                vocabularyMap.put("Influencia", "Influence");
                vocabularyMap.put("Valorar", "To value");
                vocabularyMap.put("Revivir", "To relive");
                vocabularyMap.put("Resurgir", "To resurge");
                vocabularyMap.put("Extrañar", "To miss");
                vocabularyMap.put("Afrontar", "To face");
                vocabularyMap.put("Perder(se)", "To get lost / To miss out");
                vocabularyMap.put("Disfrutar", "To enjoy");
                vocabularyMap.put("Evadirse", "To escape");
                vocabularyMap.put("Acostumbrarse", "To get used to");

                vocabularyMap.put("Lugares de ocio y términos relacionados", "Leisure places and related terms");
                vocabularyMap.put("Locales gastronómicos", "Gastronomic establishments");
                vocabularyMap.put("Entradas", "Tickets");
                vocabularyMap.put("Estrenos", "Premieres");
                vocabularyMap.put("Salas de cine", "Movie theaters");
                vocabularyMap.put("Gran pantalla", "Big screen");
                vocabularyMap.put("Capacidad máxima", "Maximum capacity");
                vocabularyMap.put("Emblemático", "Iconic");
                vocabularyMap.put("Espectador", "Spectator");
                vocabularyMap.put("Espectáculo", "Show");
                vocabularyMap.put("Representación", "Performance");
                vocabularyMap.put("Inagotable", "Inexhaustible");
                vocabularyMap.put("Buen ambiente", "Good atmosphere");
                vocabularyMap.put("Centro comercial", "Shopping mall");

                break;
            case "checkBox3.2":
                vocabularyMap.put("Pintar mal", "To look bad / To seem unfavorable");
                vocabularyMap.put("Verlo ni en pintura", "To not want to see someone at all");
                vocabularyMap.put("Tener arte", "To have a special talent / To have flair");
                vocabularyMap.put("Que le quiten a alguien lo bailado", "No one can take away what someone has experienced");
                vocabularyMap.put("Ser un artista", "To be an artist / To be very skilled at something");
                vocabularyMap.put("Dar mucho baile", "To be very demanding / To be exhausting");

                vocabularyMap.put("Flamenco", "Flamenco");
                vocabularyMap.put("Maternos", "Maternal");
                vocabularyMap.put("Inseparables", "Inseparable");
                vocabularyMap.put("Certeza", "Certainty");
                vocabularyMap.put("Fusión", "Fusion");
                vocabularyMap.put("Gira", "Tour");
                vocabularyMap.put("Sobre las tablas", "On stage");
                vocabularyMap.put("Entre bambalinas", "Behind the scenes");
                vocabularyMap.put("Disco", "Album / Record");
                vocabularyMap.put("Partituras", "Sheet music");
                vocabularyMap.put("Visitantes", "Visitors");
                vocabularyMap.put("Estilo", "Style");
                vocabularyMap.put("Auditorios", "Auditoriums");
                vocabularyMap.put("Corrientes", "Trends / Currents");
                vocabularyMap.put("Donaciones", "Donations");
                vocabularyMap.put("Emocionante", "Exciting / Thrilling");
                vocabularyMap.put("Conmovedora", "Moving / Heartwarming");
                vocabularyMap.put("Sorprendente", "Surprising");
                vocabularyMap.put("Inverosímil", "Unbelievable / Implausible");
                vocabularyMap.put("Enigmática", "Enigmatic / Mysterious");
                vocabularyMap.put("Me dejó pensando", "It left me thinking");
                vocabularyMap.put("Sobrevalorada", "Overrated");
                vocabularyMap.put("Poco convencional", "Unconventional");

                break;
            case "checkBox3.3":
                vocabularyMap.put("Añadir a alguien como amigo", "To add someone as a friend");
                vocabularyMap.put("Avatar", "Avatar");
                vocabularyMap.put("Bio", "Bio");
                vocabularyMap.put("Blog", "Blog");
                vocabularyMap.put("Bloquear", "To block");
                vocabularyMap.put("Compartir", "To share");
                vocabularyMap.put("Configurar", "To configure");
                vocabularyMap.put("Contacto", "Contact");
                vocabularyMap.put("Enviar", "To send");
                vocabularyMap.put("Filtros", "Filters");
                vocabularyMap.put("Contraseña", "Password");
                vocabularyMap.put("Opciones de privacidad", "Privacy settings");
                vocabularyMap.put("Perfil", "Profile");
                vocabularyMap.put("Postear", "To post");
                vocabularyMap.put("Redes sociales", "Social media");
                vocabularyMap.put("Registrarse", "To sign up");
                vocabularyMap.put("Tuit, tuitear", "Tweet, to tweet");

                vocabularyMap.put("Aburrir", "To bore");
                vocabularyMap.put("Acceder a", "To access");
                vocabularyMap.put("Animar a", "To encourage");
                vocabularyMap.put("Asustar", "To scare");
                vocabularyMap.put("Consumir", "To consume");
                vocabularyMap.put("Dar miedo", "To be scary");
                vocabularyMap.put("Dedicar", "To dedicate");
                vocabularyMap.put("Elegir", "To choose");
                vocabularyMap.put("Encantar", "To love (something)");
                vocabularyMap.put("Fascinar", "To fascinate");
                vocabularyMap.put("Incluir", "To include");
                vocabularyMap.put("Interesar", "To interest");
                vocabularyMap.put("Molestar", "To bother");
                vocabularyMap.put("Ofrecer", "To offer");
                vocabularyMap.put("Preocupar", "To worry");
                vocabularyMap.put("Sorprender", "To surprise");

                vocabularyMap.put("Cara a cara", "Face to face");
                vocabularyMap.put("Cortar por lo sano", "To cut something off for good");
                vocabularyMap.put("Cruzarse una palabra", "To exchange a word");
                vocabularyMap.put("Dejar a un lado", "To put aside");
                vocabularyMap.put("Día tras día", "Day after day");
                vocabularyMap.put("Doble filo", "Double-edged");
                vocabularyMap.put("Echar la vista atrás", "To look back");
                vocabularyMap.put("Estar acostumbrado a", "To be used to");
                vocabularyMap.put("Estar al alcance de", "To be within reach");
                vocabularyMap.put("Estar enganchado a", "To be hooked on");
                vocabularyMap.put("Estilo de vida", "Lifestyle");
                vocabularyMap.put("Llamar la atención", "To attract attention");
                vocabularyMap.put("No marchar bien", "To not go well");
                vocabularyMap.put("No tener ningún peso", "To have no importance");
                vocabularyMap.put("Prestar atención", "To pay attention");
                vocabularyMap.put("Realizar experimentos", "To conduct experiments");
                vocabularyMap.put("Sentir nostalgia de", "To feel nostalgic about");
                vocabularyMap.put("Tener la sensación", "To have the feeling");

                vocabularyMap.put("A todo esto", "Speaking of which");
                vocabularyMap.put("Además", "Moreover / Besides");
                vocabularyMap.put("Antes que nada", "First of all");
                vocabularyMap.put("Así que", "So");
                vocabularyMap.put("Asimismo", "Likewise");
                vocabularyMap.put("El caso es que", "The thing is that");
                vocabularyMap.put("En conclusión", "In conclusion");
                vocabularyMap.put("En este sentido", "In this sense");
                vocabularyMap.put("En primer lugar", "In the first place");
                vocabularyMap.put("En segundo lugar", "In the second place");
                vocabularyMap.put("Entonces", "Then / So");
                vocabularyMap.put("Igualmente", "Likewise");
                vocabularyMap.put("Para empezar", "To begin with");
                vocabularyMap.put("Por ese motivo", "For that reason");
                vocabularyMap.put("Por eso", "That's why");
                vocabularyMap.put("Por otra parte", "On the other hand");
                vocabularyMap.put("Por otro lado", "On the other side");
                vocabularyMap.put("Por último", "Finally");
                vocabularyMap.put("Por un lado", "On one side");
                vocabularyMap.put("Por una parte", "On one part");
                vocabularyMap.put("Primero", "First");
                vocabularyMap.put("Primero de todo…", "First of all...");
                vocabularyMap.put("Pues bien", "Well then");

                break;
            case "checkBox3.4":
                vocabularyMap.put("Ideas", "Ideas");
                vocabularyMap.put("Invención", "Invention");
                vocabularyMap.put("Cambiado", "Changed");
                vocabularyMap.put("Patenta", "Patents");
                vocabularyMap.put("Propulsión", "Propulsion");
                vocabularyMap.put("Genios", "Geniuses");
                vocabularyMap.put("Brillantes", "Brilliant");
                vocabularyMap.put("Cardiovascular", "Cardiovascular");
                vocabularyMap.put("Ayudado", "Helped");
                vocabularyMap.put("Pioneros", "Pioneers");

                vocabularyMap.put("Inventos", "Inventions");
                vocabularyMap.put("Métodos", "Methods");
                vocabularyMap.put("Inventan", "They invent");
                vocabularyMap.put("Desechando", "Discarding");
                vocabularyMap.put("Producción", "Production");
                vocabularyMap.put("Soluciones", "Solutions");
                vocabularyMap.put("Industria", "Industry");
                vocabularyMap.put("Ferias", "Fairs");
                vocabularyMap.put("Premian", "They award");
                vocabularyMap.put("Ventajas", "Advantages");

                vocabularyMap.put("Tubos", "Tubes");
                vocabularyMap.put("Industrias", "Industries");
                vocabularyMap.put("Químicos", "Chemicals");
                vocabularyMap.put("Residuos", "Waste");
                vocabularyMap.put("Dióxido", "Dioxide");
                vocabularyMap.put("Pruebas", "Tests");
                vocabularyMap.put("Prototipo", "Prototype");
                vocabularyMap.put("Supervisor", "Supervisor");

                vocabularyMap.put("Beneficio", "Benefit");

                vocabularyMap.put("Trata", "Deals with");
                vocabularyMap.put("Datos", "Data");
                vocabularyMap.put("Registran", "They record");

                vocabularyMap.put("Seguridad", "Security");
                vocabularyMap.put("Resolver", "To solve");
                vocabularyMap.put("Desafíos", "Challenges");
                vocabularyMap.put("Impracticable", "Impractical");

                vocabularyMap.put("Campo", "Field");

                vocabularyMap.put("Artificial", "Artificial");
                vocabularyMap.put("Robótica", "Robotics");
                vocabularyMap.put("Virtual", "Virtual");
                vocabularyMap.put("Programación", "Programming");
                vocabularyMap.put("Móvil", "Mobile");
                vocabularyMap.put("Especialización", "Specialization");
                vocabularyMap.put("Técnicos", "Technicians");
                vocabularyMap.put("Divulgación", "Dissemination");
                vocabularyMap.put("Valor", "Value");
                vocabularyMap.put("Agregar", "To add");

                vocabularyMap.put("Reconocimiento", "Recognition");
                vocabularyMap.put("Transcripción", "Transcription");
                vocabularyMap.put("Automatización", "Automation");
                vocabularyMap.put("Programado", "Programmed");
                vocabularyMap.put("Revolucionarse", "To be revolutionized");
                vocabularyMap.put("Autónomos", "Autonomous");
                vocabularyMap.put("Microchips", "Microchips");
                vocabularyMap.put("Sensores", "Sensors");
                vocabularyMap.put("Algoritmos", "Algorithms");
                vocabularyMap.put("Cíborgs", "Cyborgs");

                break;
            case "checkBox3.5":
                vocabularyMap.put("Sellado", "Sealed");
                vocabularyMap.put("Cerebro", "Brain");
                vocabularyMap.put("Ensayo", "Trial / Essay");
                vocabularyMap.put("Célula sanguínea", "Blood cell");
                vocabularyMap.put("Debutar", "To debut");
                vocabularyMap.put("Plasmar", "To capture / To express");
                vocabularyMap.put("Atribuir", "To attribute");
                vocabularyMap.put("Organoléptico", "Organoleptic (relating to sensory properties)");
                vocabularyMap.put("Raza", "Race / Breed");
                vocabularyMap.put("Cruzar", "To crossbreed");
                vocabularyMap.put("Alterar", "To alter");
                vocabularyMap.put("Embrión", "Embryo");
                vocabularyMap.put("Óvulo", "Egg cell / Ovum");
                vocabularyMap.put("Gen", "Gene");
                vocabularyMap.put("Fecundación", "Fertilization");
                vocabularyMap.put("Nacer", "To be born");
                vocabularyMap.put("Audición", "Hearing / Audition");
                vocabularyMap.put("Prueba", "Test / Proof");
                vocabularyMap.put("Cavidad", "Cavity");
                vocabularyMap.put("Tomografía", "Tomography");
                vocabularyMap.put("Poner en duda", "To question / To doubt");
                vocabularyMap.put("Concluir", "To conclude");
                vocabularyMap.put("Plazo", "Term / Deadline");
                vocabularyMap.put("Capacidad", "Capacity / Ability");

                vocabularyMap.put("Patógeno", "Pathogen");
                vocabularyMap.put("Brote", "Outbreak");

                vocabularyMap.put("Tripular", "To crew / To man");
                vocabularyMap.put("Herramienta", "Tool");
                vocabularyMap.put("Catalizador", "Catalyst");
                vocabularyMap.put("Avería", "Breakdown / Malfunction");
                vocabularyMap.put("Aeronave", "Aircraft");
                vocabularyMap.put("Almacenamiento", "Storage");
                vocabularyMap.put("Disponer", "To arrange / To have available");
                vocabularyMap.put("Recuperar", "To recover");
                vocabularyMap.put("Decaer", "To decline / To decay");
                vocabularyMap.put("Reutilizable", "Reusable");

                vocabularyMap.put("Sarcófago", "Sarcophagus");
                vocabularyMap.put("Hallazgo", "Discovery / Finding");
                vocabularyMap.put("Antepasado", "Ancestor");
                vocabularyMap.put("Procedente", "Coming from / Originating from");
                vocabularyMap.put("Superar", "To overcome");

                vocabularyMap.put("Armamento", "Weaponry / Armament");
                vocabularyMap.put("Combatir", "To combat / To fight");
                vocabularyMap.put("Mediar", "To mediate");

                break;
            case "checkBox4.1":
                vocabularyMap.put("Amargado", "Bitter / Resentful");
                vocabularyMap.put("Con la pata en alto", "With your leg up (injured/resting)");
                vocabularyMap.put("Escayola", "Cast (for broken bones)");
                vocabularyMap.put("Estado de alarma", "State of alarm");
                vocabularyMap.put("Confinamiento", "Lockdown / Confinement");
                vocabularyMap.put("Recapacitar", "To reconsider / To reflect");
                vocabularyMap.put("Aplaudir", "To applaud");
                vocabularyMap.put("Estar de mala leche", "To be in a bad mood");
                vocabularyMap.put("Estar de cachondeo", "To be joking around / To be messing around");
                vocabularyMap.put("Estar muy mono/mona", "To look very cute");

                vocabularyMap.put("Voluntariado", "Volunteering");
                vocabularyMap.put("Comprometerse", "To commit oneself");
                vocabularyMap.put("Reivindicar", "To demand / To claim");
                vocabularyMap.put("Agravarse", "To worsen");
                vocabularyMap.put("Pobreza", "Poverty");
                vocabularyMap.put("Tomar conciencia", "To become aware");
                vocabularyMap.put("Solidaridad", "Solidarity");
                vocabularyMap.put("Desigualdad", "Inequality");
                vocabularyMap.put("Compromiso", "Commitment");
                vocabularyMap.put("Aportar un granito de arena", "To do one’s bit / To contribute a little");

                vocabularyMap.put("Auge", "Rise / Boom");
                vocabularyMap.put("A menudo", "Often");
                vocabularyMap.put("Trascender", "To transcend / To go beyond");
                vocabularyMap.put("Entablar", "To establish (a relationship/conversation)");
                vocabularyMap.put("Vagar", "To wander / To roam");
                vocabularyMap.put("Entorno", "Environment / Surroundings");
                vocabularyMap.put("Llevarse (con alguien)", "To get along (with someone)");
                vocabularyMap.put("Tolerar", "To tolerate");
                vocabularyMap.put("Arraigo", "Roots / Attachment");
                vocabularyMap.put("Merodear", "To loiter / To prowl");
                vocabularyMap.put("Expatriado", "Expatriate");

                vocabularyMap.put("Vínculo", "Bond / Link");
                vocabularyMap.put("Aislado", "Isolated");
                vocabularyMap.put("Llevarse con alguien", "To get along with someone");
                vocabularyMap.put("Fuente", "Source");
                vocabularyMap.put("Afín", "Related / Like-minded");
                vocabularyMap.put("Acompañamiento", "Support / Accompaniment");
                vocabularyMap.put("Darle mil vueltas", "To overthink / To go over something repeatedly");

                vocabularyMap.put("Afectivo", "Emotional / Affectionate");
                vocabularyMap.put("Forjarse", "To forge / To build oneself");

                break;
            case "checkBox4.2":
                vocabularyMap.put("Todo da su fruto", "Everything bears fruit");
                vocabularyMap.put("Ponerse las pilas", "To get one’s act together / To step up");
                vocabularyMap.put("Como Pedro por su casa", "Like Pedro in his own home (To feel at home anywhere)");
                vocabularyMap.put("Estar a la altura de las circunstancias", "To rise to the occasion");
                vocabularyMap.put("Arrimar el hombro", "To lend a hand / To pitch in");

                vocabularyMap.put("Asequibilidad", "Affordability");
                vocabularyMap.put("Soledad", "Loneliness");
                vocabularyMap.put("Diferido", "Deferred / Delayed");
                vocabularyMap.put("Altruista", "Altruistic / Selfless");
                vocabularyMap.put("Apoyar", "To support");
                vocabularyMap.put("Degustar", "To taste / To savor");
                vocabularyMap.put("Elenco", "Cast (of a play, film, etc.)");
                vocabularyMap.put("Obsequio", "Gift / Present");
                vocabularyMap.put("Recuperar", "To recover / To regain");
                vocabularyMap.put("Animar", "To encourage / To cheer up");
                vocabularyMap.put("Tarima", "Platform / Stage");
                vocabularyMap.put("Resaltar", "To highlight / To stand out");
                vocabularyMap.put("Gastronomía", "Gastronomy / Cuisine");
                vocabularyMap.put("Jornada", "Workday / Session");

                vocabularyMap.put("Desafío", "Challenge");
                vocabularyMap.put("Prejuicio", "Prejudice");
                vocabularyMap.put("Occidentalización", "Westernization");
                vocabularyMap.put("Reconfigurar", "To reconfigure");
                vocabularyMap.put("Deconstruir", "To deconstruct");
                vocabularyMap.put("Reivindicar", "To reclaim / To demand");
                vocabularyMap.put("Visibilizar", "To make visible / To raise awareness");
                vocabularyMap.put("Integrante", "Member");
                vocabularyMap.put("Asentarse", "To settle");
                vocabularyMap.put("Identificarse", "To identify oneself");

                vocabularyMap.put("Carencia", "Lack / Shortage");
                vocabularyMap.put("Alcanzar", "To reach / To achieve");
                vocabularyMap.put("Grabar", "To record");
                vocabularyMap.put("Encargar", "To order / To be in charge of");
                vocabularyMap.put("Prevenir", "To prevent");
                vocabularyMap.put("Favorecer", "To favor / To promote");
                vocabularyMap.put("Impulsar", "To boost / To drive forward");
                vocabularyMap.put("Retroalimentación", "Feedback");

                vocabularyMap.put("Estar dispuesto", "To be willing / To be ready");

                vocabularyMap.put("Caudaloso", "Mighty / Large (river)");
                vocabularyMap.put("La memoria histórica", "Historical memory");
                vocabularyMap.put("Incalculable", "Incalculable / Immeasurable");
                vocabularyMap.put("Equitativo", "Equitable / Fair");
                vocabularyMap.put("Justo", "Fair / Just");
                vocabularyMap.put("Respetuoso", "Respectful");
                vocabularyMap.put("Inclusivo", "Inclusive");
                vocabularyMap.put("Decretar", "To decree / To order");

                vocabularyMap.put("Balboa", "Balboa (historical figure or currency)");
                vocabularyMap.put("Chácara", "Small farm / Rural property");
                vocabularyMap.put("Tablero", "Board / Panel");
                vocabularyMap.put("Potrero", "Pasture / Grazing land");
                vocabularyMap.put("Exiguo", "Scant / Meager");
                vocabularyMap.put("Serpentear", "To meander / To wind");

                break;
            case "checkBox4.3":
                vocabularyMap.put("Manifestación", "Protest / Demonstration");
                vocabularyMap.put("Huelga", "Strike");
                vocabularyMap.put("Campaña en las redes sociales", "Social media campaign");
                vocabularyMap.put("Desfile", "Parade");
                vocabularyMap.put("Sentada", "Sit-in");
                vocabularyMap.put("Pintadas", "Graffiti / Political slogans on walls");
                vocabularyMap.put("Disturbios", "Riots / Disturbances");
                vocabularyMap.put("Comedor social", "Soup kitchen");
                vocabularyMap.put("Reivindicación", "Claim / Demand");
                vocabularyMap.put("Voluntariado", "Volunteering");
                vocabularyMap.put("Emblemáticos", "Iconic / Emblematic");
                vocabularyMap.put("Reacción en cadena", "Chain reaction");
                vocabularyMap.put("Congregarse", "To gather / To assemble");
                vocabularyMap.put("Pancartas", "Banners / Placards");
                vocabularyMap.put("Hacer codos", "To study hard");
                vocabularyMap.put("Sacarse una carrera", "To earn a degree");
                vocabularyMap.put("Batucada", "Percussion group (Brazilian-style drumming)");
                vocabularyMap.put("Acampada", "Camping / Protest camp");
                vocabularyMap.put("Tienda de campaña", "Tent");
                vocabularyMap.put("Se me saltan las lágrimas", "It brings tears to my eyes");

                vocabularyMap.put("Trabajar codo con codo", "To work side by side");
                vocabularyMap.put("Echar una mano", "To lend a hand");
                vocabularyMap.put("Dar el brazo a torcer", "To give in / To yield");
                vocabularyMap.put("Andar con pies de plomo", "To tread carefully");
                vocabularyMap.put("No tener ni pies ni cabeza", "To make no sense");
                vocabularyMap.put("Ser como uña y carne", "To be inseparable");
                vocabularyMap.put("Hablar por los codos", "To talk a lot / To be very talkative");
                vocabularyMap.put("Tomar el pelo", "To tease / To pull someone’s leg");
                vocabularyMap.put("Decir las cosas a la cara", "To say things directly");
                vocabularyMap.put("Tener la mosca detrás de la oreja", "To have a hunch / To be suspicious");

                vocabularyMap.put("Solicitados", "In demand / Sought after");
                vocabularyMap.put("Arrancar sonrisas", "To bring smiles");
                vocabularyMap.put("Punto de inflexión", "Turning point");
                vocabularyMap.put("Monopatín", "Skateboard");
                vocabularyMap.put("Hacerse eco", "To echo / To spread the word");
                vocabularyMap.put("Bordado", "Embroidery");
                vocabularyMap.put("Vidriera", "Stained glass window");
                vocabularyMap.put("Tapiz", "Tapestry");

                vocabularyMap.put("Dar alegría", "To bring joy");
                vocabularyMap.put("Dar asco", "To be disgusting");
                vocabularyMap.put("Dar igual", "To not matter / To be the same");
                vocabularyMap.put("Dar miedo", "To be scary");
                vocabularyMap.put("Dar pereza", "To feel lazy about");
                vocabularyMap.put("Dar pena", "To feel sorry for");
                vocabularyMap.put("Dar rabia", "To make angry / To infuriate");
                vocabularyMap.put("Dar vergüenza", "To be embarrassing");


                break;
            case "checkBox4.4":
                vocabularyMap.put("Guardería", "Daycare / Nursery school");
                vocabularyMap.put("Internado", "Boarding school");
                vocabularyMap.put("Docente", "Teacher / Educator");
                vocabularyMap.put("Casilleros", "Lockers");
                vocabularyMap.put("Ensayos", "Essays / Rehearsals");
                vocabularyMap.put("Aprobarás", "You will pass");
                vocabularyMap.put("Suspender", "To fail / To suspend");
                vocabularyMap.put("Patio", "Schoolyard / Courtyard");
                vocabularyMap.put("Recreo", "Recess / Break");
                vocabularyMap.put("Apuntes", "Notes");
                vocabularyMap.put("Burbuja", "Bubble");
                vocabularyMap.put("Ambiente", "Environment / Atmosphere");
                vocabularyMap.put("Autodidacta", "Self-taught");
                vocabularyMap.put("Brecha digital", "Digital divide");
                vocabularyMap.put("Competencias", "Skills / Competencies");
                vocabularyMap.put("Procrastinar", "To procrastinate");
                vocabularyMap.put("Material didáctico", "Teaching material");
                vocabularyMap.put("Coeducación", "Coeducation (mixed-gender education)");
                vocabularyMap.put("Diversidad cultural", "Cultural diversity");
                vocabularyMap.put("Educación inclusiva", "Inclusive education");
                vocabularyMap.put("Modelo a seguir", "Role model");
                vocabularyMap.put("Alabar", "To praise");
                vocabularyMap.put("Premiar", "To reward");
                vocabularyMap.put("Castigar", "To punish");
                vocabularyMap.put("Beca", "Scholarship / Grant");
                vocabularyMap.put("Chuletas", "Cheat sheets");
                vocabularyMap.put("Despacho del director", "Principal's office");
                vocabularyMap.put("Empollón", "Bookworm / Nerd");
                vocabularyMap.put("Horarios", "Schedules");
                vocabularyMap.put("Pupitre", "Desk");

                vocabularyMap.put("Tiza", "Chalk");
                vocabularyMap.put("Pizarras interactivas", "Interactive whiteboards");
                vocabularyMap.put("Tabletas", "Tablets");
                vocabularyMap.put("Portátiles", "Laptops");
                vocabularyMap.put("Auriculares", "Headphones / Earphones");
                vocabularyMap.put("Inalámbricos", "Wireless");
                vocabularyMap.put("Contraseña", "Password");
                vocabularyMap.put("Navegador", "Browser");
                vocabularyMap.put("Descargar", "To download");
                vocabularyMap.put("Archivos", "Files");
                vocabularyMap.put("Herramientas", "Tools");

                vocabularyMap.put("Delegado", "Class representative");
                vocabularyMap.put("Zona de confort", "Comfort zone");
                vocabularyMap.put("La vieja escuela", "The old school / Old-fashioned way");
                vocabularyMap.put("Aprender de memoria", "To learn by heart / To memorize");
                vocabularyMap.put("Lluvia de ideas", "Brainstorming");
                vocabularyMap.put("Disposición", "Willingness / Readiness");
                vocabularyMap.put("Emprender", "To undertake / To start");
                vocabularyMap.put("Comprometerse", "To commit oneself");

                vocabularyMap.put("Fronteras", "Borders");
                vocabularyMap.put("Papeles", "Papers / Legal documents");
                vocabularyMap.put("Se marchan", "They leave / They depart");
                vocabularyMap.put("Dejar atrás", "To leave behind");
                vocabularyMap.put("Mejores perspectivas de vida", "Better life prospects");
                vocabularyMap.put("Obstáculos/barreras", "Obstacles / Barriers");
                vocabularyMap.put("Superar", "To overcome");
                vocabularyMap.put("Sueño de una vida mejor", "Dream of a better life");
                vocabularyMap.put("Riesgos", "Risks");

                break;
            case "checkBox4.5":
                vocabularyMap.put("Talento", "Talent");
                vocabularyMap.put("Liderazgo", "Leadership");
                vocabularyMap.put("Clima", "Climate / Atmosphere");
                vocabularyMap.put("Rendimiento", "Performance");
                vocabularyMap.put("Metas", "Goals");
                vocabularyMap.put("Confianza", "Trust / Confidence");
                vocabularyMap.put("Motivar", "To motivate");
                vocabularyMap.put("Recompensas", "Rewards");
                vocabularyMap.put("Calma", "Calm");
                vocabularyMap.put("Satisfecho", "Satisfied");

                vocabularyMap.put("Destreza", "Skill / Dexterity");
                vocabularyMap.put("Perfil", "Profile");
                vocabularyMap.put("Emociones", "Emotions");
                vocabularyMap.put("Resiliencia", "Resilience");
                vocabularyMap.put("Resolver", "To solve / To resolve");
                vocabularyMap.put("Crítico", "Critical");
                vocabularyMap.put("Redacción", "Writing / Composition");
                vocabularyMap.put("Concentración", "Concentration");
                vocabularyMap.put("Negociación", "Negotiation");
                vocabularyMap.put("Coordinación", "Coordination");

                vocabularyMap.put("Periodos", "Periods");
                vocabularyMap.put("Teletrabajo", "Remote work / Telework");
                vocabularyMap.put("Planificado", "Planned");
                vocabularyMap.put("Calendario", "Calendar / Schedule");
                vocabularyMap.put("Doméstico", "Domestic");
                vocabularyMap.put("Disfrutar", "To enjoy");
                vocabularyMap.put("Dedicar", "To dedicate");
                vocabularyMap.put("Desplazamientos", "Commutes / Travel");
                vocabularyMap.put("Gestiones", "Errands / Transactions");
                vocabularyMap.put("Aficiones", "Hobbies");

                vocabularyMap.put("Adaptar", "To adapt");
                vocabularyMap.put("Artífice", "Architect / Creator");
                vocabularyMap.put("Referente", "Role model / Reference");
                vocabularyMap.put("Punto", "Point / Dot");
                vocabularyMap.put("Plantilla", "vocabularyMaplate / Workforce");
                vocabularyMap.put("Agobiado", "Overwhelmed / Stressed");
                vocabularyMap.put("Tienda", "Store / Shop");
                vocabularyMap.put("Incentivar", "To encourage / To incentivize");
                vocabularyMap.put("Apoyo", "Support");
                vocabularyMap.put("Nichos", "Niches / Market segments");

                vocabularyMap.put("Experiencia", "Experience");
                vocabularyMap.put("Mudarse", "To move (house/city)");
                vocabularyMap.put("Carrera", "Career / Degree");
                vocabularyMap.put("Currículum", "Resume / CV");
                vocabularyMap.put("Carta de presentación", "Cover letter");
                vocabularyMap.put("Vacante", "Vacancy / Job opening");
                vocabularyMap.put("Remunerado", "Paid");
                vocabularyMap.put("Beca", "Scholarship / Internship");
                vocabularyMap.put("Esfuerzo", "Effort");
                vocabularyMap.put("Adaptación", "Adaptation");

                vocabularyMap.put("Comunicarle", "To communicate to (someone)");
                vocabularyMap.put("Módulo", "Module / Unit");
                vocabularyMap.put("Último", "Last / Latest");
                vocabularyMap.put("Reducido", "Reduced / Limited");
                vocabularyMap.put("Trabajo", "Work / Job");
                vocabularyMap.put("Precio", "Price");
                vocabularyMap.put("Adjuntar", "To attach");
                vocabularyMap.put("Dudar", "To doubt / To hesitate");
                vocabularyMap.put("Ponerse en contacto", "To get in touch");
                vocabularyMap.put("Adquirir", "To acquire");

                vocabularyMap.put("Puesto", "Position / Job role");
                vocabularyMap.put("Saber", "To know");
                vocabularyMap.put("Objetivos", "Objectives / Goals");
                vocabularyMap.put("Empleo", "Employment / Job");
                vocabularyMap.put("Explicar", "To explain");
                vocabularyMap.put("Manejar", "To manage / To handle");
                vocabularyMap.put("Salarial", "Salary-related");
                vocabularyMap.put("Debilidad", "Weakness");
                vocabularyMap.put("Aportar", "To contribute");


                break;
            case "checkBox5.1":
                vocabularyMap.put("Basura", "Trash / Garbage");
                vocabularyMap.put("Calentamiento global", "Global warming");
                vocabularyMap.put("Cambio climático", "Climate change");
                vocabularyMap.put("Contaminar", "To pollute");
                vocabularyMap.put("Efecto invernadero", "Greenhouse effect");
                vocabularyMap.put("Incendios forestales", "Wildfires / Forest fires");
                vocabularyMap.put("Lluvia ácida", "Acid rain");
                vocabularyMap.put("Petróleo", "Oil / Petroleum");
                vocabularyMap.put("Sustancias químicas", "Chemical substances");

                vocabularyMap.put("Aguijón", "Stinger");
                vocabularyMap.put("Cera", "Wax");
                vocabularyMap.put("Colmenas", "Beehives");
                vocabularyMap.put("Invasoras", "Invasive (species)");
                vocabularyMap.put("Miel", "Honey");
                vocabularyMap.put("Panal", "Honeycomb");
                vocabularyMap.put("Picadura", "Sting / Bite");
                vocabularyMap.put("Polen", "Pollen");

                vocabularyMap.put("Arbustos", "Bushes / Shrubs");
                vocabularyMap.put("Arena", "Sand");
                vocabularyMap.put("Bosques", "Forests / Woods");
                vocabularyMap.put("Cordillera", "Mountain range");
                vocabularyMap.put("Cuevas", "Caves");
                vocabularyMap.put("Río", "River");
                vocabularyMap.put("Selvas", "Jungles / Rainforests");
                vocabularyMap.put("Senderos", "Trails / Paths");

                vocabularyMap.put("Acantilados", "Cliffs");
                vocabularyMap.put("Amenaza", "Threat");
                vocabularyMap.put("Arrecifes", "Reefs");
                vocabularyMap.put("Bombillas de bajo consumo", "Energy-saving light bulbs");
                vocabularyMap.put("Calentamiento", "Warming / Heating");
                vocabularyMap.put("Caza furtiva", "Poaching");
                vocabularyMap.put("Contaminación acústica", "Noise pollution");
                vocabularyMap.put("Derretirse", "To melt");
                vocabularyMap.put("Desarrollo sostenible", "Sustainable development");
                vocabularyMap.put("En peligro de extinción", "Endangered");
                vocabularyMap.put("Energía eólica", "Wind energy");
                vocabularyMap.put("Energías renovables", "Renewable energies");
                vocabularyMap.put("Llamas", "Flames");
                vocabularyMap.put("Marea negra", "Oil spill");
                vocabularyMap.put("Propagación", "Spread / Propagation");
                vocabularyMap.put("Recursos naturales", "Natural resources");
                vocabularyMap.put("Supervivencia", "Survival");
                vocabularyMap.put("Vertidos", "Spills / Waste dumping");

                vocabularyMap.put("Erupción volcánica", "Volcanic eruption");
                vocabularyMap.put("Huracanes", "Hurricanes");
                vocabularyMap.put("Inundaciones", "Floods");
                vocabularyMap.put("Olas de calor", "Heat waves");
                vocabularyMap.put("Sequías", "Droughts");
                vocabularyMap.put("Terremoto", "Earthquake");
                vocabularyMap.put("Tormentas", "Storms");

                break;
            case "checkBox5.2":
                vocabularyMap.put("Libertad", "Freedom");
                vocabularyMap.put("Someter", "To subdue / To subject");
                vocabularyMap.put("Ideas", "Ideas");
                vocabularyMap.put("Difusión", "Dissemination / Spread");
                vocabularyMap.put("Practicar", "To practice");
                vocabularyMap.put("Privacidad", "Privacy");
                vocabularyMap.put("Desarrollo", "Development");
                vocabularyMap.put("Promover", "To promote");
                vocabularyMap.put("Bienestar", "Well-being");
                vocabularyMap.put("Pertenecer", "To belong");
                vocabularyMap.put("Tratados", "Treaties");
                vocabularyMap.put("Civiles", "Civilians / Civil");
                vocabularyMap.put("Política", "Politics / Policy");
                vocabularyMap.put("Abusos", "Abuses");
                vocabularyMap.put("Autoridades", "Authorities");
                vocabularyMap.put("Merecer", "To deserve");
                vocabularyMap.put("Discriminación", "Discrimination");
                vocabularyMap.put("Respeto", "Respect");
                vocabularyMap.put("Nacer", "To be born");
                vocabularyMap.put("Autodeterminación", "Self-determination");
                vocabularyMap.put("Acciones", "Actions");
                vocabularyMap.put("Manifestación", "Protest / Demonstration");
                vocabularyMap.put("Valores", "Values");
                vocabularyMap.put("Sensibilizar", "To raise awareness");
                vocabularyMap.put("Jornadas", "Conferences / Sessions / Days");
                vocabularyMap.put("Discusiones", "Discussions");
                vocabularyMap.put("Participación", "Participation");
                vocabularyMap.put("Intergubernamentales", "Intergovernmental");
                vocabularyMap.put("ONG", "NGO (Non-Governmental Organization)");
                vocabularyMap.put("Función", "Function / Role");
                vocabularyMap.put("Discriminado", "Discriminated");
                vocabularyMap.put("Trato", "Treatment");
                vocabularyMap.put("Vulnerables", "Vulnerable");
                vocabularyMap.put("Intolerancia", "Intolerance");
                vocabularyMap.put("Asesoría", "Advisory / Consulting");
                vocabularyMap.put("Medidas", "Measures");
                vocabularyMap.put("Harmonía", "Harmony");
                vocabularyMap.put("Incursiones", "Incursions / Raids");
                vocabularyMap.put("Ancestrales", "Ancestral");
                vocabularyMap.put("Sentencias", "Sentences / Judgments");
                vocabularyMap.put("Cargos", "Charges / Positions");
                vocabularyMap.put("Crimen", "Crime");
                vocabularyMap.put("Asistencia", "Assistance / Attendance");
                vocabularyMap.put("Asilo", "Asylum");
                vocabularyMap.put("Arrestar", "To arrest");
                vocabularyMap.put("Vandalismo", "Vandalism");
                vocabularyMap.put("Acoso", "Harassment / Bullying");
                vocabularyMap.put("Agresiones", "Assaults / Attacks");
                vocabularyMap.put("Pública", "Public");

                vocabularyMap.put("Oficiales", "Officials / Official");
                vocabularyMap.put("Publicar", "To publish");
                vocabularyMap.put("Oral", "Oral");
                vocabularyMap.put("Precisa", "Precise / Accurate");
                vocabularyMap.put("Soluciones", "Solutions");
                vocabularyMap.put("Preguntas", "Questions");
                vocabularyMap.put("Impersonal", "Impersonal");
                vocabularyMap.put("Secciones", "Sections");
                vocabularyMap.put("Puntos", "Points");

                break;
            case "checkBox5.3":
                vocabularyMap.put("Preservar", "To preserve");
                vocabularyMap.put("Fundacional", "Foundational");
                vocabularyMap.put("Estados", "States");
                vocabularyMap.put("Voto", "Vote");
                vocabularyMap.put("Asamblea (General)", "General Assembly");
                vocabularyMap.put("Secretario", "Secretary");
                vocabularyMap.put("Programas", "Programs");
                vocabularyMap.put("Desarrollo", "Development");
                vocabularyMap.put("Derechos", "Rights");
                vocabularyMap.put("Agencias", "Agencies");
                vocabularyMap.put("Resolución", "Resolution");
                vocabularyMap.put("Especial", "Special");

                vocabularyMap.put("Indígenas", "Indigenous");
                vocabularyMap.put("Formas (de vida)", "Ways of life");
                vocabularyMap.put("Lengua", "Language");
                vocabularyMap.put("Reconocer", "To recognize");
                vocabularyMap.put("Adoptar", "To adopt");
                vocabularyMap.put("Consulta", "Consultation");
                vocabularyMap.put("Indemnización", "Compensation");

                vocabularyMap.put("Amenaza", "Threat");
                vocabularyMap.put("Disputa", "Dispute");
                vocabularyMap.put("Grave", "Serious");
                vocabularyMap.put("Tensión", "Tension");
                vocabularyMap.put("Sanción", "Sanction");
                vocabularyMap.put("Reclamación", "Claim");
                vocabularyMap.put("Litigio", "Litigation");
                vocabularyMap.put("Fronterizo", "Border-related");
                vocabularyMap.put("Límite (territorial/marítimo)", "Boundary (territorial/maritime)");
                vocabularyMap.put("Soberanía", "Sovereignty");
                vocabularyMap.put("Ilegal", "Illegal");
                vocabularyMap.put("Derecho (internacional)", "International law");

                vocabularyMap.put("Mediación", "Mediation");
                vocabularyMap.put("Acuerdo (llegar a un…)", "Agreement (to reach an...)");
                vocabularyMap.put("Alerta", "Alert");
                vocabularyMap.put("Diplomacia", "Diplomacy");
                vocabularyMap.put("Prestar (ayuda)", "To provide (help)");
                vocabularyMap.put("Compensación", "Compensation");
                vocabularyMap.put("Esclarecimiento", "Clarification");
                vocabularyMap.put("Liberación", "Liberation");
                vocabularyMap.put("Dialogar", "To engage in dialogue");
                vocabularyMap.put("Desbloquear", "To unblock");
                vocabularyMap.put("Oponente", "Opponent");
                vocabularyMap.put("Punto de vista", "Point of view");
                vocabularyMap.put("Empatía", "Empathy");
                vocabularyMap.put("Abordar", "To address");
                vocabularyMap.put("Creativo", "Creative");
                vocabularyMap.put("Enfrentamiento", "Confrontation");
                vocabularyMap.put("Alternativa", "Alternative");
                vocabularyMap.put("Millones", "Millions");
                vocabularyMap.put("Semilla", "Seed");

                vocabularyMap.put("Enfado", "Anger");
                vocabularyMap.put("Urna", "Ballot box");
                vocabularyMap.put("Resolver", "To resolve");
                vocabularyMap.put("Pacífico", "Peaceful");
                vocabularyMap.put("Rumbo", "Course / Direction");
                vocabularyMap.put("Heredar", "To inherit");

                vocabularyMap.put("Visual", "Visual");
                vocabularyMap.put("Letra", "Letter / Font");
                vocabularyMap.put("Información", "Information");
                vocabularyMap.put("Póster", "Poster");
                vocabularyMap.put("Parágrafo o párrafo", "Paragraph");
                vocabularyMap.put("Enseñar", "To teach");
                vocabularyMap.put("Tamaño", "Size");
                vocabularyMap.put("Tríptico", "Triptych / Brochure");
                vocabularyMap.put("Organización", "Organization");
                vocabularyMap.put("Lema", "Slogan");

                vocabularyMap.put("(Contra) viento (y marea)", "(Against) all odds");
                vocabularyMap.put("Estar algo en manos de alguien", "To be in someone's hands");

                break;
            case "checkBox5.4":
                vocabularyMap.put("Derechos", "Rights");
                vocabularyMap.put("Género", "Gender");
                vocabularyMap.put("Dimensión", "Dimension");
                vocabularyMap.put("Discriminar", "To discriminate");
                vocabularyMap.put("Distribución", "Distribution");
                vocabularyMap.put("Equitativo", "Equitable");
                vocabularyMap.put("Justo", "Fair / Just");
                vocabularyMap.put("Oportunidad", "Opportunity");
                vocabularyMap.put("Trato", "Treatment");
                vocabularyMap.put("Rol", "Role");
                vocabularyMap.put("Catalogar", "To categorize");
                vocabularyMap.put("Diversidad", "Diversity");
                vocabularyMap.put("Inclusión", "Inclusion");
                vocabularyMap.put("Exaltar", "To exalt / To praise");
                vocabularyMap.put("Desprecio", "ConvocabularyMapt / Disdain");
                vocabularyMap.put("Discapacidad", "Disability");

                vocabularyMap.put("Aislamiento", "Isolation");
                vocabularyMap.put("Discriminación", "Discrimination");
                vocabularyMap.put("Herencia", "Inheritance / Heritage");
                vocabularyMap.put("Solo/a", "Alone");
                vocabularyMap.put("Violencia", "Violence");
                vocabularyMap.put("Vulnerable", "Vulnerable");
                vocabularyMap.put("Acoso", "Harassment");

                vocabularyMap.put("Decisión", "Decision");
                vocabularyMap.put("Fuerza", "Strength");
                vocabularyMap.put("Responsabilidad", "Responsibility");
                vocabularyMap.put("Integración", "Integration");
                vocabularyMap.put("Apoyar", "To support");
                vocabularyMap.put("Defender", "To defend");
                vocabularyMap.put("Manifestarse", "To protest / To demonstrate");
                vocabularyMap.put("Derrumbar (estereotipos)", "To break down (stereotypes)");
                vocabularyMap.put("Denunciar", "To report / To denounce");
                vocabularyMap.put("Instituciones", "Institutions");
                vocabularyMap.put("Organismos", "Organizations");
                vocabularyMap.put("Potenciar", "To strengthen / To promote");
                vocabularyMap.put("Optar", "To choose / To opt for");
                vocabularyMap.put("Sueños", "Dreams");
                vocabularyMap.put("Avanzar", "To advance / To move forward");
                vocabularyMap.put("Erradicar", "To eradicate");
                vocabularyMap.put("Recurrir", "To resort to / To turn to");
                vocabularyMap.put("Garantizar", "To guarantee");
                vocabularyMap.put("Rampas", "Ramps");
                vocabularyMap.put("Adaptado", "Adapted / Accessible");
                vocabularyMap.put("Barreras arquitectónicas", "Architectural barriers");

                vocabularyMap.put("Titular", "Headline");
                vocabularyMap.put("Subtítulo", "Subtitle");
                vocabularyMap.put("Secciones", "Sections");
                vocabularyMap.put("Texto", "Text");
                vocabularyMap.put("Imágenes", "Images");
                vocabularyMap.put("Viñeta", "Bullet point / Cartoon");
                vocabularyMap.put("Público objetivo", "Target audience");
                vocabularyMap.put("Llamar a la acción", "Call to action");
                vocabularyMap.put("Dirección", "Address");

                vocabularyMap.put("Más allá de…", "Beyond...");
                vocabularyMap.put("(A) Duras penas", "With great difficulty / Barely");

                break;
            case "checkBox5.5":
                vocabularyMap.put("Económico", "Economic");
                vocabularyMap.put("Consumo", "Consumption");
                vocabularyMap.put("Marcas", "Brands");
                vocabularyMap.put("Lengua franca", "Lingua franca");
                vocabularyMap.put("Unión", "Union");
                vocabularyMap.put("Negativo", "Negative");
                vocabularyMap.put("Acelerar", "To accelerate");
                vocabularyMap.put("Interacción", "Interaction");
                vocabularyMap.put("Concentrar", "To concentrate");
                vocabularyMap.put("Aumento", "Increase");

                vocabularyMap.put("Ha impulsado", "Has driven / Pushed");
                vocabularyMap.put("Locomotoras industriales", "Industrial engines");
                vocabularyMap.put("Privatización", "Privatization");
                vocabularyMap.put("Próspero", "Prosperous");
                vocabularyMap.put("Potencias", "Powers");
                vocabularyMap.put("Economía", "Economy");
                vocabularyMap.put("Desempleo", "Unemployment");
                vocabularyMap.put("Diversificado", "Diversified");
                vocabularyMap.put("Expansión", "Expansion");
                vocabularyMap.put("Neoliberal", "Neoliberal");

                vocabularyMap.put("Incursión", "Incursion");
                vocabularyMap.put("Anular", "To annul / To cancel");
                vocabularyMap.put("Instituciones", "Institutions");
                vocabularyMap.put("Sustento", "Sustenance");
                vocabularyMap.put("Calidad", "Quality");
                vocabularyMap.put("Ganar", "To win");
                vocabularyMap.put("Se mantenga", "To maintain");
                vocabularyMap.put("Supervivencia", "Survival");

                vocabularyMap.put("Relevancia", "Relevance");
                vocabularyMap.put("Gobernanza", "Governance");
                vocabularyMap.put("Gigante", "Giant");
                vocabularyMap.put("Potencia", "Power");
                vocabularyMap.put("Envejecimiento", "Aging");
                vocabularyMap.put("Autoritario", "Authoritarian");
                vocabularyMap.put("Mercado", "Market");
                vocabularyMap.put("Convenios", "Agreements");
                vocabularyMap.put("Identidad", "Identity");
                vocabularyMap.put("Ruptura", "Breakdown");

                vocabularyMap.put("Facetas", "Facets");
                vocabularyMap.put("Erradicar", "To eradicate");
                vocabularyMap.put("Ligado", "Linked");
                vocabularyMap.put("Retos", "Challenges");
                vocabularyMap.put("Inculcar", "To instill");
                vocabularyMap.put("Abrazamos", "We embrace");
                vocabularyMap.put("Convivencia", "Coexistence");
                vocabularyMap.put("Base", "Base");
                vocabularyMap.put("Corrientes", "Currents");

                vocabularyMap.put("Cifras", "Figures");
                vocabularyMap.put("Creciente", "Growing");
                vocabularyMap.put("Ha decrecido", "Has decreased");
                vocabularyMap.put("Oficial", "Official");
                vocabularyMap.put("Cooficial", "Co-official");
                vocabularyMap.put("Enseñanza", "Teaching");
                vocabularyMap.put("Habitantes", "Inhabitants");
                vocabularyMap.put("Regionales", "Regional");
                vocabularyMap.put("Usado", "Used");
                vocabularyMap.put("Creciendo", "Growing");


                break;
            case "checkBox5.6":
                vocabularyMap.put("Todo da su fruto", "Everything bears fruit");
                vocabularyMap.put("Ponerse las pilas", "To get one's act together");
                vocabularyMap.put("Como Pedro por su casa", "To feel at home");
                vocabularyMap.put("Estar a la altura de las circunstancias", "To rise to the occasion");
                vocabularyMap.put("Arrimar el hombre", "To pitch in / Lend a hand");
                vocabularyMap.put("Asequibilidad", "Affordability");
                vocabularyMap.put("Soledad", "Solitude");
                vocabularyMap.put("Diferido", "Deferred");
                vocabularyMap.put("Altruista", "Altruistic");
                vocabularyMap.put("Apoyar", "To support");
                vocabularyMap.put("Degustar", "To taste");
                vocabularyMap.put("Elenco", "Cast");
                vocabularyMap.put("Obsequio", "Gift");
                vocabularyMap.put("Recuperar", "To recover");
                vocabularyMap.put("Animar", "To encourage");
                vocabularyMap.put("Tarima", "Stage");
                vocabularyMap.put("Resaltar", "To highlight");
                vocabularyMap.put("Gastronomía", "Gastronomy");
                vocabularyMap.put("Jornada", "Day (of work, event, etc.)");

                vocabularyMap.put("Desafío", "Challenge");
                vocabularyMap.put("Prejuicio", "Prejudice");
                vocabularyMap.put("Occidentalización", "Westernization");
                vocabularyMap.put("Reconfigurar", "To reconfigure");
                vocabularyMap.put("Deconstruir", "To deconstruct");
                vocabularyMap.put("Reivindicar", "To claim / To demand");
                vocabularyMap.put("Visibilizar", "To make visible");
                vocabularyMap.put("Integrante", "Member");
                vocabularyMap.put("Asentarse", "To settle");
                vocabularyMap.put("Identificarse", "To identify oneself");

                vocabularyMap.put("Apoyo", "Support");
                vocabularyMap.put("Bondad", "Kindness");
                vocabularyMap.put("Comportamiento", "Behavior");
                vocabularyMap.put("Generosidad", "Generosity");
                vocabularyMap.put("Dilemas", "Dilemmas");
                vocabularyMap.put("Decidir", "To decide");
                vocabularyMap.put("Apariencia", "Appearance");
                vocabularyMap.put("Juzgar", "To judge");

                vocabularyMap.put("Equidad", "Equity");
                vocabularyMap.put("Productores", "Producers");
                vocabularyMap.put("Salario", "Salary");
                vocabularyMap.put("Lograr", "To achieve");
                vocabularyMap.put("Explotado", "Exploited");
                vocabularyMap.put("Discriminación", "Discrimination");
                vocabularyMap.put("Comprometido", "Committed");
                vocabularyMap.put("Desfavorecido", "Disadvantaged");
                vocabularyMap.put("Esmero", "Care / Diligence");

                vocabularyMap.put("Regular", "To regulate");
                vocabularyMap.put("Dolor", "Pain");
                vocabularyMap.put("Experimentación", "Experimentation");
                vocabularyMap.put("Controversia", "Controversy");
                vocabularyMap.put("Beneficio", "Benefit");
                vocabularyMap.put("Investigación", "Research");
                vocabularyMap.put("Protesta", "Protest");
                vocabularyMap.put("Derecho", "Right");
                vocabularyMap.put("Trato", "Treatment");
                vocabularyMap.put("Debate", "Debate");

                vocabularyMap.put("Pagar el pato", "To take the blame");
                vocabularyMap.put("Tener pájaros en la cabeza", "To have birds in one's head (to be absent-minded)");
                vocabularyMap.put("Ser una gallina", "To be a coward");
                vocabularyMap.put("Ser/haber cuatro gatos", "To be very few (people)");
                vocabularyMap.put("Llevarse como el perro y el gato", "To fight like cats and dogs");
                vocabularyMap.put("Hacer un tiempo de perros", "To have bad weather");
                vocabularyMap.put("Por si las moscas", "Just in case");
                vocabularyMap.put("No ver tres en un burro", "To be very near-sighted");
                vocabularyMap.put("Tener una vista de águila", "To have eagle-eyed vision");
                vocabularyMap.put("Sentirse como pez en el agua", "To feel like a fish in water");

                vocabularyMap.put("Avance", "Advance");
                vocabularyMap.put("Contrarreloj", "Race against time");
                vocabularyMap.put("Percatarse", "To notice / To become aware");
                vocabularyMap.put("Legislación", "Legislation");
                vocabularyMap.put("Riesgo", "Risk");
                vocabularyMap.put("Incitar", "To incite");
                vocabularyMap.put("Percibir", "To perceive");
                vocabularyMap.put("Precavido", "Cautious");
                vocabularyMap.put("Persuadir", "To persuade");
                vocabularyMap.put("Invasivo", "Invasive");

                break;
        }
    }
}