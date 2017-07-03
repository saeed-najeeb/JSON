package bestservices.json;




import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv=(TextView) findViewById(R.id.txt) ;

        /*
        {
"name":"saeed",
"fname":"najeeb",
"address":[
{"first":"R of D", "second":"D K"}
{"first":"B", "second":"S E F"}

],
"CV":["f","s","t"]
}
         */

        JSONObject mycontact = new JSONObject();
        try {
            mycontact.put("name","saeed");
            mycontact.put("fname","najeeb");

            JSONArray address=new JSONArray();
            JSONObject firstA=new JSONObject();
            firstA.put("first","R OF D");
            firstA.put("second","D K");
            JSONObject secondA=new JSONObject();
            secondA.put("first","B");
            secondA.put("second","S E F");
            address.put(firstA);
            address.put(secondA);

            mycontact.put("address",address);
            mycontact.put("CV",new JSONArray().put("f")
                    .put("s")
                    .put("t"));



        } catch (JSONException e) {
            e.printStackTrace();
        }
        tv.setText(mycontact.toString());

        String myname="";
        JSONArray myaddress = new JSONArray();
        String firstA="";

        try {
            myname=mycontact.getString("name");
            myaddress=mycontact.getJSONArray("address");
            firstA=myaddress.getJSONObject(0).getString("first");
        } catch (JSONException e) {
            e.printStackTrace();
        }





        Log.i("log1", myname);
        Log.i("log1", firstA);


    }
}
