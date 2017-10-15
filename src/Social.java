import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.restfb.BinaryAttachment;
import com.restfb.DefaultFacebookClient;
import com.restfb.Facebook;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import com.restfb.types.Photo;
import com.restfb.types.User;

public class Social {
	
	public static void postarNoFb(String token, String path, String nomegrafico, String message, PhotoTag photoTag) throws FileNotFoundException{
		String accessToken = token;
		
		ArrayList<PhotoTag> myTagList = new ArrayList<PhotoTag>();
		myTagList.add(photoTag);		

		@SuppressWarnings("deprecation")
		FacebookClient fb = new DefaultFacebookClient(accessToken);
		
		FileInputStream file = new FileInputStream(new File(path + nomegrafico));
		
		
		@SuppressWarnings("deprecation")
		FacebookType response = fb.publish("me/photos", FacebookType.class, 
				BinaryAttachment.with(nomegrafico, file),
				Parameter.with("message", message),
				Parameter.with("tags", myTagList));
	
	}

}
