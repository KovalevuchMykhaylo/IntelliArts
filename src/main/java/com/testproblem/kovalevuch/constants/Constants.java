package com.testproblem.kovalevuch.constants;

public final class Constants {

    public static final String BIG_DECIMAL_WITH_DOT = "^([0-9]{1,17}\\.[0-9]{1,2})|([0-9]{1,17}\\,[0-9]{1,2})|([0-9]{1,17})$";

    public static final String BIG_DECIMAL_WITHOUT_DOT = "^([0-9]{1,17})$";

    public static final String DATE_REGX = "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$";

    public static final String WELCOME_MESSAGE = "\n\033[31m$$   $$  $$$$$   $$       $$$$    $$$$   $$   $$  $$$$$\n" +
            "$$   $$  $$      $$      $$  $$  $$  $$  $$$ $$$  $$\n" +
            "$$ $ $$  $$$$    $$      $$      $$  $$  $$ $ $$  $$$$\n" +
            "$$$$$$$  $$      $$      $$  $$  $$  $$  $$   $$  $$\n" +
            " $$ $$   $$$$$   $$$$$$   $$$$    $$$$   $$   $$  $$$$$\033[0m\n";

    public static final String MAIN_MENU = "\n\033[32mEnter 'add' to item to expense list. EXAMPLE: add 2017-04-25 12 USD Jogurt\n" +
            "Enter 'list' to show all expense\n" +
            "Enter 'clear' removes all expenses for specified date. EXAMPLE: clear 2017-04-25\n" +
            "Enter 'total PLN' to show total amount of expenses. EXAMPLE total USD\n" +
            "Enter 'help' to show help\n" +
            "Enter 'exit' to exit app\033[0m\n";

    public static final class HelpMenu {

        public static final String PLN_NAMES = "Code\tName\n" +
                "AED\tUnited Arab Emirates Dirham\n" +
                "AFN\tAfghan Afghani\n" +
                "ALL\tAlbanian Lek\n" +
                "AMD\tArmenian Dram\n" +
                "ANG\tNetherlands Antillean Guilder\n" +
                "AOA\tAngolan Kwanza\n" +
                "ARS\tArgentine Peso\n" +
                "AUD\tAustralian Dollar\n" +
                "AWG\tAruban Florin\n" +
                "AZN\tAzerbaijani Manat\n" +
                "BAM\tBosnia-Herzegovina Convertible Mark\n" +
                "BBD\tBarbadian Dollar\n" +
                "BDT\tBangladeshi Taka\n" +
                "BGN\tBulgarian Lev\n" +
                "BHD\tBahraini Dinar\n" +
                "BIF\tBurundian Franc\n" +
                "BMD\tBermudan Dollar\n" +
                "BND\tBrunei Dollar\n" +
                "BOB\tBolivian Boliviano\n" +
                "BRL\tBrazilian Real\n" +
                "BSD\tBahamian Dollar\n" +
                "BTC\tBitcoin\n" +
                "BTN\tBhutanese Ngultrum\n" +
                "BWP\tBotswanan Pula\n" +
                "BYR\tBelarusian Ruble\n" +
                "BZD\tBelize Dollar\n" +
                "CAD\tCanadian Dollar\n" +
                "CDF\tCongolese Franc\n" +
                "CHF\tSwiss Franc\n" +
                "CLF\tChilean Unit of Account (UF)\n" +
                "CLP\tChilean Peso\n" +
                "CNY\tChinese Yuan\n" +
                "COP\tColombian Peso\n" +
                "CRC\tCosta Rican Colón\n" +
                "CUC\tCuban Convertible Peso\n" +
                "CUP\tCuban Peso\n" +
                "CVE\tCape Verdean Escudo\n" +
                "CZK\tCzech Republic Koruna\n" +
                "DJF\tDjiboutian Franc\n" +
                "DKK\tDanish Krone\n" +
                "DOP\tDominican Peso\n" +
                "DZD\tAlgerian Dinar\n" +
                "EGP\tEgyptian Pound\n" +
                "ERN\tEritrean Nakfa\n" +
                "ETB\tEthiopian Birr\n" +
                "EUR\tEuro\n" +
                "FJD\tFijian Dollar\n" +
                "FKP\tFalkland Islands Pound\n" +
                "GBP\tBritish Pound Sterling\n" +
                "GEL\tGeorgian Lari\n" +
                "GGP\tGuernsey Pound\n" +
                "GHS\tGhanaian Cedi\n" +
                "GIP\tGibraltar Pound\n" +
                "GMD\tGambian Dalasi\n" +
                "GNF\tGuinean Franc\n" +
                "GTQ\tGuatemalan Quetzal\n" +
                "GYD\tGuyanaese Dollar\n" +
                "HKD\tHong Kong Dollar\n" +
                "HNL\tHonduran Lempira\n" +
                "HRK\tCroatian Kuna\n" +
                "HTG\tHaitian Gourde\n" +
                "HUF\tHungarian Forint\n" +
                "IDR\tIndonesian Rupiah\n" +
                "ILS\tIsraeli New Sheqel\n" +
                "IMP\tManx pound\n" +
                "INR\tIndian Rupee\n" +
                "IQD\tIraqi Dinar\n" +
                "IRR\tIranian Rial\n" +
                "ISK\tIcelandic Króna\n" +
                "JEP\tJersey Pound\n" +
                "JMD\tJamaican Dollar\n" +
                "JOD\tJordanian Dinar\n" +
                "JPY\tJapanese Yen\n" +
                "KES\tKenyan Shilling\n" +
                "KGS\tKyrgystani Som\n" +
                "KHR\tCambodian Riel\n" +
                "KMF\tComorian Franc\n" +
                "KPW\tNorth Korean Won\n" +
                "KRW\tSouth Korean Won\n" +
                "KWD\tKuwaiti Dinar\n" +
                "KYD\tCayman Islands Dollar\n" +
                "KZT\tKazakhstani Tenge\n" +
                "LAK\tLaotian Kip\n" +
                "LBP\tLebanese Pound\n" +
                "LKR\tSri Lankan Rupee\n" +
                "LRD\tLiberian Dollar\n" +
                "LSL\tLesotho Loti\n" +
                "LTL\tLithuanian Litas\n" +
                "LVL\tLatvian Lats\n" +
                "LYD\tLibyan Dinar\n" +
                "MAD\tMoroccan Dirham\n" +
                "MDL\tMoldovan Leu\n" +
                "MGA\tMalagasy Ariary\n" +
                "MKD\tMacedonian Denar\n" +
                "MMK\tMyanma Kyat\n" +
                "MNT\tMongolian Tugrik\n" +
                "MOP\tMacanese Pataca\n" +
                "MRO\tMauritanian Ouguiya\n" +
                "MUR\tMauritian Rupee\n" +
                "MVR\tMaldivian Rufiyaa\n" +
                "MWK\tMalawian Kwacha\n" +
                "MXN\tMexican Peso\n" +
                "MYR\tMalaysian Ringgit\n" +
                "MZN\tMozambican Metical\n" +
                "NAD\tNamibian Dollar\n" +
                "NGN\tNigerian Naira\n" +
                "NIO\tNicaraguan Córdoba\n" +
                "NOK\tNorwegian Krone\n" +
                "NPR\tNepalese Rupee\n" +
                "NZD\tNew Zealand Dollar\n" +
                "OMR\tOmani Rial\n" +
                "PAB\tPanamanian Balboa\n" +
                "PEN\tPeruvian Nuevo Sol\n" +
                "PGK\tPapua New Guinean Kina\n" +
                "PHP\tPhilippine Peso\n" +
                "PKR\tPakistani Rupee\n" +
                "PLN\tPolish Zloty\n" +
                "PYG\tParaguayan Guarani\n" +
                "QAR\tQatari Rial\n" +
                "RON\tRomanian Leu\n" +
                "RSD\tSerbian Dinar\n" +
                "RUB\tRussian Ruble\n" +
                "RWF\tRwandan Franc\n" +
                "SAR\tSaudi Riyal\n" +
                "SBD\tSolomon Islands Dollar\n" +
                "SCR\tSeychellois Rupee\n" +
                "SDG\tSudanese Pound\n" +
                "SEK\tSwedish Krona\n" +
                "SGD\tSingapore Dollar\n" +
                "SHP\tSaint Helena Pound\n" +
                "SLL\tSierra Leonean Leone\n" +
                "SOS\tSomali Shilling\n" +
                "SRD\tSurinamese Dollar\n" +
                "STD\tSão Tomé and Príncipe Dobra\n" +
                "SVC\tSalvadoran Colón\n" +
                "SYP\tSyrian Pound\n" +
                "SZL\tSwazi Lilangeni\n" +
                "THB\tThai Baht\n" +
                "TJS\tTajikistani Somoni\n" +
                "TMT\tTurkmenistani Manat\n" +
                "TND\tTunisian Dinar\n" +
                "TOP\tTongan Paʻanga\n" +
                "TRY\tTurkish Lira\n" +
                "TTD\tTrinidad and Tobago Dollar\n" +
                "TWD\tNew Taiwan Dollar\n" +
                "TZS\tTanzanian Shilling\n" +
                "UAH\tUkrainian Hryvnia\n" +
                "UGX\tUgandan Shilling\n" +
                "USD\tUnited States Dollar\n" +
                "UYU\tUruguayan Peso\n" +
                "UZS\tUzbekistan Som\n" +
                "VEF\tVenezuelan Bolívar Fuerte\n" +
                "VND\tVietnamese Dong\n" +
                "VUV\tVanuatu Vatu\n" +
                "WST\tSamoan Tala\n" +
                "XAF\tCFA Franc BEAC\n" +
                "XAG\tSilver (troy ounce)\n" +
                "XAU\tGold (troy ounce)\n" +
                "XCD\tEast Caribbean Dollar\n" +
                "XDR\tSpecial Drawing Rights\n" +
                "XOF\tCFA Franc BCEAO\n" +
                "XPF\tCFP Franc\n" +
                "YER\tYemeni Rial\n" +
                "ZAR\tSouth African Rand\n" +
                "ZMK\tZambian Kwacha (pre-2013)\n" +
                "ZMW\tZambian Kwacha\n" +
                "ZWL\tZimbabwean Dollar\n";

        public static final String HELP = "Available main menu commands is:\n" +
                "\tADD, LIST, CLEAR, TOTAL, EXIT, HELP\n" +
                "\tDate format is yyyy-mm-dd, please be careful!!!\n" +
                "\tProduct name must contains less then 254 characters\n" +
                "\tPLN means currency\n" +
                "\tAvailable help menu commands is:\n" +
                "\tPLN, RETURN\n";
    }
}
