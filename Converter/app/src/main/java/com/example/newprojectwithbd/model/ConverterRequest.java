package com.example.newprojectwithbd.model;

import com.example.newprojectwithbd.R;

public class ConverterRequest {

    public Integer setCountryFlag (String countryName) {

        int id = R.drawable.def;

        switch (countryName) {
            case "Австралия": id = R.drawable.australia; break; case "Австрия": id = R.drawable.austria; break; case "Андорра": id = R.drawable.andorra; break;
            case "Бельгия": id = R.drawable.belgia; break; case "Ватикан": id = R.drawable.vatican; break; case "Германия": id = R.drawable.german; break;
            case "Греция": id = R.drawable.grezia; break; case "Ирландия":id = R.drawable.irland; break; case "Испания":id = R.drawable.spanish; break;
            case "Италия": id = R.drawable.italia; break; case "Азербайджан": id = R.drawable.azerb; break; case "Албания": id = R.drawable.albania; break;
            case "Алжир": id = R.drawable.algir; break; case "Ангилья": id = R.drawable.angilia;break; case "Гренада": id = R.drawable.grenada;break;
            case "Ангола": id = R.drawable.angola; break; case "Аргентина": id = R.drawable.argentina; break;case "Канада": id = R.drawable.kanada; break;
            case "Армения": id = R.drawable.armenia; break; case "Аруба": id = R.drawable.aruba; break; case "Афганистан": id = R.drawable.afganistan; break;
            case "Бангладеш": id = R.drawable.bangladesh; break; case "Барбадос": id = R.drawable.barbados; break; case "Бахрейн": id = R.drawable.bahreyn; break;
            case "Белоруссия": id = R.drawable.flag_bel; break; case "Болгария": id = R.drawable.bolgaria; break; case "Боливия": id = R.drawable.bolivia; break;
            case "Бразилия": id = R.drawable.brasilia; break; case "Бутан": id = R.drawable.butan; break; case "Вануату": id = R.drawable.vanuatu; break;
            case "Великобритания": id = R.drawable.british; break; case "Венгрия": id = R.drawable.vengria; break; case "Венесуэла": id = R.drawable.venesuala; break;
            case "Вьетнам": id = R.drawable.vetnam; break; case "Габон": id = R.drawable.gabon; break; case "Гаити": id = R.drawable.gaity; break;
            case "Гамбия": id = R.drawable.gambia; break; case "Гана": id = R.drawable.gana; break; case "Гватемала": id = R.drawable.gvatemala; break;
            case "Гвинея": id = R.drawable.gvinea; break; case "Гибралтар": id = R.drawable.gibraltar; break; case "Гондурас": id = R.drawable.gonduras; break;
            case "Гонконг": id = R.drawable.gonkong; break; case "Гренландия": id = R.drawable.grenlandia; break; case "Грузия": id = R.drawable.gruzia; break;
            case "Дания": id = R.drawable.dania; break; case "Доминика": id = R.drawable.dominicana; break; case "Египет": id = R.drawable.egipet; break;
            case "Замбия": id = R.drawable.zambia; break; case "Зимбабве": id = R.drawable.zimb; break; case "Израиль": id = R.drawable.izrail; break;
            case "Индия": id = R.drawable.india; break; case "Индонезия": id = R.drawable.indonesia; break; case "Иордания": id = R.drawable.iordania; break;
            case "Ирак": id = R.drawable.irak; break; case "Иран": id = R.drawable.iran; break; case "Исландия": id = R.drawable.island; break;
            case "Казахстан": id = R.drawable.flag_kzt; break; case "Камбоджа": id = R.drawable.combodgi; break; case "Камерун": id = R.drawable.camerun; break;
            case "США": id = R.drawable.usa; break; case "Россия": id = R.drawable.flag_rus; break; case "Украина": id = R.drawable.flag_ukr; break;
        }
        return id;
    }

}
