package com.example.android.rarelyusedwordsinukrainian;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends ListActivity {
    /**
     * Called when the activity is first created.
     */
    private ArrayList<ListData> wordList;
    String[] words = {"АБАЖУР", "АБИЩИЦЯ", "АБСЕНТЕЇЗМ",
            "АБСОЛЮТ", "АБСТРАГУВАТИСЯ"};
    String[] meanings = {"<p align=\"justify\"><strong> АБАЖ<span class=\"stressed\">У</span><span class=\"stress\">́</span>Р</strong>, а, <i><span style=\"color:green\"><abbr title=\"чоловічий рід\">чол.</abbr></span></i> Дашок різної форми і з різного матеріалу на лампу (свічку і т. ін.) для захисту очей від світла або для зосередження світла в певному напрямі.<br /><i>Моя лампа під широким картоновим абажуром ділить хату на два поверхи — вгорі темний, похмурий, важкий; під ним — залитий світлом</i> <span style=\"color:gray\">(Михайло Коцюбинський, I, 1955, 414)</span>; <i>На столику стояла свічка під абажуром</i> <span style=\"color:gray\">(Семен Журахович, Вечір.., 1958, 235)</span>.<br /><small><a href=\"http://sum.in.ua/p/1/2/2\">© Словник української мови: в 11 томах. — Том 1, 1970. — Стор. 2.</a></small></p>",
            "<p align=\"justify\"><strong>АБ<span class=\"stressed\">И</span><span class=\"stress\">́</span>ЩИЦЯ</strong>, i, <i><span style=\"color:green\"><abbr class=\"mark\" title=\"жіночий рід\">жін.</abbr></span></i>, <i><span style=\"color:green\"><abbr class=\"mark\" title=\"розмовне\">розм.</abbr></span></i> Річ або справа, що не має ніякої цінності чи значення; дрібниця, дурниця.<br /><i>Це така абищиця, що не варт і казати</i> <span style=\"color:gray\">(Словник Грінченка)</span>; <i>Верхівнянські ліси не така вже абишиця</i> <span style=\"color:gray\">(Натан Рибак, Помилка.., 1956, 41)</span>.<br /><small><a href=\"http://sum.in.ua/p/1/3/2\">&copy; Словник української мови: в 11 томах. — Том 1, 1970. — Стор. 3.</a></small></p>",
            "<p align=\"justify\"><strong> АБСЕНТЕ<span class=\"stressed\">Ї</span><span class=\"stress\">́</span>ЗМ</strong>, у, <i><span style=\"color:green\"><abbr title=\"чоловічий рід\">чол.</abbr></span></i> В ідеалістичній філософії — вічна, незмінна, нескінченна першооснова Всесвіту (дух, ідея); у релігії — бог.<br /><i>Що-небудь самодостатнє, безвідносне, нічим не обумовлене. На противагу дрібнобуржуазним демократам, Маркс бачив в усіх без винятку демократичних вимогах не абсолют, а історичний вираз боротьби керованих буржуазією народних мас проти феодалізму</i> <span style=\"color:gray\">(Ленін, 22, 1950, 133)</span>. <br /><small><a href=\"http://sum.in.ua/p/1/5/2\">&copy; Словник української мови: в 11 томах. — Том 1, 1970. — Стор. 5.</a></small></p>",
            "<p align=\"justify\"><strong>АБСОЛ<span class=\"stressed\">Ю</span><span class=\"stress\">́</span>Т</strong>, у, <i><span style=\"color:green\"><abbr title=\"чоловічий рід\">чол.</abbr></span></i> У буржуазних країнах — масове ухиляння від участі у виборах, а також систематична відсутність на засіданнях членів колегіальних органів.<br /><i>Ми тепер «сидимо по вуха» у виборах [до IV Державної думи]. Абсентеїзм страшенно великий. По робітничій курії теж. Але обрані все ж скрізь соціал-демократи</i> <span style=\"color:gray\">(Ленін, 35, 1952, 33)</span>.  <br /><small><a href=\"http://sum.in.ua/p/1/5/2\">&copy; Словник української мови: в 11 томах. — Том 1, 1970. — Стор. 5.</a></small></p>\n",
            "<p align=\"justify\"><strong> АБСТРАГУВ<span class=\"stressed\">А</span><span class=\"stress\">́</span>ТИСЯ</strong>, уюся, уєшся,  <i><span style=\"color:green\"><abbr title=\"недоконаний вид\">недок.</abbr></span></i> i <i><span style=\"color:green\"><abbr title=\"доконаний вид\">док.</abbr></span></i>Уявно (в думках) відриватися від тих чи інших сторін, властивостей або зв'язків предметів і явищ.<br /><i>Коли абстрагуватися від споживної вартості товарних тіл, то у них лишається тільки одна властивість, а саме та, що вони — продукти праці</i> <span style=\"color:gray\">(Карл Маркс, Капітал, т. І, кн. І, 1952, 44)</span>; <i>Наука логіка, досліджуючи логічні форми, абстрагується від конкретного змісту тієї чи іншої думки</i> <span style=\"color:gray\">(Логіка, 1953, 4)</span>.<br /><small><a href=\"http://sum.in.ua/p/1/6/2\">&copy; Словник української мови: в 11 томах. — Том 1, 1970. — Стор. 6.</a></small></p>"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //Create an array of objects ListData and fill in data
        wordList = new ArrayList<ListData>();
        for (int i = 1; i <= 5; i++) {
            wordList.add(new ListData(words[i - 1], meanings[i - 1]));
        }

    //data adapter
        ListAdapter listAdapter;
        listAdapter = new ListAdapter(this, wordList);
        setListAdapter(listAdapter);
    }

    public void onListItemClick(ListView parent, View v, int position, long id) {
        Intent intent=new Intent(this, WordMeaningActivity.class);
        intent.putExtra(WordMeaningActivity.EXT_TextToShow, wordList.get(position).meaning);
        startActivity(intent);
    }
}
