package com.hackerhank.daysofcodehackerhank.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

public class FileTestCaseUtil {

	private FileTestCaseUtil() {
		throw new IllegalStateException("Utility class");
	}

	public static Scanner getFileFromResources(String fileName) {
		try {
			ClassLoader classLoader = ClassLoader.getSystemClassLoader();
			URL resource = classLoader.getResource(fileName);

			if (resource == null)
				System.err.println("file is not found");

			return new Scanner(new File(resource.getFile()));
		} catch (FileNotFoundException e) {
			System.err.println("file is not found");
			return null;
		}
	}

}
