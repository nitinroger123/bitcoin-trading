import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.util.Calendar;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


public class HelloWorld {
	public static void main(String[] args) throws IOException
	{
		String host = "http://bitcoincharts.com/charts/chart.json?m=mtgoxUSD&SubmitButton=Draw&r=&i=Daily&c=0&s=&e=&Prev=&Next=&t=S&b=&a1=&m1=10&a2=&m2=25&x=0&i1=&i2=&i3=&i4=&v=1&cv=0&ps=0&l=0&p=0&";
		HttpURLConnection connection;
		URL url = new URL(host);
		String line = null;
		String result = "";
		connection = (HttpURLConnection) url.openConnection();
		BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        while ((line = rd.readLine()) != null) {
           result += line;
        }
        rd.close();
		System.out.println(result);
		Object obj=JSONValue.parse(result);
		JSONArray array=(JSONArray)obj;
		int count = 1;
		for (Object o : array) {
			JSONArray arr = (JSONArray)o; 
			Long date = Long.parseLong(String.valueOf(arr.get(0)));
			Date d = new Date(date*1000);
			System.out.println(d.toString());
					
		}
		System.exit(0);
	}

}
