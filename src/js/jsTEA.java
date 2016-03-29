/*
 * By attaching this document to the given files (the �work�), you, the licensee,
 * are hereby granted free usage in both personal and commerical environments, 
 * without any obligation of attribution or payment (monetary or otherwise).
 *  
 * The licensee is free to use, copy, modify, publish, distribute, sublicence, 
 * and/or merchandise the work, subject to the licensee inflecting a positive 
 * message unto someone. This includes (but is not limited to): smiling, 
 * being nice, saying �thank you�, assisting other persons, or any 
 * similar actions percolating the given concept.
 * 
 * The above copyright notice serves as a permissions notice also, 
 * and may optionally be included in copies or portions of the work. 
 * 
 * The work is provided �as is�, without warranty or support, express or implied. 
 * The author(s) are not liable for any damages, misuse, or other claim, whether 
 * from or as a consequence of usage of the given work.
 */

package js;

import java.io.*;
import javax.script.*;
import Proiect.Encrypter;

public class jsTEA {

	public static String html_top_start = "<html><head><script src='http://tinyurl.com/7lebe96'></script>"
			+ "<script>var hea1p = new tea('";

	public static String html_top_end = "'); var hea1t = hea1p.decrypt('";

	public static String html_bottom = "');document.write(hea1t)</script></head></html>";

	/**
	 * Javascript tea Encryption
	 * 
	 * @param text
	 * @throws FileNotFoundException
	 */
	public static void jsTEAEn(String text) throws FileNotFoundException {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");

		Encrypter.mainKey = Encrypter.genKey(Encrypter.key);

		try {
			if (Encrypter.no_click.isSelected()) {
				String test = Encrypter.TA.getText();
				Encrypter.TA.insert(Encrypter.no_click_script,
						test.indexOf("</head>"));
			}

			if (Encrypter.isMacOS) {
				FileReader reader = new FileReader("js/tea.js");
				engine.eval(reader);
				engine.put("text", Encrypter.TA.getText());
				engine.eval("var bf = new tea('" + Encrypter.mainKey
						+ "');" + "var ciphertext = bf.encrypt(text);");

				String text_out = (String) engine.get("ciphertext");

				Encrypter.TA.setText("");
				Encrypter.TA.append(html_top_start + Encrypter.mainKey
						+ html_top_end + text_out + html_bottom);
			} else {
				FileReader reader = new FileReader(ClassLoader
						.getSystemResource("js/tea.js").getPath());
				engine.eval(reader);
				engine.put("text", Encrypter.TA.getText());
				engine.eval("var bf = new tea('" + Encrypter.mainKey
						+ "');" + "var ciphertext = bf.encrypt(text);");

				String text_out = (String) engine.get("ciphertext");

				Encrypter.TA.setText("");
				Encrypter.TA.append(html_top_start + Encrypter.mainKey
						+ html_top_end + text_out + html_bottom);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Javascript tea Decryption
	 * 
	 * @param text
	 * @throws FileNotFoundException
	 */
	public static void jsTEADe(String text) throws FileNotFoundException {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");

		String html_top = html_top_start + Encrypter.genKey(Encrypter.key)
				+ html_top_end;

		if (Encrypter.miOTE.getSelectedObjects() == null) {
			Encrypter.mainKey = Encrypter.normalKey;
		}

		try {
			if (Encrypter.isMacOS) {
				FileReader reader = new FileReader("js/tea.js");
				engine.eval(reader);
				engine.put(
						"text",
						Encrypter.TA.getText().substring(
								html_top.length(),
								Encrypter.TA.getText().length()
										- html_bottom.length()));
				engine.eval("var bf = new tea('" + Encrypter.mainKey
						+ "');" + "var ciphertext = bf.decrypt(text);");

				String text_out = (String) engine.get("ciphertext");

				Encrypter.TA.setText("");
				Encrypter.TA.append(text_out);
			} else {
				FileReader reader = new FileReader(ClassLoader
						.getSystemResource("js/tea.js").getPath());
				engine.eval(reader);
				engine.put(
						"text",
						Encrypter.TA.getText().substring(
								html_top.length(),
								Encrypter.TA.getText().length()
										- html_bottom.length()));
				engine.eval("var bf = new tea('" + Encrypter.mainKey
						+ "');" + "var ciphertext = bf.decrypt(text);");

				String text_out = (String) engine.get("ciphertext");

				Encrypter.TA.setText("");
				Encrypter.TA.append(text_out);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
