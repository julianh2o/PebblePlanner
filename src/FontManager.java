import java.awt.Font;
import java.awt.FontFormatException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.HashMap;

public class FontManager {
	HashMap<String,Font> fontCache;
	Path fontDirectory;
	
	public FontManager(Path fontDirectory) {
		this.fontDirectory = fontDirectory;
		fontCache = new HashMap<String,Font>();
	}
	
	public Font getFont(String name) throws FontFormatException, IOException {
		if (!fontCache.containsKey(name)) {
			return loadFont(name);
		}
		
		return fontCache.get(name);
	}
	
	public Font loadFont(String name) throws FontFormatException, IOException {
		Path fontPath = fontDirectory.resolve(name);
		InputStream is = new FileInputStream(fontPath.toAbsolutePath().toString());
		Font font = Font.createFont(Font.TRUETYPE_FONT, is);
		fontCache.put(name, font);
		return font;
	}
}
