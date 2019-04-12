package controller;
import model.Etablissement;
import view.Viewer;
import java.util.List;
import java.util.Map;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		ConvertCSV build = new ConvertCSV();
		List<Map<String, String>> result = build.Run_CSV("./src/ecoles-creches-idf.csv");
		for(int i = 0; i < result.size(); i++) {
			Etablissement data = new Etablissement((Map)result.get(i));
		}
	}
}
