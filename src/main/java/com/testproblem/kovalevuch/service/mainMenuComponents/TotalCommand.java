package com.testproblem.kovalevuch.service.mainMenuComponents;

import com.testproblem.kovalevuch.constants.Constants;
import com.testproblem.kovalevuch.entity.Expenses;
import com.testproblem.kovalevuch.enums.Pln;
import com.testproblem.kovalevuch.service.ExpensesService;
import com.testproblem.kovalevuch.utils.ConsoleMessagePrinters;
import com.testproblem.kovalevuch.utils.Parsers;
import com.testproblem.kovalevuch.utils.UrlSendGetRequset;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Component
public class TotalCommand {

    private ExpensesService expensesService;

    @Autowired
    public TotalCommand(ExpensesService expensesService) {
        this.expensesService = expensesService;
    }

    private String fukingResponce = "{\"success\":true,\"timestamp\":1529710388,\"base\":\"EUR\",\"date\":\"2018-06-22" +
            "\",\"rates\":{\"AED\":4.28034,\"AFN\":83.306119,\"ALL\":125.856564,\"AMD\":561.383922,\"ANG\":2.109928," +
            "\"AOA\":286.30126,\"ARS\":31.458945,\"AUD\":1.565316,\"AWG\":2.074495,\"AZN\":1.980681,\"BAM\":1.958538," +
            "\"BBD\":2.330893,\"BDT\":97.477943,\"BGN\":1.956906,\"BHD\":0.441359,\"BIF\":2040.673472,\"BMD\":1.165446," +
            "\"BND\":1.567064,\"BOB\":7.995428,\"BRL\":4.41087,\"BSD\":1.165446,\"BTC\":0.000192,\"BTN\":79.425181,\"BWP\"" +
            ":12.033939,\"BYN\":2.331316,\"BYR\":22842.751202,\"BZD\":2.328334,\"CAD\":1.546319,\"CDF\":1824.511048," +
            "\"CHF\":1.151233,\"CLF\":0.02712,\"CLP\":743.718041,\"CNY\":7.578437,\"COP\":3396.111072,\"CRC\":655.971529," +
            "\"CUC\":1.165446,\"CUP\":30.884332,\"CVE\":110.262894,\"CZK\":25.760906,\"DJF\":206.925028,\"DKK\":7.452833," +
            "\"DOP\":57.514782,\"DZD\":136.225545,\"EGP\":20.768714,\"ERN\":17.820134,\"ETB\":31.723452,\"EUR\":1," +
            "\"FJD\":2.430003,\"FKP\":0.878518,\"GBP\":0.878607,\"GEL\":2.852901,\"GGP\":0.878813,\"GHS\":5.569091,\"" +
            "GIP\":0.878868,\"GMD\":54.554551,\"GNF\":10486.68793,\"GTQ\":8.728075,\"GYD\":240.408301,\"HKD\":9.142974" +
            ",\"HNL\":27.835525,\"HRK\":7.369822,\"HTG\":77.408954,\"HUF\":324.530219,\"IDR\":16401.328452,\"ILS\"" +
            ":4.200069,\"IMP\":0.878813,\"INR\":79.124145,\"IQD\":1379.888644,\"IRR\":49519.821767,\"ISK\":125.984763," +
            "\"JEP\":0.878813,\"JMD\":152.277243,\"JOD\":0.826889,\"JPY\":128.030128,\"KES\":117.302192,\"KGS\":79.505596" +
            ",\"KHR\":4714.23146,\"KMF\":491.562019,\"KPW\":1048.902249,\"KRW\":1294.232746,\"KWD\":0.352086,\"KYD\"" +
            ":0.956113,\"KZT\":396.088627,\"LAK\":9800.23994,\"LBP\":1754.812723,\"LKR\":185.18944,\"LRD\":170.388273," +
            "\"LSL\":15.664046,\"LTL\":3.553101,\"LVL\":0.723218,\"LYD\":1.580234,\"MAD\":11.077614,\"MDL\":19.70537,\"" +
            "MGA\":3811.010426,\"MKD\":61.33745,\"MMK\":1611.812899,\"MNT\":2851.847964,\"MOP\":9.417278,\"MRO\"" +
            ":413.733907,\"MUR\":40.499707,\"MVR\":18.146443,\"MWK\":831.464481,\"MXN\":23.311262,\"MYR\":4.662997," +
            "\"MZN\":68.423362,\"NAD\":15.654322,\"NGN\":417.230244,\"NIO\":36.723658,\"NOK\":9.431147,\"NPR\":126.160021," +
            "\"NZD\":1.686446,\"OMR\":0.448585,\"PAB\":1.165446,\"PEN\":3.804838,\"PGK\":3.777257,\"PHP\":62.025063," +
            "\"PKR\":141.555129,\"PLN\":4.320897,\"PYG\":6609.247442,\"QAR\":4.241997,\"RON\":4.657245,\"RSD\":118.123131," +
            "\"RUB\":73.335719,\"RWF\":989.965204,\"SAR\":4.370859,\"SBD\":9.173817,\"SCR\":15.65238,\"SDG\":20.925829," +
            "\"SEK\":10.317586,\"SGD\":1.582448,\"SHP\":0.878868,\"SLL\":9300.263384,\"SOS\":665.47034,\"SRD\":8.636391," +
            "\"STD\":24498.850664,\"SVC\":10.198088,\"SYP\":600.181611,\"SZL\":15.631322,\"THB\":38.366496,\"TJS" +
            "\":10.604519,\"TMT\":3.962518,\"TND\":3.027874,\"TOP\":2.687408,\"TRY\":5.449672,\"TTD\":7.866186,\"TWD\"" +
            ":35.307245,\"TZS\":2644.398477,\"UAH\":30.558006,\"UGX\":4497.807696,\"USD\":1.165446,\"UYU\":36.874726,\"" +
            "UZS\":9148.755336,\"VEF\":93002.630284,\"VND\":26677.070154,\"VUV\":128.490902,\"WST\":3.026552,\"XAF\"" +
            ":655.365544,\"XAG\":0.070867,\"XAU\":0.000918,\"XCD\":3.150908,\"XDR\":0.825687,\"XOF\":655.365544,\"XPF\"" +
            ":119.239203,\"YER\":291.186812,\"ZAR\":15.655564,\"ZMK\":10490.421132,\"ZMW\":11.643234,\"ZWL\":375.687516}}";

    private String responce = "{" +
            "\"success\"" + ": " + "true, " +
            "\"timestamp\"" + ": " + 1519296206 + ", " +
            "\"base\"" + ": " + "\"EUR\"" + "," +
            "\"date\"" + ": " + "\"2018-06-21\"" + ", " +
            "\"rates\"" + ": " + "{" +
            "\"AUD\"" + ": " + 1.566015 + ", " +
            "\"CAD\"" + ": " + 1.560132 + ", " +
            "\"CHF\"" + ": " + 1.154727 + ", " +
            "\"CNY\"" + ": " + 7.827874 + ", " +
            "\"GBP\"" + ": " + 0.882047 + ", " +
            "\"JPY\"" + ": " + 132.360679 + ", " +
            "\"USD\"" + ": " + 1.23396  + "}" + "}";

    public void getTotalPrice(String fullInput){
        Pln pln = Parsers.stringToPln(fullInput.trim().split(" ")[1]);
        if(pln==null){
            ConsoleMessagePrinters.errorPrinter("Wrong PLN input!!!");
            return;
        }
        jsonResponceParser(pln);
    }

    public void totalPrice(Pln pln, JSONObject rates){
        List<Expenses> expenses = expensesService.findAll();
        BigDecimal total = new BigDecimal(0);
        for(Expenses e: expenses)
            if(!e.getPln().equals(pln)){
                total = total.add(e.getPrice().multiply(BigDecimal.valueOf((Double) rates.get(pln.name()))));
            }else {
                total = total.add(e.getPrice());
            }
        ConsoleMessagePrinters.successPrinter(total.setScale(2, RoundingMode.CEILING).toString());
    }

//    public void JsonResponceParser(Pln pln, String responce){
    public void jsonResponceParser(Pln pln){
        JSONObject jsonObjectMy = new JSONObject(fukingResponce);
        System.out.println(jsonObjectMy);
        JSONObject jsonObject = new JSONObject(UrlSendGetRequset.createUrl(Constants.ApiConsts.LATES_WITH_API_KEY_AND_BASE + pln.name() + Constants.ApiConsts.API_SYMBOLS));
        System.out.println(jsonObject);
        JSONObject object = new JSONObject(jsonObject.getJSONObject("rates").toString());
        totalPrice(pln, object);
    }
}
