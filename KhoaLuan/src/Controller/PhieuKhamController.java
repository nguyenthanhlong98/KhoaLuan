package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import enity.BenhNhan;
import enity.PhieuKhambenh;



public class PhieuKhamController {
	static String POST_PHIEU_KHAM_BENH="http://localhost:5001/phieukhambenh/insert";
	/**
	 * @author Vien
	 * date : 17/4/2021
	 * @return Thêm phiếu khám bệnh vào cơ sở dữ liệu 
	 * @decripstion : Thêm phiếu khám bệnh bằng cái sử dụng RestFull API
	 * */
	//[START POST Request]
	public  int POSTPhieuKhamBenh(PhieuKhambenh phieukham) throws IOException {

		Gson gson = new GsonBuilder()
    		    .setDateFormat("yyyy-MM-dd")
    		    .create();
		String POST_PARAMS = gson.toJson(phieukham);
	    System.out.println(POST_PARAMS);
	    URL obj = new URL(POST_PHIEU_KHAM_BENH);
	    HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
	    postConnection.setRequestMethod("POST");
	    postConnection.setRequestProperty("Content-Type", "application/json");


	    postConnection.setDoOutput(true);
	    OutputStream os = postConnection.getOutputStream();
	    os.write(POST_PARAMS.getBytes());
	    os.flush();
	    os.close();


	    int responseCode = postConnection.getResponseCode();
	    System.out.println("POST Response Code :  " + responseCode);
	    System.out.println("POST Response Message : " + postConnection.getResponseMessage());

	    if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
	        BufferedReader in = new BufferedReader(new InputStreamReader(
	            postConnection.getInputStream()));
	        String inputLine;
	        StringBuffer response = new StringBuffer();

	        while ((inputLine = in .readLine()) != null) {
	            response.append(inputLine);
	        } in .close();

	        // print result
	        System.out.println(response.toString());
	    } else {
	        System.out.println("POST NOT WORKED");
	    }
	    return responseCode;
	}
	//[End POST Request]

}
