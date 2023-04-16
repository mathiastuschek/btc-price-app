package testing;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;



public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		URL url = new URL("https://api.coinbase.com/v2/prices/BTC-EUR/buy");
		
		String placeholder = "loading...";
		
        JFrame a = new JFrame("BTC");
        JLabel b1;
        b1 = new JLabel(placeholder);
        b1.setHorizontalAlignment(JLabel.CENTER);
        b1.setBounds(40,20,120,120);
        a.add(b1);
        a.setSize(220,220);
        a.setResizable(false);
        a.setLayout(null);
        a.setVisible(true);
		
		while(true) {
		
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.connect();
			
	        String header = "";
	        Scanner scanner = new Scanner(url.openStream());
	
	        while (scanner.hasNext()) {
	            header += scanner.nextLine();
	        }
	        scanner.close();
	        
	        Thread.sleep(2000);
	        
	        String price = header.substring(49, 54);
	        String res = price.substring(0,2) + "." + price.substring(2) + "€";
	        b1.setText(res);

		}
	}
}	


