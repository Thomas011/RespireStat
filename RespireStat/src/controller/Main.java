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
		List<Etablissement> Collections = build.Run_CSV("./src/ecoles-creches-idf.csv");
		//for(Etablissement data : Collections) { }
		Viewer viewer = new Viewer("RespireStat");
	}
}
