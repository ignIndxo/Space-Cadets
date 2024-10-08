import java.io.*;
import java.net.*;

class Main {
    public static void main(String[] args) 
        throws IOException
    {
        BufferedReader reader = 
        new BufferedReader(new InputStreamReader(System.in));

        String complete_url= "https://www.ecs.soton.ac.uk/people/" + reader.readLine();

        try {
            URL person = new URI(complete_url).toURL();

            URLConnection urlconnect = person.openConnection();
            InputStream info = urlconnect.getInputStream();

            BufferedReader webreader = 
            new BufferedReader(new InputStreamReader(info));

            boolean foundAnything = false;
            String line = "";
            while(foundAnything == false){
                line = webreader.readLine();
                if(line.contains("og:title")) {
                    foundAnything = true;
                }

            }
            if(!foundAnything) {
                System.out.println("There was no results");
            }

            String name = line.substring(35,line.length()-4);
            System.out.println(name);
            
        }
        catch (URISyntaxException e){}


    }
  }
