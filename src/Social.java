import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.restfb.BinaryAttachment;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import com.restfb.types.User;


public class Social {

	public static void postarNoFb(String token, String path, String nomegrafico, String message) throws FileNotFoundException{
		String accessToken = token;

		@SuppressWarnings("deprecation")
		FacebookClient fb = new DefaultFacebookClient(accessToken);
		
		FileInputStream file = new FileInputStream(new File(path + nomegrafico));
		
		
		@SuppressWarnings("deprecation")
		FacebookType response = fb.publish("me/photos", FacebookType.class, 
				BinaryAttachment.with(nomegrafico, file),
				Parameter.with("message", message));
	
	}

}
