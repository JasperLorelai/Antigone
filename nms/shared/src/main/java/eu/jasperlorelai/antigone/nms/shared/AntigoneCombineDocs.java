package eu.jasperlorelai.antigone.nms.shared;

import java.io.*;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.common.base.Charsets;

public final class AntigoneCombineDocs {

	private static final File NMS_DIR = new File("").getAbsoluteFile().getParentFile();
	private static final File FILE = new File(NMS_DIR.getParentFile(), "docs/docs.json");

	public static void main(String... args) {
		JsonObject docs = new JsonObject();

		try {
			File[] versionDirs = NMS_DIR.listFiles();
			if (versionDirs == null) throw new RuntimeException();

			for (File versionDir : versionDirs) {
				if (!versionDir.getName().startsWith("v")) continue;
				File versionDocFile = new File(versionDir, "build/docs.json");

				try (Reader reader = new InputStreamReader(new FileInputStream(versionDocFile), Charsets.UTF_8)) {
					docs.add(versionDir.getName(), JsonParser.parseReader(reader));
				}
			}

			try (Writer writer = new OutputStreamWriter(new FileOutputStream(FILE), Charsets.UTF_8)) {
				writer.write(docs.toString());
			}
		} catch (IOException e) {
			System.err.println("An error occurred:");
			//noinspection CallToPrintStackTrace
			e.printStackTrace();
		}
	}

}
