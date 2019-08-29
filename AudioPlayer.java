package Code;
import java.util.Map;
import java.util.HashMap;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class AudioPlayer {
    
    public static Map<String, Sound> soundMap = new HashMap<String, Sound>();
    public static Map<String, Music> musicMap = new HashMap<String, Music>();
    
    public static void load() {
        
        try {
            soundMap.put("Menu_Sound",new Sound ("res/SFX/Select.wav"));
            
            soundMap.put("PauseOn",new Sound ("res/SFX/Pause.wav"));
            
            soundMap.put("PauseOff",new Sound ("res/SFX/PauseOff.wav"));
            
            musicMap.put("Intro",new Music("Res/Songs/Intro.wav"));
            
            musicMap.put("Menu",new Music("Res/Songs/Menu.wav"));
            
        } catch (SlickException e) {
            e.printStackTrace();
        }
        
    }
    
    public static Music getMusic(String key) {
        return musicMap.get(key); 
    }
    
    public static Sound getSound(String key) {
        return soundMap.get(key);
    }
    
}