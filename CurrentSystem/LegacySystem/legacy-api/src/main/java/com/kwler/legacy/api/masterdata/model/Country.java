package com.kwler.legacy.api.masterdata.model;

public enum Country {
    AD("Andorra"), AE("United Arab Emirates"), AF("Afghanistan"), AG("Antigua and Barbuda"), AI("Anguilla"), AL("Albania"), AM("Armenia"), AN("Netherlands Antilles"), AO("Angola"), AQ("Antarctica"), AR("Argentina"), AS("American Samoa"), AT("Austria"), AU("Australia"), AW("Aruba"), AX("Åland Islands"), AZ("Azerbaijan"), BA("Bosnia and Herzegovina"), BB("Barbados"), BD("Bangladesh"), BE("Belgium"), BF("Burkina Faso"), BG("Bulgaria"), BH("Bahrain"), BI("Burundi"), BJ("Benin"), BL("Saint Barthélemy"), BM("Bermuda"), BN("Brunei Darussalam"), BO("Bolivia"), BQ("Bonaire, Sint Eustatius and Saba"), BR("Brazil"), BS("Bahamas"), BT("Bhutan"), BV("Bouvet Island"), BW("Botswana"), BY("Belarus"), BZ("Belize"), CA("Canada"), CC("Cocos (Keeling) Islands"), CD("Congo, the Democratic Republic of the"), CF("Central African Republic"), CG("Congo"), CH("Switzerland"), CI("Cote d'Ivoire"), CK("Cook Islands"), CL("Chile"), CM("Cameroon"), CN("China"), CO("Colombia"), CR("Costa Rica"), CU("Cuba"), CV("Cape Verde"), CW("Curaçao"), CX("Christmas Island"), CY("Cyprus"), CZ("Czech Republic"), DE("Germany"), DJ("Djibouti"), DK("Denmark"), DM("Dominica"), DO("Dominican Republic"), DZ("Algeria"), EC("Ecuador"), EE("Estonia"), EG("Egypt"), EH("Western Sahara"), ER("Eritrea"), ES("Spain"), ET("Ethiopia"), FI("Finland"), FJ("Fiji"), FK("Falkland Islands (Malvinas)"), FM("Micronesia, Federated States of"), FO("Faroe Islands"), FR("France"), GA("Gabon"), GB("United Kingdom"), GD("Grenada"), GE("Georgia"), GF("French Guiana"), GG("Guernsey"), GH("Ghana"), GI("Gibraltar"), GL("Greenland"), GM("Gambia"), GN("Guinea"), GP("Guadeloupe"), GQ("Equatorial Guinea"), GR("Greece"), GS("South Georgia And The South Sandwich Islands"), GT("Guatemala"), GU("Guam"), GW("Guinea-Bissau"), GY("Guyana"), HK("Hong Kong"), HM("Heard Island And McDonald Islands"), HN("Honduras"), HR("Croatia"), HT("Haiti"), HU("Hungary"), ID("Indonesia"), IE("Ireland"), IL("Israel"), IM("Isle Of Man"), IN("India"), IO("British Indian Ocean Territory"), IQ("Iraq"), IR("Iran, Islamic Republic of"), IS("Iceland"), IT("Italy"), JE("Jersey"), JM("Jamaica"), JO("Jordan"), JP("Japan"), KE("Kenya"), KG("Kyrgyzstan"), KH("Cambodia"), KI("Kiribati"), KM("Comoros"), KN("Saint Kitts And Nevis"), KP("Korea, Democratic People's Republic of"), KR("Korea, Republic of"), KW("Kuwait"), KY("Cayman Islands"), KZ("Kazakhstan"), LA("Lao People's Democratic Republic"), LB("Lebanon"), LC("Saint Lucia"), LI("Liechtenstein"), LK("Sri Lanka"), LR("Liberia"), LS("Lesotho"), LT("Lithuania"), LU("Luxembourg"), LV("Latvia"), LY("Libya"), MA("Morocco"), MC("Monaco"), MD("Moldova"), ME("Montenegro"), MF("Saint Martin (French part)"), MG("Madagascar"), MH("Marshall Islands"), MK("Macedonia"), ML("Mali"), MM("Myanmar"), MN("Mongolia"), MO("Macao"), MP("Northern Mariana Islands"), MQ("Martinique"), MR("Mauritania"), MS("Montserrat"), MT("Malta"), MU("Mauritius"), MV("Maldives"), MW("Malawi"), MX("Mexico"), MY("Malaysia"), MZ("Mozambique"), NA("Namibia"), NC("New Caledonia"), NE("Niger"), NF("Norfolk Island"), NG("Nigeria"), NI("Nicaragua"), NL("Netherlands"), NO("Norway"), NP("Nepal"), NR("Nauru"), NU("Niue"), NZ("New Zealand"), OM("Oman"), PA("Panama"), PE("Peru"), PF("French Polynesia"), PG("Papua New Guinea"), PH("Philippines"), PK("Pakistan"), PL("Poland"), PM("Saint Pierre And Miquelon"), PN("Pitcairn"), PR("Puerto Rico"), PS("Palestine"), PT("Portugal"), PW("Palau"), PY("Paraguay"), QA("Qatar"), RE("Reunion"), RO("Romania"), RS("Serbia"), RU("Russian Federation"), RW("Rwanda"), SA("Saudi Arabia"), SB("Solomon Islands"), SC("Seychelles"), SD("Sudan"), SE("Sweden"), SG("Singapore"), SH("Saint Helena"), SI("Slovenia"), SJ("Svalbard And Jan Mayen"), SK("Slovakia"), SL("Sierra Leone"), SM("San Marino"), SN("Senegal"), SO("Somalia"), SR("Suriname"), SS("South Sudan"), ST("Sao Tome And Principe"), SV("El Salvador"), SX("Sint Maarten (Dutch part)"), SY("Syrian Arab Republic"), SZ("Swaziland"), TC("Turks And Caicos Islands"), TD("Chad"), TF("French Southern Territories"), TG("Togo"), TH("Thailand"), TJ("Tajikistan"), TK("Tokelau"), TL("Timor-Leste"), TM("Turkmenistan"), TN("Tunisia"), TO("Tonga"), TR("Turkey"), TT("Trinidad and Tobago"), TV("Tuvalu"), TW("Taiwan"), TZ("Tanzania, United Republic of"), UA("Ukraine"), UG("Uganda"), UM("United States Minor Outlying Islands"), US("United States"), UY("Uruguay"), UZ("Uzbekistan"), VA("Vatican"), VC("Saint Vincent And The Grenadines"), VE("Venezuela"), VG("Virgin Islands (British)"), VI("U.S. Virgin Islands"), VN("Viet Nam"), VU("Vanuatu"), WF("Wallis And Futuna"), WS("Samoa"), XK("Kosovo"), YE("Yemen"), YT("Mayotte"), ZA("South Africa"), ZM("Zambia"), ZW("Zimbabwe"), WORLD("Global");

    private String displayName;

    private Country(String name) {
        this.displayName = name;
    }

    public String toDisplayName() {
        return this.displayName;
    }

    public static Country fromName(String name) {

        if (name != null) {
            for (Country country : Country.values()) {
                if (country.displayName.equalsIgnoreCase(name)) return country;
            }
        }

        return null;

    }

}
