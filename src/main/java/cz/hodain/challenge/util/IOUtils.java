package cz.hodain.challenge.util;

import java.io.Closeable;
import java.io.IOException;

public class IOUtils {

	public static void close(Closeable stream) {
		if (stream != null) {
			try {
				stream.close();
			} catch (IOException e) {
				// DO NOTHING
			}
		}

	}

}
