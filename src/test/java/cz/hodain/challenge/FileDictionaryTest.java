package cz.hodain.challenge;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;


public class FileDictionaryTest {

	final File testDictionaryFile = FileUtils.getFile("src", "test", "resources", "TestDictionary.txt");


	@Test
	public void testGetInstance() throws Exception {
		Dictionary dictionary = FileDictionary.getInstance(testDictionaryFile);

		Assert.assertTrue(dictionary.size() == 4);
		Assert.assertTrue(dictionary.contains("word1"));
		Assert.assertTrue(dictionary.contains("word2"));
		Assert.assertTrue(dictionary.contains("word3"));
		Assert.assertTrue(dictionary.contains("word4"));
		Assert.assertTrue(dictionary == FileDictionary.getInstance(testDictionaryFile));
	}

}
