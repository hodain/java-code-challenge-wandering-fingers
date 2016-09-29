package cz.hodain.challenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import cz.hodain.challenge.util.IOUtils;


public class FileDictionary implements Dictionary {

	private static FileDictionary INSTANCE;

	private Set<String> data = new HashSet<String>();

	private FileDictionary(File file) throws FileNotFoundException {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			String line;
			while ((line = br.readLine()) != null) {
				data.add(line);
			}
		} catch (IOException e) {
			// FIXME
		} finally {
			IOUtils.close(fr);
			IOUtils.close(br);
		}
	}


	public boolean contains(String word) {
		return data.contains(word);
	}


	public int size() {
		return data.size();
	}


	public static Dictionary getInstance(File file) throws FileNotFoundException {
		if (INSTANCE == null) {
			INSTANCE = new FileDictionary(file);
		}
		return INSTANCE;
	}

}
